/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package domains.puzzle;

import framework.problem.Mover;
import framework.problem.State;

/**
 *
 * @author benja
 */
public class PuzzleMover extends Mover {
    
    public PuzzleMover()
    {
        addMove("MOVE SLIDE 1", s -> moveSlideTile(1, s));
        addMove("MOVE SLIDE 2", s -> moveSlideTile(2, s));
        addMove("MOVE SLIDE 3", s -> moveSlideTile(3, s));
        addMove("MOVE SLIDE 4", s -> moveSlideTile(4, s));
        addMove("MOVE SLIDE 5", s -> moveSlideTile(5, s));
        addMove("MOVE SLIDE 6", s -> moveSlideTile(6, s));
        addMove("MOVE SLIDE 7", s -> moveSlideTile(7, s));
        addMove("MOVE SLIDE 8", s -> moveSlideTile(8, s));
        
    }
    
    private PuzzleState moveSlideTile(int tile, State state)
    {
        PuzzleState s = (PuzzleState)state;
        PuzzleState.Location locator = s.getLocation(tile);
        int tileX = locator.getColumn();
        int tileY = locator.getRow();
        PuzzleState.Location blank = s.getLocation(0);
        int blankX = blank.getColumn();
        int blankY = blank.getRow();
        if (tileX != blankX && tileY != blankY) return null;
        if (tileX != blankX + 1 && tileX != blankX - 1 && tileY != blankY + 1 && tileY != blankY - 1) return null;
        return new PuzzleState(s, locator, blank);
    }
}
