package ar.edu.utn.dds.k3003.model;

import ar.edu.utn.dds.k3003.facades.dtos.FormaDeColaborarEnum;

import java.util.List;


public class Colaborador {
  private Long ID;
  private String nombre;
  private Double puntos;

  public void setPuntos(Double puntos) {
    this.puntos = puntos;
  }

  private List<FormaDeColaborarEnum> listaFormaDeColaborarEnum;
  public Colaborador(String nombre,List<FormaDeColaborarEnum> formaDeColaborarEnum){
    this.nombre = nombre;
    this.listaFormaDeColaborarEnum = formaDeColaborarEnum;
  }
  public List<FormaDeColaborarEnum> getListaFormaDeColaborarEnum() {
    return listaFormaDeColaborarEnum;
  }

  public void setListaFormaDeColaborarEnum(List<FormaDeColaborarEnum> listaFormaDeColaborarEnum) {
    this.listaFormaDeColaborarEnum = listaFormaDeColaborarEnum;
  }

  public Long getId() {
    return ID;
  }
  public void setId(Long ID) {
    this.ID = ID;
  }
  public String getNombre() {
    return nombre;
  }
  public Double getPuntos() {
    return puntos;
  }

}
