import java.util.HashMap;

public class EdgeList {
    HashMap<String,Edge> edges;
    HashMap<String, Vertex> vertices;

    public EdgeList() {
        this.edges = new HashMap<>();
        this.vertices = new HashMap<>();
    }

   void addEdge(String a,String b,int c){
        Vertex i = vertices.get(a);
        Vertex l = vertices.get(b);
        Edge edge = new Edge(i,l,c);
        vertices.get(a).addEdge(edge);
        vertices.get(b).addEdge(edge);
        edges.put(i.getName()+"-"+l.getName(),edge);
        edges.put(l.getName()+"-"+i.getName(),edge);
   }

    void addVertex(String name){
        Vertex  v= new Vertex(name);
        vertices.put(name,v);
    }
}

