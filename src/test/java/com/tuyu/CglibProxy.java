package com.tuyu;

//import org.aopalliance.intercept.MethodInterceptor;
//import org.aopalliance.intercept.MethodInvocation;
import org.springframework.cglib.proxy.Enhancer;
import org.springframework.cglib.proxy.MethodInterceptor;
import org.springframework.cglib.proxy.MethodProxy;

import java.lang.reflect.Method;

/**
 * @author tuyu
 * @date 9/16/18
 * Talk is cheap, show me the code.
 */
public class CglibProxy implements MethodInterceptor {
    private Object targetObject;

    public Object createProxy(Object targetObject) {
        this.targetObject = targetObject;
        Enhancer enhancer = new Enhancer();
        enhancer.setSuperclass(targetObject.getClass());
        enhancer.setCallback(this);
        Object ret = enhancer.create();
        return ret;
    }

    @Override
    public Object intercept(Object o, Method method, Object[] objects, MethodProxy methodProxy) throws Throwable {
        Object ret = null;
        System.out.println("cglib before execute method");
        ret = method.invoke(targetObject, objects);
        System.out.println("cglib after execute method");
        return ret;
    }

//    @Override
//    public Object invoke(MethodInvocation methodInvocation) throws Throwable {
//        Method method = methodInvocation.getMethod();
//        Object ret = method.invoke(null);
//        return ret;
//    }
}
