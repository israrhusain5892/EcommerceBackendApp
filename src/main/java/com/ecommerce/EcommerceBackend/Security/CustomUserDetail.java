// package com.numetry.Travel.and.Tourism.Management.System.Security;

// import com.numetry.Travel.and.Tourism.Management.System.Model.Role;
// import com.numetry.Travel.and.Tourism.Management.System.Model.User;
// import org.springframework.beans.factory.annotation.Autowired;
// import org.springframework.boot.autoconfigure.AutoConfigureOrder;
// import org.springframework.security.core.GrantedAuthority;
// import org.springframework.security.core.authority.SimpleGrantedAuthority;
// import org.springframework.security.core.userdetails.UserDetails;

// import java.util.ArrayList;
// import java.util.Collection;
// import java.util.List;
// import java.util.Set;

// public class CustomUserDetail extends User implements UserDetails {

//    private User user;
//    public CustomUserDetail(User user){
//        super();
//        this.user=user;
//    }
//    @Override
//    public Collection<? extends GrantedAuthority> getAuthorities() {

//        List<GrantedAuthority> grantedAuthorityList=new ArrayList<>();
//        Set<Role> roles=user.getRoles();
//        for(Role role:roles){

//            grantedAuthorityList.add(new SimpleGrantedAuthority(role.getName()));
//        }
//        return grantedAuthorityList;
//    }

//    @Override
//    public String getUsername() {
//        return user.getEmail();
//    }

//    @Override
//    public boolean isAccountNonExpired() {
//        return true;
//    }

//    @Override
//    public boolean isAccountNonLocked() {
//        return true;
//    }

//    @Override
//    public boolean isCredentialsNonExpired() {
//        return true;
//    }

//    @Override
//    public boolean isEnabled() {
//        return true;
//    }
// }
