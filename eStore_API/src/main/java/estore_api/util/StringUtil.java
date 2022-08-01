package estore_api.util;

import java.text.DecimalFormat;
import java.util.Random;
import java.util.UUID;

import org.springframework.stereotype.Component;

@Component
public class StringUtil {

	public static String generateOTP() {
		return new DecimalFormat("000000").format(new Random().nextInt(999999));
	}
	
	public static String getUnitUniversalIdentifier() {
		return UUID.randomUUID().toString();
	}

}
