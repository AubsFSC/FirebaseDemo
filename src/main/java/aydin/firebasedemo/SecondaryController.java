package aydin.firebasedemo;

import java.io.IOException;

import com.google.firebase.auth.FirebaseAuthException;
import com.google.firebase.auth.UserRecord;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.TextField;

public class SecondaryController {

    @FXML
    private TextField emailTextField;

    @FXML
    private TextField passwordTextField;

    @FXML
    void registerButtonClicked(ActionEvent event) {
        registerUser();
    }

    @FXML
    void signinButtonClicked(ActionEvent event) {
        signinUser();
    }

    public boolean registerUser() {
        UserRecord.CreateRequest request = new UserRecord.CreateRequest()
                .setEmail("user222@example.com")
                .setEmailVerified(false)
                .setPassword("secretPassword")
                .setPhoneNumber("+11234567890")
                .setDisplayName("John Doe")
                .setDisabled(false);

        UserRecord userRecord;
        try {
            userRecord = DemoApp.fauth.createUser(request);
            System.out.println("Successfully created new user with Firebase Uid: " + userRecord.getUid()
                    + " check Firebase > Authentication > Users tab");
            DemoApp.setRoot("primary");
            return true;

        } catch (FirebaseAuthException ex) {
            // Logger.getLogger(FirestoreContext.class.getName()).log(Level.SEVERE, null, ex);
            System.out.println("Error creating a new user in the firebase");
            return false;
        } catch (IOException ex) {
            System.out.println("Error switching to the Primary View");
            return false;
        }

    }

    public boolean signinUser() {

        try {
        DemoApp.fauth.getUserByEmail((emailTextField.getText().toString()));
        System.out.println("Successfully logged in");
            DemoApp.setRoot("primary");
        return true;
        }
        catch (FirebaseAuthException ex) {
            System.out.println("Error logging in");
            return false;
        } catch (IOException ex) {
            System.out.println("Error switching to the Primary View");
            return false;
        }

    }

}
