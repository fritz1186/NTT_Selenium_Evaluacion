package com.nttdata.steps;

import com.nttdata.page.InventoryPageBensg;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import java.util.List;

public class InventoryStepsBensg {

    private WebDriver driver;

    //contrsuctor
    public InventoryStepsBensg(WebDriver driver){
        this.driver = driver;
    }

    /**
     * Obtener el título de la pantalla de productos
     * @return el valor del título de la pantalla de productos
     */
    public String getTitle(){
        return this.driver.findElement(InventoryPageBensg.productsTitle).getText();
    }

    /**
     * Retorna la cantidad de items
     * @return la cantidad de items
     */
    public int getItemSize(){
        List<WebElement> items = this.driver.findElements(InventoryPageBensg.itemsCards);
        return items.size();
    }
}
