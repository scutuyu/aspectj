package com.tuyu;

import org.springframework.cglib.proxy.MethodInterceptor;
import org.springframework.cglib.proxy.MethodProxy;

import java.lang.reflect.Method;

/**
 * @author tuyu
 * @date 9/16/18
 * Talk is cheap, show me the code.
 */
public class CglibMethodInterceptor implements MethodInterceptor {
    private Object targetObject;

    public CglibMethodInterceptor(Object targetObject) {
        this.targetObject = targetObject;
    }

    @Override
    public Object intercept(Object o, Method method, Object[] objects, MethodProxy methodProxy) throws Throwable {
        Object ret = null;
        System.out.println("cglib before execute method");
        // 如果按照注释代码执行，将抛出InvocationTargetException,在增强类中com.tuyu.NaiveWaiter$$EnhancerByCGLIB$$75f7907c
//        ret = method.invoke(o, objects);
        ret = method.invoke(targetObject, objects);
        System.out.println("cglib after execute method");
        return ret;
    }
}
