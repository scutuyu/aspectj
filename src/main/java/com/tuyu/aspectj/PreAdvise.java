package com.tuyu.aspectj;

import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.springframework.stereotype.Component;

/**
 * 一个切面
 * @author tuyu
 * @date 9/10/18
 * Talk is cheap, show me the code.
 */
@Component
@Aspect
public class PreAdvise {

    // 前置增强，切点表达式：* hello(..) 表示所有类的hello方法，不管hello方法的参数怎样
    @Before("execution(* hello(..))")
    public void naiveWord() {
        // 增强逻辑
        System.out.println("How do you do?");
    }
}
