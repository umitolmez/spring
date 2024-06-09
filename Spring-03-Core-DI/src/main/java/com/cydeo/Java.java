package com.cydeo;

import lombok.AllArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
@AllArgsConstructor
public class Java {

    //field injection (it will work but not recommended, deprecated)
    //@Autowired
    OfficeHours officeHours;

    //constructor injection
    /*
    @Autowired       //without the annotation spring can inject
    public Java(OfficeHours officeHours){     //@AllArgsConstructor will create this const.
        this.officeHours = new OfficeHours();
    }
    */
    public void getTeachingHours(){
        System.out.println("Weekly teaching hours: " +(20 + officeHours.getHours()));
    }
}
