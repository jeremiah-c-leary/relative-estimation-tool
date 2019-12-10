
import java.util.ArrayList;

public class Task {

  private String name;
  private String description;
  private Integer percent;
  private Integer level;
  private ArrayList<Integer> hours = new ArrayList<Integer>();
  private ArrayList<Task> subtasks = new ArrayList<Task>();

  public Task() {
      name = "";
      description = "";
      percent = 0;
      level = 0;
  }

  public String getName() {
      return this.name;
  }

  public void setName(String input) {
      this.name = input;
  }

  public String getDescription() {
      return this.description;
  }

  public void setDescription(String input) {
      this.description = input;
  }

  public Integer getPercent() {
      return this.percent;
  }

  public void setPercent(Integer input) {
      this.percent = input;
  }

  public Integer getLevel() {
      return this.level;
  }

  public void setLevel(Integer input) {
      this.level = input;
  }

  public ArrayList<Integer> getHours() {
      return new ArrayList<Integer>(this.hours);
  }

  public void updateHours(ArrayList<Integer> input) {
      ArrayList<Integer> myTemp = new ArrayList<Integer>();
      Integer myPercent;
      for (Integer myHour : input) {
          myPercent = myHour * this.percent / 100;
          myTemp.add(myPercent);
      }
      this.hours = myTemp;
  }

  public ArrayList<Task> getSubtasks() {
      return new ArrayList<Task>(this.subtasks);
  }
}
