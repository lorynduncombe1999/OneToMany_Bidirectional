package com.oneToMany.api.controller;

import com.oneToMany.api.model.Role;
import com.oneToMany.api.model.User;
import com.oneToMany.api.repository.RoleRepository;
import com.oneToMany.api.repository.UserRepository;
import com.oneToMany.api.service.RoleService;
import com.oneToMany.api.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;
//User Delete needs to be implemented
@RestController
@RequestMapping(value = "/api")
public class UserController {

    @Autowired
    private UserRepository userRepository;

    @Autowired
    private RoleRepository roleRepository;

    @Autowired
    private UserService userService;

    @Autowired
    RoleService roleService;


    //Post- uses the role pathway to create a user. A user CANNOT exist without a role. However a role may exsist without a user
    @PostMapping("role/{id}")
    public ResponseEntity<?> updateRole(@PathVariable(value = "id") long id, @RequestBody Role role)
            throws Exception {
        return roleService.putRole(id, role);
    }



    //Put
    @PutMapping("user/put/{id}")
    public ResponseEntity<?> updateUser(@PathVariable(value = "id")long id, @RequestBody User user) throws Exception {
        return userService.putUser(id,user);
    }

    //Delete


    //Get user by id
    @GetMapping("user/{id}")
    public Optional<User> getUserById(@PathVariable(value = "id")long id){
        return userRepository.findById(id);
    }

    //returns a whole list of users
    @GetMapping("user/list")
    public List<User> getUserList() {
        return userRepository.findAll();
    }
}
