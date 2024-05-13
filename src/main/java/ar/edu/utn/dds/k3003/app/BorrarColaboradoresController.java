package ar.edu.utn.dds.k3003.app;

import ar.edu.utn.dds.k3003.model.Colaborador;
import ar.edu.utn.dds.k3003.repositories.ColaboradorRepo;
import io.javalin.http.Context;
import io.javalin.http.Handler;
import org.jetbrains.annotations.NotNull;

public class BorrarColaboradoresController implements Handler {

  private ColaboradorRepo repo;

  public BorrarColaboradoresController(ColaboradorRepo repo) {
    super();
    this.repo = repo;
  }

  @Override
  public void handle(@NotNull Context context) throws Exception {
    String coldId = context.pathParam("ColId");
    Colaborador col = repo.findById(Long.parseLong(coldId));
    repo.remove(col);
    context.result("Colaborador eliminado");
  }
}
