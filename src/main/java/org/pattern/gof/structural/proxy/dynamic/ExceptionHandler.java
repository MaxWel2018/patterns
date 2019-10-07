package org.pattern.gof.structural.proxy.dynamic;

import org.pattern.gof.structural.proxy.dynamic.exception.EntityNotFoundRuntimeException;
import org.pattern.gof.structural.proxy.dynamic.http.Response;
import org.pattern.gof.structural.proxy.dynamic.http.Status;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;
import java.util.HashMap;
import java.util.Map;

import static org.pattern.gof.structural.proxy.dynamic.http.Status.*;

public class ExceptionHandler implements InvocationHandler {

    private Map<Class<? extends Exception>, Status> exceptionToStatus = new HashMap<>();

    public ExceptionHandler() {
        exceptionToStatus.put(EntityNotFoundRuntimeException.class,NOT_FOUND);
        exceptionToStatus.put(NullPointerException.class,SERVER_ERROR);

    }

    @Override
    public Response invoke(Object proxy, Method method, Object[] args){
        try {
            Object invoke = method.invoke(proxy, args);
            return new Response(OK, invoke.toString());
        } catch (Exception e) {
            Throwable cause = e.getCause();
            Class<? extends Throwable> clazz = cause.getClass();
            Status status = exceptionToStatus.get(clazz);
            return new Response(status, "");
        }
    }
}
