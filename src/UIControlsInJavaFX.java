
import javafx.application.Application;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.geometry.Insets;
import javafx.scene.Scene;
import javafx.scene.control.Alert;
import javafx.scene.control.Button;
import javafx.scene.control.CheckMenuItem;
import javafx.scene.control.Label;
import javafx.scene.control.Menu;
import javafx.scene.control.MenuBar;
import javafx.scene.control.RadioButton;
import javafx.scene.control.RadioMenuItem;
import javafx.scene.control.TextField;
import javafx.scene.control.ToggleGroup;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;
import javafx.scene.paint.Color;
import javafx.scene.text.Font;
import javafx.scene.text.FontPosture;
import javafx.scene.text.FontWeight;
import javafx.stage.Stage;

public class UIControlsInJavaFX extends Application{

    VBox mainLayout;
    Scene scene;
    Menu SettingsMenu, fontStyleMenu, fontSizeMenu, colorMenu;
    Label nameLabel, ageLabel, genderLabel;
    TextField txtName,txtAge;
    RadioMenuItem rbRed, rbGreen, rbBlue, rbBlack, rb12, rb15, rb18, rb20, rb25, rb30;
    RadioButton maleRadioButton, femaleRadioButton;
    Button btnSubmit;
    ToggleGroup colorGroup, gendToggleGroup, fontSizeGroup;



    public static void main(String[] args) throws Exception {
        launch(args);
    }

    private boolean validateInput(String name, String age) {
        return !name.isEmpty() && age.matches("\\d+") && Integer.parseInt(age) >= 0;
    }
   
    @Override
    public void start(Stage primaryStage) {

        

        nameLabel = new Label("Name");
        txtName = new TextField();
        txtName.setPromptText("Name");
        ageLabel = new Label("Age");
        txtAge = new TextField();
        txtAge.setPromptText("Age");
        genderLabel = new Label("Gender");
        maleRadioButton = new RadioButton("Male");
        femaleRadioButton = new RadioButton("Female");
        btnSubmit = new Button("Submit");

        gendToggleGroup = new ToggleGroup();
        maleRadioButton.setToggleGroup(gendToggleGroup);
        femaleRadioButton.setToggleGroup(gendToggleGroup);
        
        GridPane gridPane = new GridPane();
        gridPane.setPadding(new Insets(20));
        gridPane.setHgap(10);
        gridPane.setVgap(10);
        gridPane.add(nameLabel, 0, 0);
        gridPane.add(txtName, 1, 0);
        gridPane.add(ageLabel, 0, 1);
        gridPane.add(txtAge, 1, 1);
        gridPane.add(genderLabel, 0, 2);
        HBox genderBox = new HBox(10, maleRadioButton, femaleRadioButton);
        gridPane.add(genderBox, 1, 2);
        gridPane.add(btnSubmit, 1, 3);

       
        SettingsMenu = new Menu("Settings");

        //Font Menu with subMenu Using ChecckBox
        fontStyleMenu = new Menu("Font Style");
        Font fontBoldItalic = Font.font("Times New Roman", FontWeight.BOLD, FontPosture.ITALIC, 15);
        Font fontBold = Font.font("Times New Roman", FontWeight.BOLD, FontPosture.REGULAR, 15);
        Font fontItalic = Font.font("Times New Roman", FontWeight.NORMAL, FontPosture.ITALIC, 15);
        Font fontNormal = Font.font("Times New Roman", FontWeight.NORMAL, FontPosture.REGULAR, 15);
        CheckMenuItem chkBold = new CheckMenuItem("Bold");
        CheckMenuItem chkItalic = new CheckMenuItem("Italic");
       
        EventHandler<ActionEvent> handler = e -> { 
            if (chkBold.isSelected() && chkItalic.isSelected()) {
              nameLabel.setFont(fontBoldItalic); 
              ageLabel.setFont(fontBoldItalic);
              genderLabel.setFont(fontBoldItalic);
              btnSubmit.setFont(fontBoldItalic);
            }
            else if (chkBold.isSelected()) {
              nameLabel.setFont(fontBold);
              ageLabel.setFont(fontBold); 
              genderLabel.setFont(fontBold);
              btnSubmit.setFont(fontBold);
            }
            else if (chkItalic.isSelected()) {
              nameLabel.setFont(fontItalic); 
              ageLabel.setFont(fontItalic);
              genderLabel.setFont(fontItalic);
              btnSubmit.setFont(fontItalic);

            }      
            else {
              nameLabel.setFont(fontNormal); 
              ageLabel.setFont(fontNormal);
              genderLabel.setFont(fontNormal);
              btnSubmit.setFont(fontNormal);

            }
        };
          
        chkBold.setOnAction(handler);
        chkItalic.setOnAction(handler);

        fontStyleMenu.getItems().addAll(chkBold, chkItalic);

        //Font Size with subMenu Using RadioButton
        fontSizeMenu = new Menu("Font Size");
        Font font12 = Font.font("Times New Roman", FontWeight.NORMAL, FontPosture.REGULAR, 12);
        Font font15 = Font.font("Times New Roman", FontWeight.NORMAL, FontPosture.REGULAR, 15);
        Font font18 = Font.font("Times New Roman", FontWeight.NORMAL, FontPosture.REGULAR, 18);
        Font font20 = Font.font("Times New Roman", FontWeight.NORMAL, FontPosture.REGULAR, 20);
        Font font25 = Font.font("Times New Roman", FontWeight.NORMAL, FontPosture.REGULAR, 25);
        Font font30 = Font.font("Times New Roman", FontWeight.NORMAL, FontPosture.REGULAR, 30);

        fontSizeGroup = new ToggleGroup();
        rb12 = new RadioMenuItem("12");
        rb12.setToggleGroup(fontSizeGroup);
        rb15 = new RadioMenuItem("15");
        rb15.setToggleGroup(fontSizeGroup);
        rb18 = new RadioMenuItem("18");
        rb18.setToggleGroup(fontSizeGroup);
        rb20 = new RadioMenuItem("20");
        rb20.setToggleGroup(fontSizeGroup);
        rb25 = new RadioMenuItem("25");
        rb25.setToggleGroup(fontSizeGroup);
        rb30 = new RadioMenuItem("30");
        rb30.setToggleGroup(fontSizeGroup);
        rb12.setOnAction(e -> {
            if (rb12.isSelected()) {
                nameLabel.setFont(font12);
                ageLabel.setFont(font12);
                genderLabel.setFont(font12);
                maleRadioButton.setFont(font12);
                femaleRadioButton.setFont(font12);
                btnSubmit.setFont(font12);
            }
        });
        rb15.setOnAction(e -> {
            if (rb15.isSelected()) {
                nameLabel.setFont(font15);
                ageLabel.setFont(font15);
                genderLabel.setFont(font15);
                maleRadioButton.setFont(font15);
                femaleRadioButton.setFont(font15);
                btnSubmit.setFont(font15);
            }
        });
        rb18.setOnAction(e -> {
            if (rb18.isSelected()) {
                nameLabel.setFont(font18);
                ageLabel.setFont(font18);
                genderLabel.setFont(font18);
                maleRadioButton.setFont(font18);
                femaleRadioButton.setFont(font18);
                btnSubmit.setFont(font18);
            }
        });
        rb20.setOnAction(e -> {
            if (rb20.isSelected()) {
                nameLabel.setFont(font20);
                ageLabel.setFont(font20);
                genderLabel.setFont(font20);
                maleRadioButton.setFont(font20);
                femaleRadioButton.setFont(font20);
                btnSubmit.setFont(font20);
            }
        });
        rb25.setOnAction(e -> {
            if (rb25.isSelected()) {
                nameLabel.setFont(font25);
                ageLabel.setFont(font25);
                genderLabel.setFont(font25);
                maleRadioButton.setFont(font25);
                femaleRadioButton.setFont(font25);
                btnSubmit.setFont(font25);
            }
        });
        rb30.setOnAction(e -> {
            if (rb30.isSelected()) {
                nameLabel.setFont(font30);
                ageLabel.setFont(font30);
                genderLabel.setFont(font30);
                maleRadioButton.setFont(font30);
                femaleRadioButton.setFont(font30);
                btnSubmit.setFont(font30);
            }
        });
        fontSizeMenu.getItems().addAll(rb12, rb15, rb18, rb20, rb25, rb30);      
        

        //Text Color with subMenu Using RadioButton
        colorMenu = new Menu("Color");
        colorGroup = new ToggleGroup();
        rbRed = new RadioMenuItem("Red");
        rbRed.setToggleGroup(colorGroup);
        rbGreen = new RadioMenuItem("Green");
        rbGreen.setToggleGroup(colorGroup);
        rbBlue = new RadioMenuItem("Blue");
        rbBlue.setToggleGroup(colorGroup);
        rbBlack = new RadioMenuItem("Black");
        rbBlack.setToggleGroup(colorGroup);       
        rbRed.setOnAction(e -> {
            if(rbRed.isSelected()){
                nameLabel.setTextFill(Color.RED);
                ageLabel.setTextFill(Color.RED);
                genderLabel.setTextFill(Color.RED);
                btnSubmit.setTextFill(Color.RED);
                maleRadioButton.setTextFill(Color.RED);
                femaleRadioButton.setTextFill(Color.RED);
            }
        });
        rbGreen.setOnAction(e -> {
            if(rbGreen.isSelected()){
                nameLabel.setTextFill(Color.GREEN);
                ageLabel.setTextFill(Color.GREEN);
                genderLabel.setTextFill(Color.GREEN);
                btnSubmit.setTextFill(Color.GREEN);
                maleRadioButton.setTextFill(Color.GREEN);
                femaleRadioButton.setTextFill(Color.GREEN);
            }
        });
        rbBlue.setOnAction(e -> {
            if (rbBlue.isSelected()) {
                nameLabel.setTextFill(Color.BLUE);
                ageLabel.setTextFill(Color.BLUE);
                genderLabel.setTextFill(Color.BLUE);
                btnSubmit.setTextFill(Color.BLUE);
                maleRadioButton.setTextFill(Color.BLUE);
                femaleRadioButton.setTextFill(Color.BLUE);
            }
        });
        rbBlack.setOnAction(e -> {
            if (rbBlack.isSelected()) {
                nameLabel.setTextFill(Color.BLACK);
                ageLabel.setTextFill(Color.BLACK);
                genderLabel.setTextFill(Color.BLACK);
                btnSubmit.setTextFill(Color.BLACK);
                maleRadioButton.setTextFill(Color.BLACK);
                femaleRadioButton.setTextFill(Color.BLACK);
            }
        });
        colorMenu.getItems().addAll(rbRed, rbGreen, rbBlue, rbBlack);

        SettingsMenu.getItems().addAll(fontStyleMenu, fontSizeMenu, colorMenu);

        MenuBar menuBar = new MenuBar();
        menuBar.getMenus().add(SettingsMenu);

        btnSubmit.setOnAction(event -> {
            String name = txtName.getText();
            String age = txtAge.getText();
            String gender = "";
            if (maleRadioButton.isSelected()) {
                gender = "Male";
            } else if (femaleRadioButton.isSelected()) {
                gender = "Female";
            }

            if (validateInput(name, age)) {
                Alert successAlert = new Alert(Alert.AlertType.CONFIRMATION);
                successAlert.setTitle("Success!");
                successAlert.setHeaderText(null);
                successAlert.setContentText("Your details have been saved successfully.\n" 
                +"You can now close this window to continue using the application. \n"
                +"Thank you for your time!\n\n"
                +"\nName: " + name
                +"\nAge : " + age 
                +"\nGender: " + gender
                );
                successAlert.showAndWait();
                System.out.println("Name: " + name);
                System.out.println("Age: " + age);
                System.out.println("Gender: " + gender);
            } else {
                Alert alert = new Alert(Alert.AlertType.ERROR);
                alert.setTitle("Validation Error");
                alert.setHeaderText(null);
                alert.setContentText("Please enter a valid name and age.");
                alert.showAndWait();
            }
        });

        BorderPane layout = new BorderPane();
        layout.setTop(menuBar);
        layout.setCenter(gridPane);

        // mainLayout = new VBox();
        // mainLayout.setPadding(new Insets(10));
        // mainLayout.setAlignment(Pos.CENTER);
        // mainLayout.getChildren().addAll(topMenu, gridPane);
        
        scene = new Scene(layout, 500, 700);
        primaryStage.setScene(scene);
        primaryStage.setTitle("UI Controls In JavaFX");
        primaryStage.show();
        
    }
}
