import java.util.ArrayList;
 

public class Group {
  private int count;
  private ArrayList<Frog> frogs;
       
  public Group() {
    count = 0;
    frogs = new ArrayList<>();
}
 
  
   public void addFrog(Frog f) {
    
    int index = 0;
    while (index < count && f.getName().compareTo(frogs.get(index).getName()) > 0) {
        index++;
    }

    frogs.add(index, f);
    count++;
   
}


  public int size() {
    return count;
  }


  public Frog get(int i) {
      return frogs.get(i);
     
  }


   public Group[] halfGroups() {
    int halfSize = count / 2;

    Group group1 = new Group();
    Group group2 = new Group();

    for (int i = 0; i < frogs.size(); i++) {
        Frog frog = frogs.get(i);
        if (i < halfSize) {
            group1.addFrog(frog);
        } else {
            group2.addFrog(frog);
        }
    }

    Group[] result = new Group[2];
    result[0] = group1;
    result[1] = group2;
    return result;
}



  @Override
  public String toString() {
    return frogs.toString();
  }

  public static boolean FrogEquals(Group g1, Group g2) {

          
    if (g1.size() != g2.size()) {
        return false;
    }else if(g1.size() == 1){

      Frog frog1 = g1.get(0);
      Frog frog2 = g2.get(0);
      return frog1.equals(frog2);

    }else{

        Group[]  g1Split = g1.halfGroups();
        Group[]  g2Split = g2.halfGroups();

        
        if ( g1Split[0].size() % 2 == 0 &&  g2Split[0].size() % 2 == 0) {
            if(FrogEquals(g1Split[0], g2Split[0]) || FrogEquals(g2Split[1], g1Split[1])){
                  return true;
            }
      
        }  
        boolean eqCross1 = FrogEquals(g1Split[0], g2Split[1]) || FrogEquals(g1Split[1], g2Split[0]);
        boolean eqCross2 = FrogEquals(g1Split[0], g2Split[0]) || FrogEquals(g1Split[1], g2Split[0]);
          
        return eqCross1 || eqCross2;   
      }
  }  
 
}

