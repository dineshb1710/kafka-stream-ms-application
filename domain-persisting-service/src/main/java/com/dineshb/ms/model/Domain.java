package com.dineshb.ms.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;

@Data
@Entity
@Table(name = "domains")
@AllArgsConstructor
@NoArgsConstructor
public class Domain {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;
    private String domain;
    private String created_date;
    private String updated_date;
    private String country;
    private boolean isDead;
    private String[] A;
    private String[] NS;
    private String CNAME;
    private String MX;
    private String TXT;
}
