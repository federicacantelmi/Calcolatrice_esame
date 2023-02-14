package com.example.calcolatrice_esame;

import javafx.fxml.FXML;
import javafx.scene.control.TextField;

public class Calculator {
    @FXML
    private TextField textField;

    private String firstNumber = "";
    private String currentNumber = "";
    private String calculatingType;

    public void selectZero(){addNumber("0");}
    public void selectOne(){addNumber("1");}
    public void selectTwo(){addNumber("2");}
    public void selectThree(){addNumber("3");}
    public void selectFour(){addNumber("4");}
    public void selectFive(){addNumber("5");}
    public void selectSix(){addNumber("6");}
    public void selectSeven(){addNumber("7");}
    public void selectEight(){addNumber("8");}
    public void selectNine(){addNumber("9");}

    public void selectBackspace() {
        switch(currentNumber) {
            case "-Infinity", "NaN" -> selectClear();
            default -> {
                if(!currentNumber.equals("")) {
                    currentNumber = currentNumber.substring(0, currentNumber.length()-1);
                    updateTextField();
                }
            }
        }
    }

    public void selectClear() {
        currentNumber = "";
        updateTextField();
    }

    public void selectClearAll(){
        currentNumber = "";
        firstNumber = "";
        textField.setText("");
    }

    public void selectDivide(){setCalculation("/");}
    public void selectMultiply(){setCalculation("*");}
    public void selectSub(){setCalculation("-");}
    public void selectSum(){setCalculation("+");}

    public void selectLn() {
        Double currentNumberDouble = Double.parseDouble(currentNumber);
        currentNumberDouble = Math.log(currentNumberDouble);
        currentNumber = String.valueOf(currentNumberDouble);
        updateTextField();
    }
    
    public void selectChangeSign(){
        if(!currentNumber.contains("-")) {
            currentNumber = "-" + currentNumber;
        }
        else {
            double currentNumberDouble = Double.parseDouble(currentNumber);
            currentNumberDouble = currentNumberDouble * (-1);
            currentNumber = String.valueOf(currentNumberDouble);
        }
        updateTextField();
    }

    public void selectDot() {
        if(!currentNumber.contains(".")) {
            if (currentNumber.equals(""))
                currentNumber += "0.";
            else
                currentNumber += ".";
            updateTextField();
        }
    }

    public void selectResult() {
        if (!firstNumber.equals("")) {
            double firstNumberDouble = Double.parseDouble(firstNumber);
            double secondNumberDouble = Double.parseDouble(currentNumber);
            double calculatedNumber = 0;
            switch (calculatingType) {
                case "+" -> {
                    calculatedNumber = firstNumberDouble + secondNumberDouble;
                    textField.setText(String.valueOf(calculatedNumber));
                }
                case "-" -> {
                    calculatedNumber = firstNumberDouble - secondNumberDouble;
                    textField.setText(String.valueOf(calculatedNumber));
                }
                case "*" -> {
                    calculatedNumber = firstNumberDouble * secondNumberDouble;
                    textField.setText(String.valueOf(calculatedNumber));
                }
                case "/" -> {
                    calculatedNumber = firstNumberDouble / secondNumberDouble;
                    textField.setText(String.valueOf(calculatedNumber));
                }
                default -> {//ignore
                }
            }
            currentNumber = String.valueOf(calculatedNumber);
        }
    }

    private void updateTextField() {
        textField.setText(currentNumber);
    }

    private void addNumber(String number) {
        if(!currentNumber.equals("0")) {
            currentNumber += number;
            updateTextField();
        }
    }

    private void setCalculation(String calculatingType) {
        this.calculatingType = calculatingType;
        if(!currentNumber.equals("")) {
            firstNumber = currentNumber;
            currentNumber = "";
        }
        else if(firstNumber.equals(""))
            firstNumber = "0";
    }
}