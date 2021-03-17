package org.geektimes.projects.user.jmx;

public interface CustomMBean {

  String getName();

  void setName(String name);

  int getAge();

  void setAge(int age);

  String getNote();

  void setNote(String note);
}
