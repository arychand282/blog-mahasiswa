package com.projectside.blogmahasiswa.domain;

import lombok.Data;
import org.hibernate.annotations.GenericGenerator;

import javax.persistence.*;

@Data
@Entity // this tells hibernate to make a table out of this class
public class User {

    @Id
    @GeneratedValue(generator = "system-uuid")
    @GenericGenerator(name = "system-uuid", strategy = "uuid2")
    private String id;

    @Column(name = "username", length = 50)
    private String username;

    @Column(name = "email", length = 100)
    private String email;

    @Column(name = "password", length = 50)
    private String password;

    @Column(name = "fullName", length = 200)
    private String fullName;

    @Column(name = "deleteFlag")
    private boolean deleteFlag;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "privilege_id")
    private Privilege privilege;
}
