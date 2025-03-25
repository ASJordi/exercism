package easy.dotdsl;

import java.util.Collection;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.Map;

public class Graph {

    private Map<String, String> attributes;
    private Collection<Node> nodes = new LinkedList<>();
    private Collection<Edge> edges = new LinkedList<>();

    public Graph() {
        this.attributes = new HashMap<>();
    }

    public Graph(Map<String, String> attributes) {
        this.attributes = attributes;
    }

    public Collection<Node> getNodes() {
        return this.nodes;
    }

    public Collection<Edge> getEdges() {
        return this.edges;
    }

    public Graph node(String name) {
        Node node = new Node(name);
        this.nodes.add(node);
        return this;
    }

    public Graph node(String name, Map<String, String> attributes) {
        Node node = new Node(name, attributes);
        this.nodes.add(node);
        return this;
    }

    public Graph edge(String start, String end) {
        Edge edge = new Edge(start, end);
        this.edges.add(edge);
        return this;
    }

    public Graph edge(String start, String end, Map<String, String> attributes) {
        Edge edge = new Edge(start, end, attributes);
        this.edges.add(edge);
        return this;
    }

    public Map<String, String> getAttributes() {
        return this.attributes;
    }
}
