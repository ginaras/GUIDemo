package sample;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Label;
import javafx.stage.Stage;

import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;

public class Controller3 implements Initializable {

    @FXML private Label firstNameLabel;
    @FXML private Label lastNameLabel;
    @FXML private Label birthdayLabel;
    @FXML private Label ageLabel;

    private Person selectedPerson;

    public void initData (Person person) {
        selectedPerson = person;
        firstNameLabel.setText( selectedPerson.getFirstName() );
        lastNameLabel.setText( selectedPerson.getLastName() );
        birthdayLabel.setText( selectedPerson.getBirthday().toString() );
        ageLabel.setText( Integer.toString( selectedPerson.getAge() ) );

    }
        //back button
        public void backButtonPushed3 (ActionEvent event ) throws IOException {
            Parent viewScene2 = FXMLLoader.load(getClass().getResource( "VS2.fxml" ));
            Scene tabeleViewScene = new Scene( viewScene2 );
            //This line gets the stage inforation
            Stage viewStage2 =(Stage)((Node)event.getSource()).getScene().getWindow();

            viewStage2.setScene( tabeleViewScene );
            viewStage2.show();
            String s= "100";
            System.out.println(s+520);
            int i = Integer.parseInt( s );
            System.out.println(i+520);
    }


    @Override
    public void initialize ( URL location, ResourceBundle resources ) {

    }
}
