package project;

import org.testng.annotations.Test;

@Test
public void mailOpenPage(){
        WebElement userField=driver.findElement(By.id("login"));
        WebElement passwordField=driver.findElement(By.id("password"));
        WebElement loginButton=driver.findElement(By.id("btnSubmit"));
        userField.sendKeys(email);
        passwordField.sendKeys(password);
        loginButton.click();
        }