package com.campusdual.classroom;


import java.text.Normalizer;
import java.util.Map;

public class Exercise26 {
    public static void main(String[] args) {
        Phonebook phonebook = new Phonebook();
        Contact c1 = new Contact(" Javier", "López", "630156279");
        Contact c2 = new Contact("Carlos", "Fernández-Simón", "651234866");
        Contact c3 = new Contact("Jose Manuel", "Soria", "678120941");
        Contact c4 = new Contact("Santiago", "Fernández Rocha", "621054237");
        Contact c5 = new Contact("Esteban", "Serrano del río", "687231104");
        Contact c6 = new Contact("Fernando Miguel", "Juan de los Santos Requejo León", "612309845");

        phonebook.addContact(c1);
        phonebook.addContact(c2);
        phonebook.addContact(c3);
        phonebook.addContact(c4);
        phonebook.addContact(c5);
        phonebook.addContact(c6);
        phonebook.phoneBookMenu();
    }


}
