package pages;

import base.PageBase;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class HomePage extends PageBase {

    public HomePage(WebDriver driver) {
        super(driver);
    }

    @FindBy(xpath="//button[@data-testid='todo-list-item-complete']")
    private WebElement btnComplete;

    @FindBy(xpath="//div[@class='toast-body']")
    private WebElement msgSuccess;

    @FindBy(xpath="//button[@data-testid='todo-list-item-delete']")
    private WebElement btnDelete;

    @FindBy(xpath="//button[contains(text(),'Add Todo')]")
    private WebElement btnAdd;

    public void clickComplete(){
        btnComplete.click();
    }

    public boolean verifyToastMessageComplete(String expText){
        return msgSuccess.getText().equals("Todo \""+expText+"\" completed successfully.");
    }

    public boolean verifyToastMessageInComplete(String expText){
        return msgSuccess.getText().equals("Todo \""+expText+"\" completion successfully undone.");
    }

    public boolean verifyToastMessageDelete(String expText){
        return msgSuccess.getText().equals("Todo \""+expText+"\" removed successfully.");
    }

    public boolean verifyStrikeThrough(String expText){
        return driver.findElement(By.xpath("//div[contains(text(),'"+expText+"')]")).getAttribute("style").equals("text-decoration: line-through;");
    }

    public void clickDelete(){
        btnDelete.click();
    }

    public void clickAddButton(){
        btnAdd.click();
    }
}
