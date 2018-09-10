package com.tuyu;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

/**
 * @author tuyu
 * @date 9/10/18
 * Talk is cheap, show me the code.
 */
public class Application {

    public static void main(String[] args) {
        ApplicationContext context = new ClassPathXmlApplicationContext("classpath:*.xml");
        Waiter waiter = (Waiter) context.getBean("naiveWaiter");
        Object preAdvise = context.getBean("preAdvise");
        waiter.hello("tuyu");
    }
}
