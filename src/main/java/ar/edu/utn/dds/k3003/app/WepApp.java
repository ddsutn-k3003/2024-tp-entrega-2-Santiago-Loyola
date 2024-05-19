package ar.edu.utn.dds.k3003.app;
import ar.edu.utn.dds.k3003.controller.*;
import io.javalin.Javalin;

public class WepApp {
    public static void main(String[] args) {

      var fachada = new Fachada();
      Javalin app = Javalin.create().start(8081);
         app.get("/", ctx -> ctx.result("Hello World"));


      var altaColaboradoresController = new AltaColaboradoresController(fachada);
      var listaDeColaboradoresController = new ListaDeColaboradoresController(fachada);
      var modificarFormasDeColaborarController = new ModificarFormasDeColaborarController(fachada);
      var obtenerPuntosController = new ObtenerPuntosController(fachada);
      var actualizarPesosSegunFormulaController = new ActualizarPesosSegunFormulaController(fachada);

      app.post("/colaboradores", altaColaboradoresController::agregar);
      app.get("/colaboradores/{colaboradorId}", listaDeColaboradoresController:: devolverCol);
      app.patch("/colaboradores/{colaboradorId}",modificarFormasDeColaborarController :: modificarFormas);
      app.get("/colaboradores/{colaboradorId}/puntos", obtenerPuntosController::obtener);
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

