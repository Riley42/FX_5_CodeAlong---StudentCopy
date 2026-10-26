package com.example.fx_5_codealong;

import javafx.scene.control.Alert;
import javafx.scene.control.ButtonBar;
import javafx.scene.control.ButtonType;

import java.util.Optional;

public class Utils
{
    private static Alert createAlert(Alert.AlertType alertType, String title, String content)
    {
        Alert alert = new Alert(alertType);
        var css = Utils.class.getResource("alert.css");

        if (css != null) {
            alert.getDialogPane().getStylesheets().add(css.toString());
        }

        alert.setTitle(title);
        alert.setHeaderText(null);
        alert.setContentText(content);

        return alert;
    }

    /**
     * Shows an Alert the user just needs to see and dismiss \u2014
     * INFORMATION, WARNING, or ERROR all work here.
     */
    public static void showInformativeAlert(Alert.AlertType alertType, String title, String content)
    {
        Alert alert = createAlert(alertType, title, content);
        alert.showAndWait();
    }

    /**
     * Shows a Yes/No confirmation Alert and returns which button the
     * user picked \u2014 wrapped in an Optional since it's possible they
     * closed the window without picking either one.
     */
    public static Optional<ButtonType> showConfirmationAlert(String title, String content)
    {
        Alert alert = createAlert(Alert.AlertType.CONFIRMATION, title, content);

        ButtonType yesButton = new ButtonType("Yes", ButtonBar.ButtonData.OK_DONE);
        ButtonType noButton = new ButtonType("No", ButtonBar.ButtonData.CANCEL_CLOSE);

        alert.getButtonTypes().setAll(yesButton, noButton);

        return alert.showAndWait();
    }
}
