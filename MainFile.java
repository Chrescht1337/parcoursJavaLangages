class MainFile{
  public static void main(String[] args){
    Graph g= new Graph();
    System.out.print("Graph of ");
    System.out.print(g.getNbrOfNodes());
    System.out.println(" nodes created.");
    System.out.println("There will be 4 scans.");
    System.out.println("Scan 1 : ");
    TreatableNode n=g.getRandomNode();
    NodeCounter.setNbrOfNodes(g.getNbrOfNodes());
    ThreadParcours tp=new ThreadParcours(g,n);
    (new Thread(tp)).start();
    while (Thread.activeCount()!=1){ //on attend la fin des Threads faisant le parcours
      try{
        Thread.sleep(1000);
        System.out.println(Thread.activeCount());
      }catch (InterruptedException ex){}
    }
    g.print();
    NodeCounter.reset(g.getNbrOfNodes());
    g.reset();


    System.out.println();
    System.out.println();
    System.out.println("Scan 2 : ");
    n=g.getRandomNode();
    (new Thread(new ThreadParcours(g,n))).start();
    while (Thread.activeCount()!=1){ //on attend la fin des Threads faisant le parcours
      try{
        Thread.sleep(1000);
        System.out.println(Thread.activeCount());
      }catch (InterruptedException ex){}
    }
    g.print();
    g.reset();
    NodeCounter.reset(g.getNbrOfNodes());
    System.out.println();
    System.out.println();
    System.out.println("Scan 3 : ");
    n=g.getRandomNode();
    (new Thread(new ThreadParcours(g,n))).start();
    while (Thread.activeCount()!=1){ //on attend la fin des Threads faisant le parcours
      try{
        Thread.sleep(1000);
        System.out.println(Thread.activeCount());
      }catch (InterruptedException ex){}
    }
    g.print();
    g.reset();
    NodeCounter.reset(g.getNbrOfNodes());
    System.out.println();
    System.out.println();
    System.out.println("Scan 4 : ");
    n=g.getRandomNode();
    (new Thread(new ThreadParcours(g,n))).start();
    while (Thread.activeCount()!=1){ //on attend la fin des Threads faisant le parcours
      try{
        Thread.sleep(1000);
        System.out.println(Thread.activeCount());
      }catch (InterruptedException ex){}
    }
    g.print();

  }
}
