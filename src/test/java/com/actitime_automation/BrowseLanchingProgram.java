package com.actitime_automation;

import org.utilities.GenericUtility;

public class BrowseLanchingProgram {
    public static void main(String []args)
    {
        GenericUtility gu = new GenericUtility();
        gu.startUp("ch", "https://www.flipkart.com/");
        System.out.println("Doing changes and Try to push git hub ");
    }
}
