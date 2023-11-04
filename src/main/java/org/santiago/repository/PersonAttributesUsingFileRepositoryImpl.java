package org.santiago.repository;

import org.santiago.model.PersonAttributes;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.stream.Stream;

public class PersonAttributesUsingFileRepositoryImpl implements PersonAttributesRepository{
    private static final Logger logger = LoggerFactory.getLogger( PersonAttributesUsingFileRepositoryImpl.class);
    private List<PersonAttributes> listOfPeople;
    public PersonAttributesUsingFileRepositoryImpl() {
        this.listOfPeople = new ArrayList<>(loadPeople());//Al momento de construir el Repository se cargan los datos desde el archivo
    }

    private List<PersonAttributes> loadPeople(){
        logger.info( "Cargando los datos desde archivo" );
        List<String> plainTextPeobleList =  readFileWithPeople();
        List<PersonAttributes> listOfPeople = plainTextPeobleList.stream().map( this::buildPeople ).toList();
        return listOfPeople;
    }

    private List<String> readFileWithPeople(){
        //Este método lee el archivo y adiciona cada linea en una posicion de una Lista

        //Para el ejercicio se utiliza la ruta donde se encentra el archivo en el codigo fuente.
        //Este ruta es diferente al momento de empaquetar el proyecto

        Path path = Paths.get( "./src/main/resources/BD.txt");
        try (Stream<String> stream = Files.lines( path)) {
            return stream.toList();
        } catch (IOException x) {
            logger.error("IOException: {0}", x);
        }
        return Collections.emptyList();//Devuelve una lista vacía
    }

    private PersonAttributes buildPeople(String plainTextGrade){
    /*Este metodo toma una linea del archivo para generar un vector
   y con dicho vector generar una Nota
     */
        String[] questionArray = plainTextGrade.split(",");//En el archivo las notas vienen separadas por comas por ejemplo: UNIDAD 1,4.5D,2023-08-01

        PersonAttributes personAttributes = new PersonAttributes( questionArray[0], questionArray[1],
                Integer.parseInt(questionArray[2]), questionArray[3].charAt(0),
                Boolean.parseBoolean(questionArray[4]), Integer.parseInt(questionArray[5]),
                Integer.parseInt(questionArray[6]), questionArray[7],
                Double.parseDouble(questionArray[8]));

        return personAttributes;
    }

    @Override
    public List<PersonAttributes> findAllPersons() {
        return listOfPeople;
    }
}
