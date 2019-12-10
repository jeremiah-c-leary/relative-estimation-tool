
import java.util.ArrayList;

public class Task {

  private String name;
  private String description;
  private Integer percent;
  private Integer level;
  private ArrayList<Integer> hours = new ArrayList<Integer>();
  private ArrayList<Integer> calculatedHours = new ArrayList<Integer>();
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
      this.updateCalculatedHours();
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

  public ArrayList<Integer> getCalculatedHours() {
      return new ArrayList<Integer>(this.calculatedHours);
  }

  public void setHours(ArrayList<Integer> input) {
      ArrayList<Integer> myTemp = new ArrayList<Integer>();
      for (Integer myHour : input) {
          myTemp.add(myHour);
      }
      this.hours = myTemp;
      this.updateCalculatedHours();
  }

  private void updateCalculatedHours() {
      ArrayList<Integer> myTemp = new ArrayList<Integer>();
      for (Integer myHour : this.hours) {
          myTemp.add(myHour * this.percent / 100);
      }
      this.calculatedHours = myTemp;
  }

  public void addSubtask(Task input) {
      this.subtasks.add(input);
  }

  public ArrayList<Task> getSubtasks() {
      return new ArrayList<Task>(this.subtasks);
  }
}
