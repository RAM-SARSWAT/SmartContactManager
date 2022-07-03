package com.smart.entity;

import lombok.Data;

import javax.persistence.*;

@Data
@Entity
@Table(name = "CONTACT_DETAILS_SCM")
public class ContactDetails {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "CID")
    private Long cId;
    @Column(name = "NAME")
    private String name;
    @Column(name = "NICK_NAME")
    private String nickName;
    @Column(name = "WORK")
    private String work;
    @Column(name = "MOBILE_NUMBER")
    private String mobileNo;
    @Column(name = "IMAGE_URL")
    private String imageUrl;
    @Column(name = "DESCRIPTION")
    private String description;
    @Column(name = "EMAIL")
    private String email;
    @ManyToOne
    private UserDetail userDetails;
}
