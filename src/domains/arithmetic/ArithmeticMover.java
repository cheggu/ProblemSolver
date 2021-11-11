/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package domains.arithmetic;

import framework.problem.Mover;
import framework.problem.State;

/**
 *
 * @author Ben Marksberry
 */
public class ArithmeticMover extends Mover {
        public static final String ADD_THREE = "Add 3";
        public static final String SUB_FIVE = "Subtract 5";
        public static final String MULT_TWO = "Multiply by 2";
        public static final String DIV_TWO = "Divide by 2";
        
        /*
        * Constructs a new ArithmeticMover object
        */
        public ArithmeticMover() {
            super.addMove(ADD_THREE, s -> tryAddThree(s));
            super.addMove(SUB_FIVE, s -> trySubFive(s));
            super.addMove(MULT_TWO, s -> tryMultTwo(s));
            super.addMove(DIV_TWO, s -> tryDivTwo(s));
            //super.addMove(MARY, s -> illegalMove(s));
        }
        
        
         /**
        * State that adds 3 to the current value and returns the new state with the new value
        * @param state a state to add to
        */ 
        private State tryAddThree(State state) {
            // To get at the current state, you first need to cast:
            ArithmeticState s = (ArithmeticState) state;
            // Now you can use s to access the state, for example,
            // the name of the move that got to this state:
            s.setValue(s.getValue() + 3);
            // However, this dummy example just creates a dummy state:
            return new ArithmeticState(s.getValue());
        }

        /**
        * State that subtracts 5 from the current value and returns the new state with the new value
        * @param state a state to subtracts 5 from
        */ 
        private State trySubFive(State state) {
            ArithmeticState s = (ArithmeticState) state;
            
            s.setValue(s.getValue() - 5);
            
            return new ArithmeticState(s.getValue());
        }

         /**
        * State that multiplies the current value by 2 and returns the new state with the new value
        * @param state a state to multiply by 2
        */ 
        private State tryMultTwo(State state) {
            ArithmeticState s = (ArithmeticState) state;
            
            s.setValue(s.getValue() * 2);
            
            return new ArithmeticState(s.getValue());
        }
        
         /**
        * State that divides the current value by 2 and returns the new state with the new value
        * @param state a state to divide by 2
        */ 
        private State tryDivTwo(State state) {
            ArithmeticState s = (ArithmeticState) state;
            
            s.setValue(s.getValue() / 2);
            
            return new ArithmeticState(s.getValue());
        }

         /**
        * State that returns null if the user has inputted an invalid state
        * @param state a state that is invalid
        */ 
        private State illegalMove(State state) {
            return null;
        }
}
