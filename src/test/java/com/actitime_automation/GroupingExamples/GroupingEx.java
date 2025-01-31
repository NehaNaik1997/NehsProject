package com.actitime_automation.GroupingExamples;

import org.testng.annotations.Test;

public class GroupingEx {
    @Test(groups = {"regression","smoke","intgration"})
    public void CreateCustomer()
    {System.out.println("Capital Create Customer");}

    @Test(groups = {"smoke","intgration"})
    public void createcustomer()
    {System.out.println("Small Create Customer");}

    @Test(groups = {"smoke","regression"})
    public void UpdateCustomer()
    {System.out.println("Capital update customer");}

    @Test(groups ={"smoke"} )
    public void LoginCustomer()
    {System.out.println("Login Customer");}

    @Test(groups ={"intgration","regression"} )
    public void logoutCustomer()
    {System.out.println("Customer logs out");}
}
