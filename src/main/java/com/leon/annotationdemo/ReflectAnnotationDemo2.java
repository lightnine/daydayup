package com.leon.annotationdemo;

/**
 * 通过反射的方法来获取类上的注解,只能获取RUNTIME的注解
 * @author leon
 * @since 2019/7/11 18:44
 */
public class ReflectAnnotationDemo2 {
    public static void main(String[] args) {
        try {
            Class demo = Class.forName("com.leon.annotationdemo.Demo2");
            if (demo.isAnnotationPresent(AnnotationDemo2.class)) {
                AnnotationDemo2 annotationDemo2 = (AnnotationDemo2) demo.getAnnotation(AnnotationDemo2.class);
                int val = annotationDemo2.val();
                System.out.println("注解的内容:" + val);
            } else {
                System.out.println("没有提供注解或者注解的生命周期为SOURCE，CLASS");
            }
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }
    }
}
