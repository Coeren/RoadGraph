package RoadGraph.Model;

import javax.xml.bind.annotation.*;
import java.util.Collection;
import java.util.LinkedList;

@XmlType(name = "NodeType")
public class Node {
    @XmlAttribute(name = "Name")
    @XmlID
    private String name;
    @XmlElement(name = "RoadTo")
    @XmlIDREF
    private Collection<Node> roadsTo = new LinkedList<>();

    public Node() { this(""); }
    public Node(String name) { this.name = name; }
    void linkTo(Node target) { roadsTo.add(target); }
}
