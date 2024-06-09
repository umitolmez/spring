package com.cydeo;

import lombok.AllArgsConstructor;
import org.springframework.stereotype.Component;

@Component
@AllArgsConstructor
public class Java2 {
    OfficeHours officeHours;

    public void getTeachingHours(){
        System.out.println("Weekly teaching hours: " +(20 + officeHours.getHours()));
    }
}
