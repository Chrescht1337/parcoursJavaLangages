//Christian Frantzen - 000394691 - BA2 INFO
public final class NodeCounter{
  private static int count=0;
  private static int totalNodes;
  private NodeCounter(){
  }
  public static synchronized int getTreatmentNbr(){
    count+=1;
    totalNodes-=1;
    return count;
  }

  public static synchronized boolean nodesAllTreated(){
    return totalNodes==0;
  }

  public static void setNbrOfNodes(int i){
    totalNodes=i;
  }

  public static synchronized int getNbrOfNodesTreated(){
    return count;
  }

  public static void reset(int i){
    count=0;
    totalNodes=i;
  }

}
