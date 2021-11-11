package domains.puzzle;

import framework.problem.Mover;
import framework.problem.Problem;
import framework.problem.State;
import java.util.List;
import org.junit.Test;
import static org.junit.Assert.*;

/**
 *
 * @author Your name here
 */
public class PuzzleProblemTest {
    
    /**
     * Declare private instance fields here. For example:
     */
    
    private final PuzzleProblem problem;
    private final Mover mover;
    private final String slide1, slide2, slide3, slide4,   // move names
                         slide5, slide6, slide7, slide8;
    
    public PuzzleProblemTest() {

        problem = new PuzzleProblem();
        mover = new PuzzleMover();
        
        slide1 = "MOVE SLIDE 1";
        slide2 = "MOVE SLIDE 2";
        slide3 = "MOVE SLIDE 3";
        slide4 = "MOVE SLIDE 4";
        slide5 = "MOVE SLIDE 5";
        slide6 = "MOVE SLIDE 6";
        slide7 = "MOVE SLIDE 7";
        slide8 = "MOVE SLIDE 8";
    }

    @Test
    public void testSolution() {

	/**
	 * Display a welcome, the problem introduction, and the initial state.
	 * Perform moves until the problem is solved, making appropriate
	 * assertions along the way.
	 * Use FarmerProblemTest as a model.
	 */
        display(problem.getIntroduction());
        display(problem.getCurrentState());
        assertFalse(problem.success());
        
        tryMove(slide6);
        assertFalse(problem.success());
        
        tryMove(slide8);
        assertFalse(problem.success());
        
        tryMove(slide2);
        assertFalse(problem.success());
        
        tryMove(slide1);
        assertFalse(problem.success());
        
        tryMove(slide8);
        assertTrue(problem.success()); 
    }
    
    private void display(Object o) {
        System.out.println(o + "\n");
    }
    
    private void tryMove(String move) {
        State next = mover.doMove(move, problem.getCurrentState());
        assertTrue(next != null);
        problem.setCurrentState(next);
        display(problem.getCurrentState());
    }
    
    
}