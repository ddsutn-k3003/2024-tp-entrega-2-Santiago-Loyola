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

  public void agregar(@NotNull Context context) {
    try {
      var colDto = context.bodyAsClass(ColaboradorDTO.class);

      if (colDto == null) {
        throw new IllegalArgumentException("Error de solicitud");
      }
      var colDtoRta = this.fachada.agregar(colDto);
      context.json(colDtoRta);
      context.status(HttpStatus.OK);
      context.result("Colaborador agregado correctamente");

    } catch (IllegalArgumentException e) {
      context.status(HttpStatus.BAD_REQUEST);
      context.result("Error 400" + e.getMessage());
    }
  }

  public void buscarXId(@NotNull Context context) {
    var id = context.pathParamAsClass("id", Long.class).get();
    var colDtoRta = fachada.buscarXId(id);
    try {
      if (colDtoRta == null) {
        throw new IllegalArgumentException("Colaborador no encontrado");
      }
      context.json(colDtoRta);
      context.status(HttpStatus.OK);
      context.result("Colaborador encontrado");

    } catch (IllegalArgumentException e) {
      context.status(HttpStatus.NOT_FOUND);
      context.result("Error 404" + e.getMessage());
    }
  }

  public void modificar(@NotNull Context context) {
    var id = context.pathParamAsClass("id", Long.class).get();
    var colDtoRta = fachada.buscarXId(id);
    try {
      if (colDtoRta == null) {
        throw new IllegalArgumentException("Error de solicitud");
      }
      var colDtoRtaF = fachada.modificar(id, colDtoRta.getFormas());
      context.json(colDtoRtaF);
      context.status(HttpStatus.OK);
      context.result("Colaborador modificado correctamente");

    } catch (IllegalArgumentException e) {
      context.status(HttpStatus.BAD_REQUEST);
      context.result("Error 400" + e.getMessage());
    }
  }

  public void puntos(@NotNull Context context) {
    var id = context.pathParamAsClass("id", Long.class).get();
    var colDtoRta = fachada.buscarXId(id);
    try {
      if (colDtoRta == null) {
        throw new IllegalArgumentException("Error: response status is 404");
      }
      var puntos = fachada.puntos(id);
      context.json(puntos);
      context.status(HttpStatus.OK);
      context.result("Puntos obtenidos correctamente");

    } catch (IllegalArgumentException e) {
      context.status(HttpStatus.NOT_FOUND);
      context.result("Error 404" + e.getMessage());
    }
  }

  public void actualizarPesosPuntos(@NotNull Context context) {
  }
}