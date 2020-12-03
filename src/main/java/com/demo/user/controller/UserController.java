package com.demo.user.controller;

import javax.validation.constraints.Positive;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.demo.user.exception.RecordNotFoundException;
import com.demo.user.model.User;
import com.demo.user.service.UserService;

/**
* <h1>User Details Controller</h1>
* The class is the controller for UserDetails operations.
* <p>
*
* @author  Ketki Gupta
* @version 1.0
* @since   2020-12-03
*/
@RestController
@Validated
public class UserController {
    @Autowired
    public UserService service;

    /**
     * This API method is used to retrieve user details using user Id.
     *
     * @param  Id             This is the user id.
     * @return ResponseEntity This is the HTTP entity with retrieved user details.
     */
    @GetMapping("/api/userdetails/{id}")
    public ResponseEntity<User> getEmployeeById(@PathVariable
            @Positive Long id) throws RecordNotFoundException{
        User userEntity = service.getUserById(id);

        return new ResponseEntity<User>(userEntity, new HttpHeaders(), HttpStatus.OK);
    }

    /**
     * This API method is used to update user details.
     *
     * @param  Id             This is the user id.
     * @param  User           This is the user details to be updated.
     * @return ResponseEntity This is the HTTP entity with updated user details.
     */
    @PutMapping("/api/updateuser/{id}")
    public ResponseEntity<User> updateUserDetails (
      @RequestBody User userDetails, @PathVariable @Positive Long id)
              throws RecordNotFoundException {
        userDetails.setId(id);
        User updatedDetails = service.updateUserDetails(userDetails);
        return new ResponseEntity<User>(updatedDetails, new HttpHeaders(), HttpStatus.OK);
    }

}
