package estore_api.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import estore_api.entity.PaymentMethod;

public interface PaymentMethodRepository extends JpaRepository<PaymentMethod, Integer> {

}
