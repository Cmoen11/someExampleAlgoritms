import java.util.ArrayList;

/**
 * Created by Christian on 08.05.2017.
 */
public class Graph <T> {

    Node rootNode = null;

    public void addToRoot(T data, int distance) {
        Node node = new Node (data);
        if (rootNode == null) rootNode = node;
        else rootNode.edges.add(new Edge (rootNode, node, distance));
    }

    public void addNodeToNode(Node node, T data, int distance) {
        Edge edge = new Edge(node, new Node(data), distance);
        node.edges.add(edge);
    }

    public class Node{
        ArrayList<Edge> edges;
        T data;

        public Node(T data) {
            edges = new ArrayList<>();
            this.data = data;
        }
    }

    public class Edge{
        Node from_node, too_node;
        int distance;
        public Edge(Node from_node, Node too_node, int distance) {
            this.from_node = from_node;
            this.too_node = too_node;
            this.distance = distance;
        }
    }
