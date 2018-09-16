package com.tuyu;


import org.junit.Test;

/**
 * @author tuyu
 * @date 9/16/18
 * Talk is cheap, show me the code.
 */
public class JdkProxyTest {


    @Test
    public void testJdk() {
        Waiter waiter = new NaiveWaiter();
        JdkProxy jdkProxy = new JdkProxy();
        waiter = (Waiter) jdkProxy.createProxy(waiter);
        waiter.hello("tuyu");
    }
}
