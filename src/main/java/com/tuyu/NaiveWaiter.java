package com.tuyu;

import org.springframework.stereotype.Component;

/**
 * 待增强的类，代理接口的实现类
 * @author tuyu
 * @date 9/10/18
 * Talk is cheap, show me the code.
 */
@Component
public class NaiveWaiter implements Waiter{


    @Override
    public void hello(String name) {
        System.out.println(String.format("hello %s", name));
    }
}
