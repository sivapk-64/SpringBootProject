
package com.example.projectdatabase.model;


import jakarta.persistence.Entity;

import jakarta.persistence.Id;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;
@Data
@AllArgsConstructor
@NoArgsConstructor
@Entity(name = "User")
@ToString
public class User{
    @Id
    private int UserId;
    private String userName;
    private String UserPassword;
    private int UserEmail;
   
}

