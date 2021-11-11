/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package domains.arithmetic;

import framework.problem.State;

/**
 *
 * @author Ben Marksberry
 */
public class ArithmeticState extends State {
        
        /*
        * Constructor for a new ArithmeticState
        * @param value an integer to perform operations on
        */
        public ArithmeticState(int value) {
            this.value = value;
        }

        /* 
        * Determines whether two arithmetic states are equal in value
        * @param other The other ArtithmeticState object to compare values with
        */
        @Override
        public boolean equals(Object other)
        {
            ArithmeticState otherArithmetic = (ArithmeticState) other;
            int thisVal = getValue();
            int otherVal = otherArithmetic.getValue();
            
            return thisVal == otherVal;
        }
        
        /*
        * Returns a string representation of the current value
        */
        @Override
        public String toString()
        {
            return "The value is: " + value;
        }

        /*
        * @param val Value to set
        */
        public void setValue(int val)
        {
            value = val;
        }
        
        public int getValue()
        {
            return value;
        }
        
        private int value;
}
