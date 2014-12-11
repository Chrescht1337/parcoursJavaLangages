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



  public static void main(String[] args){
    Graph g= new Graph();
    System.out.println(g.getNbrOfNodes());
    TreatableNode n=g.getRandomNode();
    NodeCounter.setNbrOfNodes(g.getNbrOfNodes());
    ThreadParcours tp=new ThreadParcours(g,n);
    (new Thread(tp)).start();
    while (Thread.activeCount()!=1){}
    g.print();
    NodeCounter.reset(g.getNbrOfNodes());
    g.reset();


    n=g.getRandomNode();
    System.out.println();
    System.out.println();
    System.out.println("New start");
    (new Thread(new ThreadParcours(g,n))).start();
    while (Thread.activeCount()!=1){}
    g.print();
    g.reset();
    NodeCounter.reset(g.getNbrOfNodes());
    n=g.getRandomNode();
    System.out.println();
    System.out.println();
    System.out.println();
    (new Thread(new ThreadParcours(g,n))).start();
    while (Thread.activeCount()!=1){}
    g.print();
    g.reset();
    NodeCounter.reset(g.getNbrOfNodes());
    n=g.getRandomNode();
    System.out.println();
    System.out.println();
    System.out.println();
    (new Thread(new ThreadParcours(g,n))).start();
    while (Thread.activeCount()!=1){}
    g.print();

  }
}
