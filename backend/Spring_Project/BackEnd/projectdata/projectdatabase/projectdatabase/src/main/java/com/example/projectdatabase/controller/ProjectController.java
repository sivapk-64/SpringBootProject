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

import com.example.projectdatabase.model.MyCart;
import com.example.projectdatabase.service.ProjectService;
@RequestMapping("/Cart")
@RestController
public class ProjectController {
    private final ProjectService PS;
    @Autowired
    public ProjectController(ProjectService PS){
        this.PS=PS;
    }
    @PostMapping("/add")
    public MyCart AddItem(@RequestBody MyCart M){
        MyCart M1=PS.AddtoMyCart(M);
            return M1;
    }



    @GetMapping("/Details")
    public ResponseEntity<List<MyCart>> getAll(){
        List<MyCart> items=PS.CartList();
        return new ResponseEntity<>(items,HttpStatus.CREATED);
    }
    @GetMapping("/Detailss/{applianceId}")
    public ResponseEntity<MyCart> getById(@PathVariable int applianceId){
        MyCart M=PS.ApplianceById(applianceId);
        if(M!=null){
            return new ResponseEntity<>(M,HttpStatus.OK);
        }
        else{
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }
    @GetMapping("/Details/{AppName}")
    public ResponseEntity<List<MyCart>> getByName(@PathVariable String AppName){
        List<MyCart> M=PS.ApplicationName1(AppName);
        if(M!=null){
            return new ResponseEntity<>(M,HttpStatus.OK);
        }
        else{
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }


    @PutMapping("/update/{ApplianceId}")
    public ResponseEntity<MyCart> updatecart(@PathVariable int ApplianceId,@RequestBody MyCart M){
        return new ResponseEntity<>(PS.update(ApplianceId,M),HttpStatus.OK);
    }



    @DeleteMapping("/delete/{ApplianceId}")
    public ResponseEntity<Boolean> deleteById(@PathVariable int ApplianceId){
        return new ResponseEntity<>(PS.deleteById(ApplianceId),HttpStatus.OK);
    }
    @DeleteMapping("/deletes/{AppName}")
    public ResponseEntity<Boolean> deleteByName(@PathVariable String AppName){
        return new ResponseEntity<>(PS.deleteByAppName(AppName),HttpStatus.OK);
    }
}

