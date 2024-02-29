package com.example.projectdatabase.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.projectdatabase.model.Product;
import com.example.projectdatabase.service.ProductService;
@RequestMapping("/Product")
@RestController
public class ProductController {
    @Autowired
    private final ProductService Ps;
    
    public ProductController(ProductService Ps) {
        this.Ps = Ps;
    }

    @PostMapping("/addproduct")
    public Product Addproduct(@RequestBody Product p){
        Product p1=Ps.createproduct(p);
            return p1;
    }
    @GetMapping("/getproduct")
    public ResponseEntity<List<Product>> getAllproduct(){
        List<Product> items=Ps.getproduct();
        return new ResponseEntity<>(items,HttpStatus.CREATED);
    }
    @GetMapping("/getDetails/{productId}")
    public ResponseEntity<Product> getById(@PathVariable int productId){
        Product p=Ps.getproId(productId);
        if(p!=null){
            return new ResponseEntity<>(p,HttpStatus.OK);
        }
        else{
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }
  
    // @GetMapping("/Details/{AppName}")
    // public ResponseEntity<List<MyCart>> getByName(@PathVariable String AppName){
    //     List<MyCart> M=PS.ApplicationName1(AppName);
    //     if(M!=null){
    //         return new ResponseEntity<>(M,HttpStatus.OK);
    //     }
    //     else{
    //         return new ResponseEntity<>(HttpStatus.NOT_FOUND);
    //     }
    // }


    @PutMapping("/update/{productId}")
    public ResponseEntity<Product> updateproduct(@PathVariable int productId,@RequestBody Product p){
        return new ResponseEntity<>(Ps.update(productId,p),HttpStatus.OK);
    }



    @DeleteMapping("/delete/{productId}")
    public ResponseEntity<Boolean> deleteById(@PathVariable int productId){
        return new ResponseEntity<>(Ps.deleteproduct(productId),HttpStatus.OK);
    }
    // @DeleteMapping("/deletes/{AppName}")
    // public ResponseEntity<Boolean> deleteByName(@PathVariable String AppName){
    //     return new ResponseEntity<>(PS.deleteByAppName(AppName),HttpStatus.OK);
    // }
}

