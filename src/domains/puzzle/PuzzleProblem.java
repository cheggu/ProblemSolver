/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package domains.puzzle;

import framework.problem.Benchmark;
import framework.problem.Problem;

/**
 *
 * @author benja
 */
public class PuzzleProblem extends Problem{
    private static final String INTRO = "A 3x3 grid of 8 numbers and an empty spot lay before you. The numbers are placed randomly. The goal is to sort the numbers from least to greatest in a clockwise fashion, starting from the top-left-most grid. Complete the problem in as few moves as possible!";
    
    public String getIntro()
    {
        return INTRO;
    }
    /**
     *
     */
    public PuzzleProblem() {
        super.addBenchmark(new Benchmark("8-Puz 1", 5, BENCH1, GOAL));
        super.addBenchmark(new Benchmark("8-Puz 2", 10, BENCH2, GOAL));
        super.addBenchmark(new Benchmark("8-Puz 3", 13, BENCH3, GOAL));
        super.addBenchmark(new Benchmark("8-Puz 4", 18, BENCH4, GOAL));
        super.addBenchmark(new Benchmark("8-Puz 5", 20, BENCH5, GOAL));
        super.addBenchmark(new Benchmark("8-Puz 6", 24, BENCH6, GOAL));
        super.addBenchmark(new Benchmark("8-Puz 7", 30, BENCH7, GOAL));
        super.addBenchmark(new Benchmark("8-Puz 8", 30, BENCH8, GOAL));
        
        
        super.setName("Welcome to the Puzzle problem");
        super.setIntroduction(INTRO);
        super.setMover(new PuzzleMover());
        
        int[] row1 = { 2, 8, 3 };
        int[] row2 = { 1, 6, 4 };
        int[] row3 = { 7, 0, 5 };
        int[][] rows = { row1, row2, row3 };
        
        super.setInitialState(new PuzzleState(rows));
        super.setCurrentState(super.getInitialState());
        
        row1 = new int[] { 1, 2, 3 };
        row2 = new int[] { 8, 0, 4 };
        row3 = new int[] { 7, 6, 5 };
        rows = new int[][] { row1, row2, row3 };
        
        super.setFinalState(new PuzzleState(rows));     
    }
    
    @Override
    public boolean success()
    {
        PuzzleState curState = (PuzzleState)super.getCurrentState();
        PuzzleState finState = (PuzzleState)super.getFinalState();
        return curState.equals(finState);
    }
    
    public static final PuzzleState BENCH1 = 
        new PuzzleState(new int[][]{new int[]{2, 8, 3}, 
                                    new int[]{1, 6, 4}, 
                                    new int[]{7, 0, 5}});
    
    public static final PuzzleState BENCH2 = 
        new PuzzleState(new int[][]{new int[]{3, 6, 4}, 
                                    new int[]{1, 0, 2}, 
                                    new int[]{8, 7, 5}});
    
    public static final PuzzleState BENCH3 = 
        new PuzzleState(new int[][]{new int[]{3, 0, 4}, 
                                    new int[]{1, 6, 5}, 
                                    new int[]{8, 2, 7}});
    
    public static final PuzzleState BENCH4 = 
        new PuzzleState(new int[][]{new int[]{2, 1, 3}, 
                                    new int[]{8, 0, 4}, 
                                    new int[]{6, 7, 5}});
    
    public static final PuzzleState BENCH5 = 
        new PuzzleState(new int[][]{new int[]{4, 2, 0}, 
                                    new int[]{8, 3, 6}, 
                                    new int[]{7, 5, 1}});
    
    public static final PuzzleState BENCH6 = 
        new PuzzleState(new int[][]{new int[]{1, 6, 3}, 
                                    new int[]{4, 0, 8}, 
                                    new int[]{7, 2, 5}});
    
    public static final PuzzleState BENCH7 = 
        new PuzzleState(new int[][]{new int[]{5, 6, 7}, 
                                    new int[]{4, 0, 8}, 
                                    new int[]{3, 2, 1}});
    
    public static final PuzzleState BENCH8 = 
        new PuzzleState(new int[][]{new int[]{5, 2, 7}, 
                                    new int[]{8, 0, 4}, 
                                    new int[]{3, 6, 1}});
    
    private static final PuzzleState GOAL = 
            new PuzzleState(new int[][]{new int[]{1, 2, 3}, 
                                        new int[]{8, 0, 4}, 
                                        new int[]{7, 6, 5}});
}
