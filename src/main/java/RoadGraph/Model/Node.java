package RoadGraph.Model;

import javax.xml.bind.annotation.*;
import java.util.ArrayList;
import java.util.Collection;
import java.util.LinkedList;
import java.util.List;

@XmlType(name = "NodeType")
public class Node {
    @XmlAttribute(name = "Name")
    @XmlID
    private String name;
//    @XmlElement(name = "RoadTo")
//    @XmlIDREF
//    private Collection<Node> roadsTo = new LinkedList<>();

    @XmlElementWrapper(name = "Left")
    @XmlElement(name = "RoadTo")
    @XmlIDREF
    private List<Node> leftRoads = new ArrayList<>();
    @XmlElementWrapper(name = "Straight")
    @XmlElement(name = "RoadTo")
    @XmlIDREF
    private List<Node> straightRoads = new ArrayList<>();
    @XmlElementWrapper(name = "Right")
    @XmlElement(name = "RoadTo")
    @XmlIDREF
    private List<Node> rightRoads = new ArrayList<>();

    public Node() { this(""); }

    Node(String name) { this.name = name; }
    void linkTo(Node target) { straightRoads.add(target); }
}
