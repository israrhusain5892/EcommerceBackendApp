package com.ecommerce.EcommerceBackend.Repository;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.ecommerce.EcommerceBackend.Models.OrderPayment;

@Repository
public interface OrderPaymentRepo extends JpaRepository<OrderPayment,Integer> {
    
}
