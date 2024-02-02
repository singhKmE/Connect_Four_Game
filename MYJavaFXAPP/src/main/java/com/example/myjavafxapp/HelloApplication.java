package com.example.myjavafxapp;

import javafx.application.Application;
import javafx.application.Platform;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.Pane;
import javafx.stage.Stage;

import java.io.IOException;

public class HelloApplication extends Application {
    private  HelloController controller;
    @Override
    public void start(Stage stage) throws IOException {
        FXMLLoader fxmlLoader = new FXMLLoader(getClass().getResource("game.fxml"));
        GridPane rootGridPane=fxmlLoader.load();

        controller= fxmlLoader.getController();
        controller.CreatePlayGround();

        MenuBar menuBar=CreateMenu();
        menuBar.prefWidthProperty().bind(stage.widthProperty());

        Pane menuPane = (Pane) rootGridPane.getChildren().get(0);
        menuPane.getChildren().add(menuBar);
        Scene scene = new Scene(rootGridPane);

        stage.setScene(scene);
        stage.setTitle("Connect Four");
        stage.setResizable(false);
        stage.show();

    }

    private MenuBar CreateMenu(){
        //File Menu
        Menu fileMenu= new Menu("File");

        MenuItem newGame= new MenuItem("New Game");
        newGame.setOnAction(actionEvent -> controller.resetGame());

        MenuItem resetGame=new MenuItem("Reset Game");
        newGame.setOnAction(actionEvent -> controller.resetGame());

        SeparatorMenuItem separatorMenuItem=new SeparatorMenuItem();
        MenuItem exitGame= new MenuItem("Exit Game");
        exitGame.setOnAction(actionEvent ->ExitGame());

        fileMenu.getItems().addAll(newGame, resetGame, separatorMenuItem, exitGame );


        // Help Menu
        Menu HelpMenu= new Menu("Help");

        MenuItem AboutGame= new MenuItem("About Game");
        AboutGame.setOnAction(actionEvent -> aboutConnect4());

        SeparatorMenuItem separatorHelpItem=new SeparatorMenuItem();
        MenuItem AboutMe= new MenuItem("About Me");
        AboutMe.setOnAction(actionEvent -> aboutMe());

        HelpMenu.getItems().addAll(AboutGame, separatorHelpItem, AboutMe );


        MenuBar menuBar=new MenuBar();
        menuBar.getMenus().addAll(fileMenu, HelpMenu);

        return menuBar;
    }

    private void aboutMe() {
        Alert alert= new Alert(Alert.AlertType.INFORMATION);
        alert.setTitle("About Developer");
        alert.setHeaderText("ER. Ekta");
        alert.setContentText("I love to play around with" +
                "  code and create game. " +
                "Connect 4 is one of them. In free time " +
                "I like to spend time with nears and dears.");
        alert.show();
    }

    private void aboutConnect4() {
        Alert alert= new Alert(Alert.AlertType.INFORMATION);
        alert.setTitle("About Connect Four");
        alert.setHeaderText("How to Play?");
        alert.setContentText("Connect Four is a two-player connection" +
                " game in which the players first choose a color and " +
                "then take turns dropping colored discs from the top" +
                " into a " +
                "seven-column, six-row vertically suspended grid. " +
                "The pieces fall straight down, occupying the next " +
                "available space within the column. " +
                "The objective of the game is to be the first to" +
                " form a horizontal, vertical, or diagonal line of four of one's own discs. Connect Four is a solved game." +
                "The first player can always win by playing the right" +
                " moves.");
        alert.show();
    }



    private void ExitGame() {
        Platform.exit();
        System.exit(0);
    }

    private void resetGame() {
        Platform.exit();
        System.exit(0);
    }

    public static void main(String[] args) {
        launch();
    }
}