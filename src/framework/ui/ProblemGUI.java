/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package framework.ui;
import framework.problem.Mover;
import framework.problem.Problem;
import framework.problem.State;
import framework.solution.SolvingAssistant;
import static java.awt.SystemColor.control;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.layout.Border;
import javafx.scene.layout.BorderStroke;
import javafx.scene.layout.BorderStrokeStyle;
import javafx.scene.layout.BorderWidths;
import javafx.scene.layout.CornerRadii;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;
import javafx.scene.paint.Color;
import javafx.scene.paint.Paint;
import javafx.scene.text.Font;
import javafx.scene.text.FontPosture;
import javafx.scene.text.FontWeight;
/**
 *
 * @author benja
 */
public class ProblemGUI extends VBox{
    
    private int moveCount;
    private Label numMoves;
    private Label curState;
    private Label finState;
    private Label problemSolved;
    private SolvingAssistant solver;
    
    /*
    Constructor for ProblemGUI, does 3 main things:
    1: Creates labels, boxes and buttons
    2: Formats the labels, boxes, and buttons; font, color, size, button handling, etc
    3: Adds the elements to the main screen
    */
    public ProblemGUI(Problem problem, double width, double height)
    {
        setSolver(problem);
        Label welcomeMessage = new Label(problem.getName());
        Label introduction = new Label(problem.getIntroduction());
        Label curStateLbl = new Label("\nCurrent State:\n");
        curState = new Label(problem.getCurrentState().toString());
        Label finStateLbl = new Label("\nGoal State\n");
        finState = new Label(problem.getFinalState().toString());
        numMoves = new Label("\nMoves (" + solver.getMoveCount() + " moves so far)\n");
        problemSolved = new Label("You solved the problem. Congratulations!");
        Button btnReset = new Button("Reset");
        btnReset.setOnAction(e -> reset(problem));
        
        List<Button> btnList = new ArrayList<>();
        problem.getMover().getMoveNames().forEach((move) -> {
            btnList.add(new Button(move));
        });
        
        welcomeMessage.setFont(Font.font("Monospaced", FontWeight.BOLD, 20 ));
        introduction.setFont(Font.font("Monospaced", 12));
        curState.setFont(Font.font("Monospaced", 20));
        curStateLbl.setFont(Font.font("Monospaced", FontWeight.BOLD, 20 ));
        finState.setFont(Font.font("Monospaced", 20));
        finStateLbl.setFont(Font.font("Monospaced", FontWeight.BOLD, 20 ));
        numMoves.setFont(Font.font("Monospaced", FontWeight.BOLD, 15 ));
        problemSolved.setFont(Font.font("Monospaced", FontWeight.BOLD, 15 ));
        problemSolved.setTextFill(Color.RED);
        
        welcomeMessage.setWrapText(true);
        introduction.setWrapText(true);
        curState.setWrapText(true);
        curStateLbl.setWrapText(true);
        finState.setWrapText(true);
        finStateLbl.setWrapText(true);
        numMoves.setWrapText(true);
        problemSolved.setWrapText(true);
        
        welcomeMessage.setAlignment(Pos.TOP_CENTER);
        introduction.setAlignment(Pos.TOP_CENTER);
        curState.setAlignment(Pos.TOP_CENTER);
        curStateLbl.setAlignment(Pos.TOP_CENTER);
        finState.setAlignment(Pos.TOP_CENTER);
        finStateLbl.setAlignment(Pos.TOP_CENTER);
        numMoves.setAlignment(Pos.TOP_CENTER);
        problemSolved.setAlignment(Pos.TOP_CENTER);
        
        curState.setBorder(new Border(new BorderStroke(Color.BLACK, BorderStrokeStyle.SOLID, CornerRadii.EMPTY, new BorderWidths(2,2,2,2))));
        curState.setPadding(new Insets(20, 20, 20, 20));
        finState.setBorder(new Border(new BorderStroke(Color.BLACK, BorderStrokeStyle.SOLID, CornerRadii.EMPTY, new BorderWidths(2,2,2,2))));
        finState.setPadding(new Insets(20, 20, 20, 20));
        
        HBox hbox = new HBox();
        VBox currentState = new VBox();
        VBox buttons = new VBox();
        VBox finalState = new VBox();
        
        currentState.setAlignment(Pos.TOP_CENTER);
        buttons.setAlignment(Pos.TOP_CENTER);
        finalState.setAlignment(Pos.TOP_CENTER);
        
        currentState.getChildren().addAll(curStateLbl,
                                            curState);
        
        buttons.setSpacing(10);
        buttons.getChildren().add(numMoves);
        btnList.forEach((btn) -> {
            btn.setPadding(new Insets(7, 10, 7, 10));
            btn.setFont(Font.font("Monospaced"));
            btn.setAlignment(Pos.CENTER);
            btn.setOnAction(e -> input(btn.getText(), problem)); //
            buttons.getChildren().add(btn);
        });
        
        finalState.getChildren().addAll(finStateLbl,
                                            finState);
        
        hbox.getChildren().addAll(currentState,
                                  buttons,
                                  finalState);
        
        hbox.setSpacing(5);
        hbox.setMaxWidth(Double.MAX_VALUE);
        hbox.setAlignment(Pos.TOP_CENTER);
        
        VBox vbox = new VBox();   
        vbox.getChildren().addAll(welcomeMessage, 
                                  introduction, 
                                  hbox, 
                                  problemSolved,
                                  btnReset);
        
        problemSolved.setVisible(false);
        
        vbox.setAlignment(Pos.CENTER);
        vbox.setPadding(new Insets(30, 30, 30, 30));
        vbox.setMaxHeight(Double.MAX_VALUE);
        vbox.setMaxWidth(width);
        vbox.autosize();
        
        super.getChildren().add(vbox);

    }
    
    private void setSolver(Problem p)
    {
        solver = new SolvingAssistant(p);
    }
    
    /*
    Button handler for resetting the game
    */
    private void reset(Problem p)
    {
        numMoves.setText("\nMoves (" + 0 + " moves so far)\n");
        p.setCurrentState(p.getInitialState());
        solver = new SolvingAssistant(p);
        curState.setText(solver.getProblem().getCurrentState().toString());
        problemSolved.setVisible(false);
    }
    
    /*
    Handles input for the buttons, takes in the string value of the button
    and a handle to the problem.
    */
    private void input(String move, Problem problem)
    {
        solver.tryMove(move);
        
        moveCount = solver.getMoveCount();
        //System.out.print("\n" + move + "\n" + solver.getProblem().getCurrentState());
        curState.setText(solver.getProblem().getCurrentState().toString());
        numMoves.setText("\nMoves (" + moveCount + " moves so far)\n");
        if (solver.getProblem().getCurrentState().equals(problem.getFinalState()))
        {
             problemSolved.setVisible(true);
        }
    }
    
}
