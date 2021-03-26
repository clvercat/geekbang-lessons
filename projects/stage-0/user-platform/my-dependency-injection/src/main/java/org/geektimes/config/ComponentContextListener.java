package org.geektimes.config;

import javax.servlet.ServletContext;
import javax.servlet.ServletContextEvent;
import javax.servlet.ServletContextListener;
import org.geektimes.context.ClassicComponentContext;
import org.geektimes.context.ComponentContext;

public class ComponentContextListener implements ServletContextListener {

  @Override
  public void contextInitialized(ServletContextEvent sce) {
    ServletContext ctx = sce.getServletContext();
    ClassicComponentContext componentContext = new ClassicComponentContext();
    componentContext.init(ctx);
  }

  @Override
  public void contextDestroyed(ServletContextEvent sce) {
    ComponentContext context = ClassicComponentContext.getInstance();
    context.destroy();
  }
}
