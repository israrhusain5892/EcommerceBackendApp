package com.ecommerce.EcommerceBackend.Controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import com.ecommerce.EcommerceBackend.Dto.OrderPaymentDto;
import com.ecommerce.EcommerceBackend.Service.OrderService;
import com.razorpay.Order;

@RestController
@RequestMapping("/public")
@CrossOrigin
public class OrderController {
       
    @Autowired
    private OrderService orderService;
     
    @PostMapping("/create-order/{amount}")
    @ResponseBody
    public String createOrder(@PathVariable Integer amount) throws Exception{
          
            return orderService.doPayment(amount);
             
    }

    // @PostMapping("/update-order/{userId}")
    // public OrderPaymentDto updateOrder(@RequestBody OrderPaymentDto paymentOrderDto,@PathVariable Integer userId,
    // @) {
             
    //         // Long id=(long)(hotelBookingId.charAt(hotelBookingId.length()-1) - '0');
    //        Long id= (long)Integer.parseInt(hotelBookingId.replaceAll("[^0-9]",""));
    //         System.out.println(id);
    //         return hotelPaymentService.updateOrder(hotelPaymentOrderDto,userId,id);
             
    // }
}
