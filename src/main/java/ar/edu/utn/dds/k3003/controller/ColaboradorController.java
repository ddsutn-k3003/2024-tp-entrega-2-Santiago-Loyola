package ar.edu.utn.dds.k3003.controller;

import ar.edu.utn.dds.k3003.app.Fachada;
import ar.edu.utn.dds.k3003.facades.dtos.ColaboradorDTO;
import io.javalin.http.Context;
import io.javalin.http.HttpStatus;
import org.jetbrains.annotations.NotNull;

public class ColaboradorController {

  private final Fachada fachada;
  public ColaboradorController(Fachada fachada) {
    this.fachada = fachada;
  }

  public void agregar(@NotNull Context context){
    try {
      var colDto = context.bodyAsClass(ColaboradorDTO.class);

      if (colDto == null) {
        throw new IllegalArgumentException("Error de solicitud");
      }
      var colDtoRta = this.fachada.agregar(colDto);
      context.json(colDtoRta);
      context.status(HttpStatus.CREATED);
      context.result("Colaborador agregado correctamente");

    } catch (IllegalArgumentException e){
      context.status(HttpStatus.BAD_REQUEST);
      context.result("Error 400" + e.getMessage());
    }
  }

  public void devolverCol(@NotNull Context context){
    var id = context.pathParamAsClass("id", Long.class).get();
    var colDtoRta = fachada.buscarXId(id);
    try{
      if(colDtoRta == null){
        throw new IllegalArgumentException("Colaborador no encontrado");
      }
      context.json(colDtoRta);
      context.status(HttpStatus.ACCEPTED);
      context.result("Colaborador encontrado");

    } catch (IllegalArgumentException e){
      context.status(HttpStatus.BAD_REQUEST);
      context.result("Error 404"+ e.getMessage());
    }
  }

  public void modificarFormas (@NotNull Context context) {
    var id = context.pathParamAsClass("id", Long.class).get();
    var colDto = fachada.buscarXId(id);
    try{
      if(colDto == null){
        throw new IllegalArgumentException("Error de solicitud");
      }

      var colDtoRta = fachada.modificar(id,colDto.getFormas());
      context.json(colDtoRta);
      context.status(HttpStatus.CREATED);
      context.result("Colaborador modificado correctamente");

    } catch (IllegalArgumentException e){
      context.status(HttpStatus.BAD_REQUEST);
      context.result("Error 400" + e.getMessage());
    }
  }

  public void obtenerPuntos(@NotNull Context context) {

  }
}
