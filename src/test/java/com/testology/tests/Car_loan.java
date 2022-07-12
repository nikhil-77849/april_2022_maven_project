package com.testology.tests;
import org.testng.annotations.Test;
import utils.TestBase;

public class Car_loan   extends TestBase
{  
@Test (groups={"exclude_test_group"})
public void WebLoginCarLoan() {
    System.out.println("Web Login Home Loan");
}
    @Test(groups= {"Regression"})
    public void MobileLoginCarLoan()
    {
        System.out.println("Mobile Login Home Loan");
    }
    @Test(groups= {"Regression"})
    public void APILoginCarLoan()
    {
        System.out.println("API Login Home Loan");
    }
}


