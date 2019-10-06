package org.pattern.gof.structural.proxy.dynamic.service;

import org.pattern.gof.structural.proxy.dynamic.domain.User;

public interface UserService {
    User findById(Long id);
}
