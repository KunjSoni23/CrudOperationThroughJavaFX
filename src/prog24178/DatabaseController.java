/*
 * Name : Soni Kunj Mayurkumar
 * Id : 991591881
 * Project : Assignment6
 * Performed Date : 6th August 2020
 */

package prog24178;

import java.io.File;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.Scanner;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.geometry.Orientation;
import javafx.scene.control.*;
import javafx.scene.control.Alert.AlertType;
import javafx.scene.input.MouseEvent;

public class DatabaseController  implements Config{
	
		//declaration of variables
		@FXML TextField textId, textItem, textQuantity, textPrice;
		@FXML Label labelId, labelItem, labelQuantity, labelPrice;
		@FXML Button buttonAdd, buttonModify, buttonRemove, buttonLoad, buttonSave;
		@FXML ListView<String> listView; 
				
		int index =  0; 
		private ArrayList<Item> items = new ArrayList<Item>();
		
		//to load the data from file
		@FXML
		public void ldData(ActionEvent e) {
			listView.getItems().clear();
			File f = new File(file);
			
			//try and catch method for exception handling
			try {
				Scanner lines = new Scanner(f);
				
				if(!lines.hasNextLine()) {
					Alert alert = new Alert(AlertType.INFORMATION, "Data Field is empty. Need to enter the items"); 
					alert.showAndWait();
				}
				else {
					while(lines.hasNextLine()) {
						Scanner line = new Scanner(lines.nextLine());
						line.useDelimiter(":\\s*");
						items.add((Item) new Item(line.nextInt(), line.next(), line.nextInt(), line.nextDouble()));
						line.close();
				}
			}
					
			lines.close();
			listView.setOrientation(Orientation.VERTICAL);
				
			for(Item item : items) 
				listView.getItems().add(item.toString());
			} 
			
			catch (Exception e1) {
				e1.printStackTrace();
			}
			
			buttonLoad.setDisable(true);
			System.out.println(index);
			buttonAdd.setDisable(false);
			buttonSave.setDisable(false);
		}
		
		//to save the data to the file
		@FXML
		public void svData(ActionEvent e) {
			 File f = new File(file);
			 
			//try and catch method for exception handling
			try {
				
				if(!f.exists()) f.createNewFile();
				PrintWriter printWriter = new PrintWriter(f);
				for(Item itm : items) 
					printWriter.printf("%d:%s:%d:%f\n", itm.getId(), itm.getItem(), itm.getQuantity(), itm.getPrice());
					printWriter.close();
			}
				
			catch (Exception e1) {
				e1.printStackTrace();
			}
				
			 Alert alert = new Alert(AlertType.INFORMATION, "You Successfully Saved your Data"); 
			 alert.showAndWait();					
		}

		//to select the data and carry out the task
		@FXML 
		public void sltData(MouseEvent arg) {
		   
			index = listView.getSelectionModel().getSelectedIndex();
			
			textId.setText(String.valueOf(items.get(index).getId()));
			textItem.setText(items.get(index).getItem());
			textQuantity.setText(String.valueOf(items.get(index).getQuantity()));
			textPrice.setText(String.valueOf(items.get(index).getPrice()));
			
			buttonModify.setDisable(false);
			buttonRemove.setDisable(false);		
		}
		
		//to add the item in the file
		@FXML
		public void addItm(ActionEvent e) {
			
			//index=-1;//to make sure item is not selected
			try {
				int id = Integer.parseInt(textId.getText());
				String item = textItem.getText();
				int quantity = Integer.parseInt(textQuantity.getText());
				double price = Double.parseDouble(textPrice.getText());
				
				listView.setOrientation(Orientation.VERTICAL);
				items.add(new Item(id, item, quantity, price));
				listView.getItems().clear();
				
				for(Item i : items){ 
					listView.getItems().add(i.toString());
				}
				
				textId.setText("");					
				textQuantity.setText("");
				textPrice.setText("");				
				textItem.setText("");
			}
			
			catch(Exception ex) {
				Alert alert = new Alert(AlertType.INFORMATION, "No Input; Please Try Again..!"); 
				alert.showAndWait();			
			}
		}
		
		//to modify the selected field in the database.
		@FXML
		public void modfItm(ActionEvent e) {
			
			if(listView.getSelectionModel().isSelected(index)) {
				
				int id = Integer.parseInt(textId.getText());
				String item = textItem.getText();
				double price = Double.parseDouble(textPrice.getText());
				int quantity = Integer.parseInt(textQuantity.getText());
				
				items.remove(index);
				items.add(index, new Item(id, item, quantity, price));
				listView.getItems().clear();
				
					for(Item i : items){ 
						listView.getItems().add(i.toString());
					}
						
					textId.setText("");				
					textQuantity.setText("");
					textPrice.setText("");			
					textItem.setText("");
				}
			
			else{
				Alert alert = new Alert(AlertType.INFORMATION, "Need To select atleast one Data field !!!"); 
					alert.showAndWait();
		 		}
			
		}
		
		//to remove the selected field from the file
		@FXML
		public void rmvItm(ActionEvent e) {
			
			if(index >=0 && index < items.size()) {
				items.remove(index);
				listView.getItems().clear();
				
					for(Item i : items) {
						listView.getItems().add(i.toString());
					}
					
					textId.setText("");
					textItem.setText("");
					textQuantity.setText("");
					textPrice.setText("");	
			}
			
			else{
				Alert alert = new Alert(AlertType.INFORMATION, "Need To select atleast one Data field !!!"); 
				alert.showAndWait();
			 }
			
		}
}//end of DatabaseController class
