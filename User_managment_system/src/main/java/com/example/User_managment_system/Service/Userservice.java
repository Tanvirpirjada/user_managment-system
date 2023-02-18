package com.example.User_managment_system.Service;

import com.example.User_managment_system.Dao.IUSerrepository;
import com.example.User_managment_system.Model.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
@Service
public class Userservice {


    @Autowired
    IUSerrepository repo;


    public void saveuser(User newuser) {
        repo.save(newuser);
    }

    public List<User> getuser(Integer id) {
        List<User> users;
        if(id==null){
            users=repo.findAll();
        }
        else{
            users=new ArrayList<>();
            users.add(repo.findById(id).get());
        }
        return users;
    }

    public void updateuser(Integer id, User newuser) {
        User olduser=repo.findById(id).get();

       olduser.setUser_id(newuser.getUser_id());
       olduser.setUsername(newuser.getUsername());
       olduser.setDate_ofbirth(newuser.getDate_ofbirth());
       olduser.setEmail(newuser.getEmail());
       olduser.setPhone_number(newuser.getPhone_number());
       olduser.setDate(newuser.getDate());
       olduser.setTime(newuser.getTime());

       repo.save(newuser);
    }


    public void deleteuser(Integer id) {
        User user=repo.findById(id).get();
        repo.delete(user);
    }
}
