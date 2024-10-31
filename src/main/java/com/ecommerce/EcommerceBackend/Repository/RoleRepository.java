package com.ecommerce.EcommerceBackend.Repository;


import com.ecommerce.EcommerceBackend.Models.Role;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface RoleRepository extends JpaRepository<Role,Integer> {
}
