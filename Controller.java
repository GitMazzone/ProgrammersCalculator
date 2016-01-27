import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.application.Application;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.scene.Scene;
import javafx.scene.Parent;
import javafx.scene.control.ToggleButton;
import javafx.scene.layout.Pane;
import javafx.stage.Stage;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import java.io.IOException;
import java.io.*;

public class Controller{

    @FXML private Label result_label;
    @FXML private ToggleButton use_recursion;
    @FXML private ToggleButton hide_binary;
    @FXML private Pane bin_container;
    @FXML private String binaryResult = "";
    private IterativeMath iMath = new IterativeMath();
    private RecursiveMath rMath = new RecursiveMath();
    private ReversePolishNotation rPN = new ReversePolishNotation();

    //Prints the number value to the result label with no spacing on either
    //side, because spacing for RPN is accounted for in showOperator/Factorial.
    @FXML protected	void showValue(ActionEvent	event)	{
        String value = ((Button)event.getSource()).getText();
        result_label.setText(result_label.getText() + value);
    }

    //Prints factorial with spacing on either side, because the only case
    //where space is not needed on left side is when factorial is used, which
    //is accounted for in showFactorial.
    @FXML protected void showOperator(ActionEvent event) {
        String value = ((Button)event.getSource()).getText();
        result_label.setText(result_label.getText() + " " + value + " ");
    }

    //Prints factorial with spacing on left side only, because there will never
    //be anything but a number on left side of it, which has no spacing on
    //either side. No spacing on left side to account for existing spacing on
    //either side of an operator character.
    @FXML protected void showFactorial(ActionEvent event) {
        String value = ((Button)event.getSource()).getText();
        result_label.setText(result_label.getText() + " " + value);
    }

    //Hide or show binary section depending on toggle.
    @FXML protected void toggleBinary(ActionEvent event) {
        if(hide_binary.isSelected()){
            bin_container.setVisible(false);
        }
        else {
            bin_container.setVisible(true);
        }
    }

    //Flips the bit that was pressed to a 0 or 1 depending on previous state
    //Gets int value of each active bit
    @FXML protected void flipBit(ActionEvent event) {
        //Used to update 0 or 1
        String bitText = ((Button)event.getSource()).getText();
        //Used to update value displayed
        String bitID = ((Button)event.getSource()).getId();

        if(bitText.equals("0")) {
            ((Button)event.getSource()).setText("1");

            //add id (bit value) to string
            if(binaryResult.length() < 1) {
                binaryResult = bitID;
            }
            else {
                binaryResult = binaryResult + " + " + bitID;
            }
        }
        if(bitText.equals("1")) {
            ((Button)event.getSource()).setText("0");

            binaryResult = binaryResult + " - " + bitID;
        }

        Math math;

        //Checks if recursive toggle is selected, applies appropriate class
        //Will use currently selected math class for next Enter press
        if(use_recursion.isSelected()) {
            math = rMath;
        }
        else {
            math = iMath;
        }

        String infixArr[] = binaryResult.split(" ");
        String postfixArr[] = rPN.infixToPostfix(infixArr);
        int result = rPN.evaluate(math, postfixArr);
        String stringResult = Integer.toString(result);
        result_label.setText(stringResult);

    }

    //Sets label text to be blank - effectively clearing it
    @FXML protected void clear(ActionEvent event) {
        result_label.setText("");
    }

    //Sets label text to a substring of the current text minus last character
    @FXML protected void backspace(ActionEvent event) {
        String value = result_label.getText();
        String updatedValue = value.substring(0, value.length() - 1);
        result_label.setText(updatedValue);
    }

    //When pressed, gets current String from result label
    //It's put into an array after split by spaces (converted to infix)
    //Finally put into postfix using RPN postfix method and stored in new array
    //Use RPN evaluate method based on which math class is implemented
    //Convert int result to String and update (set) the label accordingly
    @FXML protected void equate(ActionEvent event) {
        Math math;

        //Checks if recursive toggle is selected, applies appropriate class
        //Will use currently selected math class for next Enter press
        if(use_recursion.isSelected()) {
            math = rMath;
        }
        else {
            math = iMath;
        }

        String input = result_label.getText();
        String infixArr[] = input.split(" ");
        String postfixArr[] = rPN.infixToPostfix(infixArr);
        int result = rPN.evaluate(math, postfixArr);
        String stringResult = Integer.toString(result);
        result_label.setText(stringResult);
    }

    //Simply lets tester know which math class is being used.
    //Updates after each time the Enter button is pressed.
    @FXML protected void recursionToggle(ActionEvent event) {
        if(use_recursion.isSelected()) {
            System.out.println("recursive");
        }
        else {
            System.out.println("iterative");
        }
    }

    //TODO
    @FXML protected void detectKonami(ActionEvent event) {
        //Make Pong game that is set to invisible until activated via this
    }

}
