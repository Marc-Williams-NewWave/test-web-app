package com.nwt.framework.data;

import com.nwt.framework.exception.service.NotYetImplementedException;
import com.nwt.framework.validation.EntityValidator;
import com.nwt.framework.validation.Validity;

import java.io.Serializable;

/**
 * BaseService implementation for basic access to service
 * methods of crud operation on entity
 *
 *
 * @author: Prabakar Singaram
 * @created: 3/25/2013 10:41 PM
 * @company: NewWave Technologies Inc
 */
public abstract class BaseMongoServiceImpl<T extends Entity, ID extends Serializable> implements BaseService<T, ID> {
    protected BaseCrudRepository baseCrudRepository;
    protected Class<T> entityClass;

     public T insert(T object) throws Exception {
        return (T) baseCrudRepository.save(object);
    }


     public T update(T object) throws Exception {
        throw new NotYetImplementedException("Update not implemented in controller");
    }


     public void delete(T object) throws Exception {
        baseCrudRepository.delete(object);
    }


     public T findById(ID id) throws Exception {
        return (T) baseCrudRepository.findOne(id);
    }


     public Validity validate(T object) {
        EntityValidator<T> entityValidator = new EntityValidator<T>();
        return entityValidator.validate(object, entityClass);
    }
}