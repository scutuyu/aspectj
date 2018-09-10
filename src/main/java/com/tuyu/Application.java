package com.tuyu;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

/**
 * 测试类
 * @author tuyu
 * @date 9/10/18
 * Talk is cheap, show me the code.
 */
public class Application {

    public static void main(String[] args) {
        ApplicationContext context = new ClassPathXmlApplicationContext("classpath:*.xml");
        // 获取已经增强的bean naiveWaiter
        Waiter waiter = (Waiter) context.getBean("naiveWaiter");
        waiter.hello("tuyu");
    }
}
