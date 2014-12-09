import java.util.ArrayList;

public class TreatableNode extends Node{
  private int timesPassed;
  private boolean treated;

  public TreatableNode(String name_){
    super(name_);
    timesPassed=0;
    treated=false;
  }

}
