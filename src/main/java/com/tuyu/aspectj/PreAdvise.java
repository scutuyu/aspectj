package com.tuyu.aspectj;

import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.springframework.stereotype.Component;

/**
 * @author tuyu
 * @date 9/10/18
 * Talk is cheap, show me the code.
 */
@Component
@Aspect
public class PreAdvise {

    @Before("execution(* hello(..))")
    public void naiveWord() {
        System.out.println("How do you do?");
    }
}
