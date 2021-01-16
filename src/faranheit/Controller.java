package faranheit;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Alert;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.image.Image;
import javafx.scene.layout.Region;
import javafx.stage.Modality;
import javafx.stage.Stage;

public class Controller {
    @FXML
    private Label celsius;
    @FXML
    private TextField CText;
    @FXML
    private Label fahrenheit;
    @FXML
    private Label Flabel;
    @FXML
    private Label kelvin;
    @FXML
    private Label Klabel;
    @FXML
    private Button convertio;
    @FXML
    private Button abt;
    @FXML
    private void convert(ActionEvent e) {
        String inp = CText.getText();
        try {
            double c = Double.parseDouble(inp);
            double f = c * (9.0/5.0) + 32;
            double k = c + 273.15;
            if (k > 0) {
                Flabel.setText(f + "");
                Klabel.setText(k + "");
            } else if (k == 0) {
                Flabel.setText(f + "");
                Klabel.setText("Absolute Zero!");
            } else {
                Flabel.setText("Cannot be reached!");
                Klabel.setText("Cannot be below 0!");
                Alert alert = new Alert(Alert.AlertType.ERROR);
                alert.setTitle("Error Dialog");
                alert.setHeaderText("Logic Error!");
                alert.setContentText("Kelvin is an absolute scale. 0K is absolute zero — the point at which gas molecules have no thermal energy. There's no negative temperature on the Kelvin temperature scale. At zero kelvin (minus 273 degrees Celsius) the particles stop moving and all disorder disappears. Thus, nothing can be colder than absolute zero on the Kelvin scale.");
                alert.getDialogPane().setMinHeight(Region.USE_PREF_SIZE);
                alert.showAndWait();
            }
        } catch (Exception ex) {
            Alert alert = new Alert(Alert.AlertType.ERROR);
            alert.setTitle("Error Dialog");
            alert.setHeaderText("Invalid input!");
            alert.setContentText("Please input a valid value, not "+inp+'!');
            alert.showAndWait();
        }
    }
    @FXML
    private void handleAbout(ActionEvent event) {
        try {
            Stage stage = new Stage();
            Parent root = FXMLLoader.load(getClass().getResource("About.fxml"));
            stage.setScene(new Scene(root));
            stage.setResizable(false);
            stage.setTitle("About the Programmer");
            stage.getIcons().add(new Image(("file:thermometer.jpg")));
            stage.initModality(Modality.WINDOW_MODAL);
            stage.initOwner(abt.getScene().getWindow());
            stage.showAndWait();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
