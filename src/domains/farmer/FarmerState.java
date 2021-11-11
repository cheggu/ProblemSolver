/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package domains.farmer;

import framework.problem.State;
import java.util.Objects;

/**
 *
 * @author benja
 */
public class FarmerState extends State {
    
        public FarmerState(String farmer, String wolf, String goat, String cabbage) {
            this.Farmer = farmer;
            this.Wolf = wolf;
            this.Goat = goat;
            this.Cabbage = cabbage;
            
            buildString();
        }   
        
        private void buildString()
        {
            outputPositions += "   |  |   \n";
            
            if ("West".equals(this.Farmer))
            {
                outputPositions += " F |  |   \n";
            }
            else
            {
                outputPositions += "   |  | F \n";
            }
            
            if ("West".equals(this.Wolf))
            {
                outputPositions += " W |  |   \n";
            }
            else
            {
                outputPositions += "   |  | W \n";
            }
            if ("West".equals(this.Goat))
            {
                outputPositions += " G |  |   \n";
            }
            else
            {
                outputPositions += "   |  | G \n";
            }
            if ("West".equals(this.Cabbage))
            {
                outputPositions += " C |  |   \n";
            }
            else
            {
                outputPositions += "   |  | C \n";
            }     
            
            outputPositions += "   |  |   ";
        }
        
        @Override
        public String toString()
        {
            return outputPositions;
        }
        /*
        public boolean equals(FarmerState other) {
            return (other.getState("F").equals(getState("F")) && other.getState("W").equals(getState("W")) &&
                    other.getState("G").equals(getState("G")) && other.getState("C").equals(getState("C")));
        }
        */
        
        public boolean equals(FarmerState other) {
            if (other.getFarmer().equals(getFarmer()))
            {
                if (other.getWolf().equals(getWolf()))
                {
                    if (other.getGoat().equals(getGoat()))
                    {
                        if (other.getCabbage().equals(getCabbage()))
                        {
                            return true;
                        }
                    }
                }
            }
            return false;
        }  
        
        @Override
        public int hashCode() {
        int hash = 7;
        hash = 97 * hash + Objects.hashCode(this.Farmer);
        hash = 97 * hash + Objects.hashCode(this.Wolf);
        hash = 97 * hash + Objects.hashCode(this.Goat);
        hash = 97 * hash + Objects.hashCode(this.Cabbage);
        return hash;
        }

    @Override
    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null) {
            return false;
        }
        if (getClass() != obj.getClass()) {
            return false;
        }
        final FarmerState other = (FarmerState) obj;
        if (!Objects.equals(this.Farmer, other.Farmer)) {
            return false;
        }
        if (!Objects.equals(this.Wolf, other.Wolf)) {
            return false;
        }
        if (!Objects.equals(this.Goat, other.Goat)) {
            return false;
        }
        if (!Objects.equals(this.Cabbage, other.Cabbage)) {
            return false;
        }
        return true;
    }
        
        public String getFarmer()
        {
            return Farmer;
        }
        
        public String getWolf()
        {
            return Wolf;
        }

        public String getGoat()
        {
            return Goat;
        }

        public String getCabbage()
        {
            return Cabbage;
        }
        
        public String getOutput()
        {
            return outputPositions;
        }
                
        public String getState(String item)
        {
            switch (item) {
                case "F":
                    return Farmer;
                case "W":
                    return Wolf;
                case "G":
                    return Goat;
                case "C":
                    return Cabbage;
                default:
                    return "NULL";
            }
        }
        
        private String Farmer, Wolf, Goat, Cabbage;
        private String outputPositions = "";
        
}
