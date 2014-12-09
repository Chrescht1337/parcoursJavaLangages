import java.util.ArrayList;

public class TreatableNode extends Node{
  private int timesExplored;
  private int treatmentNbr;

  public TreatableNode(String name_){
    super(name_);
    this.timesExplored=0;
    this.treatmentNbr=0;

  }

  public boolean isTreated(){
    return this.treatmentNbr==0;
  }

  public void setTreatmentNbr(int i){
    if (i>0)
      this.treatmentNbr=i;
  }

  public void gotExplored(){
    this.timesExplored+=1;
  }

}
