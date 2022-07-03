package com.smart.service.serviceImp;

import com.smart.entity.UserDetail;
import com.smart.enums.Role;
import com.smart.enums.Status;
import com.smart.repository.UserDetailsRepository;
import com.smart.service.UserDetailService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;
import javax.transaction.Transactional;

@Service
public class UserDetailServiceImp implements UserDetailService {

    @Autowired
    UserDetailsRepository userDetailsRepository;
    @Autowired
    BCryptPasswordEncoder passwordEncoder;

    @Override
    @Transactional(rollbackOn = Exception.class)
    public UserDetail registerUser(UserDetail userDetails) {
        userDetails.setUserRole(Role.USER);
        userDetails.setStatus(Status.ACTIVE);
       userDetails.setPassword(passwordEncoder.encode(userDetails.getPassword()));
         userDetailsRepository.save(userDetails);
        return userDetails;
    }
}
