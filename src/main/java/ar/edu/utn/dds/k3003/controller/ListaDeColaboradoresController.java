package ar.edu.utn.dds.k3003.controller;

import ar.edu.utn.dds.k3003.app.Fachada;
import io.javalin.http.Context;
import io.javalin.http.HttpStatus;
import org.jetbrains.annotations.NotNull;

import java.util.NoSuchElementException;

public class ListaDeColaboradoresController{

  private final Fachada fachada;
  public ListaDeColaboradoresController(Fachada fachada) {
    this.fachada = fachada;
  }

  public void devolverCol(@NotNull Context context) throws Exception {
    var id = context.pathParamAsClass("id", Long.class).get();
    try{
      var colaboradorDto = this.fachada.buscarXId(id);
      context.json(colaboradorDto);
    } catch (NoSuchElementException ex){
      context.result(ex.getLocalizedMessage());
      context.status(HttpStatus.NOT_FOUND);
    }
  }
}
