package ar.edu.utn.dds.k3003.repositories;
import ar.edu.utn.dds.k3003.model.Colaborador;

import java.util.*;
import java.util.concurrent.atomic.AtomicLong;

public class ColaboradorRepo {
  private AtomicLong seqId = new AtomicLong();
  Collection<Colaborador> colaboradores;
  public ColaboradorRepo() {
    this.colaboradores = new ArrayList<>();
  }
  public Colaborador save(Colaborador colaborador) {
    if (Objects.isNull(colaborador.getId())) {
      colaborador.setId(seqId.getAndIncrement());
      this.colaboradores.add(colaborador);
    }
    return colaborador;
  }
  public Colaborador findById(Long id) {
    Optional<Colaborador> first = this.colaboradores.stream().filter(x -> x.getId().equals(id)).findFirst();
    return first.orElseThrow(() -> new NoSuchElementException(
        String.format("No hay una ruta de id: %s", id)
    ));
  }
}
