package com.ecommerce.EcommerceBackend.Dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import java.util.*;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class OrderPaymentDto {
     
         private Long id;
         private String receiptNo;
         private String order_id;
         private Integer amount;
         private String paymentStatus;
         private Date date;
         private UserDto user;
         private String bookingId; 
         private String bookingStatus;

        private Integer stayDuration;
      

        // private HotelBookingDto hotelBookingDto;
}