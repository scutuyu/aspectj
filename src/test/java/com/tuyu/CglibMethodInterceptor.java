package com.tuyu;

import org.springframework.cglib.proxy.MethodInterceptor;
import org.springframework.cglib.proxy.MethodProxy;

import java.lang.reflect.Method;

/**
 * 实现MethodInterceptor接口的增强类
 * @author tuyu
 * @date 9/16/18
 * Talk is cheap, show me the code.
 */
public class CglibMethodInterceptor implements MethodInterceptor {
    private Object targetObject;

    public CglibMethodInterceptor(Object targetObject) {
        this.targetObject = targetObject;
    }

    /**
     * @param o 代理类实例，
     * @param method 目标方法的反射对象
     * @param objects 目标方法的动态入参
     * @param methodProxy 方法的代理对象，可以通过methodProxy.invokeSuper(o, objects)调用目标类的方法
     * @return 目标方法的返回值
     * @throws Throwable
     */
    @Override
    public Object intercept(Object o, Method method, Object[] objects, MethodProxy methodProxy) throws Throwable {
        Object ret = null;
        System.out.println("cglib before execute method");
        // 如果按照注释代码执行，将抛出InvocationTargetException,在增强类中com.tuyu.NaiveWaiter$$EnhancerByCGLIB$$75f7907c
//        ret = method.invoke(o, objects);
        // 下面注释的代码也可以执行
//        ret = method.invoke(targetObject, objects);
        ret = methodProxy.invokeSuper(o, objects);
        System.out.println("cglib after execute method");
        return ret;
    }
}
