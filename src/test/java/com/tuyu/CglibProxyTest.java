package com.tuyu;

import org.junit.Test;

/**
 * Cglib动态代理测试类
 * @author tuyu
 * @date 9/16/18
 * Talk is cheap, show me the code.
 */
public class CglibProxyTest {

    /**
     * 未使用工厂方法
     */
    @Test
    public void testCglib() {
        // 目标对象
        Waiter waiter = new NaiveWaiter();
        CglibProxy cglibProxy = new CglibProxy();
        // 通过CglibPorxy对象来创建爱一个代理对象，将返回的代理对象强转为Waiter类型
        waiter = (Waiter) cglibProxy.createProxy(waiter);
        // 调用代理对象的方法
        waiter.hello("tuyu");
    }

    /**
     * 使用工厂方法
     */
    @Test
    public void testFactory() {
        // 通过静态代理工厂为目标对象创建代理对象，并将代理对象强转为Waiter类型
        Waiter waiter = (Waiter) CglibProxyFactory.createProxy(new NaiveWaiter());
        // 调用代理对象的方法
        waiter.hello("tuyu");
    }
}
