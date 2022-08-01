package estore_api.service;

import java.util.concurrent.TimeUnit;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.google.common.cache.CacheBuilder;
import com.google.common.cache.CacheLoader;
import com.google.common.cache.LoadingCache;
import com.twilio.rest.api.v2010.account.Message;
import com.twilio.type.PhoneNumber;

import estore_api.config.TwilioConfig;
import estore_api.constants.OTPStatus;
import estore_api.dto.OTPRequest;
import estore_api.dto.OTPResponse;
import estore_api.util.StringUtil;

@Service
public class OTPService {
	private static final Integer EXPIRE_MINS = 4;
	private LoadingCache<String, String> otpCache;

	public OTPService() {
		super();
		otpCache = CacheBuilder.newBuilder().expireAfterWrite(EXPIRE_MINS, TimeUnit.MINUTES)
				.build(new CacheLoader<String, String>() {
					public String load(String key) {
						return null;
					}
				});
	}

	@Autowired
	private TwilioConfig config;

	public OTPResponse sentTOP(OTPRequest request) {
		OTPResponse response = new OTPResponse();
		String otpCode = StringUtil.generateOTP();
		String message = "Dear Customer, your OTP is " + otpCode + ".";
		try {
			Message.creator(new PhoneNumber(request.getName()), new PhoneNumber(config.getTrialPhoneNo()), message)
					.create();
			response.setMessage(message);
			response.setStatus(OTPStatus.DELIVERED);
			otpCache.put(request.getName(), otpCode);
		} catch (Exception e) {
			response.setMessage(e.getMessage());
			response.setStatus(OTPStatus.FAILED);
		}
		return response;

	}

	public Boolean validateOTP(OTPRequest request) {
		if (request.getOtp().equals(getOtp(request.getName()))) {
			return true;
		}
		return false;
	}
	
	public String getOtp(String key) {
	    try {
	      return otpCache.get(key);
	    } catch (Exception e) {
	      return null;
	    }
	  }

	  // This method is used to clear the OTP catched already
	  public void clearOTP(String key) {
	    otpCache.invalidate(key);
	  }
}
