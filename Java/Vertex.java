/**
 * Referencias: Duane A. Bailey. (2007). Java Structures. 7ma edicion.
 */

package Java;

public class Vertex<E>{

    private E label;
    private Boolean visited;

    public Vertex(E label){
        this.label = label;
    }
    // post: constructs unvisited vertex with label

    public E getLabel(){
        return this.label;
    }
    // post: returns user label associated w/vertex

    public boolean visit(){
        boolean oldValue = this.visited;
        this.visited = true;
        return oldValue;
    }
    // post: returns, then marks vertex as being visited

    public boolean isVisited(){
        return this.visited;
    }
    // post: returns true iff vertex has been visited

    public void reset(){
        this.visited = false;
    }
    // post: marks vertex unvisited
    
    public boolean equals(Vertex<E> other){
        if(this.label.equals(other.label)){
            return true;
        }else{
            return false;
        }
    }
    // post: returns true iff vertex labels are equal

}