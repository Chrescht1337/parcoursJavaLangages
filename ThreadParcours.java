import java.util.Random;
public class ThreadParcours implements Runnable{
  private Graph graph;
  private TreatableNode initialNode;

  public ThreadParcours(Graph graph,TreatableNode initialNode){
    this.graph=graph;
    this.initialNode=initialNode;
  }

  public void run(){
    if (!(this.graph.nodesAllTreated())){
      System.out.println("Hello from a thread!");
      if (!(this.initialNode.isTreated())){
        this.initialNode.setTreatmentNbr(this.graph.nodesTreated());
        int neighbours=this.initialNode.nbrOfNeighbours();
        for (int i=0;i<neighbours;i++){
          (new Thread(new ThreadParcours(this.graph,this.initialNode.getNeighbourAt(i)))).start();
        }
      this.initialNode.gotExplored();
      }
    }
  }

  public static void main(String[] args){
    Graph g= new Graph();
    TreatableNode n=g.getRandomNode();
    (new Thread(new ThreadParcours(g,n))).start();

  }
}
