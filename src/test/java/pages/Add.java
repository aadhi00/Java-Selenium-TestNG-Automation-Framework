package pages;

import base.PageBase;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.Select;

public class Add extends PageBase {


    public Add(WebDriver driver) {
        super(driver);
    }

    @FindBy(xpath="//div[@class='modal-footer']/button")
    private WebElement btnSubmit;

    @FindBy(xpath="//input[@id='new-todo-text']")
    private WebElement txtDescription;

    @FindBy(xpath="//select[@id='new-todo-priority']")
    private WebElement ddPriority;

    @FindBy(xpath="//div[@class='react-datepicker__input-container']/input")
    private WebElement datePicker;

    public boolean verifySubmit(){
        return btnSubmit.isEnabled();
    }

    public void createTodo(String description, String priority, String date){
        txtDescription.sendKeys(description);
        Select s = new Select(ddPriority);
        s.selectByValue(priority);
        datePicker.click();
        driver.findElement(By.xpath("//div[contains(text(),"+date+")]")).click();
    }
}
