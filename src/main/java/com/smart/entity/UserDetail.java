package com.smart.entity;

import com.smart.enums.Role;
import com.smart.enums.Status;
import lombok.Data;

import javax.persistence.*;
import javax.validation.constraints.Email;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Pattern;
import javax.validation.constraints.Size;
import java.util.ArrayList;
import java.util.List;

@Data
@Entity
@Table(name = "USER_DETAILS_SCM")
public class UserDetail {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "ID")
    private Long id;
    @NotBlank(message = "Name fields can not be Blank")
    @Size(min = 2,max = 25,message = "Name must be between 2-25 character")
    @Column(name = "USER_NAME")
    private String userName;
    @Column(name = "EMAIL_ID")
    @Size(min = 5,max = 40,message = "Email must be between 5-40 character")
    @Email(regexp = "^[a-zA-Z0-9+_.-]+@[a-zA-Z0-9.-]+$")
    private String email;
    @Size(min = 5,max = 300,message = "Password must be between 5-30 character")
    @NotBlank(message = "Password can not be Blank")
    @Column(name = "PASSWORD")
    private String password;
    @Column(name = "USER_ROLE")
    @Enumerated(EnumType.STRING)
    private Role userRole;
    @Column(name = "USER_STATUS")
    @Enumerated(EnumType.STRING)
    private Status status;
    @Column(name = "IMAGE_URL")
    private String imageUrl;
    @Column(name = "ABOUT")
    @NotBlank(message = "About can not be Blank")
    private String about;
 @OneToMany(cascade = CascadeType.ALL,fetch = FetchType.LAZY,mappedBy = "userDetails")
    private List<ContactDetails> contactDetails=new ArrayList<>();
}
