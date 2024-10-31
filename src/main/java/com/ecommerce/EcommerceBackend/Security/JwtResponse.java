package com.ecommerce.EcommerceBackend.Security;


import com.ecommerce.EcommerceBackend.Dto.UserDto;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@Builder
@NoArgsConstructor
public class JwtResponse {

       private String token;
       private UserDto userDto;
}
