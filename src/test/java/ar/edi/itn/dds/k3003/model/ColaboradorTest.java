package ar.edi.itn.dds.k3003.model;

import ar.edu.utn.dds.k3003.facades.dtos.FormaDeColaborarEnum;
import ar.edu.utn.dds.k3003.model.Colaborador;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.List;

import static ar.edu.utn.dds.k3003.facades.dtos.FormaDeColaborarEnum.DONADOR;
import static ar.edu.utn.dds.k3003.facades.dtos.FormaDeColaborarEnum.TRANSPORTADOR;
import static org.junit.jupiter.api.Assertions.assertEquals;

public class ColaboradorTest {

  @Test
  public void testColaboradorFormasDeColaborarEnumNull(){
    List<FormaDeColaborarEnum> formaDeColaborarEnums = null;
    Colaborador Santiago = new Colaborador("Santiago",formaDeColaborarEnums);

    assertEquals(null,Santiago.getListaFormaDeColaborarEnum(),"Santiago no colabora de ninguna manera");

  }
  @Test
  public void testColaboradorFormasDeColaborarEnumDONADOR(){
    List<FormaDeColaborarEnum> formaDeColaborarEnumsDONADOR = new ArrayList<>();
    formaDeColaborarEnumsDONADOR.add(DONADOR);
    Colaborador Lucas = new Colaborador("Lucas",formaDeColaborarEnumsDONADOR);

    assertEquals(formaDeColaborarEnumsDONADOR,Lucas.getListaFormaDeColaborarEnum(),"Lucas colabora como donador");

  }
  @Test
  public void testColaboradorFormasDeColaborarEnumDONADORTRANSPORTARDOR(){
    List<FormaDeColaborarEnum> formasDeColaborarEnumDONADORTRANSPORTADOR = new ArrayList<>();
    formasDeColaborarEnumDONADORTRANSPORTADOR.add(DONADOR);
    formasDeColaborarEnumDONADORTRANSPORTADOR.add(TRANSPORTADOR);
    Colaborador Juan = new Colaborador("Juan",formasDeColaborarEnumDONADORTRANSPORTADOR);

    assertEquals(formasDeColaborarEnumDONADORTRANSPORTADOR,Juan.getListaFormaDeColaborarEnum(),"Colabora como Donador y transportador");
  }
}
