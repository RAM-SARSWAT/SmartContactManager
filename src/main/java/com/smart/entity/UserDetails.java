package com.smart.entity;

import com.smart.enums.Role;
import com.smart.enums.Status;
import lombok.Data;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

@Data
@Entity
@Table(name = "USER_DETAILS_SCM")
public class UserDetails {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "ID")
    private Long id;
    @Column(name = "USER_NAME")
    private String userName;
    @Column(name = "EMAIL_ID")
    private String email;
    @Column(name = "PASSWORD")
    private String password;
    @Column(name = "USER_ROLE")
    @Enumerated(EnumType.STRING)
    private Role userRole;
    @Column(name = "USER_STATUS")
    @Enumerated(EnumType.STRING)
    private Status enable;
    @Column(name = "IMAGE_URL")
    private String imageUrl;
    @Column(name = "ABOUT")
    private String about;
 @OneToMany(cascade = CascadeType.ALL,fetch = FetchType.LAZY,mappedBy = "userDetails")
    private List<ContactDetails> contactDetails=new ArrayList<>();
}
