package com.nttdata.stepsdefinitions;

import com.nttdata.steps.InventoryStepsBensg;
import com.nttdata.steps.LoginStepsBensg;
import io.cucumber.java.es.Cuando;
import io.cucumber.java.es.Dado;
import io.cucumber.java.es.Entonces;
import io.cucumber.java.es.Y;
import org.junit.jupiter.api.Assertions;
import org.openqa.selenium.WebDriver;

import static com.nttdata.core.DriverManager.getDriver;
import static com.nttdata.core.DriverManager.screenShot;

public class LoginBensgStepsDef {

    private WebDriver driver;

    private InventoryStepsBensg inventoryStepsBensg(WebDriver driver){
        return new InventoryStepsBensg(driver);
    }

    @Dado("estoy en la página de la tienda")
    public void estoyEnLaPaginaDeLaTienda() {
        driver = getDriver();
        driver.get("https://qalab.bensg.com/store/pe/iniciar-sesion?back=https%3A%2F%2Fqalab.bensg.com%2Fstore%2Fpe%2F");
        screenShot();
    }

    @Cuando("me logueo con mi usuario {string} y clave {string}")
    public void meLogueoConMiUsuarioYClave(String user, String password) {
        LoginStepsBensg loginStepsBensg = new LoginStepsBensg(driver);

        loginStepsBensg.typeUser(user);
        loginStepsBensg.typePassword(password);
        loginStepsBensg.login();
        screenShot();
    }

    @Entonces("valido autenticacion correcta {string}")
    public void validoAutenticacionCorrecta(String expectedTitle) {
        String title =  inventoryStepsBensg(driver).getTitle();
        //prueba: validamos el título del My Store
        Assertions.assertEquals(expectedTitle, title);
        screenShot();
    }

    @Y("cierro sesion")
    public void cierroSesion() {
        LoginStepsBensg loginStepsBensg = new LoginStepsBensg(driver);
        loginStepsBensg.logout();
        screenShot();

    }

}