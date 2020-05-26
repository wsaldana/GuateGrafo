/**
 * Referencias: Duane A. Bailey. (2007). Java Structures. 7ma edicion.
 */

package Java;

public class GraphMatrixVertex<V> extends Vertex<V>{
    
    protected int index;

    public GraphMatrixVertex(V label, int idx){
        super(label);
        index = idx;
    }

    public int index(){
        return index;
    }

    
}
