package action;

import org.junit.Assert;
import page.HomePage;


public class HomeAction extends HomePage {


    public void setText(String text)
    {
        campoBusca.click();
        campoBusca.sendKeys(text);
    }

    public void clickBtnLookUp(){
        BtnBusca.click();
    }

    public void validarFrasePear(){
        String frase = frasePear.getText();
        Assert.assertEquals("An edible fruit produced by the pear tree, similar to an apple but elongated towards the stem.", frase );

    }

    public void validarFraseApple(){
        String frase = fraseApple.getText().substring(0,94);
        Assert.assertEquals("A common, round fruit produced by the tree Malus domestica, cultivated in temperate climates. ", frase );
    }

}
