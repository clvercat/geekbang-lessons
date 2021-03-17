package org.geektimes.projects.user.jmx;

public class Custom implements CustomMBean {

  private String name;

  private int age;

  private String note;

  @Override
  public String getName() {
    return this.name;
  }

  @Override
  public void setName(String name) {
    this.name = name;
  }

  @Override
  public int getAge() {
    return this.age;
  }

  @Override
  public void setAge(int age) {
    this.age = age;
  }

  @Override
  public String getNote() {
    return this.note;
  }

  @Override
  public void setNote(String note) {
    this.note = note;
  }

  @Override
  public String toString() {
    return "Custom{" +
        "name='" + name + '\'' +
        ", age=" + age +
        ", note='" + note + '\'' +
        '}';
  }
}
