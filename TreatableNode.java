import java.util.ArrayList;

public class TreatableNode extends Node{
  private int timesExplored;
  private int treatmentNbr;
  private ArrayList<TreatableNode> neighbours;


  public TreatableNode(){
    super();
    this.timesExplored=0;
    this.treatmentNbr=0;
    this.neighbours= new ArrayList<TreatableNode>();
  }

  public synchronized boolean isTreated(){
    return this.treatmentNbr!=0;
  }

  public synchronized void setTreatmentNbr(int i){
    if (i>0)
      this.treatmentNbr=i;
  }

  public synchronized void gotExplored(){
    this.timesExplored+=1;
  }

  public void reset(){
    this.timesExplored=0;
    this.treatmentNbr=0;
  }

  public int nbrOfNeighbours(){
    return this.neighbours.size();
  }

  public void addNeighbour(TreatableNode n){
    if (!(this.neighbours.contains(n))){
      this.neighbours.add(n);
    }
  }

  public TreatableNode getNeighbourAt(int i){
    return this.neighbours.get(i);
  }


  public String toString(){
    StringBuilder result = new StringBuilder();
    result.append("Node " +this.getName());
    result.append(" : passed as "+this.treatmentNbr +",");
//    result.append("Node " +this.getName());
    result.append(" passed "+this.timesExplored + " times.");
    return result.toString();
  }

}
