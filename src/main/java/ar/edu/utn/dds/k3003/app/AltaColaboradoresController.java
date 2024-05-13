package ar.edu.utn.dds.k3003.app;

import ar.edu.utn.dds.k3003.model.Colaborador;
import ar.edu.utn.dds.k3003.repositories.ColaboradorRepo;
import io.javalin.http.Context;
import io.javalin.http.Handler;
import io.javalin.http.HttpStatus;
import org.jetbrains.annotations.NotNull;

public class AltaColaboradoresController implements Handler {

  ColaboradorRepo repo = new ColaboradorRepo();
  public AltaColaboradoresController(ColaboradorRepo repo) {
    super();
    this.repo = repo;
  }

  @Override
  public void handle(@NotNull Context context) throws Exception {
    Colaborador col =context.bodyAsClass(Colaborador.class);
    this.repo.save(col);
    context.status(HttpStatus.CREATED);
    context.result("Colaborador creado correctamente");
  }
}
