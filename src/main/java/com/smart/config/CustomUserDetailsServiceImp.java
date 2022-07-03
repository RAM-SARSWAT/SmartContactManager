package com.smart.config;

import com.smart.entity.UserDetail;
import com.smart.repository.UserDetailsRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;

import static com.smart.constant.Constant.*;

public class CustomUserDetailsServiceImp implements UserDetailsService {
    @Autowired
    UserDetailsRepository userDetailsRepository;
    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
      UserDetail user=userDetailsRepository.getUserByUserName(username);
      if(user==null){
          throw new UsernameNotFoundException(USER_NOT_FOUND_ERR);
      }
        return new CustomUserDetails(user);
    }
}
