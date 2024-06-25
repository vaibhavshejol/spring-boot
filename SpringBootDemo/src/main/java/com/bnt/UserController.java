package com.bnt;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;


@Controller
public class UserController {

    @ResponseBody
    @RequestMapping("/adduser")
    public String addUser() {
        return "This is a addUser() method from UserController";
    }


    @ResponseBody
    @RequestMapping("/updateuser")
    public String updateUser() {
        return "This is a updateUser() method from UserController";
    }


    @ResponseBody
    @RequestMapping("/deleteuser")
    public String deleteUser() {
        return "This is a deleteUser() method from UserController";
    }


    @ResponseBody
    @RequestMapping("/viewuser")
    public String viewUser() {
        return "This is a viewUser() method from UserController";
    }
    
}
