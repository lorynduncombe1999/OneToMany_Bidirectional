package com.oneToMany.api.model;

import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

import javax.persistence.*;
import javax.validation.constraints.Size;

@Entity
@Table(name = "user_table")
@Getter
@Setter
@NoArgsConstructor
@ToString
public class User extends AuditModel{

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private long id;

    @Column(nullable = false)
    private String name;

    @Column(unique = true, nullable = false)
    private String userName;

    @Column(unique = true, nullable = false)
    private String email;

    @Column(nullable = false)
    @Size(min = 8, max = 32)
    private String password;

    //creates relationship between the two classes
    //Many to one relationship because one role my have multiple users but a user may only have ONE ROLE
    @JsonIgnore
    @ManyToOne (targetEntity=Role.class)
    private Role role;
   /* public static void main(String[] args) {
        //loops through string
        //checks to see if space is in a string
        String someName = "myRestAPIProject";
        for(char index: someName.toCharArray()){
             if(index == '_'|| index == ' ')
                System.out.println(index);
        }
    }*/

}
