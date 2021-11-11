package framework.solution;

import domains.example.ExampleGraph;
import framework.graph.Vertex;
import java.util.Iterator;
import java.util.Stack;

/**
 *
 * @author tcolburn
 */
public class Solution implements Iterator<Vertex> {
    
    private ExampleGraph graph = new ExampleGraph();
    /**
     * Creates an object that represents a path from a start
     * vertex to an end vertex in a problem solving domain.
     * This constructor will be called after a search has been
     * initiated on the start vertex.
     * If a path from start to end exists, it can be constructed
     * from the predecessor information stored in the end vertex.
     * @param start the start vertex
     * @param end the end vertex
     */
    public Solution(Vertex start, Vertex end) {
        // You must provide
        stack = new Stack<>();
        Vertex predecessor = end;
        
        while (predecessor != start)
        {
            stack.push(predecessor);
            predecessor = predecessor.getPredecessor();
            length++;
        }
        
        stack.push(start);
    }

    /**
     * Gets the length of the solution.
     * This is the number of moves in the solution, not the
     * number of vertices.
     * @return the solution length
     */
    public int getLength() {
        return length;
    }
    
    /**
     * Checks whether there are more vertices in this solution.
     * @return true if there are more vertices in this solution, false
     * otherwise
     */
    @Override
    public boolean hasNext() {
        return (length > 1);
    }
    
    /**
     * Removes and returns the next vertex in this solution.
     * @return the next vertex in this solution
     * @throws RuntimeException if there are no more vertices
     */
    @Override
    public Vertex next() {
        length--;
        return stack.pop();
    }
    
    // Private instance fields here
    private int length = 0;
    Stack<Vertex> stack;
}