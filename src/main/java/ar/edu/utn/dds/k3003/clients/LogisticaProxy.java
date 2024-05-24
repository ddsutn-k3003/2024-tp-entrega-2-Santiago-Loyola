package ar.edu.utn.dds.k3003.clients;

import ar.edu.utn.dds.k3003.facades.FachadaHeladeras;
import ar.edu.utn.dds.k3003.facades.FachadaLogistica;
import ar.edu.utn.dds.k3003.facades.FachadaViandas;
import ar.edu.utn.dds.k3003.facades.dtos.RutaDTO;
import ar.edu.utn.dds.k3003.facades.dtos.TrasladoDTO;
import ar.edu.utn.dds.k3003.facades.exceptions.TrasladoNoAsignableException;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

import java.util.List;
import java.util.NoSuchElementException;

public class LogisticaProxy implements FachadaLogistica {

  private String endpoint;
  private ViandasRetrofitClient service;
  public void ViandasProxy() {

    var env = System.getenv();
    this.endpoint = env.getOrDefault("URL_Logistica", "http://localhost:8081/");

    var retrofit =
        new Retrofit.Builder()
            .baseUrl(this.endpoint)
            .addConverterFactory(GsonConverterFactory.create())
            .build();

    this.service = retrofit.create(ViandasRetrofitClient.class);
  }
  @Override
  public RutaDTO agregar(RutaDTO rutaDTO) {
    return null;
  }

  @Override
  public TrasladoDTO buscarXId(Long aLong) throws NoSuchElementException {
    return null;
  }

  @Override
  public TrasladoDTO asignarTraslado(TrasladoDTO trasladoDTO) throws TrasladoNoAsignableException {
    return null;
  }

  @Override
  public List<TrasladoDTO> trasladosDeColaborador(Long aLong, Integer integer, Integer integer1) {
    return null;
  }

  @Override
  public void setHeladerasProxy(FachadaHeladeras fachadaHeladeras) {

  }

  @Override
  public void setViandasProxy(FachadaViandas fachadaViandas) {

  }

  @Override
  public void trasladoRetirado(Long aLong) {

  }

  @Override
  public void trasladoDepositado(Long aLong) {

  }
}
