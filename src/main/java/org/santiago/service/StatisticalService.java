package org.santiago.service;

import java.math.BigDecimal;
// interfas donde se definen los metodos a utilizar, los cuales permitiran realizar los calgulos estadisticos mediante
// su implementacion
public interface StatisticalService {
    int countNumberOfPeople();
    BigDecimal getAverageAgeUnemployed();
    BigDecimal getAverageStratumUnemployed();
    BigDecimal getAverageNumberOfChildrenUnemployed();
    BigDecimal getAverageSalaryUnemployed();
    BigDecimal getAverageSalary();
    String getTrendEducationalLevel();
    Double getMedianAge();
    Double getMedianStratum();
    Double getMedianNumberOfChildren();
    Double getPercentageMen();
    Double getPercentageWoman();
}