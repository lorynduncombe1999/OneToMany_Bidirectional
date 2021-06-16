package com.oneToMany.api.controller;

import com.oneToMany.api.exception.DataNotFoundException;
import com.oneToMany.api.model.Role;
import com.oneToMany.api.model.User;
import com.oneToMany.api.repository.RoleRepository;
import com.oneToMany.api.service.RoleService;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.media.Content;
import io.swagger.v3.oas.annotations.media.Schema;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.responses.ApiResponses;
import io.swagger.v3.oas.annotations.tags.Tag;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.swing.text.html.Option;
import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping(value = "/api/role")
@Tag(name = "Role API", description = "Role API controller")
public class RoleController {

    @Autowired
    private RoleService roleService;

    @Autowired
    private RoleRepository roleRepository;

    //Post
    @PostMapping("/create")
    public ResponseEntity<Object> createRoleWithUser(@RequestBody Role role) {
        return roleService.addRoleWithUser(role);
    }

    //Get
    @GetMapping("/{id}")
    public ResponseEntity<Role> getRoleById(@PathVariable(value = "id") long id)
            throws DataNotFoundException {
        Role role = roleRepository.findById(id).orElseThrow(() -> new DataNotFoundException("Given Id not found"));
        return ResponseEntity.ok(role);
    }
    @Operation(summary = "Get the list of all the roles")
    @ApiResponses(value = {@ApiResponse(responseCode = "200", description = "Found the list of roles", content = {@Content(mediaType = "application/json", schema = @Schema(implementation = Role.class))})})
    @GetMapping("/list")
    public List<Role> getRoleList() {
        return roleRepository.findAll();
    }


    //put
    @PutMapping("/put/{id}")
    public ResponseEntity<?> updateRole(@PathVariable(value = "id") long id, @RequestBody Role role)
            throws Exception {
        return roleService.putRole(id, role);
    }

    //delete

    @DeleteMapping("/delete/{id}")
    public ResponseEntity<?> delete(@PathVariable(value = "id") long id) {
        return roleService.deleteRole(id);
    }
}
