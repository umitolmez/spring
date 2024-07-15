package com.cydeo;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class UserController {

    @RequestMapping("/user")
    public String user(){
        //return "userinfo.html";  //go to static folder and look over there
        return "/user/userinfo.html";
    }
}
