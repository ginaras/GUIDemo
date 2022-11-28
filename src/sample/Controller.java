package sample;

import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.stage.Stage;

import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;


public class Controller implements Initializable {


    //These items are for the CheckBox example
    @FXML private Label pizzaOrderLabel;
    @FXML private CheckBox pepperoniCheckBox;
    @FXML private CheckBox pineappleCheckBox;
    @FXML private CheckBox baconCheckBox;

    @FXML private ChoiceBox choiceBox;
    @FXML private Label choiceBoxLabel;

    @FXML private ComboBox comboBox;
    @FXML private Label comboBoxLabel;

    @FXML private RadioButton phpBut;
    @FXML private RadioButton javaBut;
    @FXML private RadioButton cShBut;
    @FXML private RadioButton cplusBut;
    @FXML private Label radioButtonLabel;
    private ToggleGroup favToggleGroup;

    //List & Text
    @FXML private ListView listView;
    @FXML private TextArea golfTextArea;
    @FXML private ListView golfListArea;
    @FXML private Button selectButton;
    @FXML private Button changeb;
    @FXML private Button ch;

    public void clickOnListViewSelectButton(){
        this.selectButton.setDisable( false );
    }



    //Changecvsctage button
//    public void changeScreenButtonPushed( ActionEvent event ) throws IOException {
//         Parent viewScene1 = FXMLLoader.load(getClass().getResource( "VS2.fxml" ));
//        Scene tabeleViewScene = new Scene( viewScene1 );
//     //This line gets the stage inforation
//        Stage viewStage1 =  (Stage)((Node)event.getSource()).getScene().getWindow();
//
//        viewStage1.setScene( tabeleViewScene );
//        viewStage1.show(); }

    public void changeScreenButtonPushed() throws IOException {
        Parent scene = FXMLLoader.load(getClass().getResource("VS2.fxml"));
//        Stage stage = (Stage) ch.getScene().getWindow();
//        Stage stage = (Stage) selectButton.getScene().getWindow();
        Stage stage = (Stage) changeb.getScene().getWindow();
//        Stage stage = (Stage) selectButton.getScene().getWindow();
        stage.setScene(new Scene(scene));
    }
//    Stage Window = (Stage) btnChangeScene.getScene().getWindow()
//	window.setScene(new Scene(root));

           //buton de pizza checkBox
        public void pizzaOrderButtonPushed()
    {
        String order = "Toppings are:";

        if (pineappleCheckBox.isSelected())
            order += "\npineapple";

        if (pepperoniCheckBox.isSelected())
            order += "\npepperoni";

        if (baconCheckBox.isSelected())
            order += "\nbacon";

        this.pizzaOrderLabel.setText(order);
    }
        //buton de alegere lista desfasurata
    public void choisBoxButtonPush (){
        choiceBoxLabel.setText("My favorite Fruits is:\n"+choiceBox.getValue().toString() );
    }

    //ComboBox
    public void ComboBoxWasUpdated(){
        this.comboBoxLabel.setText( "Product selected is: \n"+comboBox.getValue().toString() );
    }

    //Radio button
    public void radioButtonChange(){
        if (this.favToggleGroup.getSelectedToggle().equals( this.cplusBut ))
        radioButtonLabel.setText( "U pushed C++" );
        if (this.favToggleGroup.getSelectedToggle().equals( this.cShBut ))
        radioButtonLabel.setText( "U pushed C#" );
        if (this.favToggleGroup.getSelectedToggle().equals( this.javaBut ))
        radioButtonLabel.setText( "U pushed Java" );
        if (this.favToggleGroup.getSelectedToggle().equals( this.phpBut ))
        radioButtonLabel.setText( "U pushed PHP" );
        }

    //trecerea de info din list in text view
    public void listViewButtonPushed(){
        String textAreaString = "";
        ObservableList listOfItems= listView.getSelectionModel().getSelectedItems();

        for (Object item : listOfItems){
            textAreaString += String.format( "%n%s", item );
            }
        this.golfTextArea.setText( textAreaString );
        this.golfListArea.setItems( listOfItems );

//        ObservableList <ListView> selectedItems, allElements;
//        allElements =listView.getItems();
//        selectedItems =listView.getSelectionModel().getSelectedItems();
//
//        for (ObservableList  : selectedItems); {
//            allElements.remove( selectedItems );
//
//        }

    }
    //Unselect Text view button
   public void UnselectButtom (  ) {

        ObservableList listGofl = golfListArea.getSelectionModel().getSelectedItems();

        for (Object item: listGofl)
            listGofl.remove( item );
        }


    @Override
    public void initialize ( URL location, ResourceBundle resources ) {

        pizzaOrderLabel.setText( "" );

        choiceBoxLabel.setText( " " );
        choiceBox.getItems().add( "mere" );
        choiceBox.getItems().addAll( "pere", "portocale", "prune", "caise" );
        choiceBox.setValue( "" );

        comboBoxLabel.setText( "" );
        comboBox.getItems().addAll( "TV", "Radio", "Laptop", "Printer" );

        radioButtonLabel.setText( " " );
        favToggleGroup =new ToggleGroup();
        this.phpBut.setToggleGroup( favToggleGroup );
        this.javaBut.setToggleGroup( favToggleGroup );
        this.cplusBut.setToggleGroup( favToggleGroup );
        this.cShBut.setToggleGroup( favToggleGroup );

        // populare listView

       listView.getItems().addAll( "golf ball", "golf cross", "football ball", "cricket ball");
       listView.getSelectionModel().setSelectionMode( SelectionMode.MULTIPLE );

       this.selectButton.setDisable( true );

    }


}
