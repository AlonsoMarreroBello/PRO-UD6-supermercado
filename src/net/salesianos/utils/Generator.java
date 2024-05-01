package net.salesianos.utils;

import java.util.Random;

import net.salesianos.entities.Customer;

public class Generator {
  private static final String[] FIRST_NAMES = { "Juan", "María", "Adri", "Ana", "Carlos", "Luisa", "Diego", "Laura",
      "Pablo", "Sofía", "Javier", "Elena", "Miguel", "Carmen", "Manuel", "Rosa", "Alejandro", "Isabel", "Antonio",
      "Lucía" };
  private static final String[] LAST_NAMES = { "García", "Martínez", "Rodríguez", "López", "Hernández", "Sánchez",
      "Pérez", "González", "Gómez", "Fernández", "Díaz", "Alvarez", "Vásquez", "Romero", "Suárez", "Torres", "Ramírez",
      "Flores", "Benítez", "Acosta" };


  public static Customer generateCustomer() {
    String firstName = FIRST_NAMES[new Random().nextInt(FIRST_NAMES.length)];
    String lastName = LAST_NAMES[new Random().nextInt(LAST_NAMES.length)];
    boolean isLatin = new Random().nextBoolean();
    boolean isVenezuelan = isLatin && (new Random().nextInt(10) == 0); // 1 de cada 10 latinos será venezolano

    return new Customer(firstName, lastName, isLatin, isVenezuelan);
  }

}
