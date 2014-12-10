import java.util.Random;
public class Graph{
  private int m;  //nombre de lignes
  private int n;  //nombre de colonnes
  private int nbrOfNodes;
  private int nodesTreated;
  private TreatableNode[][] graph;

  public Graph(){
    Random r=new Random();
    this.m=r.nextInt(15)+5;
    this.n=r.nextInt(15)+5;
    this.nbrOfNodes=this.m*this.n;
    this.nodesTreated=0;
    this.graph=new TreatableNode[this.m][this.n];

    String nodeNames="ABCDEFGHIJKLMNOPQRSTUVWXYZabcdefghijklmnopqrstuvwxyz";
    String tmp;

    for (int i=0;i<this.m;i++){
      for (int j=0;j<this.n;j++){
        this.graph[i][j]=new TreatableNode();
        tmp=String.valueOf(nodeNames.charAt(i))+String.valueOf(nodeNames.charAt(j));
        this.graph[i][j].setName(tmp);
      }
    }

    //on connecte les noeuds
    for (int i=0;i<this.m-1;i++){
      for (int j=1;j<this.n;j++){
        this.graph[i][j].addNeighbour(this.graph[i+1][j-1]);
      }
    }

    for (int j=0,i=this.m-1;j<this.n-1;j++){
      this.graph[i][j].addNeighbour(this.graph[i][j+1]);
    }

    for (int j=0,i=0;j<this.n-1;j++){
      this.graph[i][j].addNeighbour(this.graph[i][j+1]);
    }

    //avec ceci, on a créé un graph connexe qui se ressemble tjrs
    this.graph[this.m-1][this.n-1].addNeighbour(this.graph[0][0]);

    //on ajoute des connections aléatoires
    int randomEffects=r.nextInt(20)+10;
    for (int k=0;k<randomEffects;k++){
      int i=r.nextInt(this.m);
        for (int j=0;j<this.n;j++){
          this.graph[i][j].addNeighbour(this.graph[r.nextInt(this.m)][r.nextInt(this.n)]);
        }
      }
    }

  public TreatableNode getRandomNode(){
    Random r=new Random();
    return this.graph[r.nextInt(this.m)][r.nextInt(this.n)];
  }

  public int getNbrOfNodes(){
    return this.nbrOfNodes;
  }

  public synchronized int nodesTreated(){
    this.nodesTreated+=1;
    return this.nodesTreated;
  }

  public synchronized boolean nodesAllTreated(){
    return this.nodesTreated==this.nbrOfNodes;
  }

  public void reset(){
    for (int i=0;i<this.m;i++){
      for (int j=0;j<this.n;j++){
        this.graph[i][j].reset();
      }
    }
  }

  public void print(){
    for (int i=0;i<this.m;i++){
      for (int j=0;j<this.n;j++){
        System.out.println(this.graph[i][j]);
      }
    }
  }
}
