package org.santiago.repository;

import org.santiago.model.PersonAttributes;

import java.util.List;
// Interfas entre los atributos de las personas y la implementacion de una lista con todos los campos diligenciados
public interface PersonAttributesRepository {
    List<PersonAttributes> findAllPersons();
}
