package ar.edu.utn.dds.k3003.app;

import ar.edu.utn.dds.k3003.repositories.ColaboradorRepo;
import io.javalin.http.Context;
import io.javalin.http.Handler;
import org.jetbrains.annotations.NotNull;

public class ListaDeColaboradoresController implements Handler {

  private ColaboradorRepo repo;
  public ListaDeColaboradoresController(ColaboradorRepo repo) {
    super();
    this.repo = repo;
  }

  @Override
  public void handle(@NotNull Context context) throws Exception {
    context.json(repo.getColaboradores());
  }
}
