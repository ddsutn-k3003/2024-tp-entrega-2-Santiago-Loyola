package ar.edu.utn.dds.k3003.clients;

import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

public class RetrofitClient {
  private static RetrofitClient instancia = null;
  private static final String urlAbsoluta = "https://apis.datos.gob.ar/georef/api/";
  private Retrofit retrofit;

  private RetrofitClient() {
    this.retrofit = new Retrofit.Builder()
    .baseUrl(urlAbsoluta)
    .addConverterFactory(GsonConverterFactory.create())
    .build();
  }

  public static RetrofitClient getInstance(String baseUrl){
    if(instancia == null){
      instancia = new RetrofitClient();
    }
    return instancia;
  }
}
