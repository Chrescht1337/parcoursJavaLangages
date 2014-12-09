import java.util.ArrayList;

public class Node
{
  private String name;
  private ArrayList<Node> neighbours;

  public Node(String name_){
    this.name=name_;
    this.neighbours= new ArrayList<Node>();
  }

  public void addNeighbour(Node n){
    if (!(this.neighbours.contains(n))){
      this.neighbours.add(n);
      n.addNeighbour(this);
    }
  }

}
