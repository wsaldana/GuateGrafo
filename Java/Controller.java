package Java;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.util.Iterator;

public class Controller {
    
    private Graph<String, Integer> graph;
    
    public Controller(){}

    public Controller(File file){
        this.graph = new GraphMatrixDirected<String, Integer>(15);
        int size = fileToGraph(file);
        this.graph = new GraphMatrixDirected<String, Integer>(size);
        fileToGraph(file);
        floyd();
    }

    public int fileToGraph(File file){
        BufferedReader reader;
        int size = 0;
        try {
			reader = new BufferedReader(new FileReader(file));
			String line = reader.readLine();
			while (line != null) {
				System.out.println(line);
                String data[] = line.split(" ");
                if(!graph.contains(data[0])){
                    this.graph.add(data[0]);
                    size += 1;
                }
                if(!graph.contains(data[1])){
                    this.graph.add(data[1]);
                    size += 1;
                }
                this.graph.addEdge(data[0], data[1], Integer.parseInt(data[2]));
                line = reader.readLine();
			}
			reader.close();
		} catch (IOException e) {
			e.printStackTrace();
        }
        return size;
    }

    public void route(){

    }

    public void interrupcion(String v1, String v2){
        graph.removeEdge(v1, v2);
    }

    public void conexion(String v1, String v2, int label){
        graph.addEdge(v1, v2, label);
    }

    public String getCentro(){
        floyd();
        Edge<String, Integer>[][] data = ((GraphMatrixDirected<String, Integer>) graph).getMatrix();
        Integer[] max = new Integer[data.length];
        for(int i=0; i<max.length; i++){
            max[i]=0;
        }
        for(int i=0; i<data.length-1; i++){
            for(int j=0; j<data.length-1; j++){
                try{
                    if(data[j][i].getLabel()>max[i]){
                        max[i] = data[j][i].getLabel();
                    }
                }catch(Exception e){}
            }
        }
        Integer minIndex = 0;
        for(int i=0; i<data.length; i++){
            if(max[i]<minIndex) minIndex = max[i];
        }
        
        return ((GraphMatrixDirected<String, Integer>) graph).getMatrix()[0][minIndex].here();
    }

    public void floyd(){
        Iterator<String> witer = graph.iterator();
        while (witer.hasNext()){
            Iterator<String> uiter = graph.iterator();
            String w = witer.next();
            while (uiter.hasNext()){
                Iterator<String> viter = graph.iterator();
                String u = uiter.next();
                while (viter.hasNext()){
                    String v = viter.next();
                    if (graph.containsEdge(u,w) && graph.containsEdge(w,v)){
                        Edge<String,Integer> leg1 = graph.getEdge(u,w);
                        Edge<String,Integer> leg2 = graph.getEdge(w,v);
                        int leg1Dist = leg1.getLabel();
                        int leg2Dist = leg2.getLabel();
                        int newDist = leg1Dist+leg2Dist;
                        if (graph.containsEdge(u,v)){
                            Edge<String,Integer> across = graph.getEdge(u,v);
                            int acrossDist = across.getLabel();
                            if (newDist < acrossDist)
                                across.setLabel(newDist);
                        }else{
                            graph.addEdge(u,v,newDist);
                        }
                    }
                }
            }
        }
    }
}