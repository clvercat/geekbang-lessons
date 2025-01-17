package org.geektimes.projects.user.web.controller;

import java.util.List;
import org.geektimes.context.ClassicComponentContext;
import org.geektimes.web.mvc.controller.PageController;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.Path;

/**
 * 输出 “Hello,World” Controller
 */
@Path("/hello")
public class HelloWorldController implements PageController {

    @GET
    @POST
    @Path("/world") // /hello/world -> HelloWorldController
    public String execute(HttpServletRequest request, HttpServletResponse response) throws Throwable {
        ClassicComponentContext instance = ClassicComponentContext.getInstance();
        List<String> componentNames = instance.getComponentNames();
        System.out.println("ComponentContext componentNames:");
        System.out.println(componentNames);
        return "index.jsp";
    }
}
