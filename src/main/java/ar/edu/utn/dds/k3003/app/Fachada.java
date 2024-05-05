package ar.edu.utn.dds.k3003.app;

import ar.edu.utn.dds.k3003.model.Colaborador;
import ar.edu.utn.dds.k3003.repositories.ColaboradoresMapper;
import ar.edu.utn.dds.k3003.facades.FachadaLogistica;
import ar.edu.utn.dds.k3003.facades.FachadaViandas;
import ar.edu.utn.dds.k3003.facades.dtos.FormaDeColaborarEnum;
import ar.edu.utn.dds.k3003.facades.FachadaColaboradores;
import ar.edu.utn.dds.k3003.repositories.ColaboradorRepo;
import ar.edu.utn.dds.k3003.facades.dtos.ColaboradorDTO;


import java.util.List;

public class Fachada implements FachadaColaboradores {

  private ColaboradoresMapper colaboradoresMapper;
  private ColaboradorRepo repoCol;
  private FachadaViandas fachadaViandas;
  private FachadaLogistica fachadaLogistica;
  double viandasDistribuida = 0;
  double viandasDonada = 0;



  public Fachada() {
    this.repoCol = new ColaboradorRepo();
    this.colaboradoresMapper = new ColaboradoresMapper();
  };

  @Override
  public ColaboradorDTO agregar(ColaboradorDTO colaboradorDTO){
    Colaborador nuevoColaborador = new Colaborador(colaboradorDTO.getNombre(), colaboradorDTO.getFormas());
    repoCol.save(nuevoColaborador);
    return colaboradoresMapper.map(nuevoColaborador);
  }
  @Override
  public void actualizarPesosPuntos(Double pesosDonados,Double viandasDistribuidas,Double viandasDonadas,Double tarjetasRepartidas, Double heladerasActivas ){
    viandasDistribuida = viandasDistribuidas;
    viandasDonada = viandasDonadas;
  };
  @Override
  public Double puntos(Long colaborarID){
    ColaboradorDTO colaboradorDTO = this.buscarXId(colaborarID);
    Colaborador col = colaboradoresMapper.pam(colaboradorDTO);
    double calculadosPuntos =
        (this.viandasDistribuida * fachadaLogistica.trasladosDeColaborador(colaborarID,1,2024).size()) +
            (this.viandasDonada * fachadaViandas.viandasDeColaborador(colaborarID,1,2024).size());
    col.setPuntos(calculadosPuntos);
    return calculadosPuntos;
  };

  @Override
  public ColaboradorDTO buscarXId(Long colaborarID){
    Colaborador col = repoCol.findById(colaborarID);
    return colaboradoresMapper.map(col);
  };
  @Override
  public ColaboradorDTO modificar(Long colaborarID, List<FormaDeColaborarEnum> formas){
    Colaborador col = repoCol.findById(colaborarID);
    col.setListaFormaDeColaborarEnum(formas);
    return colaboradoresMapper.map(col);
  };
  @Override
  public void setLogisticaProxy(FachadaLogistica logistica){
    this.fachadaLogistica = logistica;
  }
  @Override
  public void setViandasProxy(FachadaViandas fachadaViandas) {
    this.fachadaViandas = fachadaViandas;
  }
}
