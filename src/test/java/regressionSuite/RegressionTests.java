package regressionSuite;

import base.TestBase;
import org.testng.annotations.Test;
import pages.Add;
import pages.HomePage;

public class RegressionTests extends TestBase {

    HomePage homePage;

    Add add;

    @Test(priority = 1)
    public void complete_a_todo() {
        driver.get(data.getProperty("base.url"));
        homePage = new HomePage(driver);
        homePage.clickComplete();
        log.info("Clicked complete button");
        if (homePage.verifyToastMessageComplete(data.getProperty("taskName")))
            log.info("toast verified");
        else {
            log.info("toast mismatch");
            getScreenshot(this.getClass().getEnclosingMethod().getName());
        }
        if (homePage.verifyStrikeThrough(data.getProperty("taskName")))
            log.info("task completed");
        else {
            getScreenshot(this.getClass().getEnclosingMethod().getName());
            log.info("task incomplete");
        }
    }

    @Test(priority = 2)
    public void uncomplete_a_todo() {
        homePage.clickComplete();
        log.info("Clicked complete button again");
        if (homePage.verifyToastMessageInComplete(data.getProperty("taskName"))) {
            log.info("toast verified");
        } else {
            log.info("toast mismatch");
            getScreenshot(this.getClass().getEnclosingMethod().getName());
        }
        if (homePage.verifyStrikeThrough(data.getProperty("taskName")))
            log.info("task still completed");
        else {
            getScreenshot(this.getClass().getEnclosingMethod().getName());
            log.info("task incomplete");
        }
    }

    @Test(priority = 3)
    public void delete_a_todo() {
        homePage.clickDelete();
        log.info("Clicked delete button");
        if (homePage.verifyToastMessageDelete(data.getProperty("taskName")))
            log.info("Task deleted");
        else {
            log.info("Task not deleted");
            getScreenshot(this.getClass().getEnclosingMethod().getName());
        }
    }

    @Test(priority = 4)
    public void add_a_todo() {
        homePage.clickAddButton();
        add = new Add(driver);
        if (add.verifySubmit()) {
            log.info("submit enabled-fail");
            getScreenshot(this.getClass().getEnclosingMethod().getName());
        } else {
            log.info("submit disabled-pass");

        }
        add.createTodo("xyz", "medium", "18");
        log.info("Entered the data");
        if (add.verifySubmit())
            log.info("submit enabled-pass");
        else {
            log.info("submit disabled-fail");
            getScreenshot(this.getClass().getEnclosingMethod().getName());
        }
    }
}
