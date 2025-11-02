//src/test/java/test/InputTests.java
package test;
import org.testng.Assert;
import org.testng.annotations.Test;

public class InputTests extends BaseTest{
    //Testing for getting message for positve number only for Age
    @Test 
    public void testAgeInputErrorMessagePositveNumbersOnly(){
        calculatePage.setUS();    
        testAgeToGetPositiveNumbersOnly();
        calculatePage.setMetric();
        testAgeToGetPositiveNumbersOnly();
        
    }
    //Testing for getting message for positive number only for Height
    @Test
    public void testHeightInputErrorMessagePositveNumbersOnly(){
        calculatePage.setMetric();
        testHeightMetricToGetPositiveNumbersOnly();
    }
    
    //Testiung to get message for non negatie numbers only for Height
    @Test
    public void testHeightInputErrorMessageNonNegativeNumbersOnly(){
        calculatePage.setUS();
        testHeightUSToGetPositiveNumbersOnly();
    }

    //Testing for getting message Please provide an age between 18 and 80 for male and female in US and Metric Units
    @Test
    public void testAgeErrorMessageUSMale(){
        calculatePage.setUS();
        calculatePage.setAgeNumber(1);
        calculatePage.setMaleGender();
        calculatePage.setHeightUSF(5);
        calculatePage.setHeightUSI(5);
        calculatePage.setWeightUS(170);
        calculatePage.setActivity("Sedentary: little or no exercise");
        setActivityWithMifflin();
    }
    @Test
    public void testAgeErrorMessageUSFemale(){
        calculatePage.setUS();
        calculatePage.setAgeNumber(1);
        calculatePage.setFemaleGender();
        calculatePage.setHeightUSF(5);
        calculatePage.setHeightUSI(5);
        calculatePage.setWeightUS(170);
        calculatePage.setActivity("Sedentary: little or no exercise");
        setActivityWithMifflin();
    }

    @Test
    public void testAgeErrorMessageMetricMale(){
        calculatePage.setMetric();
        calculatePage.setAgeNumber(1);
        calculatePage.setMaleGender();
        calculatePage.setHeightM(5);
        calculatePage.setWeightM(170);
        calculatePage.setActivity("Sedentary: little or no exercise");
        setActivityWithMifflin();
    }

    @Test
    public void testAgeErrorMessageMetricFemale(){
        calculatePage.setMetric();
        calculatePage.setAgeNumber(1);
        calculatePage.setFemaleGender();
        calculatePage.setHeightM(5);
        calculatePage.setWeightM(170);
        calculatePage.setActivity("Sedentary: little or no exercise");
        setActivityWithMifflin();
    }


    private void testAgeToGetPositiveNumbersOnly(){
        calculatePage.setClear();
        calculatePage.setAgeNumber(0);
        String actualMessageOne = calculatePage.getError();
        Assert.assertTrue(actualMessageOne.contains("positive numbers only"));

        calculatePage.setClear();
        calculatePage.setAgeNumber(-1);
        String actualMessageTwo = calculatePage.getError();
        Assert.assertTrue(actualMessageTwo.contains("positive numbers only"));

        calculatePage.setClear();
        calculatePage.setAgeNumber(-10);
        String actualMessageThree = calculatePage.getError();
        Assert.assertTrue(actualMessageThree.contains("positive numbers only"));

        calculatePage.setClear();
        calculatePage.setAgeNumber(-0.0000001);
        String actualMessageFour = calculatePage.getError();
        Assert.assertTrue(actualMessageFour.contains("positive numbers only"));

        calculatePage.setClear();
        calculatePage.setAgeString("!");
        String actualMessageFifth = calculatePage.getError();
        Assert.assertTrue(actualMessageFifth.contains("positive numbers only"));

        calculatePage.setClear();
        calculatePage.setAgeString("a");
        String actualMessageSixth = calculatePage.getError();
        Assert.assertTrue(actualMessageSixth.contains("positive numbers only"));
    }

    private void testHeightMetricToGetPositiveNumbersOnly(){
        calculatePage.setClear();
        calculatePage.setHeightM(0);
        String actualMessageOne = calculatePage.getHeightM();
        Assert.assertTrue(actualMessageOne.contains("positive numbers only"));
    }

    private void testHeightUSToGetPositiveNumbersOnly(){
        calculatePage.setClear();
        calculatePage.setHeightUSF(-1);
        String actualMessageOneFeet = calculatePage.getHeightUSFeet();
        Assert.assertFalse(actualMessageOneFeet.contains("positive numbers only"));
        Assert.assertTrue(actualMessageOneFeet.contains("non negative numbers only"));
        calculatePage.setHeightUSI(-1);
        String actualMessageOneInch = calculatePage.getHeightUSFeet();
        Assert.assertFalse(actualMessageOneInch.contains("positive numbers only"));
        Assert.assertTrue(actualMessageOneInch.contains("non negative numbers only"));
    }

    public void setActivityWithMifflin(){
        calculatePage.setSettings();
        calculatePage.selectMifflinFormula();
        calculatePage.setCalculate();
        String actualMessageOne = calculatePage.getErrorAge();
        Assert.assertTrue(actualMessageOne.contains("Please provide an age between 18 and 80"));
        calculatePage.setActivity("Light: exercise 1-3 times/week");
        String actualMessageTwo = calculatePage.getErrorAge();
        Assert.assertTrue(actualMessageTwo.contains("Please provide an age between 18 and 80"));
        calculatePage.setActivity("Moderate: exercise 4-5 times/week");
        String actualMessageThree = calculatePage.getErrorAge();
        Assert.assertTrue(actualMessageThree.contains("Please provide an age between 18 and 80"));
        calculatePage.setActivity("Active: daily exercise or intense exercise 3-4 times/week");
        String actualMessageFour = calculatePage.getErrorAge();
        Assert.assertTrue(actualMessageFour.contains("Please provide an age between 18 and 80"));
    }
}


