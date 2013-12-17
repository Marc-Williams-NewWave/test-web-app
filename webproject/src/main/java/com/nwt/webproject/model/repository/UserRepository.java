package com.nwt.webproject.model.repository;

import com.nwt.framework.data.BaseJpaRepository;
import com.nwt.webproject.model.entity.Users;

/**
 * DD Repository for User related actions and events
 * 
 * @author: Prabakar Singaram
 * @created: 3/25/2013 11:02 AM
 * @company: NewWave Technologies Inc
 */
public interface UserRepository extends BaseJpaRepository<Users, Long> {
    /**
     * Finds a user with the given email
     *
     * @param email
     * @return
     */
    public Users findByEmail(String email);


    /**
     * Finds a user with the given username
     *
     * @param username
     * @return
     */
    public Users findByUsername(String username);
}
