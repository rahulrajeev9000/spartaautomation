package testsuites;

import org.junit.*;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Action;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.Select;
import utilities.DriverUtilities;

public class RegisterTest {

    static WebDriver driver;

    @BeforeClass
    public static void SetUp(){
        driver = DriverUtilities.getInstanceOfDriverUtilities().getDriver();
    }

    @Before
    public void preCondition(){
        driver.get("http://automation-form.spartaglobal.education/");
    }


    @Test
    public void registerTest() throws InterruptedException {
        driver.findElement(By.id("firstName")).sendKeys("Rahul");
        driver.findElement(By.id("lastName")).sendKeys("Rajeev");
        driver.findElement(By.xpath("/html/body/div/form/div[3]/div/input")).sendKeys("22");

        WebElement dobSelect = driver.findElement(By.name("dob"));
        dobSelect.sendKeys("20111996");

        driver.findElement(By.xpath("/html/body/div/form/div[5]/label")).click();
        driver.findElement(By.xpath("/html/body/div/form/div[7]/div/input")).sendKeys("Mechanical Engineering");
        WebElement uniSelect = driver.findElement(By.id("inputUni"));
        Select uniOptionToSelect = new Select(uniSelect);
        uniOptionToSelect.selectByVisibleText("University of Oxford");
        driver.findElement(By.id("inputAddress")).sendKeys("10 Downing Street");
        driver.findElement(By.id("inputCity")).sendKeys("London");
        driver.findElement(By.id("inputPostcode")).sendKeys("EC1 1AA");
        driver.findElement(By.id("inputemailaddress")).sendKeys("rahul.sparta@gmail.com");
        driver.findElement(By.id("exampleFormControlInput1")).sendKeys("07912324242");
        driver.findElement(By.xpath("/html/body/div/form/div[20]/div[1]/label")).click();
        driver.findElement(By.id("terms")).click();

        WebElement slider = driver.findElement(By.id("experienceSlider"));
        Actions move = new Actions(driver);
        Action action = move.dragAndDropBy(slider, 400, 0).build();
        action.perform();
        Thread.sleep(1000);

        driver.findElement(By.xpath("/html/body/div/form/button")).click();
        Assert.assertTrue(driver.findElement(By.xpath("/html/body/div/h3")).getText().contains("You have successfully registered an account with Sparta Global!"));
        Thread.sleep(3000);


    }


}
