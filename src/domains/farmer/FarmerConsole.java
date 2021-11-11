/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

import domains.farmer.FarmerProblem;
import framework.ui.ProblemConsole;
import javafx.application.Application;
import static javafx.application.Application.launch;
import javafx.scene.Scene;
import javafx.stage.Stage;

/**
 *
 * @author Ben Marksberry
 */
public class FarmerConsole extends Application {
    
    @Override
    public void start(Stage primaryStage) {
        Scene scene = new Scene(new ProblemConsole(new FarmerProblem(), 450, 700));
        primaryStage.setTitle("Testing Farmer Console");
        primaryStage.setScene(scene);
        primaryStage.show();
    }

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        launch(args);
    }
}
