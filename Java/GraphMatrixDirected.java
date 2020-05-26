/**
 * Referencias: Duane A. Bailey. (2007). Java Structures. 7ma edicion.
 */

package Java;

import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;

public class GraphMatrixDirected<V, E> extends GraphMatrix<V, E> {

	public GraphMatrixDirected(int size)
	// pre: size > 0
	// post: constructs an empty graph that may be expanded to
	// at most size vertices. Graph is directed if dir true
	// and undirected otherwise
	{
		super(size, true);
	}

	public void addEdge(V vLabel1, V vLabel2, E label)
	// pre: vLabel1 and vLabel2 are labels of existing vertices
	// post: an edge is inserted between vLabel1 and vLabel2;
	// if edge is new, it is labeled with label (can be null)
	{
		GraphMatrixVertex<V> vtx1, vtx2;
		// get vertices
		vtx1 = dict.get(vLabel1);
		vtx2 = dict.get(vLabel2);
		// update matrix with new edge
		Edge<V, E> e = new MyEdge<V, E>(vtx1.getLabel(), vtx2.getLabel(), label, true);
		data[vtx1.index()][vtx2.index()] = e;
	}

	@Override
	public E removeEdge(V vLabel1, V vLabel2) {
		// get indices
		int row = dict.get(vLabel1).index();
		int col = dict.get(vLabel2).index();
		// cache old value
		Edge<V,E> e = data[row][col];
		// update matrix
		data[row][col] = null;
		data[col][row] = null;
		if (e == null) return null;
		else return e.getLabel();
	}

	@Override
	public V get(V label) {
		return dict.get(label).getLabel();
	}

	@Override
	public Edge<V, E> getEdge(V label1, V label2) {
		GraphMatrixVertex<V> v0 = dict.get(label1);
        GraphMatrixVertex<V> v1 = dict.get(label2);
        if(v0 == null || v1 == null) return null;
        Edge<V,E> foundEdge = (Edge<V, E>) data[v0.index][v1.index];
        return foundEdge;
	}

	@Override
	public boolean contains(V label) {
		if(dict.get(label) != null) return true;
		else return false;
	}

	@Override
	public boolean containsEdge(V vLabel1, V vLabel2) {
		GraphMatrixVertex<V> v1 = dict.get(vLabel1);
		GraphMatrixVertex<V> v2 = dict.get(vLabel2);
		if(data[v1.index][v2.index] != null){
			return true;
		}else return false;
	}

	@Override
	public boolean visit(V label) {
		Vertex<V> vert = dict.get(label);
		return vert.visit();
	}

	@Override
	public boolean visitEdge(Edge<V, E> e) {
		return e.visit();
	}

	@Override
	public boolean isVisited(V label) {
		return dict.get(label).isVisited();
	}

	@Override
	public boolean isVisitedEdge(Edge<V, E> e) {
		return e.isVisited();
	}

	@Override
	public void reset() {
		// TODO Auto-generated method stub

	}

	@Override
	public int size() {
		return size;
	}

	@Override
	public int degree(V label) {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public int edgeCount() {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public Iterator<V> iterator(){
		return dict.keySet().iterator();
	}


	@Override
	public Iterator<V> neighbors(V label) {
		GraphMatrixVertex<V> vert;
		vert = dict.get(label);
		List<V> list = new LinkedList<V>();
		for (int row=size-1; row>=0; row--){
			Edge<V,E> e = (Edge<V,E>)data[vert.index()][row];
			if (e != null) {
				if (e.here().equals(vert.getLabel()))
				list.add(e.there());
				else list.add(e.here());
			}
		}
		return list.iterator();
	}

	@Override
	public Iterator<Edge<V, E>> edges() {
		List<Edge<V,E>> list = new LinkedList<Edge<V,E>>();
		for (int row=size-1; row>=0; row--)
		for (int col=size-1; col >= row; col--) {
		Edge<V,E> e = (Edge<V,E>)data[row][col];
		if (e != null) list.add(e);
		}
		return list.iterator();
	}

	@Override
	public void clear() {
		// TODO Auto-generated method stub

	}

	@Override
	public boolean isEmpty() {
		if(data.length>0) return false;
		else return true;
	}

	@Override
	public boolean isDirected() {
		return directed;
	}
	
	public Edge<V,E>[][] getMatrix(){
		return this.data;
	}

	public Map<V,GraphMatrixVertex<V>> getDict(){
		return dict;
	}
}