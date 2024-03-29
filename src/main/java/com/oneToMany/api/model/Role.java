package com.oneToMany.api.model;

import lombok.*;

import javax.persistence.*;
import javax.validation.constraints.Size;
import java.util.List;

@Entity
@Table(name = "role_table")
@Getter
@Setter
@NoArgsConstructor
@ToString
//extends audit model so that the created, updated, and date are included once new role is generated
//model classes are used to demonstrated the variables necessary to create a role or user (in user class)
public class Role extends AuditModel {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private long id;

    @Column(nullable = false)
    private String roleName;

    @Column(nullable = false)
    @Size(min = 25, max = 255)
    private String description;

    @OneToMany(targetEntity = User.class,cascade = CascadeType.ALL)
    private List<User> users;

    public Role(String roleName, String description, List<User> users) {
        this.roleName = roleName;
        this.description = description;
        this.users = users;
    }
}
