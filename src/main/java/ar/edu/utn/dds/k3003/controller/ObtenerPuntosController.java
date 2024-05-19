package ar.edu.utn.dds.k3003.controller;

import ar.edu.utn.dds.k3003.app.Fachada;
import io.javalin.http.Context;
import org.jetbrains.annotations.NotNull;

public class ObtenerPuntosController {
  private final Fachada fachada;
  public ObtenerPuntosController(Fachada fachada) {
    this.fachada = fachada;
  }


  public void obtener(@NotNull Context context) {
  }
}
