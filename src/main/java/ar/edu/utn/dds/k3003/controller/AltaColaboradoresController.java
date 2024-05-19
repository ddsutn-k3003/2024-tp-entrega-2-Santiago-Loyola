package ar.edu.utn.dds.k3003.controller;

import ar.edu.utn.dds.k3003.app.Fachada;
import ar.edu.utn.dds.k3003.facades.dtos.ColaboradorDTO;
import ar.edu.utn.dds.k3003.model.Colaborador;
import ar.edu.utn.dds.k3003.repositories.ColaboradorRepo;
import ar.edu.utn.dds.k3003.repositories.ColaboradoresMapper;
import io.javalin.http.Context;
import io.javalin.http.Handler;
import io.javalin.http.HttpStatus;
import org.jetbrains.annotations.NotNull;

public class AltaColaboradoresController {

  private final Fachada fachada;

  public AltaColaboradoresController(Fachada fachada) {
    this.fachada = fachada;
  }

  public void agregar(@NotNull Context context) throws Exception {
    try {
      var colDto = context.bodyAsClass(ColaboradorDTO.class);

      if (colDto == null) {
        throw new IllegalArgumentException("DTO VACIO");
      }
      var colDtoRta = this.fachada.agregar(colDto);
      context.json(colDtoRta);
      context.status(HttpStatus.CREATED);
      context.result("Colaborador creado correctamente");


    } catch (IllegalArgumentException e){
      context.status(HttpStatus.BAD_REQUEST);
      context.result("Error 400" + e.getMessage());
    }
  }
}
