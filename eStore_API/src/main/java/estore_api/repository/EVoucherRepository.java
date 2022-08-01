package estore_api.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import estore_api.entity.EVoucher;

public interface EVoucherRepository extends JpaRepository<EVoucher, Integer> {
	List<EVoucher> findByCode(String code);
}
