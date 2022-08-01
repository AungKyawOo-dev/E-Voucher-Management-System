package estore_api.dto;

import estore_api.constants.OTPStatus;
import lombok.Data;

@Data
public class OTPResponse {

	OTPStatus status;
	String message;
}
