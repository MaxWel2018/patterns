package org.pattern.gof.structural.proxy.dynamic;

import org.pattern.gof.structural.proxy.dynamic.exception.EntityNotFoundRuntimeException;
import org.pattern.gof.structural.proxy.dynamic.http.Response;
import org.pattern.gof.structural.proxy.dynamic.http.Status;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;
import java.util.HashMap;
import java.util.Map;

import static org.pattern.gof.structural.proxy.dynamic.http.Status.NOT_FOUND;
import static org.pattern.gof.structural.proxy.dynamic.http.Status.OK;

public class ExceptionHandler implements InvocationHandler {

    private Map<Class<? extends Exception>, Status> exceptionToStatus = new HashMap<>();

    public ExceptionHandler() {
        exceptionToStatus.put(EntityNotFoundRuntimeException.class,NOT_FOUND);
    }

    @Override
    public Response invoke(Object proxy, Method method, Object[] args){
        try {
            Object invoke = method.invoke(proxy, args);
            return new Response(OK, invoke.toString());
        } catch (Exception e) {
            Class<? extends Exception> clazz = e.getClass();
            System.out.println(clazz);
            Status status = exceptionToStatus.get(clazz);
            return new Response(status, "");
        }
    }
}
