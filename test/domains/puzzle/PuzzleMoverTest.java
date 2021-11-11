package domains.puzzle;

import framework.problem.Mover;
import framework.problem.State;
import java.util.List;
import org.junit.Test;
import static org.junit.Assert.*;

/**
 *
 * @author Your name here
 */
public class PuzzleMoverTest {
        
    /**
     * Declare private instance fields here. For example:
     */
    
    private final State start;
    private final Mover mover;
    private final String slide1, slide2, slide3, slide4,  // move names
	                 slide5, slide6, slide7, slide8;
    
    public PuzzleMoverTest() {
        int[] row1 = { 2, 8, 3 };
        int[] row2 = { 1, 6, 4 };
        int[] row3 = { 7, 0, 5 };
        
        int[][] rows = { row1, row2, row3 };
        
        mover = new PuzzleMover();
        start = new PuzzleState(rows);
        
        slide1 = "MOVE SLIDE 1";
        slide2 = "MOVE SLIDE 2";
        slide3 = "MOVE SLIDE 3";
        slide4 = "MOVE SLIDE 4";
        slide5 = "MOVE SLIDE 5";
        slide6 = "MOVE SLIDE 6";
        slide7 = "MOVE SLIDE 7";
        slide8 = "MOVE SLIDE 8";
    }
    
    /**
     * Test all moves in the methods below by replacing the calls to fail.
     */

    @Test
    public void testSlide1() {
        //Test if the tile cannot be moved across the same row.
        
        int[] row1 = { 2, 8, 3 };
        int[] row2 = { 7, 5, 4 };
        int[] row3 = { 1, 6, 0 };
        
        int[][] rows = { row1, row2, row3 };
        
        
        moveSlideTileIllegal(slide1, rows);
        
        //Test if the tile cannot be moved across different rows.

        row1 = new int[] { 2, 8, 3 };
        row2 = new int[] { 1, 6, 4 };
        row3 = new int[] { 7, 0, 5 };
        
        rows = new int[][] { row1, row2, row3 };
        
        moveSlideTileIllegal(slide1, rows);
        
        //test if the tile CAN be moved across the same row.
        
        row1 = new int[] {0, 1, 3};
        row2 = new int[] {2, 6, 4};
        row3 = new int[] {7, 8, 5};
        
        rows = new int[][] { row1, row2, row3 };
        
        moveSlideTileLegal(slide1, rows);
        
        //Test if the tile CAN be moved across different rows.
        
        row1 = new int[] {6, 1, 3};
        row2 = new int[] {2, 0, 4};
        row3 = new int[] {7, 8, 5};
        
        rows = new int[][] { row1, row2, row3 };
        
        moveSlideTileLegal(slide1, rows);
    }

    @Test
    public void testSlide2() {
        //Test if the tile cannot be moved across the same row.
        
        int[] row1 = { 1, 8, 3 };
        int[] row2 = { 7, 5, 4 };
        int[] row3 = { 2, 6, 0 };
        
        int[][] rows = { row1, row2, row3 };
        
        
        moveSlideTileIllegal(slide2, rows);
        
        //Test if the tile cannot be moved across different rows.

        row1 = new int[] { 1, 8, 3 };
        row2 = new int[] { 2, 6, 4 };
        row3 = new int[] { 7, 0, 5 };
        
        rows = new int[][] { row1, row2, row3 };
        
        moveSlideTileIllegal(slide2, rows);
        
        //test if the tile CAN be moved across the same row.
        
        row1 = new int[] {0, 2, 3};
        row2 = new int[] {1, 6, 4};
        row3 = new int[] {7, 8, 5};
        
        rows = new int[][] { row1, row2, row3 };
        
        moveSlideTileLegal(slide2, rows);
        
        //Test if the tile CAN be moved across different rows.
        
        row1 = new int[] {6, 1, 3};
        row2 = new int[] {7, 0, 4};
        row3 = new int[] {8, 2, 5};
        
        rows = new int[][] { row1, row2, row3 };
        
        moveSlideTileLegal(slide2, rows);
    }

    @Test
    public void testSlide3() {
        //Test if the tile cannot be moved across the same row.
        
        int[] row1 = { 0, 8, 3 };
        int[] row2 = { 7, 2, 4 };
        int[] row3 = { 1, 6, 5 };
        
        int[][] rows = { row1, row2, row3 };
        
        
        moveSlideTileIllegal(slide3, rows);
        
        //Test if the tile cannot be moved across different rows.

        row1 = new int[] { 2, 8, 3 };
        row2 = new int[] { 1, 6, 4 };
        row3 = new int[] { 7, 0, 5 };
        
        rows = new int[][] { row1, row2, row3 };
        
        moveSlideTileIllegal(slide3, rows);
        
        //test if the tile CAN be moved across the same row.
        
        row1 = new int[] {1, 0, 3};
        row2 = new int[] {2, 6, 4};
        row3 = new int[] {7, 8, 5};
        
        rows = new int[][] { row1, row2, row3 };
        
        moveSlideTileLegal(slide3, rows);
        
        //Test if the tile CAN be moved across different rows.
        
        row1 = new int[] {6, 1, 3};
        row2 = new int[] {2, 4, 0};
        row3 = new int[] {7, 8, 5};
        
        rows = new int[][] { row1, row2, row3 };
        
        moveSlideTileLegal(slide3, rows);     
    }

    @Test
    public void testSlide4() {
        //Test if the tile cannot be moved across the same row.
        
        int[] row1 = { 2, 8, 3 };
        int[] row2 = { 0, 7, 4 };
        int[] row3 = { 1, 6, 5 };
        
        int[][] rows = { row1, row2, row3 };
        
        
        moveSlideTileIllegal(slide4, rows);
        
        //Test if the tile cannot be moved across different rows.

        row1 = new int[] { 2, 8, 3 };
        row2 = new int[] { 1, 6, 4 };
        row3 = new int[] { 7, 0, 5 };
        
        rows = new int[][] { row1, row2, row3 };
        
        moveSlideTileIllegal(slide4, rows);
        
        //test if the tile CAN be moved across the same row.
        
        row1 = new int[] {6, 1, 3};
        row2 = new int[] {2, 0, 4};
        row3 = new int[] {7, 8, 5};
        
        rows = new int[][] { row1, row2, row3 };
        
        moveSlideTileLegal(slide4, rows);
        
        //Test if the tile CAN be moved across different rows.
        
        row1 = new int[] {6, 1, 0};
        row2 = new int[] {2, 3, 4};
        row3 = new int[] {7, 8, 5};
        
        rows = new int[][] { row1, row2, row3 };
        
        moveSlideTileLegal(slide4, rows);       
    }

    @Test
    public void testSlide5() {
        //Test if the tile cannot be moved across the same row.
        
        int[] row1 = { 2, 8, 3 };
        int[] row2 = { 7, 1, 4 };
        int[] row3 = { 0, 6, 5 };
        
        int[][] rows = { row1, row2, row3 };
        
        
        moveSlideTileIllegal(slide5, rows);
        
        //Test if the tile cannot be moved across different rows.

        row1 = new int[] { 2, 8, 0 };
        row2 = new int[] { 1, 3, 4 };
        row3 = new int[] { 7, 6, 5 };
        
        rows = new int[][] { row1, row2, row3 };
        
        moveSlideTileIllegal(slide5, rows);
        
        //test if the tile CAN be moved across the same row.
        
        row1 = new int[] {8, 1, 3};
        row2 = new int[] {2, 6, 4};
        row3 = new int[] {7, 0, 5};
        
        rows = new int[][] { row1, row2, row3 };
        
        moveSlideTileLegal(slide5, rows);
        
        //Test if the tile CAN be moved across different rows.
        
        row1 = new int[] {6, 1, 3};
        row2 = new int[] {2, 4, 0};
        row3 = new int[] {7, 8, 5};
        
        rows = new int[][] { row1, row2, row3 };
        
        moveSlideTileLegal(slide5, rows);       
    }

    @Test
    public void testSlide6() {
        //Test if the tile cannot be moved across the same row.
        
        int[] row1 = { 2, 8, 3 };
        int[] row2 = { 6, 4, 0 };
        int[] row3 = { 1, 7, 5 };
        
        int[][] rows = { row1, row2, row3 };
        
        
        moveSlideTileIllegal(slide6, rows);
        
        //Test if the tile cannot be moved across different rows.

        row1 = new int[] { 2, 6, 3 };
        row2 = new int[] { 1, 8, 4 };
        row3 = new int[] { 7, 0, 5 };
        
        rows = new int[][] { row1, row2, row3 };
        
        moveSlideTileIllegal(slide6, rows);
        
        //test if the tile CAN be moved across the same row.
        
        row1 = new int[] {2, 1, 3};
        row2 = new int[] {0, 6, 4};
        row3 = new int[] {7, 8, 5};
        
        rows = new int[][] { row1, row2, row3 };
        
        moveSlideTileLegal(slide6, rows);
        
        //Test if the tile CAN be moved across different rows.
        
        row1 = new int[] {6, 1, 3};
        row2 = new int[] {0, 2, 4};
        row3 = new int[] {7, 8, 5};
        
        rows = new int[][] { row1, row2, row3 };
        
        moveSlideTileLegal(slide6, rows);      
    }

    @Test
    public void testSlide7() {
        //Test if the tile cannot be moved across the same row.
        
        int[] row1 = { 2, 8, 3 };
        int[] row2 = { 7, 4, 0 };
        int[] row3 = { 1, 6, 5 };
        
        int[][] rows = { row1, row2, row3 };
        
        
        moveSlideTileIllegal(slide7, rows);
        
        //Test if the tile cannot be moved across different rows.

        row1 = new int[] { 0, 8, 3 };
        row2 = new int[] { 1, 6, 4 };
        row3 = new int[] { 7, 2, 5 };
        
        rows = new int[][] { row1, row2, row3 };
        
        moveSlideTileIllegal(slide7, rows);
        
        //test if the tile CAN be moved across the same row.
        
        row1 = new int[] {8, 1, 3};
        row2 = new int[] {2, 6, 4};
        row3 = new int[] {7, 0, 5};
        
        rows = new int[][] { row1, row2, row3 };
        
        moveSlideTileLegal(slide7, rows);
        
        //Test if the tile CAN be moved across different rows.
        
        row1 = new int[] {6, 1, 3};
        row2 = new int[] {2, 0, 4};
        row3 = new int[] {8, 7, 5};
        
        rows = new int[][] { row1, row2, row3 };
        
        moveSlideTileLegal(slide7, rows);     
    }

    @Test
    public void testSlide8() {
        //Test if the tile cannot be moved across the same row.
        
        int[] row1 = { 8, 2, 0 };
        int[] row2 = { 7, 3, 4 };
        int[] row3 = { 1, 6, 5 };
        
        int[][] rows = { row1, row2, row3 };
        
        
        moveSlideTileIllegal(slide8, rows);
        
        //Test if the tile cannot be moved across different rows.

        row1 = new int[] { 2, 8, 3 };
        row2 = new int[] { 1, 6, 4 };
        row3 = new int[] { 7, 0, 5 };
        
        rows = new int[][] { row1, row2, row3 };
        
        moveSlideTileIllegal(slide8, rows);
        
        //test if the tile CAN be moved across the same row.
        
        row1 = new int[] {7, 1, 3};
        row2 = new int[] {2, 6, 4};
        row3 = new int[] {0, 8, 5};
        
        rows = new int[][] { row1, row2, row3 };
        
        moveSlideTileLegal(slide8, rows);
        
        //Test if the tile CAN be moved across different rows.
        
        row1 = new int[] {6, 1, 3};
        row2 = new int[] {2, 0, 4};
        row3 = new int[] {7, 8, 5};
        
        rows = new int[][] { row1, row2, row3 };
        
        moveSlideTileLegal(slide8, rows);      
    }
    
    private void moveSlideTileLegal(String m, int[][] grid) {
        PuzzleState state = new PuzzleState(grid);
        next = mover.doMove(m, state);
        assertTrue(next != null);
    }
    
    private void moveSlideTileIllegal(String m, int[][] grid) {
        PuzzleState state = new PuzzleState(grid);
        next = mover.doMove(m, state);
        assertTrue(next == null);
    }
    
    private State next;
    
}