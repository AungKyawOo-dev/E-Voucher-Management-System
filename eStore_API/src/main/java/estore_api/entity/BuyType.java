package estore_api.entity;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table(name = "buy_type")
public class BuyType {

	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)  
	private Integer id;
	private Integer maxLimit;
	private String name;
	private String giftLimit;
	
}
