/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package domains.farmer;

import framework.graph.Graph;
import framework.graph.Vertex;

/**
 *
 * @author benja
 */
public class FarmerGraph extends Graph {
    
    Vertex v1 = new Vertex(new FarmerState("West",
                                                "West",
                                                "West",
                                                "West"));
        
    Vertex v7 = new Vertex (new FarmerState("East",
                                                "West",
                                                "East",
                                                "West"));
        
    Vertex v4 = new Vertex (new FarmerState("West",
                                                "West",
                                                "East",
                                                "West"));
        
    Vertex v10 = new Vertex (new FarmerState("East",
                                                "East",
                                                "East",
                                                "West"));
        
    Vertex v3 = new Vertex (new FarmerState("West",
                                                "East",
                                                "West",
                                                "West"));
        
    Vertex v9 = new Vertex (new FarmerState("East",
                                                "East",
                                                "West",
                                                "East"));
        
    Vertex v8 = new Vertex (new FarmerState("East",
                                                "West",
                                                "East",
                                                "East"));
        
    Vertex v5 = new Vertex (new FarmerState("West",
                                                "West",
                                                "West",
                                                "East"));
        
    Vertex v2 = new Vertex (new FarmerState("West",
                                                "East",
                                                "West",
                                                "East"));
        
    Vertex v6 = new Vertex (new FarmerState("East",
                                                "East",
                                                "East",
                                                "East"));
    
    public FarmerGraph()
    {
        add(v1, v7);
        add(v7, v4);
        add(v4, v10);
        add(v4, v8);
        add(v10, v3);
        add(v8, v5);
        add(v3, v9);
        add(v5, v9);
        add(v9, v2);
        add(v2, v6);
        
    }

    private void add(Vertex x, Vertex y) {
        addEdge(x, y);
        addEdge(y, x);
    }
            
}
