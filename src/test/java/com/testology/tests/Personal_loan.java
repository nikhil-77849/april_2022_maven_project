package com.testology.tests;
import org.testng.annotations.Test;
import utils.TestBase;

public class Personal_loan   extends TestBase
{  
 @Test(groups= {"Regression"})
 public void WebLoginPersonalLoan()  
 {  
     System.out.println("Web Login Personal Loan");  
 }
    @Test (groups={"exclude_test_group"})
    public void MobileLoginPersonalLoan()
 {  
     System.out.println("Mobile Login Personal Loan");  
 }
    @Test(groups= {"Regression"})
    public void APILoginPersonalLoan()
 {  
     System.out.println("API Login Personal Loan");  
 }  
}
