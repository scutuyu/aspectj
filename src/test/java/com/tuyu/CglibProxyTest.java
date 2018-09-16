package com.tuyu;

import org.junit.Test;

/**
 * @author tuyu
 * @date 9/16/18
 * Talk is cheap, show me the code.
 */
public class CglibProxyTest {

    @Test
    public void testCglib() {
        Waiter waiter = new NaiveWaiter();
        CglibProxy cglibProxy = new CglibProxy();
        waiter = (Waiter) cglibProxy.createProxy(waiter);
        waiter.hello("tuyu");
    }
}
