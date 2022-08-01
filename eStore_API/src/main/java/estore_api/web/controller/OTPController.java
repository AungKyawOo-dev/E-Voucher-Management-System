package estore_api.web.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import estore_api.dto.OTPRequest;
import estore_api.dto.OTPResponse;
import estore_api.service.OTPService;

@RestController
public class OTPController {

	@Autowired
	private OTPService service;

	@PostMapping(value = "/sendOTP")
	public @ResponseBody OTPResponse sendSMS(@RequestBody OTPRequest request) {
		OTPResponse response = service.sentTOP(request);
		return response;
	}

	@RequestMapping(value = "/validateOtp", method = RequestMethod.POST)
	public @ResponseBody String validateOtp(@RequestBody OTPRequest request) {

		final String SUCCESS = "Entered Otp is valid";
		final String FAIL = "Entered Otp is NOT valid. Please Retry!";
//		Authentication auth = SecurityContextHolder.getContext().getAuthentication();
//		String username = auth.getName();
		String serverOtp = service.getOtp(request.getName());
		if (serverOtp != null && request.getOtp().equals(serverOtp)) {
			service.clearOTP(request.getName());
			return SUCCESS;
		}
		return FAIL;
	}
}
