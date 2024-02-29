package com.example.projectdatabase.service;

import java.util.List;

import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;

import com.example.projectdatabase.model.Cart;
import com.example.projectdatabase.model.Product;
import com.example.projectdatabase.repository.ProductRepo;

@Service
public class ProductService {
    private ProductRepo Pr;

    public ProductService(ProductRepo Pr) {
        this.Pr = Pr;
    }
    public Product createproduct(Product P){
        return Pr.save(P);
    }
    public List<Product> getproduct(){
        return Pr.findAll();
    }
    public Product getproId(int productId){
        return Pr.findById(productId).orElse(null);
    }
    
    public Product update(int productId,Product P){
        Product p1=Pr.findById(productId).orElse(null);
        if(p1!=null){
            p1.setPrice(P.getPrice());
            p1.setP_id(P.getP_id());
            p1.setP_name(P.getP_name());
            return Pr.save(p1);
        }
        else{
            return Pr.save(P);
        }
    }
    public boolean deleteproduct(int productId){
        Pr.deleteById(productId);
        return true;
    }
}
