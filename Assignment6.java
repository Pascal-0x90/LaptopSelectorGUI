package Assignment6;

import javafx.application.Application;
import javafx.stage.Stage;
import javafx.scene.Scene;
import javafx.scene.control.Tab;
import javafx.scene.control.TabPane;
import javafx.scene.layout.StackPane;
import java.util.ArrayList;

public class Assignment6 extends Application {

    private TabPane tabPane;
    private InputPane inputPane;
    private PurchasePane purchasePane;
    private ArrayList<Laptop> laptopList;

    public void start(Stage stage) {
        StackPane root = new StackPane();

        //laptopList to be used in both InputPane & PurchasePane
        laptopList = new ArrayList<Laptop>();

        purchasePane = new PurchasePane(laptopList);
        inputPane = new InputPane(laptopList, purchasePane);

        tabPane = new TabPane();

        Tab tab1 = new Tab();
        tab1.setText("Laptop Input");
        tab1.setContent(inputPane);

        Tab tab2 = new Tab();
        tab2.setText("Laptop Purchase");
        tab2.setContent(purchasePane);

        tabPane.getSelectionModel().select(0);
        tabPane.getTabs().addAll(tab1, tab2);

        root.getChildren().add(tabPane);

        Scene scene = new Scene(root, 800, 600);
        stage.setTitle("Laptop Purchase Apps");
        stage.setScene(scene);
        stage.show();
    }

    public static void main(String[] args) {
        launch(args);
    }
}
// \|/
// AXA
///XXX\
//\XXX/
// `^'
// Pineapple
