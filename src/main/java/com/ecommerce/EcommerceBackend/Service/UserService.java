package com.ecommerce.EcommerceBackend.Service;

import  com.ecommerce.EcommerceBackend.Dto.UserDto;
import  com.ecommerce.EcommerceBackend.Models.Role;
import  com.ecommerce.EcommerceBackend.Models.User;
import  com.ecommerce.EcommerceBackend.Repository.RoleRepository;
import  com.ecommerce.EcommerceBackend.Repository.UserRepository;
import  com.ecommerce.EcommerceBackend.Security.JwtResponse;
import  com.ecommerce.EcommerceBackend.Security.JwtTokenHelper;
// import  com.ecommerce.EcommerceBackend.Service;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
// import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;
import java.util.UUID;

@Service
public class UserService {
 
    @Autowired
     private ModelMapper modelMapper;

    @Autowired
    private UserRepository userRepository;

   
      @Autowired
      private PasswordEncoder passwordEncoder;

    @Autowired
    private RoleRepository roleRepository;

    @Autowired
    private JwtTokenHelper jwtTokenHelper;

    public UserDto registerUser(UserDto userDto){
      //    Role role=roleRepository.findById(2).get();
          User user=modelMapper.map(userDto,User.class);
          user.setPassword(passwordEncoder.encode(userDto.getPassword()));
          Set<Role> roles=user.getRoles();
          if(roles==null){
            roles=new HashSet<>();
          }
      //      roles.add(ROLE_USER);
      //     user.setRoles(roles);
      //     System.out.println(role);


          User savedUser=userRepository.save(user);

         
         return modelMapper.map(savedUser,UserDto.class);
      }
        

    public UserDto getUser(Integer id){

          User user= userRepository.findById(id).get();
          UserDto userDto=modelMapper.map(user,UserDto.class);
          userDto.setRoles(user.getRoles());
          return userDto;
    }

    public String deleteUser(Integer id){
         userRepository.deleteById(id);
         return "user deleted successfully";
    }

    public UserDto updateUser(UserDto userDto,Integer id){

          User user = userRepository.findById(id).get();
          user.setEmail(userDto.getEmail());
          user.setName(userDto.getName());
          user.setPassword(userDto.getPassword());
          user.setMobileNumber(userDto.getMobileNumber());
          User savedUser=userRepository.save(user);
          return modelMapper.map(savedUser,UserDto.class);
    }

    public List<UserDto> getUsers(){
         List<UserDto> res=new ArrayList<>();
         List<User> users=userRepository.findAll();

         for(User user:users){
               UserDto userDto=modelMapper.map(user,UserDto.class);
               userDto.setRoles(user.getRoles());
               res.add(userDto);
         }
         return res;
    }
}
