package com.ecommerce.EcommerceBackend.Repository;

import com.ecommerce.EcommerceBackend.Models.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;


@Repository
public interface UserRepository extends JpaRepository<User, Integer> {

       User findByEmail(String username);
}
