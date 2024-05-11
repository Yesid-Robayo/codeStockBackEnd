package com.codestock.codeStockBackEnd.controller;

import com.codestock.codeStockBackEnd.model.dto.PersonDTO;
import com.codestock.codeStockBackEnd.model.dto.UserDTO;
import com.codestock.codeStockBackEnd.model.entity.Password;
import com.codestock.codeStockBackEnd.service.IPassword;
import com.codestock.codeStockBackEnd.service.IPasswordHash;
import com.codestock.codeStockBackEnd.service.IPerson;
import com.codestock.codeStockBackEnd.service.IUser;
import io.swagger.v3.oas.annotations.tags.Tag;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/v1")
@Tag(name = "User", description = "User Controller")
public class UserController {

    private final IUser userService;
    private final IPerson personService;
    private final IPassword passwordService;
    private final IPasswordHash passwordHashService;

    @Autowired
    public UserController(IUser userService, IPerson personService, IPassword passwordService, IPasswordHash passwordHashService) {
        this.userService = userService;
        this.personService = personService;
        this.passwordService = passwordService;
        this.passwordHashService = passwordHashService;

    }


    @PostMapping("/user")
    @Transactional(rollbackFor = Exception.class)
    public ResponseEntity<?> createUser(@RequestBody UserDTO user, @RequestBody PersonDTO person, BindingResult bindingResult) {

        try {

            if (bindingResult.hasErrors()) {
                return ResponseEntity.badRequest().body("Invalid data provided");
            }

            String passwordSalt = passwordHashService.generateSalt();
            String passwordHash = passwordHashService.encodePassword(user.getPassword(), passwordSalt);

            personService.save(person);
            userService.save(user);
            passwordService.save(Password.builder().idUser(user.getIdUser()).salt(passwordSalt).hash(passwordHash).build());
            return ResponseEntity.ok("User Created Successfully");
        } catch (Exception e) {
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body("Error creating user");

        }
    }

    @DeleteMapping("/user/{idPerson}")
    @Transactional(rollbackFor = Exception.class)
    public ResponseEntity<?> deleteByIdPerson(@PathVariable Integer idPerson) {
        try {

            personService.delete(idPerson);
            userService.deleteByIdPerson(idPerson);
            return ResponseEntity.ok("User deleted");
        } catch (Exception e) {
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body("Error deleting user");
        }


    }

}
