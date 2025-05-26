package com.campusdual.classroom;

import com.campusdual.util.Utils;

import java.util.HashMap;
import java.util.Map;

public class Phonebook {
    private Map<String, Contact> phoneBook;

    public Phonebook() {
        this.phoneBook = new HashMap<>();
    }

    public Map<String, Contact> getData() {
        return phoneBook;
    }

    public void setPhoneBook(Map<String, Contact> phoneBook) {
        this.phoneBook = phoneBook;
    }

    public void addContact(Contact contact) {
        this.getData().put(contact.getCode(),contact);
        System.out.println("El contacto de " + contact.getName() + " " + contact.getSurnames() + " se ha añadido correctamente");
    }

//    public void addContact2() {
//        String name = Utils.string("Ingrese el nombre del nuevo contacto:\n");//creamos la variable
//        String surnames = Utils.string("Ingrese los apellidos del nuevo contacto (separados por espacios):\n");
//        String phoneNumber = Utils.string("Ingrese el número de teléfono del nuevo contacto:\n");
//
//        Contact newContact = new Contact(name, surnames, phoneNumber);
//
//        this.getData().put(newContact.getCode(), newContact);
//        System.out.println("El contacto se ha añadido correctamente");
//    }

    public void showPhonebook() {
        if (this.phoneBook.isEmpty()) {
            System.out.println("No hay contactos en la agenda");
        } else {
            for (Map.Entry<String, Contact> entry : getData().entrySet()) {
                entry.getValue().showContactDetails();
                System.out.println();
            }
        }
    }

    public void selectContact(String code) {
        if (this.getData().containsKey(code)) {
            this.getData().get(code).actionsMenu();
        } else {
            System.out.println("El código introducido no corresponde con ningún contacto de tu agenda.");
        }
    }

    public void deleteContact(String code) {
        if (this.getData().containsKey(code)) {
            System.out.println("El contacto " + this.getData().remove(code).getCode() + " ha sido borrado correctamente");
        } else {
            System.out.println("El código introducido no corresponde con ningún contacto de tu agenda.");
        }
    }

    public void phoneBookMenu() {
        int numeroElegido;
        do {
            System.out.println("Menú principal de la agenda:\n"
                    + "Pulse 1 para añadir un contacto a su agenda\n"
                    + "Pulse 2 para mostrar los contactos de tu agenda\n"
                    + "Pulse 3 para seleccionar las opciones de un contacto\n"
                    + "Pulse 4 para eliminar un contacto\n"
                    + "Pulse 5 para salir del menú principal del listín"
            );

            numeroElegido = Utils.integer("Seleccione una opción: ");

            switch (numeroElegido) {
                case 1:
                    this.addContact(new Contact(Utils.string("Ingrese el nombre del nuevo contacto:\n"),
                            Utils.string("Ingrese los apellidos del nuevo contacto (separados por espacios):\n"),
                            Utils.string("Ingrese el número de teléfono del nuevo contacto:\n")));
                    break;
                case 2:
                    showPhonebook();
                    break;
                case 3:
                    this.selectContact(Utils.string("Ingrese el código del contacto para ver sus opciones:\n"));
                    break;
                case 4:
                    this.deleteContact(Utils.string("Ingrese el código del contacto que desea eliminar:\n"));
                    break;
                case 5:
                    System.out.println("Saliendo del programa...");
                    System.exit(0);
                    break;
                default:
                    System.out.println("ERROR. El número introducido no es válido. Inténtelo de nuevo");
            }
        } while (numeroElegido != 5);
    }
}