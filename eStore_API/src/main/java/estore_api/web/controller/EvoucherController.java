package estore_api.web.controller;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import com.stripe.exception.StripeException;

import estore_api.dto.EVoucherRequest;
import estore_api.entity.EVoucher;
import estore_api.entity.User;
import estore_api.repository.EVoucherRepository;
import estore_api.repository.UserRepository;
import estore_api.service.EVoucherService;

@RestController
public class EvoucherController {

	@Autowired
	private EVoucherRepository eVoucherRepository;

	@Autowired
	private UserRepository userRepository;

	@Autowired
	private EVoucherService eVoucherService;

	@GetMapping("/{user_id}/vouchers")
	public @ResponseBody List<EVoucher> getVouchers(@PathVariable("user_id") Integer userId) {
		Optional<User> user = userRepository.findById(userId);
		return user.get().getEVoucherList();
	}

	@GetMapping("/voucher/{voucher_id}")
	public @ResponseBody EVoucher getEVoucher(@PathVariable("voucher_id") Integer voucherId) {
		return eVoucherRepository.findById(voucherId).get();
	}

	@GetMapping("/verifyVoucher/{voucher_id}")
	public @ResponseBody String verifyVoucher(@PathVariable("voucher_id") Integer voucherId) {
		return eVoucherService.verifyVoucher(voucherId);
	}
	
	@PostMapping("/checkout")
	public @ResponseBody EVoucher checkout(@RequestBody EVoucherRequest request) throws StripeException {
		return eVoucherService.checkout(request);
	}
}
