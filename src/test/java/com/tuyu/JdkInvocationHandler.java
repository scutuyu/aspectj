package com.tuyu;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;

/**
 * @author tuyu
 * @date 9/16/18
 * Talk is cheap, show me the code.
 */
public class JdkInvocationHandler implements InvocationHandler {

    private Object targetObject;

    public JdkInvocationHandler(Object targetObject) {
        this.targetObject = targetObject;
    }

    @Override
    public Object invoke(Object proxy, Method method, Object[] args) throws Throwable {
        Object ret = null;
        System.out.println("jdk before execute method");
        ret = method.invoke(targetObject, args);
        System.out.println("jdk after execute method");
        return ret;
    }
}
