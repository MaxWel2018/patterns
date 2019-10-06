package org.pattern.gof.structural.proxy.dynamic.service;

import org.pattern.gof.structural.proxy.dynamic.domain.User;
import org.pattern.gof.structural.proxy.dynamic.exception.EntityNotFoundRuntimeException;

public class UserServiceImpl implements UserService {
    @Override
    public User findById(Long id) {
        if (id == 1) {
            return new User();
        }
        throw new EntityNotFoundRuntimeException();
    }
}
