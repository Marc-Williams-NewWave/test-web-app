package com.nwt.webproject.service;

import javax.servlet.http.HttpServletRequest;

import com.nwt.framework.data.BaseService;
import com.nwt.framework.exception.database.NotFoundException;
import com.nwt.webproject.model.entity.Users;

/**
 * Service class to have business logic operation on User entity
 *
 * @author: Prabakar Singaram
 * @created: 3/24/2013 3:51 PM
 * @company: NewWave Technologies Inc
 */
public interface UserService extends BaseService<Users, Long> {

    /**
     * Register a new user into the system
     *
     * @param user
     * @param request
     *
     * @return
     */
    public Users registerUser(Users user, HttpServletRequest request);


    /**
     * Login a new user into the system
     *
     * @param user
     * @param request
     *
     * @return
     */
    public Users loginUser(Users user, HttpServletRequest request);

    /**
     * Method to validate whether the given password
     * is same as users password stored in the system
     *
     * @param user
     * @param pass
     *
     * @return
     */
    public boolean isValidPass(Users user, String pass);


    /**
     * Validates whether the given username already
     * exists in the system.
     *
     * @param username
     *
     * @return
     */
    public boolean isUsernameExists(String username);


    /**
     * Validates whether the given email already
     * exists in the system.
     *
     * @param email
     *
     * @return
     */
    public boolean isEmailExists(String email);


    /**
     * Finds a user entity by the given username
     *
     * @param username
     * @return
     */
    public Users findByUsername(String username) throws NotFoundException;
}
