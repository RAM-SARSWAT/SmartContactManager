package com.smart.service.serviceImp;

import com.smart.entity.UserDetails;
import com.smart.enums.Role;
import com.smart.enums.Status;
import com.smart.repository.UserDetailsRepository;
import com.smart.service.UserDetailService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class UserDetailServiceImp implements UserDetailService {

    @Autowired
    UserDetailsRepository userDetailsRepository;

    @Override
    public UserDetails registerUser(UserDetails userDetails) {
        userDetails.setUserRole(Role.USER);
        userDetails.setStatus(Status.ACTIVE);
        userDetails=userDetailsRepository.save(userDetails);
        return userDetails;
    }
}
