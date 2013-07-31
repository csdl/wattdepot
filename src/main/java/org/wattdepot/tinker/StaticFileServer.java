package org.wattdepot.tinker;

import org.restlet.Application;
import org.restlet.Component;
import org.restlet.Restlet;
import org.restlet.data.LocalReference;
import org.restlet.data.Protocol;
import org.restlet.resource.Directory;
import org.restlet.routing.Router;

public class StaticFileServer {

  public static final String ROOT_URI = "file:///Users/rbrewer/";

  /**
   * @param args
   * @throws Exception Something bad happened.
   */
  public static void main(String[] args) throws Exception {

    Component component = new Component();
    component.getServers().add(Protocol.HTTP, 8182);
//    component.getClients().add(Protocol.FILE);
    component.getClients().add(Protocol.CLAP);

    // Create an application
    Application application = new Application() {
      @Override
      public Restlet createInboundRoot() {
        Router router = new Router(getContext());
        // Directory directory = new Directory(getContext(), ROOT_URI);
////        String path = "file://" + System.getProperty("user.dir") + "/src/main/resources/spa";
////        System.out.println("path: " + path);
//        Directory directory = new Directory(getContext(), path);
        Directory directory = new Directory(getContext(),
            LocalReference.createClapReference(LocalReference.CLAP_CLASS,
                    "/spa"));
        directory.setIndexName("index.html");
//        directory.setDeeplyAccessible(true);
        router.attach("/spa/", directory);
        // Directory directory = new Directory(getContext(), "clap://application/spa/");

        return router;
      }
    };

    // Attach the application to the component and start it
    component.getDefaultHost().attach("/wattdepot", application);
    component.start();
  }

}
