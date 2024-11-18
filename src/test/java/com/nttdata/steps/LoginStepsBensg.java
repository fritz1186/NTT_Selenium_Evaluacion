package com.nttdata.steps;

import com.nttdata.page.LoginPage;
import com.nttdata.page.LoginPageBensg;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;


public class LoginStepsBensg {

    private WebDriver driver;

    //constructor
    public LoginStepsBensg(WebDriver driver){
        this.driver = driver;
    }

    /**
     * Escribir el usuario
     * @param user el usuario
     */
    public void typeUser(String user){

        WebElement userInputElement = driver.findElement(LoginPageBensg.userInput);
        userInputElement.sendKeys(user);

        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(444));

        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(40));
        wait.until(ExpectedConditions.visibilityOfElementLocated(LoginPageBensg.loginButton));
    }

    /**
     * Escribir el password
     * @param password el password del usuario
     */
    public void typePassword(String password){
        this.driver.findElement(LoginPageBensg.passInput).sendKeys(password);
    }

    /**
     * Hacer click en el botón login
     */
    public void login(){
        this.driver.findElement(LoginPageBensg.loginButton).click();
    }
    public void logout(){
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(400));
        //Se espera que cargue el boton
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(40));
        wait.until(ExpectedConditions.visibilityOfElementLocated(LoginPageBensg.logoutButton));

        this.driver.findElement(LoginPageBensg.logoutButton).click();
    }

}

