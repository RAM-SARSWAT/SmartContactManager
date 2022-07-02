package com.smart.repository;

import com.smart.entity.UserDetails;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

public interface UserDetailsRepository extends JpaRepository<UserDetails,Long> {
    @Query(nativeQuery = true,value = "select u from UserDetails u where u.email=:email")
    UserDetails getUserByUserName(String email);
}
