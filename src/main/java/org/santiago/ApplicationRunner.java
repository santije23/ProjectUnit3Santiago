package org.santiago;

import org.santiago.repository.PersonAttributesRepositoryImpl;
import org.santiago.service.StatisticalService;
import org.santiago.service.StatisticalServiceImpl;


import java.math.RoundingMode;


public class ApplicationRunner {

    public static void main(String[] args) {
        PersonAttributesRepositoryImpl objetPersonAttributesRepository = new PersonAttributesRepositoryImpl();
        StatisticalService objectStatisticalService = new StatisticalServiceImpl(objetPersonAttributesRepository);

        int totalPeople = objectStatisticalService.countNumberOfPeople();
        System.out.println("El numero de personas registradas es: "+ objectStatisticalService.countNumberOfPeople());
        System.out.println("Del total de personas que equivale a "+totalPeople+" personas, el promedio de edad de las personas desempleadas es de "
                + ""+objectStatisticalService.getAverageAgeUnemployed().setScale(0, RoundingMode.HALF_UP)+" años");
        System.out.println("Del total de personas que equivale a "+totalPeople+" personas, el promedio de estrato de las personas desempleadas es de "
                + ""+objectStatisticalService.getAverageStratumUnemployed().setScale(0, RoundingMode.HALF_UP));
        System.out.println("Del total de personas que equivale a "+totalPeople+" personas, el promedio de numero de hijos de las personas desempleadas es de "
                + ""+objectStatisticalService.getAverageNumberOfChildrenUnemployed().setScale(0, RoundingMode.HALF_UP));
        System.out.println("Del total de personas que equivale a "+totalPeople+" personas, el promedio de salario de las personas desempleadas es de "
                + ""+objectStatisticalService.getAverageSalaryUnemployed().setScale(2, RoundingMode.HALF_UP)+" pesos Colombianos");
        System.out.println("Del total de personas que equivale a "+totalPeople+" personas, el promedio de salario de las personas es de "
                + ""+objectStatisticalService.getAverageSalary().setScale(2, RoundingMode.HALF_UP)+" pesos Colombianos");
        System.out.println(objectStatisticalService.getTrendEducationalLevel());
        System.out.println("La mediana de la edad de las personas es "+objectStatisticalService.getMedianAge());
        System.out.println("La mediana del estrato de las personas es "+objectStatisticalService.getMedianStratum());
        System.out.println("La mediana del numero de hijos de las personas es "+objectStatisticalService.getMedianNumberOfChildren());
        System.out.println("El total de personas que equivalen a "+totalPeople+ ", el porcentaje de hombres"
                + " equivale a el "+(objectStatisticalService.getPercentageMen()*100)+"%");
        System.out.println("El total de personas que equivalen a "+totalPeople+ ", el porcentaje de mujeres"
                + " equivale a el "+(objectStatisticalService.getPercentageWoman()*100)+"%");
    }
}