package com.tuyu;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;

/**
 * 实现InvocationHandler接口的增强类
 * @author tuyu
 * @date 9/16/18
 * Talk is cheap, show me the code.
 */
public class JdkInvocationHandler implements InvocationHandler {

    private Object targetObject;

    public JdkInvocationHandler(Object targetObject) {
        this.targetObject = targetObject;
    }

    /**
     * @param proxy 实现代理接口的代理类对象
     * @param method 目标对象的方法
     * @param args 目标方法的参数
     * @return 目标方法的返回值
     * @throws Throwable
     */
    @Override
    public Object invoke(Object proxy, Method method, Object[] args) throws Throwable {
        Object ret = null;
        System.out.println("jdk before execute method");
        ret = method.invoke(targetObject, args);
        System.out.println("jdk after execute method");
        return ret;
    }
}
