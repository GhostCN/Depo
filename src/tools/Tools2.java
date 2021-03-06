package tools;

import java.io.IOException;

import javafx.event.ActionEvent;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;

public class Tools2 {

	private void loadPage(ActionEvent event, String url,int m) throws IOException{
		//on cache l'ancienne fenetre
		if(m==1)
		{
			((Node) event.getSource()).getScene().getWindow().hide();
		//creation d'une nouvelle scene
		Parent root = FXMLLoader.load(getClass().getResource(url));
		Scene scene = new Scene(root);

		Stage primaryStage = new Stage();
		primaryStage.setTitle("Gestion d'un parc informatique");
		primaryStage.setResizable(false);
		primaryStage.setScene(scene);
		primaryStage.show();
		}
		else
		{
			Parent root = FXMLLoader.load(getClass().getResource(url));
			Scene scene = new Scene(root);

			Stage primaryStage = new Stage();
			primaryStage.setTitle("Gestion d'un parc informatique");
			primaryStage.setResizable(false);
			primaryStage.setScene(scene);
			primaryStage.show();
		}
	}
	public static void myLoadPage(ActionEvent event, String url,int m) throws IOException{
		(new Tools2()).loadPage(event, url,m);
	}
}
