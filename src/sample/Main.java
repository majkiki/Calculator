package sample;

import javafx.application.Application;
import javafx.event.EventHandler;
import javafx.fxml.FXMLLoader;

import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;

import javafx.scene.input.MouseEvent;

import javafx.scene.text.Text;
import javafx.stage.Stage;


import java.io.File;
import java.util.DoubleSummaryStatistics;


public class Main extends Application {

    public Text text;
    public Button button1;
    public Button button2;
    public Button button3;
    public Button button4;
    public Button button5;
    public Button button6;
    public Button button7;
    public Button button8;
    public Button button9;
    public Button button0;
    public Button minusb;
    public Button plusb;
    public Button multib;
    public Button divideb;
    public Button Backspace;
    public Button equalsButton;
    public Button clearButton;

    public double firstNumber = 0;
    public double secondNumber = 0;

    public char operator =' ';

    public boolean isFirstNumber = true;

    public String textBoxPreValue = "";

    @Override
    public void start(Stage primaryStage) throws Exception{
        Parent root = FXMLLoader.load(getClass().getResource("sample.fxml"));
        primaryStage.setTitle("Kalkulator");
        Scene scene = new Scene(root, 300, 275);

        scene.getStylesheets().add(getClass().getResource("CalculatorStyleSheet.css").toExternalForm());
        primaryStage.setScene(scene);
        primaryStage.show();


        text = (Text)root.lookup("#textField");

        button1 = (Button)root.lookup("#1Button");
        button1.setOnMouseClicked(mouseEventHandlerForNumericButtons);
        button2 = (Button)root.lookup("#2Button");
        button2.setOnMouseClicked(mouseEventHandlerForNumericButtons);
        button3 = (Button)root.lookup("#3Button");
        button3.setOnMouseClicked(mouseEventHandlerForNumericButtons);
        button4 = (Button)root.lookup("#4Button");
        button4.setOnMouseClicked(mouseEventHandlerForNumericButtons);
        button5 = (Button)root.lookup("#5Button");
        button5.setOnMouseClicked(mouseEventHandlerForNumericButtons);
        button6 = (Button)root.lookup("#6Button");
        button6.setOnMouseClicked(mouseEventHandlerForNumericButtons);
        button7 = (Button)root.lookup("#7Button");
        button7.setOnMouseClicked(mouseEventHandlerForNumericButtons);
        button8 = (Button)root.lookup("#8Button");
        button8.setOnMouseClicked(mouseEventHandlerForNumericButtons);
        button9 = (Button)root.lookup("#9Button");
        button9.setOnMouseClicked(mouseEventHandlerForNumericButtons);
        button0 = (Button)root.lookup("#0Button");
        button0.setOnMouseClicked(mouseEventHandlerForNumericButtons);

        minusb = (Button)root.lookup("#minusButton");
        minusb.setOnMouseClicked(mouseEventHandlerForNumericButtons);
        multib = (Button)root.lookup("#multiplicationButton");
        multib.setOnMouseClicked(mouseEventHandlerForNumericButtons);
        divideb = (Button)root.lookup("#divideButton");
        divideb.setOnMouseClicked(mouseEventHandlerForNumericButtons);
        plusb = (Button)root.lookup("#sumButton");
        plusb.setOnMouseClicked(mouseEventHandlerForNumericButtons);
        Backspace = (Button)root.lookup("#backspaceButton");
        Backspace.setOnMouseClicked(mouseEventHandlerForNumericButtons);

        equalsButton = (Button)root.lookup("#equalsButton");
        equalsButton.setOnMouseClicked(mouseEventHandlerForNumericButtons);

        clearButton = (Button)root.lookup("#clearButton");
        clearButton.setOnMouseClicked(mouseEventHandlerForNumericButtons);


    }


    EventHandler<MouseEvent> mouseEventHandlerForNumericButtons = new EventHandler<MouseEvent>() {
        @Override
        public void handle(MouseEvent event) {
            Button tmpButton = (Button) event.getSource();

            if(tmpButton == button1){
                textBoxPreValue += "1";
                text.setText(textBoxPreValue);
                updateNumber(1);
            }
            else if(tmpButton == button2){
                textBoxPreValue += "2";
                text.setText(textBoxPreValue);
                updateNumber(2);
            }
            else if(tmpButton == button3){
                textBoxPreValue += "3";
                text.setText(textBoxPreValue);
                updateNumber(3);
            }
            else if(tmpButton == button4){
                textBoxPreValue += "4";
                text.setText(textBoxPreValue);
                updateNumber(4);
            }
            else if(tmpButton == button5){
                textBoxPreValue += "5";
                text.setText(textBoxPreValue);
                updateNumber(5);
            }
            else if(tmpButton == button6){
                textBoxPreValue += "6";
                text.setText(textBoxPreValue);
                updateNumber(6);
            }
            else if(tmpButton == button7){
                textBoxPreValue += "7";
                text.setText(textBoxPreValue);
                updateNumber(7);
            }
            else if(tmpButton == button8){
                textBoxPreValue += "8";
                text.setText(textBoxPreValue);
                updateNumber(8);
            }
            else if(tmpButton == button9){
                textBoxPreValue += "9";
                text.setText(textBoxPreValue);
                updateNumber(9);
            }
            else if(tmpButton == button0){
                textBoxPreValue += "0";
                text.setText(textBoxPreValue);
                updateNumber(0);
            }
            /******* Operation buttons  ******************/
            else if(tmpButton == minusb){
                if(operator == ' ') {
                    isFirstNumber = false;
                }else{
                    doCalculations();
                    secondNumber = 0;
                }
                textBoxPreValue += " - ";
                text.setText(textBoxPreValue);
                operator = '-';
            }
            else if(tmpButton == plusb){
                if(operator == ' ') {
                    isFirstNumber = false;
                }else{
                    doCalculations();
                    secondNumber = 0;
                }
                textBoxPreValue += " + ";
                text.setText(textBoxPreValue);
                operator = '+';
            }
            else if(tmpButton == multib){
                if(operator == ' ') {
                    isFirstNumber = false;
                }else{
                    doCalculations();
                    secondNumber = 0;
                }
                textBoxPreValue += " * ";
                text.setText(textBoxPreValue);
                operator = '*';
            }
            else if(tmpButton == divideb){
                if(operator == ' ') {
                    isFirstNumber = false;
                }else{
                    doCalculations();
                    secondNumber = 0;
                }
                textBoxPreValue += " / ";
                text.setText(textBoxPreValue);
                operator = '/';
            }

            /****** equals button *******/

            else if(tmpButton == equalsButton){
                doCalculations();

                //reseting calculator
                textBoxPreValue= "";
                isFirstNumber = true;
                firstNumber=0;
                secondNumber=0;
                operator = ' ';

            }

            /***** clear button ***********/
            else if(tmpButton == clearButton){
                textBoxPreValue= "";
                isFirstNumber = true;
                firstNumber=0;
                secondNumber=0;
                operator = ' ';
                text.setText(textBoxPreValue);
            }
            else if(tmpButton == Backspace){
                if(isFirstNumber == true) {
                    if (firstNumber == 0) {

                    } else {
                        String s = Double.toString(firstNumber);
                        s = s.substring(0,s.length()-3);
                        firstNumber = Integer.parseInt(s);
                        textBoxPreValue = s;
                        text.setText(textBoxPreValue);
                        System.out.println(firstNumber);
                    }
                }else{
                    if (secondNumber == 0) {
                    } else {
                        String s = Double.toString(secondNumber);
                        String firstnumplusoperator = Double.toString(firstNumber) + operator;
                        s = s.substring(0,s.length()-3);
                        secondNumber = Integer.parseInt(s);
                        textBoxPreValue = firstnumplusoperator + s;
                        text.setText(textBoxPreValue);
                        System.out.println(secondNumber);

                    }
                }
            }
        }
    };

    public void doCalculations(){
        if(operator == '+') {
            textBoxPreValue = Double.toString(firstNumber + secondNumber);
            text.setText(textBoxPreValue);
            firstNumber = firstNumber + secondNumber;
        }
        else if(operator == '-'){
            textBoxPreValue = Double.toString(firstNumber - secondNumber);
            text.setText(textBoxPreValue);
            firstNumber = firstNumber - secondNumber;
        }
        else if(operator == '*'){
            textBoxPreValue = Double.toString(firstNumber * secondNumber);
            text.setText(textBoxPreValue);
            firstNumber = firstNumber * secondNumber;
        }
        else if(operator == '/'){
            if(secondNumber !=0){
                textBoxPreValue = Double.toString(firstNumber / secondNumber);
                text.setText(textBoxPreValue);
                firstNumber = firstNumber / secondNumber;
            }
            else text.setText("Error");
            textBoxPreValue = Double.toString(firstNumber / secondNumber);
            text.setText(textBoxPreValue);
            firstNumber = firstNumber / secondNumber;
        }
    }

    public void updateNumber(int number){
        if(isFirstNumber == true) {
            if (firstNumber == 0) {
                firstNumber = number;
            } else {
                String s = Double.toString(firstNumber);
                s = s.substring(0,s.length()-2);
                s += Integer.toString(number);
                firstNumber = Integer.parseInt(s);
                System.out.println("First number"+firstNumber);
            }
        }else{
            if (secondNumber == 0) {
                secondNumber = number;
            } else {
                String s = Double.toString(secondNumber);
                s = s.substring(0,s.length()-2);
                s += Integer.toString(number);
                secondNumber = Integer.parseInt(s);
                System.out.println("Second number"+secondNumber);
            }
        }
    }

    public static void main(String[] args) {
        launch(args);
    }
}