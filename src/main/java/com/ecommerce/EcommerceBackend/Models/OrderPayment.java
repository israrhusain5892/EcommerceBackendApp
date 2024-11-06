package com.ecommerce.EcommerceBackend.Models;

import java.util.Date;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.OneToOne;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Data
@AllArgsConstructor
@NoArgsConstructor
public class OrderPayment {
         @Id
         @GeneratedValue(strategy = GenerationType.IDENTITY)
         private Long id;
         private String receiptNo;
         private String order_id;
         private Integer amount;
         private Date date;
         private String paymentStatus;
         
         @ManyToOne
         private User user;

        //  @OneToOne
        //  private HotBooking hotelBooking;

}
