package ar.edu.utn.dds.k3003.repositories;
import ar.edu.utn.dds.k3003.facades.dtos.ColaboradorDTO;
import ar.edu.utn.dds.k3003.model.Colaborador;

public class ColaboradoresMapper {

  public ColaboradoresMapper() {
  }

  public ColaboradorDTO map(Colaborador colaborador) {
    ColaboradorDTO colaboradorDTO = new ColaboradorDTO(colaborador.getNombre(),colaborador.getListaFormaDeColaborarEnum());
    colaboradorDTO.setId(colaborador.getId());
    return colaboradorDTO;
  }
  public Colaborador pam(ColaboradorDTO colaboradorDTO) {
    Colaborador colaborador = new Colaborador(colaboradorDTO.getNombre(),colaboradorDTO.getFormas());
    colaborador.setId(colaborador.getId());
    return colaborador;
  }
}
