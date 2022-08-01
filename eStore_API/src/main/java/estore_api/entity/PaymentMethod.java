package estore_api.entity;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table(name = "payment_method")
@Getter
@Setter
public class PaymentMethod {
	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)  
	private Integer id;
	private String name;
	private Integer discount;

}
