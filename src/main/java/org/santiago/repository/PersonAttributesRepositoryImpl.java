package org.santiago.repository;

import org.santiago.model.PersonAttributes;

import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

// Implementacion de la interfas que se realizo para poder almacenar atributos diligenciados de las personas
public class PersonAttributesRepositoryImpl implements PersonAttributesRepository{
    @Override
    public List<PersonAttributes> findAllPersons() {

        List<PersonAttributes> listOfPeople = new ArrayList<>();
        listOfPeople.add(new PersonAttributes("Pedro", "Carmona", 34, 'M', true, 3, 4, "Profesional", 2300000.13));
        listOfPeople.add(new PersonAttributes("Camilo", "Perez", 43, 'M', true, 4, 2, "Tecnico", 1500000.34));
        listOfPeople.add(new PersonAttributes("Maria", "Montoya", 24, 'F', false, 3, 1, "Tecnico",0D));
        listOfPeople.add(new PersonAttributes("Camila", "Jaramillo", 25, 'F', true, 5, 0, "Profesional", 4000000D));
        listOfPeople.add(new PersonAttributes("Sofia", "", 54, 'F', false, 1, 3, "Profesional", 0D));
        listOfPeople.add(new PersonAttributes("Pedro", "Escobar", 37, 'M', false, 3, 1, "Secundaria", 0D));
        listOfPeople.add(new PersonAttributes("Santiago", "Aristizabal", 19, 'M', false, 2, 1, "Primaria", 0D));
        listOfPeople.add(new PersonAttributes("Carolina", "Ortiz", 26, 'F', true, 2, 0, "Profesional", 2345666.32));
        listOfPeople.add(new PersonAttributes("Martha", "Gonzalez", 54, 'F', true, 1, 5, "Profesional", 3670000D));
        listOfPeople.add(new PersonAttributes("Gabriela", "Garcia", 42, 'F', false, 4, 2, "Primaria", 0D));
        listOfPeople.add(new PersonAttributes("Ragina", "Gonzalez", 34, 'F', true, 3, 4, "Profesional", 2300000.1));
        listOfPeople.add(new PersonAttributes("Sebastian", "Muñoz", 29, 'M', true, 3, 0, "Secundaria", 3988800D));
        listOfPeople.add(new PersonAttributes("Gladis", "Ocampo", 26, 'F', false, 2, 3, "Profesional", 0D));
        listOfPeople.add(new PersonAttributes("Socorro", "Jimenez", 18, 'F', true, 3, 0, "Primaria", 1160000D));
        listOfPeople.add(new PersonAttributes("Alirio", "Perez", 67, 'M', true, 5, 3, "Profesional", 5100000D));
        listOfPeople.add(new PersonAttributes("Camila", "Carmona", 34, 'F', true, 3, 4, "Profesional", 2300000.43));
        listOfPeople.add(new PersonAttributes("Manuela", "Gomez", 28, 'F', true, 4, 0, "Secundaria", 2000000D));
        listOfPeople.add(new PersonAttributes("Sofia", "Perez", 23, 'F', false, 2, 3, "Tecnico", 0D));
        listOfPeople.add(new PersonAttributes("Carlos", "Lopez", 32, 'M', true, 2, 5, "Tecnico", 1300000D));
        listOfPeople.add(new PersonAttributes("Santiago", "Gonzalez", 29, 'M', true, 3, 0, "Profesional", 2300000.54));
        return listOfPeople;
    }

    @Override
    public String requestData() {
        Scanner sc = new Scanner(System.in);
        String newPersonInfo="";
        String name;
        String lastName;
        int age;
        char gender;
        boolean employmentStatus;
        int stratum;
        int numberOfChildren;
        String educationalLevel;
        double salary;
        System.out.println("Ingrese Nombre:");
        name = sc.next();
        System.out.println("Ingrese Apellido:");
        lastName = sc.next();
        System.out.println("Ingrese Edad:");
        age = sc.nextInt();
        System.out.println("Ingrese genero:");
        gender = sc.next().charAt(0);
        System.out.println("Ingrese Estado laboral true para laborando ó false para desempleado:");
        employmentStatus = sc.nextBoolean();
        System.out.println("Ingrese estrato:");
        stratum = sc.nextInt();
        System.out.println("Ingrese numero de hijos:");
        numberOfChildren = sc.nextInt();
        System.out.println("Ingrese nivel educacional entre: Tecnico, Primaria, Secundaria ó Profesional");
        educationalLevel = sc.next();
        System.out.println("Ingrese Salario actual:");
        salary = sc.nextDouble();
        newPersonInfo = name + "," + lastName + "," + age + "," + gender + ","
                + employmentStatus + "," + stratum + "," + numberOfChildren + ","
                + educationalLevel + "," + salary;
        return newPersonInfo;
    }

    @Override
    public void setInformationToFile(String newPersonInfo) {
        try{
            FileWriter escritura = new FileWriter("./src/main/resources/BD.txt",true);
            escritura.write("\n"+newPersonInfo);

        }catch (IOException exception) {
            exception.printStackTrace(System.out);
        }
    }
}
