package org.santiago.service;

import org.junit.jupiter.api.Test;
import org.santiago.repository.PersonAttributesRepositoryImpl;

import java.math.BigDecimal;

import static org.junit.jupiter.api.Assertions.*;

class StatisticalServiceImplTest {

    // El siguiente metodo se realizoa para implementar un test del numero de personas que estan en la BD
    @Test
    void countNumberOfPeople() {
        PersonAttributesRepositoryImpl objetPersonAttributesRepositoryTest = new PersonAttributesRepositoryImpl();
        StatisticalService objectStatisticalServiceTest = new StatisticalServiceImpl(objetPersonAttributesRepositoryTest);

        int result = objectStatisticalServiceTest.countNumberOfPeople();
        assertTrue(result >= 0, "El número de personas no puede ser negativo");
    }

    // El siguiente metodo se realizoa para implementar un test sobre el numero de personas desempleadas a partir de la edad
    @Test
    void averageAgeUnemployed() {
        PersonAttributesRepositoryImpl objetPersonAttributesRepositoryTest = new PersonAttributesRepositoryImpl();
        StatisticalService objectStatisticalServiceTest = new StatisticalServiceImpl(objetPersonAttributesRepositoryTest);

        BigDecimal result = objectStatisticalServiceTest.getAverageAgeUnemployed();
        assertNotEquals(result, BigDecimal.ZERO, "No hay ninguna persona desempleada");
    }

    // El siguiente metodo se realizoa para implementar un test para determinar si no hay ningun hombre en la BD
    @Test
    void percentageMen() {
        PersonAttributesRepositoryImpl objetPersonAttributesRepositoryTest = new PersonAttributesRepositoryImpl();
        StatisticalService objectStatisticalServiceTest = new StatisticalServiceImpl(objetPersonAttributesRepositoryTest);

        Double result = objectStatisticalServiceTest.getPercentageMen();
        assertNotEquals(result, 0, "No hay ningun hombre para generar estadisticas");
    }

    // El siguiente metodo se realizoa para implementar test para determinar si no hay ninguna mujer en la BD
    @Test
    void percentageWoman() {
        PersonAttributesRepositoryImpl objetPersonAttributesRepositoryTest = new PersonAttributesRepositoryImpl();
        StatisticalService objectStatisticalServiceTest = new StatisticalServiceImpl(objetPersonAttributesRepositoryTest);

        Double result = objectStatisticalServiceTest.getPercentageWoman();
        assertNotEquals(result, 0, "No hay ninguna mujer para generar estadisticas");
    }
}