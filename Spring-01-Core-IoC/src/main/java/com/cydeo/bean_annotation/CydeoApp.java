package com.cydeo.bean_annotation;

import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

public class CydeoApp {

    public static void main(String[] args) {
        ApplicationContext container = new AnnotationConfigApplicationContext(ConfigApp.class, ConfigAny.class);

        //ft is bean from container
        FullTimeMentor ft = container.getBean(FullTimeMentor.class);
        ft.createAccount();

        //PartTimeMentor pt = container.getBean("p1",PartTimeMentor.class);
        PartTimeMentor pt = container.getBean(PartTimeMentor.class);  //with @primary
        pt.createAccount();


        String str = container.getBean(String.class);
        System.out.println(str);

    }
}
