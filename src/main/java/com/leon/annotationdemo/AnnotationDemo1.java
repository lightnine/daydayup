package com.leon.annotationdemo;

import java.lang.annotation.*;

/**
 * 自定义注解，为了了解注解的使用，没有其他意义
 * @author leon
 * @since 2019/7/11 18:42
 */
@Target(ElementType.TYPE)
@Retention(RetentionPolicy.RUNTIME)
@Inherited
@Documented
public @interface AnnotationDemo1 {
    int val() default 1;
}
