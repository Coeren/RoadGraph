package RoadGraph.Model;

import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;
import java.util.ArrayList;
import java.util.Collection;

@XmlRootElement(name = "RoadGraph")
public class Graph {
    @XmlElement(name = "Node")
//    private Set<Node> nodes = new HashSet<>();
    private Collection<Node> nodes = new ArrayList<>();

    public Graph() {}

    public void dummyInit() {
        Node n1 = new Node("node1");
        Node n2 = new Node("node2");
        Node n3 = new Node("node3");
        Node n4 = new Node("node4");

        n1.linkTo(n2);
        n2.linkTo(n1);
        n2.linkTo(n3);
        n3.linkTo(n4);

        nodes.add(n1);
        nodes.add(n2);
        nodes.add(n3);
        nodes.add(n4);
    }
}
