package ar.edu.utn.dds.k3003.app;
import ar.edu.utn.dds.k3003.repositories.ColaboradorRepo;
import io.javalin.Javalin;
import io.javalin.config.JavalinConfig;

import java.util.function.Consumer;

public class WepApp {
    public static void main(String[] args) {

      Javalin app = Javalin.create(config()).start(7070);
         app.get("/", ctx -> ctx.result("Hello World"));


      ColaboradorRepo repo = new ColaboradorRepo();

      app.post("/colaboradores", new AltaColaboradoresController(repo));
      app.get("/colaboradores", new ListaDeColaboradoresController(repo));
      app.delete("/colaboradores/{ColId}",new BorrarColaboradoresController(repo));
    }
   private static Consumer<JavalinConfig> config(){
      return config -> {
        config.staticFiles.add(staticFiles -> {
          staticFiles.hostedPath ="/";
          staticFiles.directory = "/public";
        });
      };
   }

}

