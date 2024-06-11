package org.stefanini.backstefanini.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import org.stefanini.backstefanini.model.Persona;
import org.stefanini.backstefanini.model.enums.TipoDocumento;

import java.util.Optional;

@Repository
public interface PersonaRepository extends JpaRepository<Persona,Long> {
    Optional<Persona> findByIdAndTipoDocumento(Long id, TipoDocumento tipoDocumento);
}
