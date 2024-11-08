package question4;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Map;
import java.util.HashMap;
import javafx.application.Application;
import javafx.geometry.Pos;
import javafx.stage.Stage;
import javafx.scene.Scene;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;
import javafx.scene.control.TextField;
import javafx.scene.control.Label;
import javafx.scene.control.Button;
import javafx.event.Event;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.scene.control.Alert;
import javafx.scene.control.Alert.AlertType;
import javafx.scene.control.ToggleGroup;
import javafx.scene.control.RadioButton;
import javafx.scene.control.RadioButton.*;
import javafx.scene.control.ToggleButton;
import javafx.scene.control.ToggleGroup;
import javafx.collections.ObservableList;
import javafx.scene.control.TextArea;
import javafx.scene.control.TableView;
import javafx.scene.control.TableCell;
import javafx.scene.control.Cell.*;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableRow;
import javafx.scene.control.cell.MapValueFactory;
import javafx.collections.FXCollections;

public class Question4 extends Application {

    public static void main(String[] args) throws Exception {
        launch(args);
    }
    
    @Override
    public void start(Stage primaryStage) {
        Shop shop = new Shop();
        
      // Set shop name section
      Label lblShopName = new Label("Please enter the name of your shop");
      TextField tfShopName = new TextField();
      Button btnShopNameSubmit = new Button("Submit");
      Button btnShopNameCancel = new Button("Cancel");
      HBox hShopName = new HBox(btnShopNameSubmit, btnShopNameCancel);
      hShopName.setAlignment(Pos.CENTER);
      
      VBox vShopName = new VBox(lblShopName, tfShopName, hShopName);
      vShopName.setAlignment(Pos.CENTER);
      Scene scShopName = new Scene(vShopName);
      Alert alert = new Alert(AlertType.NONE);
      
      
       // Main menu section
      Label lblTitle = new Label("Management for ");
      Label lblAdd = new Label("Add");
      Label lblGenerate = new Label ("Generate Report");
      Label lblView = new Label("View");
      
      Button btnAddGame = new Button("Game");
      Button btnAddOrder = new Button("Order");
      Button btnViewGames = new Button("Available Games");
      Button btnViewOrders = new Button("Orders");
      Button btnViewSoldGames = new Button ("Sold Games");
      Button btnGenerate = new Button("Generate");
      
      VBox vAdd = new VBox(lblAdd, btnAddGame, btnAddOrder);
      vAdd.setAlignment(Pos.TOP_CENTER);
      VBox vView = new VBox(lblView, btnViewGames, btnViewOrders, btnViewSoldGames);
      vView.setAlignment(Pos.TOP_CENTER);
      VBox vGenerate = new VBox(lblGenerate, btnGenerate);
      vGenerate.setAlignment(Pos.TOP_CENTER);
      HBox hMain = new HBox(vAdd, vView, vGenerate);
      hMain.setAlignment(Pos.TOP_CENTER);
      VBox vMain = new VBox(lblTitle, hMain);
      vMain.setAlignment(Pos.TOP_CENTER);
      Scene scMain = new Scene(vMain);
      
      // Add game section
      Label lblAddGame = new Label("Add Game");
      Label lblGameName = new Label("Name");
      Label lblGamePrice = new Label("Price");
      Label lblGameCategory = new Label("Category");
      
      TextField tfGameName = new TextField();
      TextField tfGamePrice = new TextField();
      TextField tfGameCategory = new TextField();
      
      Button btnAddGameSubmit = new Button("Submit");
      Button btnGameBack = new Button("Back");
      
      VBox vGameFields = new VBox(lblGameName, lblGamePrice, lblGameCategory);
      vGameFields.setAlignment(Pos.BASELINE_LEFT);
      vGameFields.setSpacing(8);
      VBox vGameValues = new VBox(tfGameName, tfGamePrice, tfGameCategory);
      vGameValues.setAlignment(Pos.TOP_RIGHT);
      HBox hGameFields = new HBox(vGameFields, vGameValues);
      hGameFields.setSpacing(2);
      hGameFields.setAlignment(Pos.TOP_CENTER);
      HBox hGameButtons = new HBox(btnAddGameSubmit, btnGameBack);
      hGameButtons.setAlignment(Pos.BOTTOM_CENTER);
      
      VBox vAddGame = new VBox(lblAddGame, hGameFields, hGameButtons);
      vAddGame.setAlignment(Pos.TOP_CENTER);
      
      Scene scAddGame = new Scene(vAddGame);
      
      // Add order section
      Label lblAddOrder = new Label("Add Order");
      Label lblCustName = new Label("Customer Name");
      Label lblGamesBought = new Label("Game(s) Bought");
      
      TextField tfCustName = new TextField();
      VBox rgGamesBought = new VBox();
      ArrayList<RadioButton> arGamesBought = new ArrayList<>();
      
      Button btnAddOrderSubmit = new Button("Submit");
      Button btnOrderBack = new Button("Back");
      
      VBox vOrderFields = new VBox(lblCustName, lblGamesBought);
      vOrderFields.setAlignment(Pos.BASELINE_LEFT);
      vOrderFields.setSpacing(8);
      VBox vOrderValues = new VBox(tfCustName, rgGamesBought);
      vOrderValues.setAlignment(Pos.TOP_RIGHT);
      HBox hOrderFields = new HBox(vOrderFields, vOrderValues);
      hOrderFields.setAlignment(Pos.TOP_CENTER);
      hOrderFields.setSpacing(2);
      HBox hOrderButtons = new HBox(btnAddOrderSubmit, btnOrderBack);
      hOrderButtons.setAlignment(Pos.CENTER);
      
      VBox vAddOrder = new VBox(lblAddOrder,hOrderFields , hOrderButtons);
      vAddOrder.setAlignment(Pos.TOP_CENTER);
      
      Scene scAddOrder = new Scene(vAddOrder);
      
      // View games section
      Label lblViewGames = new Label("View Games");
      TableView tViewGames = new TableView();
      
      TableColumn<Map,String> cGameName = new TableColumn<>("Name");      
      cGameName.setCellValueFactory(new MapValueFactory<>("gameName"));
      tViewGames.getColumns().add(cGameName);
      
      TableColumn<Map,String> cGamePrice = new TableColumn<>("Price");
      cGamePrice.setCellValueFactory(new MapValueFactory<>("gamePrice"));
      tViewGames.getColumns().add(cGamePrice);
      
      TableColumn<Map,String> cGameCategory = new TableColumn<>("Category");
      cGameCategory.setCellValueFactory(new MapValueFactory<>("gameCategory"));
      tViewGames.getColumns().add(cGameCategory);
      ObservableList<Map<String,Object>> gItems = FXCollections.<Map<String, Object>>observableArrayList();

      Button btnViewGamesBack = new Button("Back");
      VBox vViewGames = new VBox(lblViewGames, tViewGames, btnViewGamesBack);
      vViewGames.setAlignment(Pos.CENTER);
      Scene scViewGames = new Scene(vViewGames);
      
      
      // View orders section
      Label lblViewOrders = new Label("View Orders");
      TableView tViewOrders = new TableView();
      
      TableColumn<Map,String> cOrderID = new TableColumn<>("ID");      
      cOrderID.setCellValueFactory(new MapValueFactory<>("orderID"));
      tViewOrders.getColumns().add(cOrderID);
      
      TableColumn<Map,String> cOrderCust = new TableColumn<>("Customer Name");
      cOrderCust.setCellValueFactory(new MapValueFactory<>("customerName"));
      tViewOrders.getColumns().add(cOrderCust);
      
      TableColumn<Map,String> cOrderGames = new TableColumn<>("Games Bought");
      cOrderGames.setCellValueFactory(new MapValueFactory<>("orderGames"));
      tViewOrders.getColumns().add(cOrderGames);
      
      TableColumn<Map,String> cDate = new TableColumn<>("Date");
      cDate.setCellValueFactory(new MapValueFactory<>("orderDate"));
      tViewOrders.getColumns().add(cDate);
      
      ObservableList<Map<String,Object>> cItems = FXCollections.<Map<String, Object>>observableArrayList();

      Button btnViewOrdersBack = new Button("Back");
      VBox vViewOrders = new VBox(lblViewOrders, tViewOrders, btnViewOrdersBack);
      vViewOrders.setAlignment(Pos.CENTER);
      Scene scViewOrders = new Scene(vViewOrders);
      
      // View games sold section
      Label lblViewGamesSold = new Label("View Games Sold");
      
      TableView tViewGamesSold = new TableView();
      
      TableColumn<Map,String> cGameSoldName = new TableColumn<>("Name");      
      cGameSoldName.setCellValueFactory(new MapValueFactory<>("gameSoldName"));
      tViewGamesSold.getColumns().add(cGameSoldName);
      
      TableColumn<Map,String> cGameSoldPrice = new TableColumn<>("Price");
      cGameSoldPrice.setCellValueFactory(new MapValueFactory<>("gameSoldPrice"));
      tViewGamesSold.getColumns().add(cGameSoldPrice);
      
      TableColumn<Map,String> cGameSoldCategory = new TableColumn<>("Category");
      cGameSoldCategory.setCellValueFactory(new MapValueFactory<>("gameSoldCategory"));
      tViewGamesSold.getColumns().add(cGameSoldCategory);
      
      TableColumn<Map,String> cGameSoldDate = new TableColumn<>("Date Sold");
      cGameSoldDate.setCellValueFactory(new MapValueFactory<>("gameSoldDate"));
      tViewGamesSold.getColumns().add(cGameSoldDate);
      ObservableList<Map<String,Object>> gsItems = FXCollections.<Map<String, Object>>observableArrayList();
      
      Button btnViewGamesSoldBack = new Button("Back");
      VBox vViewGamesSold = new VBox(lblViewGamesSold, tViewGamesSold, btnViewGamesSoldBack);
      vViewGamesSold.setAlignment(Pos.CENTER);
      Scene scViewGamesSold = new Scene(vViewGamesSold);
      
      // Report section
      TextArea taReport = new TextArea();
      taReport.setEditable(false);
      
      Button btnReportBack = new Button("Back");
      
      VBox vReport = new VBox(taReport, btnReportBack);
      vReport.setAlignment(Pos.CENTER);
      Scene scReport = new Scene(vReport);
      
      
      // EventHandlers and initial scene display
      btnShopNameSubmit.setOnAction(new EventHandler<ActionEvent>() {
          @Override
          public void handle(ActionEvent event) {
              if (!tfShopName.getText().isEmpty()) {
                  shop.setName(tfShopName.getText());
                  lblTitle.setText("Management for " + shop.getName());
                  primaryStage.setScene(scMain);
              }
              else {
                  alert.setAlertType(AlertType.ERROR);
                  alert.setTitle("Unable to continue");
                  alert.setHeaderText("Please enter a name for the shop");
                  alert.show();
              }
              
          }
      });
      
      btnShopNameCancel.setOnAction(new EventHandler<ActionEvent>() {
          @Override
          public void handle(ActionEvent event) {
              primaryStage.close();
          }
      });
      
      btnGameBack.setOnAction(new EventHandler<ActionEvent>() {
          @Override
          public void handle(ActionEvent event) {
              primaryStage.setScene(scMain);
          }
      });
      
      btnOrderBack.setOnAction(new EventHandler<ActionEvent>() {
          @Override
          public void handle(ActionEvent event) {
              primaryStage.setScene(scMain);
          }
      });
      
      btnAddGame.setOnAction(new EventHandler<ActionEvent>() {
          @Override
          public void handle(ActionEvent event) {
              tfGameName.clear();
              tfGamePrice.clear();
              tfGameCategory.clear();
              primaryStage.setScene(scAddGame);
          }
      });
      
      btnAddOrder.setOnAction(new EventHandler<ActionEvent>() {
          @Override
          public void handle(ActionEvent event) {
              tfCustName.clear();
              primaryStage.setScene(scAddOrder);
          }
      });
      
      btnViewGames.setOnAction(new EventHandler<ActionEvent>() {
          @Override
          public void handle(ActionEvent event) {
              gItems.clear();
              for(int i = 0; i < shop.getGames().size(); i++) {
                  Map<String, Object> gItem = new HashMap<>();
                  gItem.put("gameName", shop.getGames().get(i).getName());
                  gItem.put("gamePrice", shop.formatCurrency(shop.getGames().get(i).getPrice()));
                  gItem.put("gameCategory", shop.getGames().get(i).getCategory());
                  gItems.add(gItem);
              }              
              tViewGames.getItems().setAll(gItems);
              primaryStage.setScene(scViewGames);
          }
      });
      
      btnViewOrders.setOnAction(new EventHandler<ActionEvent>() {
          @Override
          public void handle(ActionEvent event) {
              cItems.clear();
              for (Order order : shop.getOrders()) {
                  Map<String, Object> cItem = new HashMap<>();
                  cItem.put("orderID", String.valueOf(order.getID()));
                  cItem.put("customerName", order.getCustomer());
                  cItem.put("orderGames", order.getFormattedGames());
                  cItem.put("orderDate", order.getFormattedDate());
                  cItems.add(cItem);
              }              
              tViewOrders.getItems().setAll(cItems);
              primaryStage.setScene(scViewOrders);
          }
      });
      
      btnViewSoldGames.setOnAction(new EventHandler<ActionEvent>() {
          @Override
          public void handle(ActionEvent event) {
              gsItems.clear();
              for(int i = 0; i < shop.getGamesSold().size(); i++) {
                  Map<String, Object> gsItem = new HashMap<>();
                  gsItem.put("gameSoldName", shop.getGamesSold().get(i).getName());
                  gsItem.put("gameSoldPrice", shop.formatCurrency(shop.getGamesSold().get(i).getPrice()));
                  gsItem.put("gameSoldCategory", shop.getGamesSold().get(i).getCategory());
                  gsItem.put("gameSoldDate", shop.getGamesSold().get(i).getFormattedDate());
                  gsItems.add(gsItem);
              }              
              tViewGamesSold.getItems().setAll(gsItems);
              primaryStage.setScene(scViewGamesSold);
          }
      });
      
      btnGenerate.setOnAction(new EventHandler<ActionEvent>() {
          @Override
          public void handle(ActionEvent event) {
              taReport.clear();
              taReport.setText(shop.generateReport(LocalDateTime.now()));
              primaryStage.setScene(scReport);
          }
      });
      
      btnAddGameSubmit.setOnAction(new EventHandler<ActionEvent>() {
          @Override
          public void handle(ActionEvent event) {
              String errorMessage = shop.addGame(tfGameName.getText(), tfGamePrice.getText(), tfGameCategory.getText());
              if (errorMessage == null) {
                  alert.setAlertType(AlertType.INFORMATION);
                  alert.setTitle("Game Added");
                  alert.setHeaderText("Game successfully added to the shop's stock.");
                  tfGameName.clear();
                  tfGamePrice.clear();
                  tfGameCategory.clear();
                  primaryStage.setScene(scMain);
                  rgGamesBought.getChildren().clear();
                  for (int i = 0; i < shop.getGames().size(); i++) {
                      RadioButton temp = new RadioButton(shop.getGames().get(i).getName());
                      rgGamesBought.getChildren().add(temp);
                      arGamesBought.add(temp);
                  }
                  alert.show();
              }
              else {
                  alert.setAlertType(AlertType.ERROR);
                  alert.setTitle("Failed to add Game");
                  alert.setHeaderText(errorMessage);
                  alert.show();
              }
          }
      });
      
      btnAddOrderSubmit.setOnAction(new EventHandler<ActionEvent>() {
          @Override
          public void handle(ActionEvent event) {
              LinkedList<Game> selectedGames = new LinkedList<Game>();
              LinkedList<Game> tempList = shop.getGames();
              for (int i = 0; i < arGamesBought.size(); i++) {
                  for (int j = 0; j < tempList.size(); j++) {
                      if (arGamesBought.get(i).isSelected() && arGamesBought.get(i).getText().equals(tempList.get(j).getName())) {
                          selectedGames.add(tempList.get(j));
                          break;
                      }
                  }
              }
              int selected = selectedGames.size();
              System.out.print(selected);
              String errorMessage;
              if (selected == 1) {
                  errorMessage = shop.addGameSold(selectedGames.get(0), tfCustName.getText());
              }
              else if (selected >= 1) {
                  errorMessage = shop.addGamesSold(selectedGames, tfCustName.getText());
              }
              else {
                  errorMessage = "Please select a game to add";
              }
              
              if (errorMessage == null) {
                  alert.setAlertType(AlertType.INFORMATION);
                  alert.setTitle("Order Added");
                  alert.setHeaderText("Order successfully added");
                  arGamesBought.clear();
                  rgGamesBought.getChildren().clear();
                  for (int i = 0; i < shop.getGames().size(); i++) {
                      RadioButton temp = new RadioButton(shop.getGames().get(i).getName());
                      arGamesBought.add(temp);
                      rgGamesBought.getChildren().add(temp);
                  }
                  primaryStage.setScene(scMain);
                  tfCustName.clear();
                  alert.show();
              }
              else {
                  alert.setAlertType(AlertType.ERROR);
                  alert.setTitle("Failed to add Order");
                  alert.setHeaderText(errorMessage);
                  alert.show();
              }
          }
      });
      
      btnViewGamesBack.setOnAction(new EventHandler<ActionEvent>(){
          @Override
          public void handle(ActionEvent event) {
              primaryStage.setScene(scMain);
          }
      });
      
      btnViewOrdersBack.setOnAction(new EventHandler<ActionEvent>(){
          @Override
          public void handle(ActionEvent event) {
              primaryStage.setScene(scMain);
          }
      });
      
       btnViewGamesSoldBack.setOnAction(new EventHandler<ActionEvent>(){
          @Override
          public void handle(ActionEvent event) {
              primaryStage.setScene(scMain);
          }
      });
       
       btnReportBack.setOnAction(new EventHandler<ActionEvent>(){
          @Override
          public void handle(ActionEvent event) {
              primaryStage.setScene(scMain);
          }
      });
      
      primaryStage.setScene(scShopName);
      primaryStage.show();
    }       
}
