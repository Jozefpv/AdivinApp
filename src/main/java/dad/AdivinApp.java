package dad;

import javafx.application.Application;
import javafx.event.ActionEvent;
import javafx.geometry.Pos;

import javafx.scene.Scene;
import javafx.scene.control.Alert;
import javafx.scene.control.Alert.AlertType;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;

public class AdivinApp extends Application {
//vamooooooooooooos eres dios 
	private TextField numeroText;
	private Label comprobarLabel;
	private int numero, cont = 0;
	private int numRandom = (int) (Math.random() * 100 + 1);

	@Override
	public void start(Stage primaryStage) throws Exception {
		// TODO Auto-generated method stub

		// Creamos una etiqueta
		comprobarLabel = new Label();
		comprobarLabel.setText("Introduce un numero del 1 al 100");

		// Creamos el cuadro de texto
		numeroText = new TextField();
		numeroText.setPromptText("Introduce un numero");

		// Creamos un boton
		Button comprobarButton = new Button("Comprobar");
		comprobarButton.setDefaultButton(true);
		comprobarButton.setOnAction(e -> onComprobarAction(e));

		// Creamos el panel con disposicion vertical
		VBox rootPanel = new VBox();
		rootPanel.setSpacing(5);
		rootPanel.setAlignment(Pos.CENTER);
		rootPanel.setFillWidth(false);
		rootPanel.getChildren().addAll(comprobarLabel, numeroText, comprobarButton);

		Scene scene = new Scene(rootPanel, 320, 200);

		primaryStage.setTitle("AdivinApp");
		primaryStage.setScene(scene);
		primaryStage.show();

	}

	private void onComprobarAction(ActionEvent e) {
		try {
			numero = Integer.parseInt(numeroText.getText());
		} catch (NumberFormatException e2) {
			Alert alert = new Alert(AlertType.ERROR);
			alert.setTitle("Error Dialog");
			alert.setHeaderText("Error");
			alert.setContentText("El número introducido no es válido");
			alert.showAndWait();
		
		}

		if (numero > numRandom) {
			cont++;
			Alert alert = new Alert(AlertType.WARNING);
			alert.setTitle("Warning Dialog");
			alert.setHeaderText("Has fallado");
			alert.setContentText("El numero a adivinar es menor a " + numero);
			alert.showAndWait();
		} else if (numero < numRandom) {
			cont++;
			Alert alert = new Alert(AlertType.WARNING);
			alert.setTitle("Warning Dialog");
			alert.setHeaderText("Has fallado");
			alert.setContentText("El numero a adivinar es mayor a " + numero);
			alert.showAndWait();
		}
		else {
			Alert alert = new Alert(AlertType.INFORMATION);
			alert.setTitle("Information Dialog");
			alert.setHeaderText("Has acertado");
			alert.setContentText("Has necesitado " + cont + " intentos");
			alert.showAndWait();
		}
	}

	public static void main(String[] args) {
		launch(args);
	}

}
