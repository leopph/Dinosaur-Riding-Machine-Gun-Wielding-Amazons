public class New implements Command {
  public void execute(String[] strs, World world) {
    if (strs.length == 2) {
      if (world.getAmazonMap().containsKey(strs[1])) {
        System.out.println("ilyen amazon már van");
        return;
      } 
      world.newAmazon(strs[1]);
      System.out.println(strs[1] + " létrehozva");
      return;
    } 
    System.out.println("nem megfelelő argumentummenyiség");
  }
  
  public boolean execute() {
    return true;
  }
}
