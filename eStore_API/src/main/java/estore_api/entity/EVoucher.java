package estore_api.entity;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.annotations.UpdateTimestamp;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
@Entity
@Table(name = "e_voucher")
public class EVoucher {

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Integer id;
	private String title;
	private String description;
	@Column(unique = true)
	private String code;
	private Date expiryDate;
	private String image;
	private int status;
	private Integer amount;
//	@OneToOne(cascade = CascadeType.ALL)
//	@JoinColumn(name = "payment_method_id", referencedColumnName = "id")
//	@Column(updatable = false)
//	private PaymentMethod paymentMethod;
//	private Integer quantity;
//	@OneToOne(cascade = CascadeType.ALL)
//	@JoinColumn(name = "buy_type_id", referencedColumnName = "id")
//	@Column(updatable = false)
//	private BuyType buyType;
	@CreationTimestamp
	@Column(updatable = false)
	private Date createdAt;
	@UpdateTimestamp
	private Date updatedAt;
	private Date deletedAt;
}
