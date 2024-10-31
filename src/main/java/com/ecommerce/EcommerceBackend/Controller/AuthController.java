package com.ecommerce.EcommerceBackend.Controller;

import com.ecommerce.EcommerceBackend.Dto.UserDto;
import com.ecommerce.EcommerceBackend.Models.AuthRequest;
import com.ecommerce.EcommerceBackend.Models.Role;
import com.ecommerce.EcommerceBackend.Models.User;
import com.ecommerce.EcommerceBackend.Repository.RoleRepository;
import com.ecommerce.EcommerceBackend.Repository.UserRepository;
// import com.numetry.Travel.and.Tourism.Management.System.Security.CustomUserDetail;
import com.ecommerce.EcommerceBackend.Security.CustomUserDetailService;
import com.ecommerce.EcommerceBackend.Security.JwtResponse;
import com.ecommerce.EcommerceBackend.Security.JwtTokenHelper;
import com.ecommerce.EcommerceBackend.Service.UserService;
import jakarta.validation.Valid;
import lombok.extern.slf4j.Slf4j;

import java.util.List;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.AuthenticationProvider;
import org.springframework.security.authentication.DisabledException;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/auth")
@CrossOrigin
@Slf4j
public class AuthController {

     @Autowired
    private CustomUserDetailService userDetailsService;


     @Autowired
    private JwtTokenHelper jwtTokenHelper;

     @Autowired
     private UserService userService;

     @Autowired
    private AuthenticationManager authenticationManager;

    @Autowired
    private PasswordEncoder passwordencoder;

    @Autowired
    private RoleRepository rol;


     @Autowired
     private ModelMapper mapper;

     @PostMapping("/login")
     public ResponseEntity <?> createToken(@RequestBody AuthRequest authRequest){

            this.authenticate(authRequest.getEmail(),authRequest.getPassword());
           UserDetails userDetails=userDetailsService.loadUserByUsername(authRequest.getEmail());
           System.out.println(userDetails);
        //     String encodedPass=passwordencoder.encode(authRequest.getPassword());
          //  if((passwordencoder.matches(authRequest.getPassword() ,userDetails.getPassword()))==false){
          //       return new ResponseEntity<>("password is incorrect",HttpStatus.BAD_REQUEST);
          //  }
           String token=jwtTokenHelper.generateToken(userDetails);
           JwtResponse jwtResponse=JwtResponse.builder()
                           .token(token)
                           .userDto(mapper.map((User)userDetails,UserDto.class))
                           .build();


          return new ResponseEntity<>(jwtResponse, HttpStatus.ACCEPTED);
     }

     private void authenticate(String username,String password){

         UsernamePasswordAuthenticationToken authenticationToken=new UsernamePasswordAuthenticationToken(username,password);
         try{
             this.authenticationManager.authenticate(authenticationToken);
         }
         catch(DisabledException e){
             System.out.println("user is disable");
            
         }
         

     }

    @PostMapping("/register")
    public ResponseEntity<?> addUser(@Valid @RequestBody UserDto userDto){
         
        List<UserDto> users=userService.getUsers();
         boolean userExists=users.stream().anyMatch(
               user->user.getEmail().toLowerCase().equals(userDto.getEmail().toLowerCase())
            );
         if(userExists){
            return new ResponseEntity<>("User with this "+userDto.getEmail()+" already registered !!",HttpStatus.ACCEPTED);  
         }
         UserDto userDto2=userService.registerUser(userDto);
         return new ResponseEntity<>(userDto2,HttpStatus.ACCEPTED);
    }

    @GetMapping("/")
    public List<Role> getAll(){
         return rol.findAll();
    }

}
