package com.testology.tests;
import org.testng.annotations.Test;
import utils.TestBase;

public class Home_loan    extends TestBase
{
  @Test(groups= {"Regression"})
public void WebLoginHomeLoan()  
{  
  System.out.println("Web Login Home Loan");  
}  
@Test(groups= {"Regression"})
public void MobileLoginHomeLoan()  
{  
  System.out.println("Mobile Login Home Loan");  
}  
@Test(groups={"exclude_test_group"})
public void APILoginHomeLoan()  
{  
  System.out.println("API Login Home Loan");  
}  
}  
