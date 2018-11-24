package com.roguedevstudios.uarg.System.UI;

import javafx.scene.control.ContextMenu;

public class VariableTableView<V> {
    private String text; // for some reason this HAS to be named without a '_' or the table breaks
    private Double number1;
    private Double number2;
    private Double number3;
    private Double number4;
    private Double number5;

    public VariableTableView(String text1, Double num1, Double num2, Double num3, Double num4, Double num5 ) {
	this.text = text1;
	this.number1 = num1;
	this.number2 = num2;
	this.number3 = num3;
	this.number4 = num4;
	this.number5 = num5;
    }
    
    public String getText() {
	return text;
    }

    void setText(String _text) {
	this.text = _text;
    }
    
    public Double getNumber1() {
        return number1;
    }

    public void setNumber1(Double number1) {
        this.number1 = number1;
    }

    public Double getNumber2() {
        return number2;
    }

    public void setNumber2(Double number2) {
        this.number2 = number2;
    }

    public Double getNumber3() {
        return number3;
    }

    public void setNumber3(Double number3) {
        this.number3 = number3;
    }

    public Double getNumber4() {
        return number4;
    }

    public void setNumber4(Double number4) {
        this.number4 = number4;
    }

    public Double getNumber5() {
        return number5;
    }

    public void setNumber5(Double number5) {
        this.number5 = number5;
    }
    
    
}
