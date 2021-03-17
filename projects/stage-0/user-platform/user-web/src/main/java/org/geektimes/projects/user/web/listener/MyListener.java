package org.geektimes.projects.user.web.listener;

import java.lang.management.ManagementFactory;
import javax.management.MBeanServer;
import javax.management.ObjectName;
import javax.servlet.ServletContextEvent;
import javax.servlet.ServletContextListener;
import org.geektimes.projects.user.jmx.Custom;

public class MyListener implements ServletContextListener {

  @Override
  public void contextInitialized(ServletContextEvent sce) {
    try {
      ObjectName objectName = new ObjectName(
          "org.geektimes.projects.user.jmx:type=test,name=custom");
      MBeanServer server = ManagementFactory.getPlatformMBeanServer();
      Custom custom = new Custom();
      custom.setName("Jack");
      custom.setAge(10);
      custom.setNote("hello world");
      server.registerMBean(custom, objectName);
    } catch (Exception e) {
      // todo
      e.printStackTrace();
    }
  }

  @Override
  public void contextDestroyed(ServletContextEvent sce) {

  }
}
