package ar.edu.utn.dds.k3003.clients;

import ar.edu.utn.dds.k3003.facades.FachadaHeladeras;
import ar.edu.utn.dds.k3003.facades.FachadaViandas;
import ar.edu.utn.dds.k3003.facades.dtos.EstadoViandaEnum;
import ar.edu.utn.dds.k3003.facades.dtos.ViandaDTO;
import com.fasterxml.jackson.databind.ObjectMapper;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

import java.util.List;
import java.util.NoSuchElementException;

public class ViandaProxy implements FachadaViandas {

  private String endpoint;
  private ViandasRetrofitClient service;

  public void ViandasProxy() {

    var env = System.getenv();
    this.endpoint = env.getOrDefault("URL_VIANDAS", "http://localhost:8081/");

    var retrofit =
        new Retrofit.Builder()
            .baseUrl(this.endpoint)
            .addConverterFactory(GsonConverterFactory.create())
            .build();

    this.service = retrofit.create(ViandasRetrofitClient.class);
  }
  @Override
  public ViandaDTO agregar(ViandaDTO viandaDTO) {
    return null;
  }

  @Override
  public ViandaDTO modificarEstado(String s, EstadoViandaEnum estadoViandaEnum) throws NoSuchElementException {
    return null;
  }

  @Override
  public List<ViandaDTO> viandasDeColaborador(Long aLong, Integer integer, Integer integer1) throws NoSuchElementException {
    return null;
  }

  @Override
  public ViandaDTO buscarXQR(String s) throws NoSuchElementException {
    return null;
  }

  @Override
  public void setHeladerasProxy(FachadaHeladeras fachadaHeladeras) {

  }

  @Override
  public boolean evaluarVencimiento(String s) throws NoSuchElementException {
    return false;
  }

  @Override
  public ViandaDTO modificarHeladera(String s, int i) {
    return null;
  }
}
