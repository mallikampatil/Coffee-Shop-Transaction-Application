/* 
 * Author: Mallika Patil
 * NetID: mpatil5
 * UIN: 660213398
 * Description: Create a JavaFX program, utilizing the decorator design
 * pattern included, that provides the user interface to make coffee orders and display
 * them.
 * 
 */
import java.awt.Font;
import java.awt.Label;

import javafx.application.Application;
import javafx.application.Platform;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.HBox;
import javafx.scene.layout.StackPane;
import javafx.scene.layout.VBox;
import javafx.scene.text.Text;
import javafx.scene.text.TextAlignment;
import javafx.stage.Stage;
import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.control.TextField;
import javafx.scene.layout.HBox;
import javafx.scene.layout.Priority;
import javafx.scene.paint.Color;
import javafx.stage.Stage;
import java.util.HashMap;
import java.util.Iterator;
import java.util.function.Function;
import javafx.animation.PauseTransition;
import javafx.application.Application;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.geometry.Insets;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.ListView;
import javafx.scene.control.TextField;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.input.KeyCode;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;
import javafx.util.Duration;

public class CoffeeShop extends Application {

	/* Coffee Order */ 
	Coffee order = new BasicCoffee();
    double cost = 0; 
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		launch(args);
	}

	//feel free to remove the starter code from this method
	@Override
	public void start(Stage primaryStage) throws Exception {
		// TODO Auto-generated method stub
		primaryStage.setTitle("Circle House Coffee");
        BorderPane CoffeeOrderLayout = new BorderPane();
		
		/* Images */ 
		Image bigLogo = new Image("coffee-shop-logo.png", 300, 300, true, true);
		Image smallLogo = new Image("coffee-shop-logo.png", 50, 50, true, true);
		Image cream = new Image("cream.png", 25, 25, true, true);
		Image sugar = new Image("sugar.png", 25, 25, true, true);
		Image shot = new Image("shot.png", 25, 25, true, true);
		Image milk = new Image("milk.png", 25, 25, true, true);
		Image syrup = new Image("syrup.png", 25, 25, true, true);
		Image coffee = new Image("coffee-icon.png", 25, 25, true, true);
		Image plus = new Image("plus.png", 25, 25, true, true);
		Image redo = new Image("redo.png", 25, 25, true, true);
		Image delete = new Image("delete.png", 25, 25, true, true);
		Image check = new Image("check.png", 25, 25, true, true);
		Image back = new Image("back.png", 25, 25, true, true);
		
		/* Buttons */ 
		Button Start = new Button("Place an Order");
		Start.setGraphic(new ImageView(coffee));
		Start.setPadding(new Insets(10, 10, 10, 10));
		
		Button Cream = new Button("Add Cream");
		Cream.setGraphic(new ImageView(cream));
		Cream.setMaxSize(500, 50);
		
		Button Sugar = new Button("Add Sugar");
		Sugar.setGraphic(new ImageView(sugar));
		Sugar.setMaxSize(500, 50);
		
		Button Shot = new Button("Add Shot");
		Shot.setGraphic(new ImageView(shot));
		Shot.setMaxSize(500, 50);
		
		Button Milk = new Button("Add Nut Milk");
		Milk.setGraphic(new ImageView(milk));
		Milk.setMaxSize(500, 50);
		
		Button Syrup = new Button("Add Syrup");
		Syrup.setGraphic(new ImageView(syrup));
		Syrup.setMaxSize(500, 50);
		
		Button Complete = new Button("Complete");
		Complete.setGraphic(new ImageView(check));
		Complete.setPadding(new Insets(10, 10, 10, 10));
		
		Button Restart = new Button("Restart");
		Restart.setGraphic(new ImageView(redo));
		Restart.setPadding(new Insets(10, 10, 10, 10));
		
		Button New = new Button("New");
		New.setGraphic(new ImageView(plus));
		New.setVisible(false); 
		New.setPadding(new Insets(10, 10, 10, 10));
		
		Button Exit = new Button(""); 
		Exit.setGraphic(new ImageView(delete));
		Exit.setPadding(new Insets(10, 10, 10, 10));
		Exit.setOnAction(e -> Platform.exit());
		
		Button ExitStart = new Button("Exit Application"); 
		ExitStart.setGraphic(new ImageView(delete));
		ExitStart.setPadding(new Insets(10, 10, 10, 10));
		ExitStart.setOnAction(e -> Platform.exit());
		
		Button Back = new Button(""); 
		Back.setGraphic(new ImageView(back));
		Back.setPadding(new Insets(10, 10, 10, 10));
		ExitStart.setOnAction(e -> Platform.exit());
		
		
		// Scene 1: Press Place an Order 
		StackPane title = new StackPane(); 
		title.getChildren().addAll(new ImageView(bigLogo));
		VBox StartOptions = new VBox(title, Start, ExitStart); 
		StartOptions.setPadding(new Insets(15, 12, 15, 12));
		StartOptions.setSpacing(10);
		StartOptions.setStyle("-fx-background-color: #ede0d4");
		StartOptions.setAlignment(Pos.BASELINE_CENTER);
		
		Scene scene1 = new Scene(StartOptions, 425, 600);

		// Scene 2: Build Your Order
		/* Coffee Additions Options */
		VBox CoffeeAdditions = new VBox(); 
		CoffeeAdditions.setPadding(new Insets(10)); 
		CoffeeAdditions.setSpacing(8); 
		Button additionsOptions[] = new Button[] {
			Cream, 
			Sugar, 
			Shot, 
			Milk, 
			Syrup
		}; 
		for (int i=0; i<5; i++) {
			CoffeeAdditions.setMargin(additionsOptions[i], new Insets(0, 0, 0, 8));
			CoffeeAdditions.getChildren().add(additionsOptions[i]);
		}
		

		/* List Additions Selected */ 
		ListView CoffeeList = new ListView();
		Text Summary = new Text("Order Summary: "); 
		VBox List = new VBox(Summary, CoffeeList);
		CoffeeList.getItems().add("Black Coffee: $3.99");
		
		/* Coffee Additions Options On Click */
		Cream.setOnAction( new EventHandler<ActionEvent>() {
			public void handle(ActionEvent event) {
				order = new Cream(order);
				CoffeeList.getItems().add("+ cream: $.50");
			}
		});
		
		Sugar.setOnAction( new EventHandler<ActionEvent>() {
			public void handle(ActionEvent event) {
				order = new Sugar(order); 
				CoffeeList.getItems().add("+ sugar: $.50");
			}
		});
		
		Shot.setOnAction( new EventHandler<ActionEvent>() {
			public void handle(ActionEvent event) {
				order = new ExtraShot(order); 
				CoffeeList.getItems().add("+ extra shot: $1.20");
			}
		});
		
		Milk.setOnAction( new EventHandler<ActionEvent>() {
			public void handle(ActionEvent event) {
				order = new NutMilk(order); 
				CoffeeList.getItems().add("+ nut milk: $.60");
			}
		});
		
		Syrup.setOnAction( new EventHandler<ActionEvent>() {
			public void handle(ActionEvent event) {
				order = new FlavorSyrup(order); 
				CoffeeList.getItems().add("+ flavor syrup: $.70");
			}
		});
		
		
		/* Order Options */
		HBox Header = new HBox(); 
		Header.setPadding(new Insets(15, 12, 15, 12));
		Header.setSpacing(10);
		Header.setStyle("-fx-background-color: #6faba8;");
		Header.getChildren().addAll(new ImageView(smallLogo), New, Restart, Complete, Exit);
		

		/* Display Total */ 
		HBox TotalDisplay = new HBox(); 
		TotalDisplay.setPadding(new Insets(20, 12, 20, 12));
		TotalDisplay.setSpacing(300);
		TotalDisplay.setStyle("-fx-background-color: #BF7465;");
		Text Total = new Text("Total: $" + cost);
		TotalDisplay.getChildren().clear(); 
		TotalDisplay.getChildren().addAll(Back, Total);
		TotalDisplay.setAlignment(Pos.CENTER);
		
		Complete.setOnAction( new EventHandler<ActionEvent>() {
			public void handle(ActionEvent event) {
				/* Update Order */
				cost = order.makeCoffee(); 
				cost = (double) Math.round(cost * 100) / 100; 
				/* Display Calculated Total */
				Text Total = new Text("Total: $" + cost);
				System.out.println("Total: $" + cost);
				TotalDisplay.getChildren().clear(); 
				TotalDisplay.getChildren().addAll(Back, Total);
				TotalDisplay.setAlignment(Pos.CENTER);
				
				/* Display New Order Options */
				New.setVisible(true); 
				Restart.setVisible(true); 
				Cream.setDisable(true); 
				Sugar.setDisable(true);
				Shot.setDisable(true);
				Milk.setDisable(true);
				Syrup.setDisable(true);
				Complete.setDisable(true);
			}
		});
		
		New.setOnAction( new EventHandler<ActionEvent>() {
			public void handle(ActionEvent event) {
				/* Update Order */
				CoffeeList.getItems().add("Total: $" + cost);
				order = new BasicCoffee(); 
				/* Display Calculated Total */
				cost = 0; 
				Text Total = new Text("Total: $" + cost);
				TotalDisplay.getChildren().clear(); 
				TotalDisplay.getChildren().addAll(Back, Total);
				TotalDisplay.setAlignment(Pos.CENTER);
				
				/* Display New Order */
				New.setVisible(false); 
				Restart.setVisible(true);
				Cream.setDisable(false); 
				Sugar.setDisable(false);
				Shot.setDisable(false);
				Milk.setDisable(false);
				Syrup.setDisable(false);
				Complete.setDisable(false);
				
				CoffeeList.getItems().add("Black Coffee: $3.99");
			}
		});
		
		Restart.setOnAction( new EventHandler<ActionEvent>() {
			public void handle(ActionEvent event) {
				/* Update Order */
				order = new BasicCoffee(); 
				CoffeeList.getItems().clear(); 
				
				/* Display Calculated Total */
				cost = 0; 
				Text Total = new Text("Total: $" + cost);
				TotalDisplay.getChildren().clear(); 
				TotalDisplay.getChildren().addAll(Back, Total);
				TotalDisplay.setAlignment(Pos.CENTER);
				
				/* Display New Order */
				Cream.setDisable(false); 
				Sugar.setDisable(false);
				Shot.setDisable(false);
				Milk.setDisable(false);
				Syrup.setDisable(false);
				Complete.setDisable(false);
				CoffeeList.getItems().add("Black Coffee: $3.99");
			}
		});
		
		CoffeeOrderLayout.setLeft(CoffeeAdditions);
		CoffeeOrderLayout.setTop(Header);
		CoffeeOrderLayout.setCenter(List);
		CoffeeOrderLayout.setBottom(TotalDisplay);
		CoffeeOrderLayout.setStyle("-fx-background-color: #ede0d4");
		Scene scene2 = new Scene(CoffeeOrderLayout,425,600);
		Back.setOnAction(e -> primaryStage.setScene(scene1));
		Start.setOnAction(e -> primaryStage.setScene(scene2));
		
		primaryStage.setScene(scene1);
		primaryStage.show();
		
		
	}
}
