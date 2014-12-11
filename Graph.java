import java.util.Random;
public class Graph{
  private static final int minLine = 25;
  private static final int minColonne = 35;
  private static final int randomEffects = 60;
  private static final String nodeNames="ABCDEFGHIJKLMNOPQRSTUVWXYZabcdefghijklmnopqrstuvwxyz";

  private int m;  //nombre de lignes
  private int n;  //nombre de colonnes
  private int nbrOfNodes;
  private int nodesTreated;
  private TreatableNode[][] graph;
  private Random random;

  public Graph(){
    this.random=new Random();
    this.m=this.random.nextInt(minLine)+minLine;
    this.m=Math.min(this.m,nodeNames.length());
    this.n=this.random.nextInt(minColonne)+minColonne;
    this.n=Math.min(this.n,nodeNames.length());
    this.nbrOfNodes=this.m*this.n;
    this.nodesTreated=0;
    this.graph=new TreatableNode[this.m][this.n];

    //String nodeNames="ABCDEFGHIJKLMNOPQRSTUVWXYZabcdefghijklmnopqrstuvwxyz";
    String tmp;

    for (int i=0;i<this.m;i++){
      for (int j=0;j<this.n;j++){
        this.graph[i][j]=new TreatableNode();
        tmp=String.valueOf(nodeNames.charAt(i))+String.valueOf(nodeNames.charAt(j));
        this.graph[i][j].setName(tmp);
      }
    }

    this.connectNodes();
  }

  private void connectNodes(){
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

    for (int i=0;i<this.m;i++){
    //les noeuds de la dernière colonne ne sont pas reférenciés par
    //d'autres noeuds
      this.graph[random.nextInt(this.m)][random.nextInt(this.n-1)].addNeighbour(this.graph[i][this.n-1]);
    }

    //avec ceci, on a créé un graph connexe qui se ressemble tjrs
    this.graph[this.m-1][this.n-1].addNeighbour(this.graph[0][0]);

    //on ajoute des connections aléatoires
    int randomEffs=this.random.nextInt(randomEffects)+randomEffects;
    for (int k=0;k<randomEffects;k++){
      int i=this.random.nextInt(this.m);
      for (int j=0;j<this.n;j++){
        this.graph[i][j].addNeighbour(this.graph[this.random.nextInt(this.m)][this.random.nextInt(this.n)]);
      }
    }
  }

  public TreatableNode getRandomNode(){
    Random r=new Random();
    return this.graph[r.nextInt(this.m)][r.nextInt(this.n)];
  }

  public synchronized int getNbrOfNodes(){
    return this.nbrOfNodes;
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
