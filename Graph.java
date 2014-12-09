public class Graph{
  private int nodeNbr;
  private TreatableNode[] graph;

  public Graph(int nodes){
    this.nodeNbr=nodes;
    this.graph=new TreatableNode[this.nodeNbr];
    for (int i=0;i<nodes;i++){
      this.graph[i]=new TreatableNode(i);
      System.out.println(i);
    }
  }
}
