package com.nwt.webproject.model.repository.impl;

import org.springframework.stereotype.Repository;

import com.nwt.framework.data.BaseHibernateJpaRepository;
import com.nwt.webproject.model.entity.Users;
import com.nwt.webproject.model.repository.UserRepository;

/**
 * User Repository implementation
 *
 * @author: Prabakar Singaram
 * @created: 3/26/2013 8:30 AM
 * @company: NewWave Technologies Inc
 */
@Repository
public class UserRepositoryImpl extends BaseHibernateJpaRepository<Users, Long> implements UserRepository {

     public Users findByEmail(String email) {
        return (Users) sessionFactory.getCurrentSession().createQuery("from Users u where u.email = ?").setString(0,
                email).uniqueResult();
    }


     public Users findByUsername(String username) {
        return (Users) sessionFactory.getCurrentSession().createQuery("from Users u where u.userName = ?").setString(0,
                username).uniqueResult();
    }
}
