package com.actitime_automation;


import org.testng.annotations.Test;

public class TestNGExample2 {
    @Test(priority = 0)
    public void createcustomer()
    {
        System.out.println("customer created");
    }
    @Test(priority = 3)
    public void updatepassword()
    {
        System.out.println("Passwords updated");
    }
    @Test(priority = 5)
    public void deletecustomer()
    {
        System.out.println("customer deleted");
    }
    @Test(priority = 4)
    public void modifythedetails()
    {
        System.out.println("customer modified");
    }
}
