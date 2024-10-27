package org.example;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;

import java.time.Duration;

public class Main {
    WebDriver driver;
    Actions actions;
    WebDriverWait wait;

    public Main(WebDriver driver) {
        this.driver = driver;
        this.wait = new WebDriverWait(driver, Duration.ofSeconds(3));
        actions = new Actions(driver);
        PageFactory.initElements(driver, this);
    }
        @FindBy(xpath = "//a[contains(text(), 'Рибам')]")
        WebElement forFishMenu;

        @FindBy(xpath = "//span[text()='Акваріуми']")
        WebElement aquariumsSubMenu;

        @FindBy(id = "live-search")
        WebElement searchBox;

        public void moveToForFishes() {actions.moveToElement(forFishMenu).perform();}
        public void checkAquarium() {
            wait.until(ExpectedConditions.visibilityOf(aquariumsSubMenu));
            Assert.assertTrue(aquariumsSubMenu.isDisplayed(), "Підменю 'Акваріуми' недоступне."); }
        public void clickAquariums() {
            wait.until(ExpectedConditions.elementToBeClickable(aquariumsSubMenu));
            aquariumsSubMenu.click(); }
        public void enterAquarium() {
            wait.until(ExpectedConditions.visibilityOf(searchBox));
            searchBox.sendKeys("акваріум"); }
        public void pressEnter() { searchBox.submit(); }

}