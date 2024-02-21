package com.example.projectdatabase.service;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.projectdatabase.model.MyCart;
import com.example.projectdatabase.repository.ProjectRepo;
@Service
public class ProjectService {
    private final ProjectRepo PR;
    @Autowired
    public ProjectService(ProjectRepo PR){
        this.PR=PR;
    }


    //Post
    public MyCart AddtoMyCart(MyCart MC){
        return PR.save(MC);
    }


    //Get
    public List<MyCart> CartList(){
        return PR.findAll();
    }
    public MyCart ApplianceById(int id){
        return PR.findById(id).orElse(null);
    }
    public List<MyCart> ApplicationName1(String AppName){
        return PR.findByAppName(AppName);
    }
    List<MyCart> a = new ArrayList<>();
    public List<MyCart> ApplianceByName(String Name){
        return a;
    }


    //Delete
    public boolean deleteById(int id){
        PR.deleteById(id);
        return true;
    }
    public boolean deleteByAppName(String AppName){
        //PR.deleteByAppName(AppName);
        return true;
    }


    //Update
    public MyCart update(int id,MyCart M){
        MyCart M1=PR.findById(id).orElse(null);
        if(M1!=null){
            M1.setAppName(M.getAppName());
            M1.setAddress(M.getAddress());
            M1.setMobile(M.getMobile());
            return PR.save(M1);
        }
        else{
            return PR.save(M);
        }
    }
}
