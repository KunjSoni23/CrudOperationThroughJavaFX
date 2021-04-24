/*
 * Name : Soni Kunj Mayurkumar
 * Id : 991591881
 * Project : Assignment6
 * Performed Date : 6th August 2020
 */

package prog24178;

import java.io.File;
import java.net.URL;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;

public class RunApp extends javafx.application.Application implements Config{
	
	//Override the start method in the Application class
	@Override
	public void start(Stage primaryStage) throws Exception {
		URL res = this.getClass().getResource("interface.fxml");
		Parent scene = FXMLLoader.load(res);
		
		File fi = new File(file);
		if(!fi.exists()) fi.createNewFile();
		
		Scene ns = new Scene(scene);
		primaryStage.setScene(ns);
		primaryStage.setTitle("Items Database");
		
		primaryStage.show();
	}

	//main method to run the application
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		launch(args);
	}//end of main method
	
}//end of RunApp class