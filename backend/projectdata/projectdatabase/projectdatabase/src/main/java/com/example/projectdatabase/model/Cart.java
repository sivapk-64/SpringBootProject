package com.example.projectdatabase.model;

import java.util.List;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.OneToMany;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
@Data
@AllArgsConstructor
@NoArgsConstructor
@Entity(name = "my_cart")
public class Cart{
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int ApplianceId;
    private int price;
    private String AppName;
    private String Address;
    private int mobile;
    private String Orderdate,Deliverydate;
    @OneToMany(targetEntity = Product.class,cascade = CascadeType.ALL)
    @JoinColumn(name="appid",referencedColumnName = "ApplianceId")
    List<Product> products;
    // @OneToOne(targetEntity = User.class,cascade = CascadeType.ALL)
    // @JoinColumn(name = "userid",referencedColumnName = )
}
