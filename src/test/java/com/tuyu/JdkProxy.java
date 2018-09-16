package com.tuyu;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;
import java.lang.reflect.Proxy;

/**
 * 实现了InvocationHandler接口，并能创建代理对象的类
 * @author tuyu
 * @date 9/16/18
 * Talk is cheap, show me the code.
 */
public class JdkProxy implements InvocationHandler {

    private Object targetObject;

    public Object createProxy(Object targetObject) {
        this.targetObject =targetObject;
        Class targetClass = targetObject.getClass();
        Object o = Proxy.newProxyInstance(targetClass.getClassLoader(), targetClass.getInterfaces(), this);
        return o;
    }

    @Override
    public Object invoke(Object proxy, Method method, Object[] args) throws Throwable {
        Object ret = null;
        System.out.println("before execute method");
        // 如果按照注释代码执行，程序将不会结束，并一直打印"before execute method"
        // 直到栈溢出，StackOverflowError
//        ret = method.invoke(proxy, args);
        ret = method.invoke(targetObject, args);
        System.out.println("after execute method");
        return ret;
    }
}
