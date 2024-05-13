package com.codestock.codeStockBackEnd.controller;

import com.codestock.codeStockBackEnd.model.dto.*;
import com.codestock.codeStockBackEnd.model.entity.*;
import com.codestock.codeStockBackEnd.service.*;
import io.swagger.v3.oas.annotations.tags.Tag;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;

import java.util.Map;

/**
 * This class represents the User Controller.
 * It handles HTTP requests and responses for operations related to users.
 * It uses Spring Boot annotations for RESTful web services.
 */
@RestController
@RequestMapping("/api/v1")
@Tag(name = "User", description = "User Controller")
public class UserController {

    // The IUser service to handle user operations.
    private final IUser userService;
    // The IPerson service to handle person operations.
    private final IPerson personService;
    // The IPassword service to handle password operations.
    private final IPassword passwordService;
    // The IPasswordHash service to handle password hashing operations.
    private final IPasswordHash passwordHashService;
    // The IRolUser service to handle role user operations.
    private final IRolUser rolUserService;
    // The IClient service to handle client operations.
    private final IClient clientService;

    /**
     * Constructor for the UserController.
     * It uses Spring's @Autowired annotation for dependency injection.
     *
     * @param userService         The service to handle user operations.
     * @param personService       The service to handle person operations.
     * @param passwordService     The service to handle password operations.
     * @param passwordHashService The service to handle password hashing operations.
     * @param rolUserService      The service to handle role user operations.
     * @param clientService       The service to handle client operations.
     */
    @Autowired
    public UserController(IUser userService, IPerson personService, IPassword passwordService, IPasswordHash passwordHashService, IRolUser rolUserService, IClient clientService) {
        this.userService = userService;
        this.personService = personService;
        this.passwordService = passwordService;
        this.passwordHashService = passwordHashService;
        this.rolUserService = rolUserService;
        this.clientService = clientService;


    }

    /**
     * Handles the POST request to validate a user.
     *
     * @param autenticatedDTO The AutenticatedDTO object that contains the user's email and password.
     * @return A ResponseEntity containing the user's information or an error message.
     */

    @PostMapping("/user/validate")
    public ResponseEntity<?> ValidateUser(@RequestBody AutenticatedDTO autenticatedDTO, BindingResult bindingResult) {
        try {
            if (bindingResult.hasErrors()) {
                return ResponseEntity.badRequest().body("Invalid data provided");
            }
            User findUser = userService.findByEmail(autenticatedDTO.getEmail());
            if (findUser == null) {
                return ResponseEntity.status(HttpStatus.NOT_FOUND).body("User not found");
            }
            Password findPassword = passwordService.findByIdUser(findUser.getIdUser());

            if (passwordHashService.verifyPassword(autenticatedDTO.getPassword(), findPassword.getHash())) {
                return ResponseEntity.status(HttpStatus.UNAUTHORIZED).body("Invalid password");
            }
            Person person = personService.findById(findUser.getIdPerson());
            return ResponseEntity.ok(PersonDTO.builder().IdPerson(person.getIdPerson()).name(person.getName()).lastName(person.getLastName()).dateOfBirth(person.getDateOfBirth()).phone(person.getPhone()).gender(person.getGender()).build());
        } catch (
                Exception e) {
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body("Error validating user");
        }
    }

    /**
     * Handles the POST request to create a user.
     *
     * @param userRequestDTO The UserRequestDTO object that contains the data to be saved.
     * @return A ResponseEntity containing a success message or an error message.
     */
    @PostMapping("/user")
    @Transactional(rollbackFor = Exception.class)
    public ResponseEntity<?> createUser(@RequestBody UserRequestDTO userRequestDTO, BindingResult bindingResult) {

        try {

            if (bindingResult.hasErrors()) {
                return ResponseEntity.badRequest().body("Invalid data provided");
            }

            String passwordHash = passwordHashService.encodePassword(userRequestDTO.getPassword());
            Person savedPerson = personService.save(PersonDTO.builder().name(userRequestDTO.getName()).lastName(userRequestDTO.getLastName()).dateOfBirth(userRequestDTO.getDateOfBirth()).phone(userRequestDTO.getPhone()).gender(userRequestDTO.getGender()).build());
            User savedUser = userService.save(UserDTO.builder().email(userRequestDTO.getEmail()).idPerson(savedPerson.getIdPerson()).build());
            passwordService.save(Password.builder().idUser(savedUser.getIdUser()).hash(passwordHash).build());
            rolUserService.save(RolUser.builder().idRole(2).idUser(savedUser.getIdUser()).build());
            clientService.save(Client.builder().idPerson(savedPerson.getIdPerson()).build());


            return ResponseEntity.ok(Map.of("statusCode", HttpStatus.OK.value(), "message", "User Created Successfully"));
        } catch (Exception e) {
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body("Error creating user");

        }
    }

    /**
     * Handles the PUT request to change a user's password.
     *
     * @param changePassDTO The ChangePassDTO object that contains the user's email, old password, and new password.
     * @return A ResponseEntity containing a success message or an error message.
     */
    @PutMapping("/user/changePass")
    public ResponseEntity<?> ChangePass(@RequestBody ChangePassDTO changePassDTO, BindingResult bindingResult) {
        try {
            if (bindingResult.hasErrors()) {
                return ResponseEntity.badRequest().body("Invalid data provided");
            }
            User findUser = userService.findByEmail(changePassDTO.getEmail());
            if (findUser == null) {
                return ResponseEntity.status(HttpStatus.NOT_FOUND).body("User not found");
            }
            Password findPassword = passwordService.findByIdUser(findUser.getIdUser());
            if (passwordHashService.verifyPassword(changePassDTO.getOldPass(), findPassword.getHash())) {
                return ResponseEntity.status(HttpStatus.UNAUTHORIZED).body("Invalid password");
            }
            String passwordHash = passwordHashService.encodePassword(changePassDTO.getNewPass());
            passwordService.save(Password.builder().idUser(findUser.getIdUser()).hash(passwordHash).build());
            return ResponseEntity.ok(Map.of("statusCode", HttpStatus.OK.value(), "message", "Password changed successfully"));
        } catch (Exception e) {
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body("Error changing password");
        }
    }

    /**
     * Handles the DELETE request to delete a user by its ID.
     *
     * @param idPerson The ID of the user to be deleted.
     * @return A ResponseEntity containing a success message or an error message.
     */
    @DeleteMapping("/user/{idPerson}")
    @Transactional(rollbackFor = Exception.class)
    public ResponseEntity<?> deleteByIdPerson(@PathVariable Integer idPerson) {
        try {

            User findUser = userService.findByIdPerson(idPerson);
            if (findUser == null) {
                return ResponseEntity.status(HttpStatus.NOT_FOUND).body("User not found");
            }

            passwordService.deleteByIdUser(findUser.getIdUser());
            clientService.deleteByIdPerson(idPerson);
            rolUserService.deleteByIdUser(findUser.getIdUser());
            userService.delete(findUser.getIdUser());
            personService.delete(idPerson);

            return ResponseEntity.ok(Map.of("statusCode", HttpStatus.OK.value(), "message", "User deleted successfully"));
        } catch (Exception e) {
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body("Error deleting user");
        }


    }

}
