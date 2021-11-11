/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package domains.farmer;

import framework.problem.Mover;
import framework.problem.State;
import java.util.List;
import java.util.Map;
import java.util.function.UnaryOperator;

/**
 *
 * @author benja
 */
public final class FarmerMover extends Mover {
    
    public static final String GOES_ALONE = "Farmer Goes Alone";
  
    public static final String TAKES_WOLF = "Farmer Takes Wolf";
  
    public static final String TAKES_GOAT = "Farmer Takes Goat";
  
    public static final String TAKES_CABBAGE = "Farmer Takes Cabbage";
  
    public FarmerMover()
    {
        addMove("Farmer Goes Alone", s -> goesAlone(s));
        addMove("Farmer Takes Wolf", s -> takesWolf(s));
        addMove("Farmer Takes Goat", s -> takesGoat(s));
        addMove("Farmer Takes Cabbage", s -> takesCabbage(s));
        
    }
    
    private State goesAlone(State state)
    {
        FarmerState s = (FarmerState)state;
        FarmerState farmerMove = new FarmerState(getOpposite(s.getState("F")), s.getState("W"), s.getState("G"), s.getState("C"));
        return checkSafe(farmerMove);
    }
    
    private State takesWolf(State state)
    {
        FarmerState s = (FarmerState)state;
        if (!s.getState("F").equals(s.getState("W")))
        {
            return null;
        }
        else
        {
            FarmerState farmerMove = new FarmerState(getOpposite(s.getState("F")), getOpposite(s.getState("W")), s.getState("G"), s.getState("C"));
            return checkSafe(farmerMove);
        }
    }
    
    private State takesGoat(State state)
    {
        FarmerState s = (FarmerState)state;
        if (!s.getState("F").equals(s.getState("G")))
        {
            return null;
        }
        else
        {
            FarmerState farmerMove = new FarmerState(getOpposite(s.getState("F")), s.getState("W"), getOpposite(s.getState("G")), s.getState("C"));
            return checkSafe(farmerMove);
        }
    }
    
    private State takesCabbage(State state)
    {
        FarmerState s = (FarmerState)state;
        if (!s.getState("F").equals(s.getState("C")))
        {
            return null;
        }
        else
        {
            FarmerState farmerMove = new FarmerState(getOpposite(s.getState("F")), s.getState("W"), s.getState("G"), getOpposite(s.getState("C")));
            return checkSafe(farmerMove);
        }
    }
    
    private State checkSafe(FarmerState state)
    {
        if (isSafe(state))
        {
            return state;
        }
        else
        {
            return null;
        }
    }
    
    private String getOpposite(String side)
    {
        if (side.equals("West"))
        {
            return "East";
        }
        return "West";
    }
    
    private boolean isSafe(FarmerState state)
    {
        String farmerSide = state.getState("F");
        String wolfSide = state.getState("W");
        String goatSide = state.getState("G");
        String cabbageSide = state.getState("C");
        
        return ((!wolfSide.equals(goatSide) || goatSide.equals(farmerSide)) && (!cabbageSide.equals(goatSide) || cabbageSide.equals(farmerSide)));
    }
    
    //private final String goesAlone, takesWolf, takesGoat, takesCabbage, takesGorilla;
}
