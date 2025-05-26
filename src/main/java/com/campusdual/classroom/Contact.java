package com.campusdual.classroom;

import com.campusdual.util.Utils;

import java.text.Normalizer;

public class Contact implements ICallActions {
    private String name;
    private String surnames;
    private String phone;
    private String code;

    public Contact(String name, String surnames, String phone) {
        this.name = name;
        this.surnames = surnames;
        this.phone = phone;
        this.code = generateCode();
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public String getSurnames() {
        return surnames;
    }

    public void setSurnames(String surnames) {
        this.surnames = surnames;
    }

    public String getCode() {
        return this.code;
    }

    private String generateCode() {
        StringBuilder sb = new StringBuilder();
        String normalizedName = Normalizer.normalize(getName(), Normalizer.Form.NFKD).replaceAll("[^\\p{ASCII}]", "").toLowerCase().trim();
        String normalizedSurname = Normalizer.normalize(getSurnames(), Normalizer.Form.NFKD).replaceAll("[^\\p{ASCII}]", "").toLowerCase().trim();
        String[] partesApellido = normalizedSurname.split(" ");
        if (partesApellido.length == 1) {
            sb.append(normalizedName.charAt(0)).append(normalizedSurname);
            return sb.toString();
        } else if (partesApellido.length == 2) {
            sb.append(normalizedName.charAt(0)).append(partesApellido[0].charAt(0)).append(partesApellido[1]);
            return sb.toString();
        } else {
            sb.append(normalizedName.charAt(0)).append(partesApellido[0].charAt(0));
            for (int i = 1; i < partesApellido.length; i++) {
                sb.append(partesApellido[i]);
            }
            return sb.toString();
        }
    }


    @Override
    public void callMyNumber() {
        System.out.println("Estás llamando a tu propio número." +
                "\nNombre: " + this.getName() + " " + this.getSurnames() +
                "\nTeléfono:" + this.getPhone());
    }

    @Override
    public void callOtherNumber(String number) {

        System.out.println(this.getName() + " " + this.getSurnames() + " estás llamando al número: " + number);
    }

    @Override
    public void showContactDetails() {
        System.out.println("Contacto{" +
                "\nNombre: " + getName() +
                "\nApellidos: " + getSurnames() +
                "\nTeléfono: " + getPhone() +
                "\nCódigo: " + getCode() +
                '}');
    }

    public void actionsMenu() {
        int numeroElegido;
        do {
            System.out.println("\nMenú de acciones:\n" +
                    "Pulse 1 para llamar a su propio número\n" +
                    "Pulse 2 para llamar a otro contacto\n" +
                    "Pulse 3 para seleccionar los detalles del contacto\n" +
                    "Pulse 4 para salir del menú de acciones"
            );

            numeroElegido = Utils.integer("Seleccione una opción: ");

            switch (numeroElegido) {
                case 1:
                    this.callMyNumber();
                    break;
                case 2:
                    this.callOtherNumber(Utils.string("Ingrese el número al que desea llamar: "));
                    break;
                case 3:
                    this.showContactDetails();
                    break;
                case 4:
                    System.out.println("Saliendo del menú de acciones...\n");
                    break;
                default:
                    System.out.println("ERROR. El número introducido no es válido. Inténtelo de nuevo");
            }
        } while (numeroElegido != 4);
    }


}
