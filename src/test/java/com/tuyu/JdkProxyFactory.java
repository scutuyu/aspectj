package com.tuyu;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Proxy;

/**
 * JDK动态代理类的工厂类
 *
 * @author tuyu
 * @date 9/16/18
 * Talk is cheap, show me the code.
 */
public class JdkProxyFactory {


    /**
     * JDK动态代理的工厂方法，为传入的目标对象生成代理对象，
     * 将方法调用委托给InvocationHandler对象
     * @param targetObject 目标对象
     * @param invocationHandler 保存增强逻辑的增强方法
     * @return 代理对象
     */
    public static Object createProxy(Object targetObject, InvocationHandler invocationHandler) {
        Class<?> targetClass = targetObject.getClass();
        Object proxy = Proxy.newProxyInstance(targetClass.getClassLoader(), targetClass.getInterfaces(), invocationHandler);
        return proxy;
    }

    /**
     * JDK动态代理的工厂方法，为传入的目标对象生成代理对象，
     * 将方法调用委托给默认的JdkInvocationHandler类的实例
     * @param targetObject 目标对象
     * @return 代理对象
     */
    public static Object createProxy(Object targetObject) {
        return createProxy(targetObject, new JdkInvocationHandler(targetObject));
    }

}
