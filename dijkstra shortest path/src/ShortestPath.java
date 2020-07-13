
import java.lang.*;
import java.util.HashMap;

class ShortestPath {

    String minDistance2(HashMap<String,Boolean> sptSet, HashMap<String,Integer> dist){
        int min = Integer.MAX_VALUE;
        String min_index = "";
        for(String i : dist.keySet()){
            if(sptSet.get(i)==false && dist.get(i)<= min){
                min = dist.get(i);
                min_index = i;
            }
        }
        return min_index;
    }


//////////////////////////////////////////////////////////////////////////////////////////////////////////////
    void dijkstra2(EdgeList el, String startStation, String endStation){
        HashMap<String,Edge> edges = el.edges;
        HashMap<String, Vertex> vertices = el.vertices;


        HashMap<String,Boolean> sptSet = new HashMap<>();
        HashMap<String,Integer> dist = new HashMap<>();
        HashMap<String,String> path = new HashMap<>();


        for (Vertex v : vertices.values()){
            sptSet.put(v.getName(),false);
            dist.put(v.getName(),Integer.MAX_VALUE);
            path.put(v.getName(),startStation+"->");
        }


        dist.put(startStation,0);

        for (int i = 0; i <vertices.size()-2; i++) {

            String u = minDistance2(sptSet,dist);
            sptSet.put(u,true);


            for (String v : dist.keySet()){
                int distanceTwoWertex=0;
                if(edges.get(u+"-"+v) != null){
                    distanceTwoWertex += edges.get(u+"-"+v).getDistance();
                    if(dist.get(u)!= Integer.MAX_VALUE && dist.get(u)+ distanceTwoWertex < dist.get(v)){
                        dist.put(v,dist.get(u)+ distanceTwoWertex);
                        path.put(v,path.get(u)+v+"->");
                    }
                }
            }

        }
        System.out.println(printSolution2(dist, path, startStation,endStation));
    }


    private String printSolution2(HashMap<String, Integer> dist, HashMap<String, String> path, String start, String finish) {
        String str = "";
        for (String i : dist.keySet()){
            if(dist.get(i) != Integer.MAX_VALUE && i.equals(finish)) {
                str += start + "dan " + i + "e en kısa yol " + dist.get(i) + "m. gidis yolu: " + path.get(i);
            }
        }
        return str;

    }
}

