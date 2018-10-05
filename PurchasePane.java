package Assignment6;


import javafx.scene.layout.VBox;
import javafx.event.ActionEvent;	//**Need to import to handle event
import javafx.event.EventHandler;	//**Need to import to handle event
import java.util.ArrayList;
import javafx.scene.control.ListView;

//import all other necessary javafx classes
//----
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.HBox;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.text.Font;
import javafx.scene.paint.Color;

public class PurchasePane extends VBox {
    //GUI components

    private ArrayList<Laptop> laptopList, selectedList;
    private Label avail, selected, qty, qtySel, totalAmt, total;
    private Button btn1, btn2;
    private GridPane gp, gpb, gpb2;
    private HBox hbox, hboxBot;
    private VBox vbox;
    //laptopLV for top ListView; selectedLV for bottom ListView
    private ListView<Laptop> laptopLV, selectedLV;

    //constructor
    public PurchasePane(ArrayList<Laptop> list) {
        //initialize instance variables
        this.laptopList = list;
        selectedList = new ArrayList<Laptop>();

        // Labels for the pane
        this.avail = new Label("Available Laptops");
        this.selected = new Label("Selected Laptops");
        this.qtySel = new Label("Qty Selected: ");
        this.totalAmt = new Label("Total Amt: ");
        this.qty = new Label("??");
        this.total = new Label("?.??");

        avail.setFont(new Font("Arial", 20));
        avail.setTextFill(Color.web("1034A6"));

        selected.setFont(new Font("Arial", 20));
        selected.setTextFill(Color.web("1034A6"));

        qtySel.setFont(new Font("Arial", 20));
        qtySel.setTextFill(Color.web("1034A6"));

        qty.setFont(new Font("Arial", 20));
        qty.setTextFill(Color.web("1034A6"));

        totalAmt.setFont(new Font("Arial", 20));
        totalAmt.setTextFill(Color.web("1034A6"));

        total.setFont(new Font("Arial", 20));
        total.setTextFill(Color.web("1034A6"));

        // Buttons for said pane
        this.btn1 = new Button("Pick a Laptop");
        this.btn2 = new Button("Remove a Laptop");

        // List views
        laptopLV = new ListView<Laptop>();
        selectedLV = new ListView<Laptop>();

        //Start the layout
        gp = new GridPane();
        gp.add(btn1, 0, 0);
        gp.add(btn2, 1, 0);
        gp.setHgap(20);
        hbox = new HBox();
        hbox.getChildren().addAll(gp);
        hbox.setPadding(new Insets(20, 10, 15, 10));
        hbox.setAlignment(Pos.CENTER);

        gpb = new GridPane();
        gpb.add(qtySel, 0, 0);
        gpb.add(qty, 1, 0);
        gpb.setHgap(5);

        gpb2 = new GridPane();
        gpb2.add(totalAmt, 0, 0);
        gpb2.add(total, 1, 0);

        hboxBot = new HBox();
        hboxBot.getChildren().addAll(gpb, gpb2);
        hboxBot.setAlignment(Pos.CENTER);
        hboxBot.setSpacing(50);

        vbox = new VBox();
        vbox.getChildren().addAll(avail, laptopLV, hbox, selected, selectedLV, hboxBot);
        this.getChildren().add(vbox);

        //Step #3: Register the button with its handler class
        //----
        ButtonHandler2 handled = new ButtonHandler2();
        btn1.setOnAction(handled);
        btn2.setOnAction(handled);
    } //end of constructor

    //This method refresh the ListView whenever there's new laptop added in InputPane
    //you will need to update the underline ObservableList object in order for ListView
    //object to show the updated laptop list
    public void updateLaptopList(Laptop newLaptop) {
        laptopLV.getItems().add(newLaptop);

    }

//Step #2: Create a ButtonHandler class
    private class ButtonHandler2 implements EventHandler<ActionEvent> {
        //Override the abstact method handle()

        public void handle(ActionEvent e) {
            //When "Pick a Laptop" button is pressed and a laptop is selected from
            //the top list

            if (e.getSource() == btn1) {
                if (selectedLV.getItems().indexOf(laptopLV.getSelectionModel().getSelectedItem()) != -1)
                    ; else {
                    selectedLV.getItems().add(laptopLV.getSelectionModel().getSelectedItem());
                }

            } //when "Remove a Laptop" button is pushed and a laptop is selected from
            //the bottom list
            else if (e.getSource() == btn2) {
                selectedLV.getItems().remove(selectedLV.getSelectionModel().getSelectedItem());
            } else //for all other cases
            {
                //All invalid action, do nothing here;
            }
            //update the QtySelect and AmtSelect labels
            //----
            Double price = 0.0;
            Integer count = 0;

            for (Laptop x : selectedLV.getItems()) {
                price = price + x.getPrice();
                count++;
            }
            qty.setText(count.toString());
            total.setText(price.toString());

        }
    } //end of ButtonHandler class

} //end of PurchasePane class

// \|/
// AXA
///XXX\
//\XXX/
// `^'
// Pineapple
