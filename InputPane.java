package Assignment6;

import java.util.ArrayList;
import javafx.scene.layout.HBox;
//import all other necessary javafx classes here
//----
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextArea;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.VBox;
import javafx.scene.control.TextField;
import javafx.scene.layout.FlowPane;
import javafx.geometry.Insets;
import javafx.event.ActionEvent;	//**Need to import to handle event
import javafx.event.EventHandler;	//**Need to import to handle event
import javafx.geometry.Pos;
import javafx.scene.paint.Color;
import javafx.scene.text.Font;

public class InputPane extends HBox {
    //GUI components

    private ArrayList<Laptop> laptopList;
    private Label brand, model, cpu, ram, price, space, errorText;
    private Button btn1;
    private GridPane gp;
    private HBox hbox;
    private TextArea ta;
    private TextField tfBrand, tfModel, tfCpu, tfRam, tfPrice, tfSpace;
    private FlowPane fp;

    //The relationship between InputPane and PurchasePane is Aggregation
    private PurchasePane purchasePane;
    //----

    //constructor
    public InputPane(ArrayList<Laptop> list, PurchasePane pPane) {
        this.laptopList = list;
        this.purchasePane = pPane;

        // Labels for the pane
        this.brand = new Label("Brand ");
        this.model = new Label("Model ");
        this.cpu = new Label("CPU(GHz)");
        this.ram = new Label("RAM(GB)");
        this.price = new Label("Price($)");
        this.space = new Label(" ");
        this.errorText = new Label("Please fill all fields");

        errorText.setFont(new Font("Arial", 14));
        errorText.setTextFill(Color.web("CE0000"));
        errorText.setVisible(false);

        //Buttons for the pane
        this.btn1 = new Button("Enter a Laptop Info");

        //The text area thingy
        this.ta = new TextArea("No Laptops");
        this.ta.snappedBottomInset();

        //Text field thingy
        this.tfBrand = new TextField();
        this.tfModel = new TextField();
        this.tfCpu = new TextField();
        this.tfRam = new TextField();
        this.tfPrice = new TextField();

        //Start the layout
        gp = new GridPane();
        gp.add(errorText, 0, 0);
        gp.add(tfBrand, 1, 2);
        gp.add(brand, 0, 2);
        gp.add(tfModel, 1, 3);
        gp.add(model, 0, 3);
        gp.add(tfCpu, 1, 4);
        gp.add(cpu, 0, 4);
        gp.add(tfRam, 1, 5);
        gp.add(ram, 0, 5);
        gp.add(tfPrice, 1, 6);
        gp.add(price, 0, 6);
        //gp.add(btn1, 1, 7);

        gp.setPadding(new Insets(20, 25, 10, 25));
        gp.setVgap(5);

        fp = new FlowPane();
        fp.getChildren().addAll(gp, btn1);
        fp.setAlignment(Pos.TOP_CENTER);

        btn1.setOnAction(new ButtonHandler());

        hbox = new HBox();
        hbox.getChildren().addAll(fp, ta);
        this.getChildren().add(hbox);

        //Step #3: register source object with event handler
        //----
    } //end of constructor

    //Step #2: Create a ButtonHandler class
    //ButtonHandler listens to see if the buttont "Enter a Laptop Info." is pushed or not,
    //When the event occurs, it get a laptop's brand, model, CPU, RAM and price
    //information from the relevant text fields, then create a new Laptop object and add it inside
    //the laptopList. Meanwhile it will display the laptop's information inside the text area.
    //It also does error checking in case any of the textfields are empty or wrong data was entered.
    private class ButtonHandler implements EventHandler<ActionEvent> {
        //Override the abstact method handle()

        public void handle(ActionEvent e) {
            //declare any necessary local variables here
            //---
            //when a text field is empty and the button is pushed
            if (tfBrand.getText().equalsIgnoreCase("") || tfModel.getText().equalsIgnoreCase("") || tfCpu.getText().equalsIgnoreCase("") || tfRam.getText().equalsIgnoreCase("") || tfPrice.getText().equalsIgnoreCase("")) {
                errorText.setText("Please fill all fields"); // Here we are making sure the text is not empty
                errorText.setVisible(true);
                //handle the case here
            } else //for all other cases
            {
                try {
                    errorText.setVisible(false);
                    Laptop l = new Laptop(tfBrand.getText(), tfModel.getText(), Double.parseDouble(tfCpu.getText()), Double.parseDouble(tfRam.getText()), Double.parseDouble(tfPrice.getText()));
                    //System.out.println(laptopList.indexOf(l));
                    if (laptopList.indexOf(l) != -1) {
                        //System.out.println("The size is a: " + laptopList.size());  // incase they enter more than once
                        errorText.setVisible(false);
                        errorText.setText("Laptop not added - Duplicate");
                        errorText.setVisible(true);
                    } else {
                        //System.out.println("The size is: " + laptopList.size());
                        errorText.setVisible(false);
                        errorText.setText("Laptop added!");
                        errorText.setVisible(true);
                        laptopList.add(l);
                        if (ta.getText().equalsIgnoreCase("no laptops")) { // our place holder
                            ta.setText(l.toString());
                        } else {
                            ta.setText(ta.getText() + l.toString());
                        }
                        purchasePane.updateLaptopList(l);
                        tfBrand.setText("");
                        tfModel.setText("");
                        tfCpu.setText("");
                        tfRam.setText("");
                        tfPrice.setText("");
                    }

                } catch (NumberFormatException i) {
                    errorText.setText("Incorrect data format");
                    errorText.setVisible(true);
                }
            }

        } //end of handle() method
    } //end of ButtonHandler class

}
// \|/
// AXA
///XXX\
//\XXX/
// `^'
// Pineapple
