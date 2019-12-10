
public class Task {

  private String name;
  private String description;
  private Integer percent;
  private Integer level;

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

}
