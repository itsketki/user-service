package com.demo.user.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.demo.user.model.User;

/**
* <h1>User Details Repository</h1>
* The interface is the data layer for UserDetails operations.
* <p>
*
* @author  Ketki Gupta
* @version 1.0
* @since   2020-12-03
*/
@Repository
public interface UserRepository extends JpaRepository<User, Long>{

}
