import java.util.Random;
public class ThreadParcours implements Runnable{
  private TreatableNode initialNode;

  private static Graph graph;
  private static int nbrOfNodes;
  private static int nbrOfnodesTreated=0;

  public ThreadParcours(Graph graph,TreatableNode initialNode){
    this.graph=graph;
    this.initialNode=initialNode;
    this.nbrOfNodes=this.graph.getNbrOfNodes();
  }

  public static void reset(){
    nbrOfnodesTreated=0;
  }

  // private static void newThread(TreatableNode n, int i){
  //
  //   (new Thread(new ThreadParcours(graph,n.getNeighbourAt(i)))).start();
  //   Random r=new Random();
  //   try{
  //     Thread.sleep(r.nextInt(100));
  //   }catch (InterruptedException e) {}
  // }

  private static synchronized void setTreatmentNbr(TreatableNode n){
    if (!(n.isTreated())){
      nbrOfnodesTreated+=1;
      n.setTreatmentNbr(nbrOfnodesTreated);
    }
    n.gotExplored();

  }

  public void run(){
    if (this.nbrOfNodes!=nbrOfnodesTreated){
      setTreatmentNbr(this.initialNode);
      Random r=new Random();
      int neighbours=this.initialNode.nbrOfNeighbours();
      for (int i=0;i<neighbours;i++){
        if (nbrOfNodes!=nbrOfnodesTreated){
          (new Thread(new ThreadParcours(graph,this.initialNode.getNeighbourAt(i)))).start();
           try{
             Thread.sleep(r.nextInt(500));
           }catch (InterruptedException e) {}
        }
      }
    }
  }  //if(this.graph.nodesAllTreated()){
    //System.out.println(this.initialNode);
      //this.graph.print();
    //}



  public static void main(String[] args){
    Graph g= new Graph();
    TreatableNode n=g.getRandomNode();
    ThreadParcours tp=new ThreadParcours(g,n);

    (new Thread(tp)).start();
    while (Thread.activeCount()!=1){}
    g.print();
    g.reset();
    tp.reset();
    //n=g.getRandomNode();
    //System.out.println();
    //System.out.println();
    //System.out.println(Thread.activeCount());
    // while (Thread.activeCount()!=1){}
    // System.out.println("start");
    // (new Thread(new ThreadParcours(g,n))).start();
    // while (Thread.activeCount()!=1){}
    // g.print();
    // g.reset();
    // n=g.getRandomNode();
    // System.out.println();
    // System.out.println();
    // System.out.println();
    // while (Thread.activeCount()!=1){}
    // (new Thread(new ThreadParcours(g,n))).start();
    // while (Thread.activeCount()!=1){}
    // g.print();
    // g.reset();
    // n=g.getRandomNode();
    // System.out.println();
    // System.out.println();
    // System.out.println();
    // while (Thread.activeCount()!=1){}
    // (new Thread(new ThreadParcours(g,n))).start();
    // while (Thread.activeCount()!=1){}
    // g.print();
    //g.reset();
    //n=g.getRandomNode();

  }
}
