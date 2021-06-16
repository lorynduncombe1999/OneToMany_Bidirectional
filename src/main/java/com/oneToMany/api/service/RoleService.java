package com.oneToMany.api.service;

import com.oneToMany.api.model.Role;
import com.oneToMany.api.repository.RoleRepository;
import com.oneToMany.api.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

//Service class has
@Service
public class RoleService {

    @Autowired
    private RoleRepository roleRepository;

    @Autowired
    private UserRepository userRepository;

    //new Role with new Users
    // @Transactional means that eaither you complete transaction completley or it does not go through (all or nothing)
    @Transactional
    public ResponseEntity<Object> addRoleWithUser(Role role) {
        Role newRole = new Role();
        newRole.setRoleName((role.getRoleName()));
        newRole.setDescription(role.getDescription());
        newRole.setUsers(role.getUsers());
        Role saveRole = roleRepository.save(newRole);
        if (roleRepository.findById(saveRole.getId()).isPresent()) {
            return ResponseEntity.accepted().body("Successfully created new role with Users");
        } else {
            return ResponseEntity.unprocessableEntity().body("failed to create role with users");
        }
    }


    public ResponseEntity<?> putRole(long id, Role role) throws Exception {
        Role newRole = roleRepository.findById(id).orElseThrow(() -> new Exception("The Role was not found by the following id: " + id));
        if (roleRepository.existsById(id)) {
            newRole.setRoleName(role.getRoleName());
            newRole.setDescription(role.getDescription());
            newRole.setUsers(role.getUsers());
        }
        Role updatedRole = roleRepository.save((newRole));
        return ResponseEntity.ok(updatedRole);
    }

    public ResponseEntity<?> deleteRole(long id) {
        if (roleRepository.findById(id).isPresent()) {
            roleRepository.deleteById(id);

            if (roleRepository.findById(id).isPresent()) {
                return ResponseEntity.ok().body("Failed to delete given id");
            } else
                return ResponseEntity.ok().body("Succesfully Delete ID: " + id);

        } else return ResponseEntity.unprocessableEntity().body("No record found");
    }


}
