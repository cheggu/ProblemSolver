package framework.graph;

import framework.problem.Mover;
import framework.problem.Problem;
import framework.problem.State;
import java.util.List;
import java.util.Stack;

/**
 * @author ben marksberry
 */
public class GraphCreator {
    
    public Graph createGraphFor(Problem problem) {
        graph = new Graph();
        stack = new Stack<>();
        start = new Vertex(problem.getInitialState());
        stack.push(start);
        Mover mover = problem.getMover();
        moves = mover.getMoveNames();

        while (!stack.isEmpty())
        {
            State curState = (State)stack.pop().getData();
            for (String move : moves)
            {
                next = mover.doMove(move, curState);
                
                if (next != null)
                {
                    v = new Vertex(next);
                    if (graph.getVertices().containsKey(v))
                    {
                        v = graph.getVertices().get(v);                     
                    }
                    else
                    {
                        stack.push(v);
                    }
                    u = new Vertex(curState);
                    graph.addEdge(u, v);
                }
            }
        }
        return graph;
    }
    
    private List<String> moves;
    private Vertex start = null;
    private State next = null;
    private Vertex v = null; 
    private Vertex u = null;
    private Graph graph = null;
    private Stack<Vertex> stack = null;
}