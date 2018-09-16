package com.tuyu;

import org.springframework.cglib.proxy.Callback;
import org.springframework.cglib.proxy.Enhancer;

/**
 * Cglib动态代理类的工厂类
 * @author tuyu
 * @date 9/16/18
 * Talk is cheap, show me the code.
 */
public class CglibProxyFactory {

    /**
     * Cglib动态代理的工厂方法，为传入的目标对象生成代理对象，
     * 将方法调用委托给CallBack对象
     * @param targetObject 目标对象
     * @param callback 保存增强逻辑的增强方法
     * @return 代理对象
     */
    public static Object createPoxy(Object targetObject, Callback callback) {
        Enhancer enhancer = new Enhancer();
        // 设置目标对象的类
        enhancer.setSuperclass(targetObject.getClass());
        // 设置回调方法，即增强方法
        enhancer.setCallback(callback);
        // 创建一个代理对象
        Object ret = enhancer.create();
        return ret;
    }

    /**
     * Cglib动态代理的工厂方法，为传入的目标对象生成代理对象，
     * 将方法调用委托给默认的CglibMethodInterceptor对象
     * @param targetObject 目标对象
     * @return 代理对象
     */
    public static Object createProxy(Object targetObject) {
        return createPoxy(targetObject, new CglibMethodInterceptor(targetObject));
    }
}
