package framework.ui;

import domains.arithmetic.ArithmeticProblem;
import domains.dummy.DummyProblem;
import domains.farmer.FarmerProblem;
import domains.puzzle.PuzzleProblem;
import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.control.Tab;
import javafx.scene.control.TabPane;
import javafx.stage.Stage;

/**
 * This class presents problem solving domains in a tabbed pane.
 */
public class ProblemApplication extends Application {
    
    @Override
    public void start(Stage primaryStage) {
        TabPane tabPane = new TabPane();
        
	/* Add tabs using the following */
        
	Tab tabDummy = new Tab();
        tabDummy.setText("Dummy");
        tabDummy.setContent(new ProblemGUI(new DummyProblem(), 750, 750));
        tabPane.getTabs().add(tabDummy);
        
        Tab tabArithmetic = new Tab();
        tabArithmetic.setText("Arithmetic");
        tabArithmetic.setContent(new ProblemGUI(new ArithmeticProblem(), 750, 750));
        tabPane.getTabs().add(tabArithmetic);

        Tab tabFarmer = new Tab();
        tabFarmer.setText("Farmer");
        tabFarmer.setContent(new ProblemGUI(new FarmerProblem(), 750, 750));
        tabPane.getTabs().add(tabFarmer);
        
        Tab tabPuzzle = new Tab();
        tabPuzzle.setText("Puzzle");
        tabPuzzle.setContent(new ProblemGUI(new PuzzleProblem(), 750, 750));
        tabPane.getTabs().add(tabPuzzle);
        
	//... 
        
        Scene scene = new Scene(tabPane);
        primaryStage.setTitle("Problem Solver");
        primaryStage.setScene(scene);
        primaryStage.show();
    }

    public static void main(String[] args) {
        launch(args);
    }
}