package com.smart.dto;

import com.smart.entity.ContactDetails;
import lombok.Data;

import java.util.List;

@Data
public class UserDetailsRequest {
    private Long id;
    private String userName;
    private String email;
    private String password;
    private String imageUrl;
    private String about;
    private List<ContactDetails> contactDetails;
}
