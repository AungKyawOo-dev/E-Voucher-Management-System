package estore_api.dto;

import java.util.Date;

import com.fasterxml.jackson.annotation.JsonFormat;

import estore_api.entity.BuyType;
import estore_api.entity.PaymentMethod;
import estore_api.entity.User;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class EVoucherRequest {
	
	private Integer id;
	private String title;
	private String description;
	private String code;
	@JsonFormat(shape=JsonFormat.Shape.STRING, pattern="yyyy-MM-dd'T'HH:mm:ss")
	private Date expiryDate;
	private String image;
	private Integer amount;
	private User user;
	private PaymentMethod paymentMethod;
	private Integer quantity;
	private BuyType buyType; 

}
