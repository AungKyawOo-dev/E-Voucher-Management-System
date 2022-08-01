package estore_api.service;

import java.util.Date;
import java.util.Optional;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import estore_api.constants.EVoucherStatus;
import estore_api.dto.EVoucherRequest;
import estore_api.entity.EVoucher;
import estore_api.repository.EVoucherRepository;
import estore_api.util.StringUtil;

@Service
public class EVoucherService {

	@Autowired
	EVoucherRepository eVoucherRepository;

	public String verifyVoucher(Integer voucherId) {
		Optional<EVoucher> voucher = eVoucherRepository.findById(voucherId);
		Date now = new Date();
		// check the voucher is used or not
		if (EVoucherStatus.USED.status == voucher.get().getStatus()) {
			return EVoucherStatus.USED.name();
		}
		// check the voucher expire date
		if (voucher.get().getExpiryDate().before(now)) {
			return EVoucherStatus.EXPIRED.name();
		}
		return EVoucherStatus.VALID.name();
	}

	public EVoucher checkout(EVoucherRequest request) {
		ModelMapper mapper = new ModelMapper();
		EVoucher evoucher = mapper.map(request, EVoucher.class);
		// generate voucher code instead of generating in promocode system
		evoucher.setCode(StringUtil.getUnitUniversalIdentifier());
		
		return eVoucherRepository.save(evoucher);
		
	}
}
