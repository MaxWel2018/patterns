package org.pattern.gof.structural.proxy.dynamic;

import org.pattern.gof.structural.proxy.dynamic.http.Response;
import org.pattern.gof.structural.proxy.dynamic.service.UserService;
import org.pattern.gof.structural.proxy.dynamic.service.UserServiceImpl;

import java.lang.reflect.Method;

public class ConsoleApplication {
    public static void main(String[] args) throws Throwable {

        // user is not null -> 200 , "alex"
        // user is not found ->404
        // if id null -> 500
        ExceptionHandler exceptionHandler = new ExceptionHandler();

        UserService userService = new UserServiceImpl();
        Class<? extends UserService> clazz = userService.getClass();
        Method method = clazz.getMethod("findById", Long.class);


        Response response = exceptionHandler.invoke(userService, method, new Object[]{1L});
        Response responseDontFoundUser = exceptionHandler.invoke(userService, method, new Object[]{2L});
        Response responseWithNull = exceptionHandler.invoke(userService, method, new Object[]{null});
        System.out.println(response);
        System.out.println(responseDontFoundUser);
        System.out.println(responseWithNull);
    }
}
