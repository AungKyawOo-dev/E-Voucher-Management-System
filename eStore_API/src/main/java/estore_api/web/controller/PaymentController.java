package estore_api.web.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import estore_api.entity.PaymentMethod;
import estore_api.repository.PaymentMethodRepository;

@RestController
public class PaymentController {
	@Autowired
	private PaymentMethodRepository paymentRepository;

	@GetMapping("/api/paymentList")
	public List<PaymentMethod> getPaymentList() {
		return paymentRepository.findAll();
	}
}
