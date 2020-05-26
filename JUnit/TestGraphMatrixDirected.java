package JUnit;

import static org.junit.Assert.*;  
import com.javatpoint.logic.*;  
import org.junit.Test;

import Java.GraphMatrixDirected;  

public class TestGraphMatrixDirected {

    @Test  
    public void testAdd(){
        GraphMatrixDirected<String, Integer> graph = new GraphMatrixDirected<String, Integer>(2);
        graph.add("uno");
        assertNotNull(graph.get("uno"));
    } 

    @Test  
    public void testRemove(){
        GraphMatrixDirected<String, Integer> graph = new GraphMatrixDirected<String, Integer>(2);
        graph.remove("uno");
        assertNull(graph.get("uno"));
    } 

    @Test  
    public void testSize(){
        GraphMatrixDirected<String, Integer> graph = new GraphMatrixDirected<String, Integer>(2);
        graph.add("uno");
        assertNotNull(graph.size());
    } 

}