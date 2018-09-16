package com.tuyu;


import org.junit.Test;

/**
 * JDK动态代理测试类
 * @author tuyu
 * @date 9/16/18
 * Talk is cheap, show me the code.
 */
public class JdkProxyTest {


    /**
     * 未使用静态工厂方法
     */
    @Test
    public void testJdk() {
        // 目标对象
        Waiter waiter = new NaiveWaiter();
        JdkProxy jdkProxy = new JdkProxy();
        // 通过JdkProxy对象创建代理对象，并将代理对象强转为Waiter类型
        waiter = (Waiter) jdkProxy.createProxy(waiter);
        // 调用代理对象的方法
        waiter.hello("tuyu");
    }

    /**
     * 使用静态工厂方法
     */
    @Test
    public void testFactory() {
        // 将布标对象传入静态工厂方法创建代理对象， 并将代理对象强转为Waiter类型
        Waiter waiter = (Waiter) JdkProxyFactory.createProxy(new NaiveWaiter());
        // 调用代理对象的方法
        waiter.hello("tuyu");
    }
}
