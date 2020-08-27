package stepDefinition;

import action.HomeAction;
import io.cucumber.java.pt.E;


public class HomeStepDef extends HomeAction {



    @E("pesquiso por {string}")
    public void buscarPalavra(String text){
        setText(text);
        clickBtnLookUp();
    }

    @E("valido frase pear")
    public void validarFrase(){
        validarFrasePear();
    }

    @E("valido frase apple")
    public void validarFrase2(){
        validarFraseApple();
    }


}
