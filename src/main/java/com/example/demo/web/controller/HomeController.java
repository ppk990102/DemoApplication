package com.example.demo.web.controller;

import com.example.demo.web.form.UserCreateForm;
import com.example.demo.web.form.UserForm;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.ArrayList;
import java.util.List;


@Controller
public class HomeController {

    public List<UserCreateForm> userList = new ArrayList<>();

    @RequestMapping("/")
    public String home(Model model) {
        UserForm userForm1 = new UserForm("John",23);
        UserForm userForm2 = new UserForm("Mary",20);
        UserForm userForm3 = new UserForm("Rose",26);

        List<UserForm> userFormList = new ArrayList<>();

        userFormList.add(userForm1);
        userFormList.add(userForm2);
        userFormList.add(userForm3);

        model.addAttribute("userList", userFormList);
//        model.addAttribute("user2", userForm2);
//        model.addAttribute("user3", userForm3);

        return "home";
    }

    @RequestMapping("/hello")
    public String hello(@ModelAttribute UserForm userForm) {
        System.out.println("HELLO IS RUNNING*************");
        return "hello";
    }

    @RequestMapping("/user/profile")
    public String profile() {
        return "user/profile";
    }

    @GetMapping("/user/create")
    public String create(Model model) {
        var user = new UserCreateForm();
        List<String> cities = new ArrayList<>();
        cities.add("Yangon");
        cities.add("Mandalay");
        cities.add("TaungGyi");
//        user.setUserName("John");
//        user.setPhoneNum(2456768);
//        user.setMarried(true);
//        user.setGender(2);
        model.addAttribute("user",user);
        model.addAttribute("cities",cities);
        return "user/create";
    }

    @PostMapping("/user/create")
    public String createUser(@ModelAttribute UserCreateForm userCreateForm, Model model) {
//        System.out.println("User Name:" + userCreateForm.getUserName());
//        System.out.println("Phone:" + userCreateForm.getPhoneNum());
//        System.out.println(userCreateForm.getGender());
//        System.out.println(userCreateForm.isMarried());

//
        userList.add(userCreateForm);
        for (var user: userList) {
            System.out.println("----------------------------------------");
            System.out.println("username: " + user.getUserName());
            System.out.println("Phone: " + user.getPhoneNum());
            System.out.println("Gender: " + user.getGender());
            System.out.println("Marital Status: " + user.isMarried());
            System.out.println("City: " + user.getCity());
            System.out.println("----------------------------------------");
        }

        model.addAttribute("user", userCreateForm);
        return "user/detail";
    }
}
