
package com.example.projectdatabase.service;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;

import com.example.projectdatabase.model.User;
import com.example.projectdatabase.repository.UserRepo;
@Service
public class UserService {
    @Autowired
    private final UserRepo UR;
    public UserService(UserRepo UR){
        this.UR=UR;
    }


    //Post(create)
    public User createUser(User U){
        return UR.save(U);
    }


    //Get(read)
    public List<User> Userlist(){
        return UR.findAll();
    }
    public User UserById(int id){
        return UR.findById(id).orElse(null);
    }
    
    List<User> a = new ArrayList<>();
    public List<User> UserByName(String UserName){
        return a;
    }
   public List<User> sortuser(String field){
    return UR.findAll(Sort.by(field));
   }
    public List<User> paginationuser(int UserId,int pagesize){
        return UR.findAll(PageRequest.of(UserId, pagesize)).getContent();
    }
    public List<User> paginationsort(int UserId,int pagesize,String field){
        return UR.findAll(PageRequest.of(UserId, pagesize,Sort.by(field))).getContent();
    }
    //Delete
    public boolean deleteById(int UserId){
        UR.deleteById(UserId);
        return true;
    }
    public boolean deleteByUserName(String UserName){
        //PR.deleteByAppName(AppName);
        return true;
    }
    

    //Update
    public User update(int UserId,User U){
        User U1=UR.findById(UserId).orElse(null);
        if(U1!=null){
            U1.setUserId(U.getUserId());
            U1.setUserEmail(U.getUserEmail());
            U1.setUserName(U.getUserName());
            U1.setUserPassword(U.getUserPassword());
           
            return UR.save(U1);
        }
        else{
            return UR.save(U);
        }
    }
}
