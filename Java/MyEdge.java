/**
 * Referencias: Duane A. Bailey. (2007). Java Structures. 7ma edicion.
 */

package Java;

public class MyEdge<V,E> implements Edge<V,E>{

    private V vLabel1; 
    private V vLabel2; 
    private E label;
    private boolean directed;
    private boolean visited;

    public MyEdge(){}
    
    public MyEdge(V vLabel1, V vLabel2, E label, boolean directed){
        this.vLabel1 = vLabel1;
        this.vLabel2 = vLabel2;
        this.label = label;
        this.directed = directed;
    }

    @Override
    public V here() {
        return this.vLabel1;
    }

    @Override
    public V there() {
        return this.vLabel2;
    }

    @Override
    public void setLabel(E label) {
        this.label = label;
    }

    @Override
    public E getLabel() {
        return this.label;
    }

    @Override
    public boolean visit() {
        boolean oldValue = this.visited;
        this.visited = true;
        return oldValue;
    }

    @Override
    public boolean isVisited() {
        return this.visited;
    }

    @Override
    public boolean isDirected() {
        return this.directed;
    }

    @Override
    public void reset() {
        this.visited = false;
    }
    
}