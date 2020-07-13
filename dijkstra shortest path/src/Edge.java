public class Edge {
    private Vertex initialStop;
    private Vertex finishStop;
    private int distance;

    public Edge(Vertex initialStop, Vertex finishStop, int distance) {
        this.initialStop = initialStop;
        this.finishStop = finishStop;
        this.distance = distance;
    }

    public int getDistance() {
        return distance;
    }

}
