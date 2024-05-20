package ar.edu.utn.dds.k3003.app;
import ar.edu.utn.dds.k3003.controller.*;
import io.javalin.Javalin;

public class WepApp {
    public static void main(String[] args) {

      var fachada = new Fachada();
      Javalin app = Javalin.create().start(8081);
         app.get("/", ctx -> ctx.result("Hello World"));



      var actualizarPesosSegunFormulaController = new ActualizarPesosSegunFormulaController(fachada);
      var colaboradorController = new ColaboradorController(fachada);

      app.post("/colaboradores", colaboradorController::agregar);
      app.get("/colaboradores/{colaboradorId}", colaboradorController:: devolverCol);
      app.patch("/colaboradores/{colaboradorId}",colaboradorController :: modificarFormas);
      app.get("/colaboradores/{colaboradorId}/puntos", colaboradorController::obtenerPuntos);
      app.post("/formula", actualizarPesosSegunFormulaController::actualizar);

    }

 /*  private static Consumer<JavalinConfig> config(){
      return config -> {
        config.staticFiles.add(staticFiles -> {
          staticFiles.hostedPath ="/";
          staticFiles.directory = "/public";
        });
      };
   }*/
}

