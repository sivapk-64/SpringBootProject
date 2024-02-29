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
import com.example.projectdatabase.model.User;
import com.example.projectdatabase.service.UserService;
import org.springframework.web.bind.annotation.RequestParam;



@RequestMapping("/User")
@RestController
public class UserController {
    @Autowired
    private final UserService US;
     
    public UserController(UserService US) {
        this.US = US;
    }
    
    @PostMapping("/adduser")
    public User AddUser(@RequestBody User U){
        User U1=US.createUser(U);
            return U1;
    }



    @GetMapping("/userDetails")
    public ResponseEntity<List<User>> getAlluser(){
        List<User> items=US.Userlist();
        return new ResponseEntity<>(items,HttpStatus.CREATED);
    }
    @GetMapping("/Detailss/{UserId}")
    public ResponseEntity<User> getByUserId(@PathVariable int UserId){
         User U=US.UserById(UserId);
        if(U!=null){
            return new ResponseEntity<>(U,HttpStatus.OK);
        }
        else{
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }
    @GetMapping("/sorts/{field}")
    public ResponseEntity<List<User>> sortbyuser(@PathVariable("field") String field){
        List<User> u1=US.sortuser(field);
        if(u1!=null){
            return new ResponseEntity<>(u1,HttpStatus.OK);
        }
        else{
            return new ResponseEntity<>(null,HttpStatus.NOT_FOUND);
        }
    }
    @GetMapping("/pagination/{offset}/{pagesize}")
    public ResponseEntity<List<User>> paginationbyuser(@PathVariable("offset") int offset,@PathVariable("pagesize") int pagesize){
        List<User> u1=US.paginationuser(offset, pagesize);
        if(u1!=null){
            return new ResponseEntity<>(u1,HttpStatus.OK);
        }
        else{
            return new ResponseEntity<>(null,HttpStatus.NOT_FOUND);
        }
    }
    @GetMapping("/pagesorting/{offset}/{pagesize}/{username}")
    public ResponseEntity<List<User>> pagesorting(@PathVariable("offset")int UserId,@PathVariable("pagesize")int pagesize,@PathVariable("username") String username){
        List<User> p1=US.paginationsort(UserId, pagesize, username);
        if(p1!=null){
            return new ResponseEntity<>(p1,HttpStatus.OK);
        }
        else{
            return new ResponseEntity<>(null,HttpStatus.NOT_FOUND);
        }
    }
    public String getMethodName(@RequestParam String param) {
        return new String();
    }
    
    // @GetMapping("/Details/{UserName}")
    // public ResponseEntity<List<MyCart>> getByName(@PathVariable String AppName){
    //     List<MyCart> M=PS.ApplicationName1(AppName);
    //     if(M!=null){
    //         return new ResponseEntity<>(M,HttpStatus.OK);
    //     }
    //     else{
    //         return new ResponseEntity<>(HttpStatus.NOT_FOUND);
    //     }
    // }


    @PutMapping("/update/{UserId}")
    public ResponseEntity<User> updatecart(@PathVariable int UserId,@RequestBody User U){
        return new ResponseEntity<>(US.update(UserId,U),HttpStatus.OK);
    }



    @DeleteMapping("/delete/{UserId}")
    public ResponseEntity<Boolean> deleteById(@PathVariable int UserId){
        return new ResponseEntity<>(US.deleteById(UserId),HttpStatus.OK);
    }
    @DeleteMapping("/deletes/{UserName}")
    public ResponseEntity<Boolean> deleteByName(@PathVariable String UserName){
        return new ResponseEntity<>(US.deleteByUserName(UserName),HttpStatus.OK);
    }
}

