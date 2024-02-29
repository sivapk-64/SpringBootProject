package com.example.projectdatabase.service;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.projectdatabase.model.Cart;
import com.example.projectdatabase.repository.CartRepo;
@Service
public class CartService {
    @Autowired
    private final CartRepo PR;
    public CartService(CartRepo PR){
        this.PR=PR;
    }


    //Post(create)
    public Cart AddtoMyCart(Cart MC){
        return PR.save(MC);
    }


    //Get(read)
    public List<Cart> CartList(){
        return PR.findAll();
    }
    public Cart ApplianceById(int id){
        return PR.findById(id).orElse(null);
    }
    public List<Cart> ApplicationName1(String AppName){
        return PR.findByAppName(AppName);
    }
    List<Cart> a = new ArrayList<>();
    public List<Cart> ApplianceByName(String Name){
        return a;
    }


    //Delete
    public boolean deleteById(int ApplianceId){
        PR.deleteById(ApplianceId);
        return true;
    }
    public boolean deleteByAppName(String AppName){
        //PR.deleteByAppName(AppName);
        return true;
    }
    //Update
    public Cart update(int id,Cart M){
        Cart M1=PR.findById(id).orElse(null);
        if(M1!=null){
            M1.setOrderdate(M.getOrderdate());
            M1.setDeliverydate(M.getDeliverydate());
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
