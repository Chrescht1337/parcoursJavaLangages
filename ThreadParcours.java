//Christian Frantzen - 000394691 - BA2 INFO
import java.util.Random;
public class ThreadParcours implements Runnable{
  private TreatableNode initialNode;

  private Graph graph;
  private static int nbrOfNodes;

  public ThreadParcours(Graph graph,TreatableNode initialNode){
    this.graph=graph;
    this.initialNode=initialNode;
  }

  public void run(){
    //System.out.println(this.nodeCounter.getNbrOfNodesTreated());
    //if (this.graph.getNbrOfNodes()!=this.nodeCounter.getNbrOfNodesTreated()){
    if (!NodeCounter.nodesAllTreated()){
      if (!this.initialNode.isTreated()){
        this.initialNode.setTreatmentNbr();
        Random r=new Random();
        int neighbours=this.initialNode.nbrOfNeighbours();
        for (int i=0;i<neighbours;i++){
          (new Thread(new ThreadParcours(graph,this.initialNode.getNeighbourAt(i)))).start();
           try{
             Thread.sleep(r.nextInt(500));
           }catch (InterruptedException e) {}
        }
      }
    }
    this.initialNode.gotExplored();
  }
}
