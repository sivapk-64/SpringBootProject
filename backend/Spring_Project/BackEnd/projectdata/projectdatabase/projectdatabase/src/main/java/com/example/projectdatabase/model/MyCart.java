package com.example.projectdatabase.model;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;

@Entity(name = "my_cart")
public class MyCart{
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int ApplianceId;
    private int price;
    private String AppName;
    private String Address;
    private int mobile;
    private String Orderdate,Deliverydate;
    public MyCart() {
    }
    public MyCart(int applianceId, int price, String appName, String address, int mobile, String orderdate,
            String deliverydate) {
        ApplianceId = applianceId;
        this.price = price;
        AppName = appName;
        Address = address;
        this.mobile = mobile;
        Orderdate = orderdate;
        Deliverydate = deliverydate;
    }
    public int getApplianceId() {
        return ApplianceId;
    }
    public void setApplianceId(int applianceId) {
        ApplianceId = applianceId;
    }
    public int getPrice() {
        return price;
    }
    public void setPrice(int price) {
        this.price = price;
    }
    public String getAppName() {
        return AppName;
    }
    public void setAppName(String appName) {
        AppName = appName;
    }
    public String getAddress() {
        return Address;
    }
    public void setAddress(String address) {
        Address = address;
    }
    public int getMobile() {
        return mobile;
    }
    public void setMobile(int mobile) {
        this.mobile = mobile;
    }
    public String getOrderdate() {
        return Orderdate;
    }
    public void setOrderdate(String orderdate) {
        Orderdate = orderdate;
    }
    public String getDeliverydate() {
        return Deliverydate;
    }
    public void setDeliverydate(String deliverydate) {
        Deliverydate = deliverydate;
    }
}
