import java.util.ArrayList;

public class Vertex {
    private String name;
    private ArrayList<Edge> edges;

    public Vertex(String name ) {
        this.name = name;
        this.edges = new ArrayList<>();
    }

    public void addEdge(Edge e){
        edges.add(e);
    }

    public String getName() {
        return name;
    }

}
