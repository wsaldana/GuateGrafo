/**
 * Universidad del Valle de Guatemala
 * Algoritmos y Estructuras de Datos
 * Sección 20
 * 
 * @author Walter Saldaña #19897
 * @version 1.0
 * @since 5/14/2020
 * 
 * Graph
 * Interfaz de un grafo de direccion
 * 
 * Referencias: Duane A. Bailey. (2007). Java Structures. 7ma edicion.
 */

package Java;

import java.util.Iterator;

public interface Graph<V, E> {
   
    public void add(V label);
	// pre: label is a non-null label for vertex
	// post: a vertex with label is added to graph
	// if vertex with label is already in graph, no action
	
	public void addEdge(V vtx1, V vtx2, E label);
	// pre: vtx1 and vtx2 are labels of existing vertices
	// post: an edge (possibly directed) is inserted between
	// vtx1 and vtx2.
	
	public V remove(V label);
	// pre: label is non-null vertex label
	// post: vertex with "equals" label is removed, if found
	
	public E removeEdge(V vLabel1, V vLabel2);
	// pre: vLabel1 and vLabel2 are labels of existing vertices
	// post: edge is removed, its label is returned
	
	public V get(V label);
	// post: returns actual label of indicated vertex
	
	public Edge<V,E> getEdge(V label1, V label2);
	// post: returns actual edge between vertices
	
	public boolean contains(V label);
	// post: returns true iff vertex with "equals" label exists
	
	public boolean containsEdge(V vLabel1, V vLabel2);
	// post: returns true iff edge with "equals" label exists
	
	public boolean visit(V label);
	// post: sets visited flag on vertex, returns previous value
	
	public boolean visitEdge(Edge<V,E> e);
	// pre: sets visited flag on edge; returns previous value
	
	public boolean isVisited(V label);
	// post: returns visited flag on labeled vertex
	
	public boolean isVisitedEdge(Edge<V,E> e);
	// post: returns visited flag on edge between vertices
	
	public void reset();
	// post: resets visited flags to false
	
	public int size();
	// post: returns the number of vertices in graph
	
	public int degree(V label);
	// pre: label labels an existing vertex
	// post: returns the number of vertices adjacent to vertex
	
	public int edgeCount();
	// post: returns the number of edges in graph
	
	public Iterator<V> iterator();
	// post: returns iterator across all vertices of graph
	
	public Iterator<V> neighbors(V label);
	// pre: label is label of vertex in graph
	// post: returns iterator over vertices adj. to vertex
	// each edge beginning at label visited exactly once
	
	public Iterator<Edge<V,E>> edges();
	// post: returns iterator across edges of graph
	// iterator returns edges; each edge visited once
	
	public void clear();
	// post: removes all vertices from graph
	
	public boolean isEmpty();
	// post: returns true if graph contains no vertices
	
	public boolean isDirected();
	// post: returns true if edges of graph are directed

}