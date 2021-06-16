package com.oneToMany.api.service;

import com.oneToMany.api.model.Role;
import com.oneToMany.api.model.User;
import com.oneToMany.api.repository.RoleRepository;
import com.oneToMany.api.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.RequestBody;

@Service
public class UserService {

    @Autowired
    private RoleRepository roleRepository;

    @Autowired
    private UserRepository userRepository;

//Delete
public ResponseEntity<?> deleteRole(long id) {

    //if the given id exsiss delete id
    if (userRepository.findById(id).isPresent()) {
        userRepository.deleteById(id);

        if (userRepository.findById(id).isPresent()) {
            return ResponseEntity.ok().body("Failed to delete given id");
        } else
            return ResponseEntity.ok().body("Succesfully Delete ID: " + id);

    } else return ResponseEntity.unprocessableEntity().body("No record found");
}
//Put

    public ResponseEntity<?>putUser(long id, User user) throws Exception{
        User updatedUser = userRepository.findById(id).orElseThrow(() -> new Exception("Post not found by this id" + id));
        updatedUser.setUserName(user.getUserName());
        updatedUser.setPassword(user.getPassword());
        updatedUser.setName(user.getName());
        updatedUser.setEmail(user.getEmail());
        updatedUser.setRole(user.getRole());
       User newUser =  userRepository.save(updatedUser);
       return ResponseEntity.ok(newUser);
    }
}

