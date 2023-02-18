package com.example.User_managment_system.controller;

import com.example.User_managment_system.Model.User;
import com.example.User_managment_system.Service.Userservice;
import jakarta.annotation.Nullable;
import org.json.JSONObject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.stereotype.Repository;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.regex.Pattern;

@RestController
public class Usercontroller {


    @GetMapping("getsuser")
    public List<User> getuser(@Nullable @RequestParam Integer id){
        return service.getuser(id);
    }


    @PutMapping("updateuser/id/{id}")
    public void updateuser(@PathVariable Integer id, @RequestBody User newuser){
        service.updateuser(id,newuser);
    }

    @DeleteMapping("deleteuser/id/{id}")
    public void deleteuser(@PathVariable Integer id){
        service.deleteuser(id);
    }
    @Autowired
    Userservice service;
    @PostMapping("/saveuser")
    public ResponseEntity  saveuser(@RequestBody  String Userrequest) {
        JSONObject Userdetails = new JSONObject(Userrequest);

        List<String> errorlist = validation(Userdetails);
        if (errorlist.isEmpty()) {
            User newuser = setuser(Userdetails);
            service.saveuser(newuser);
            return new ResponseEntity("user saved", HttpStatus.CREATED);
        } else {
            String[] arr = Arrays.copyOf(
                    errorlist.toArray(), errorlist.size(), String[].class);

            return new ResponseEntity<>(Arrays.toString(arr),HttpStatus.BAD_REQUEST);
        }
    }

    public List<String> validation(JSONObject json){
        List<String>  errorlist=new ArrayList<>();
        if(!json.has("username")){
            errorlist.add("username requered");
        }
        if(!json.has("date_ofbirth")){
            errorlist.add("Birth date is requered");
        }
        if(!json.has("email")){
            errorlist.add("email is requered");
        }
        if(!json.has("phone_number") ){
            errorlist.add("Phone number is Requered");

        }
        return errorlist;
    }


    public User setuser(JSONObject json){
        User user=new User();
        if(json.has("user_id")) {
            String user_id= json.getString("user_id");
            user.setUser_id(Integer.valueOf(user_id));
        }

        user.setUsername(json.getString("username"));
        user.setDate_ofbirth(json.getString("date_ofbirth"));
        user.setEmail(json.getString("email"));
        user.setPhone_number(json.getString("phone_number"));
        if(json.has("date")){
            String date= json.getString("date");
            user.setDate(date);
        }
        if(json.has("time")){
            String time= json.getString("time");
            user.setTime("time");
        }

        return user;
    }
}
