package page;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;
import org.openqa.selenium.support.PageFactory;
import util.DriverContext;

public class HomePage {

    public HomePage() {
        PageFactory.initElements(DriverContext.getDriver(), this);
    }


    @FindBy(how = How.NAME,using = "search")
    protected WebElement campoBusca;

    @FindBy(how = How.NAME, using = "go")
    protected WebElement BtnBusca;

    @FindBy(how = How.XPATH, using = "//li[contains(., 'A ') and contains(.//a, 'common') ]")
    protected WebElement fraseApple;

    @FindBy(how = How.XPATH, using = "//li[contains(., 'An edible fruit produced by the pear tree, similar to an ') and contains(.//a, 'apple') and contains(.,' but elongated towards the stem.')]")
    protected WebElement frasePear;




}
