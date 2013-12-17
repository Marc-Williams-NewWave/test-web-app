package com.nwt.webproject.service.impl;

import java.util.Date;

import javax.annotation.PostConstruct;
import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.nwt.framework.data.BaseJpaServiceImpl;
import com.nwt.framework.exception.database.NotFoundException;
import com.nwt.framework.validation.EntityValidator;
import com.nwt.framework.validation.Validity;
import com.nwt.webproject.common.Key;
import com.nwt.webproject.common.Message;
import com.nwt.webproject.model.entity.Users;
import com.nwt.webproject.model.repository.UserRepository;
import com.nwt.webproject.service.UserService;

/**
 * Service impl class to implement services for accessing the Users object entity.
 * This class acts as an interface between the outer world and the UserRepository
 *
 * @author: Prabakar Singaram
 * @created: 3/25/2013 11:05 AM
 * @company: NewWave Technologies Inc
 */
@Service
@Transactional
public class UserServiceImpl extends BaseJpaServiceImpl<Users, Long> implements UserService {
    private @Autowired UserRepository userRepository;
    private @Autowired Message msg;
    private @Autowired Key key;


    @PostConstruct
    public void setupService() {
        this.baseJpaRepository = userRepository;
        this.entityClass = Users.class;
        this.baseJpaRepository.setupEntityClass(Users.class);
    }


     public boolean isValidPass(Users user, String pass) {
        return user.getPassWord().equals(Users.hashPassword(pass));
    }


     public Users registerUser(Users user, HttpServletRequest request) {
        user.setPassWord(Users.hashPassword(user.getPassWord()));
        user.setCurrentLoginAt(new Date());
        user.setCurrentLoginIp(request.getRemoteHost());
        user.setLoginCount(0);
        return userRepository.insert(user);
    }


     public Users loginUser(final Users user, final HttpServletRequest request) {
        user.setLastLoginAt(user.getCurrentLoginAt());
        user.setLastLoginIp(user.getCurrentLoginIp());
        user.setCurrentLoginAt(new Date());
        user.setCurrentLoginIp(request.getRemoteHost());
        user.setLoginCount(user.getLoginCount() + 1);
        user.setUpdatedAt(new Date());

        return userRepository.update(user);
    }


     public boolean isUsernameExists(String username) {
        if (userRepository.findByUsername(username) != null) {
            return true;
        } else
            return false;
    }


     public boolean isEmailExists(String email) {
        if (userRepository.findByEmail(email) != null) {
            return true;
        } else
            return false;
    }


     public Validity validate(Users user) {
        EntityValidator<Users> entityValidator = new EntityValidator<Users>();
        Validity validity = entityValidator.validate(user, Users.class);

        // Check for username and email uniqueness
        if (isUsernameExists(user.getUserName())) {
            validity.addError(msg.userExists);
        }

        if (isEmailExists(user.getEmail())) {
            validity.addError(msg.emailExists);
        }

        return validity;
    }


     public Users findByUsername(String username) throws NotFoundException {
        Users user = userRepository.findByUsername(username);

        if(user != null) {
            return user;
        } else {
            throw new NotFoundException(key.unfMsg, key.unfCode);
        }
    }
}
