package com.smart.repository;

import com.smart.entity.UserDetail;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

public interface UserDetailsRepository extends JpaRepository<UserDetail,Long> {
    @Query(nativeQuery = true,value = "select * from USER_DETAILS_SCM  where EMAIL_ID= :email")
    UserDetail getUserByUserName(@Param("email") String email);
}
