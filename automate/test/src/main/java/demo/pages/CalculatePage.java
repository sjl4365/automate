//src/main/java/demo/pages/LoginPage.java
package demo.pages;
import org.openqa.selenium.By;

public class CalculatePage extends BasePage{
    private By Age = By.id("cage");
    // private By maleGender = By.id("csex1");
    private By maleGender = By.xpath("//label[@for='csex1']");
    // private By femaleGender = By.id("csex2");
    private By femaleGender = By.xpath("//label[@for='csex2']");
    private By HeightM = By.id("cheightmeter");
    private By HeightUSFeet = By.id("cheightfeet");
    private By HeightUSInch = By.id("cheightinch");
    private By WeightM =By.id("ckg");
    private By WeightUS =By.id("cpound");
    private By Activity = By.id("cactivity");
    private By Calculcate = By.name("x");
    private By ErrorA = By.id("cageifcErr");
    private By ErrorAge = By.xpath("//font[contains(text(), 'Please provide an age between 18 and 80')]");
    private By ErrorHeightM = By.id("cheightmeterifcErr");
    private By ErrorHeightUSInch = By.id("cheightinchifcErr");
    private By ErrorHeightUSFeet = By.id("cheightfeetifcErr");
    private By Clear = By.cssSelector("input[value='Clear']");
    private By US = By.linkText("US Units");
    private By Metric = By.linkText("Metric Units");
    // private By Settings = By.linkText("Settings");
    private By Settings = By.xpath("//a[@href='#' and contains(@onclick, 'cshmoreoption')]");
    private By heading = By.xpath("//h1[text()='Carbohydrate Calculator']");
    // private By mifflinFormula = By.id("cformula1");
    private By mifflinFormula = By.xpath("//label[@for='cformula1']");

    public void setAgeNumber(double age){
        set(Age, String.valueOf(age));
    }
    public void setAgeString(String age){
        set(Age, age);
    }

    public void setMaleGender(){
        click(maleGender);
    }

    public void setFemaleGender(){
        click(femaleGender);
    }

    public void setHeightM(double height){
        set(HeightM, String.valueOf(height));
    }
    public void setHeightUSF(double height){
        set(HeightUSFeet, String.valueOf(height));
    }
    public void setHeightUSI(double height){
        set(HeightUSInch, String.valueOf(height));
    }
    public void setWeightM(double weight){
        set(WeightM, String.valueOf(weight));
    }

    public void setWeightUS(double weight){
        set(WeightUS, String.valueOf(weight));
    }

    public void setCalculate(){
        click(Calculcate);
    }

    public void setClear(){
        click(Clear);
    }

    public void setUS(){
        click(US);
    }

    public void setMetric(){
        click(Metric);
    }

    public void setSettings(){
        click(Settings);
    }

    public void setActivity(String activityLevel){ 
        setDrop(Activity, activityLevel); 
    }

    public String getError(){
        return waitForElement(ErrorA).getText();
    }
    public String getErrorAge(){
        return waitForElement(ErrorAge).getText();
    }
    public String getHeightM(){
        return waitForElement(ErrorHeightM).getText();
    }
    public String getHeightUSFeet(){
        return waitForElement(ErrorHeightUSFeet).getText();
    }
    public String getHeightUSInch(){
        return waitForElement(ErrorHeightUSInch).getText();
    }

    public void clickBackground(){
        click(heading);
    }

    public void clickHeightFieldM(){
        click(HeightM);
    }
    public void clearAge(){
        clear(Age);
    }
    public void tabFromAge(){
        pressTab(Age);
    }

    public void selectMifflinFormula(){
        click(mifflinFormula);
    }
} 
