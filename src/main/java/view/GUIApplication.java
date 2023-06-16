package view;

import javafx.application.Application;


import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.stage.Stage;

import static javafx.application.Platform.exit;

public class GUIApplication extends Application {

    @Override
    public void start(Stage stage) throws Exception {

        FXMLLoader fxmlLoader = new FXMLLoader(GUIApplication.class.getResource("login.fxml"));
        Scene scene = new Scene(fxmlLoader.load(), 1250,650);
        stage.setScene(scene);
        stage.setTitle("MyShelfie");
        //stage.setMaximized(true);
        LoginController controller=fxmlLoader.getController();
        GUI gui=new GUI();
        stage.setOnHidden(event->exit());
        gui.setLoginController(controller);
        controller.setScene(gui,stage);
        gui.startGame();


        FXMLLoader fxmlLoader1 = new FXMLLoader(GUIApplication.class.getResource("chat.fxml"));
        Stage stage1=new Stage();
        Scene scene1 = new Scene(fxmlLoader1.load(), 250,300);
        stage1.setScene(scene1);
        stage1.setTitle("Chat");
        ChatController chatController= fxmlLoader1.getController();
        gui.setChatController(chatController);

        gui.setChatStage(stage1);
    }
    public static void main(String[] args) {

        launch();

    }

}