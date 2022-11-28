package sample;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.event.Event;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.stage.Stage;

import java.io.IOException;
import java.net.URL;
import java.time.LocalDate;
import java.time.Month;
import java.util.ResourceBundle;

public class Controller2 implements Initializable {

    public Button changeScreenButtonPushedBack;
    @FXML private TableView<Person> tableView;
    @FXML private TableColumn<Person, String> firstNameColumn;
    @FXML private TableColumn<Person, String> lastNameColumn;
    @FXML private TableColumn<Person, LocalDate> birthdayColumn;
    @FXML private TextField firstNameTextField;
    @FXML private TextField lastNameTextField;
    @FXML private DatePicker birthdayDatePicker;

    @FXML private Button addPerson;
    @FXML  private Button delPerson;
    @FXML private Button detailedButton;
//    private Button changeScreenButtonPushedBack;


    public void userClickOnTable(){
        this.detailedButton.setDisable( false );
        this.delPerson.setDisable( false );
    }
    public void newUserClickOnTable () {
        String control1 =  firstNameTextField.getText() + lastNameTextField.getText() ;
        //String control2 =  lastNameTextField.getText() ;
        //LocalDate control3 = birthdayDatePicker.getValue( );

        if (control1 != null ) {
            this.addPerson.setDisable( false );
        }
    }
    //back Button schimbarea de staigiuri
    public void changeScreenButtonPushedBack ( Event event ) throws IOException {
        Parent tableView = FXMLLoader.load(getClass().getResource( "PrincipalScene.fxml" ));
        Scene tabeleViewScene = new Scene( tableView );
        //This line gets the stage inforation
        Stage window =  (Stage)((Node)event.getSource()).getScene().getWindow();
        window.setScene( tabeleViewScene );
        window.show();
    }
    //Create new pers & add in list
    public void newPersonButtonPushed(){
        Person newPerson = new Person(
                firstNameTextField.getText(),
                lastNameTextField.getText(),
                birthdayDatePicker.getValue());
        tableView.getItems().add( newPerson );

    }

    //delete person
    public void deleteButtonPersonPushed(){
        ObservableList <Person> selectedRows, allPeople;
        allPeople=tableView.getItems();
        selectedRows =tableView.getSelectionModel().getSelectedItems();
        for (Person person : selectedRows){
            allPeople.remove( person );
        }
    }


    /**
     * When this method is called, it will pass the selected Person object to
     * a the detailed view
     */
    public void changeSceneToDetailedPersonView(ActionEvent event) throws IOException
    {
        FXMLLoader loader = new FXMLLoader();
        loader.setLocation(getClass().getResource("VS3.fxml"));
        Parent tableViewParent = loader.load();

        Scene tableViewScene = new Scene(tableViewParent);

        //access the controller and call a method
        Controller3 controller = loader.getController();
        controller.initData(tableView.getSelectionModel().getSelectedItem());

        //This line gets the Stage information
        Stage window = (Stage)((Node)event.getSource()).getScene().getWindow();

        window.setScene(tableViewScene);
        window.show();
    }

    @Override
    public void initialize ( URL location, ResourceBundle resources ) {
        //set up the column & populate the list
        firstNameColumn.setCellValueFactory(new PropertyValueFactory<Person,String>("firstName") );
        lastNameColumn.setCellValueFactory(new PropertyValueFactory<Person,String>("lastName") );
        birthdayColumn.setCellValueFactory(new PropertyValueFactory<Person,LocalDate>("birthday") );
        tableView.setItems( getPeople() );
       //desable a button
        this.detailedButton.setDisable( true );
        this.addPerson.setDisable( true );
        this.delPerson.setDisable( true );

    }




    //load data
    public ObservableList <Person> getPeople (){
     ObservableList <Person> people = FXCollections.observableArrayList(  ) ;
     people.add( new Person( "Mr","Tit", LocalDate.of( 1990, Month.MAY,31 ) ) );
    people.add( new Person( "Oz","GG", LocalDate.of( 1995, Month.APRIL,21 ) ) );

     return people;
    }



}
