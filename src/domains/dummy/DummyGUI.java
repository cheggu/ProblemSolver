/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package domains.dummy;

import framework.ui.ProblemGUI;
import javafx.application.Application;
import static javafx.application.Application.launch;
import javafx.scene.Scene;
import javafx.stage.Stage;

/**
 *
 * @author benja
 */
public class DummyGUI extends Application {

    @Override
    public void start(Stage primaryStage) {
        Scene scene = new Scene(new ProblemGUI(new DummyProblem(), 750, 750));
	primaryStage.setTitle("Testing Puzzle GUI");
	primaryStage.setScene(scene);

	primaryStage.show();
    }

    public static void main(String[] args) {
	launch(args);
    }
}
