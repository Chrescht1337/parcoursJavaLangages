import java.util.Random;
class MainFile{
  public static void main(String[] args){
    Graph g= new Graph();
    System.out.print("Graph of ");
    System.out.print(g.getNbrOfNodes());
    System.out.println(" nodes created.");
    Random r = new Random();
    int i= r.nextInt(4)+3;
    System.out.print("There will be ");System.out.print(i);System.out.println(" scans.");
    for (int j=1;j<=i;j++){
      System.out.println();
      System.out.print("Scan ");System.out.print(j);System.out.println(" : ");
      TreatableNode n=g.getRandomNode();
      NodeCounter.setNbrOfNodes(g.getNbrOfNodes());
      ThreadParcours tp=new ThreadParcours(g,n);
      (new Thread(tp)).start();
      while (Thread.activeCount()!=1){ //on attend la fin des Threads faisant le parcours
        try{
          Thread.sleep(1000);
        }catch (InterruptedException ex){}
      }
      g.print();
      NodeCounter.reset(g.getNbrOfNodes());
      g.reset();
    }
  }
}
