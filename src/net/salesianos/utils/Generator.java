package net.salesianos.utils;

import java.util.HashMap;
import java.util.Map;
import java.util.Random;

import net.salesianos.entities.Customer;
import net.salesianos.objects.Product;

public class Generator {
  private static final String[] FIRST_NAMES = { "Juan", "María", "Adri", "Ana", "Carlos", "Luisa", "Diego", "Laura",
      "Pablo", "Sofía", "Javier", "Elena", "Miguel", "Carmen", "Manuel", "Rosa", "Alejandro", "Isabel", "Antonio",
      "Lucía" };
  private static final String[] LAST_NAMES = { "García", "Martínez", "Rodríguez", "López", "Hernández", "Sánchez",
      "Pérez", "González", "Gómez", "Fernández", "Díaz", "Alvarez", "Vásquez", "Romero", "Suárez", "Torres", "Ramírez",
      "Flores", "Benítez", "Acosta" };
  private static final String[] PRODUCT_NAMES = { "Leche", "Pan", "Huevos", "Arroz", "Pasta", "Aceite", "Tomates",
      "Plátanos", "Manzanas", "Carne", "Atun Calvo", "Pescado" };

  private static final double MIN_PRICE = 1.0;
  private static final double MAX_PRICE = 10.0;
  private static final int MIN_CODE = 1000;
  private static final int MAX_CODE = 9999;

  private static final Map<String, Double> priceMap = new HashMap<>();
  private static final Map<String, Integer> codeMap = new HashMap<>();

  public static Customer generateCustomer() {
    String firstName = FIRST_NAMES[new Random().nextInt(FIRST_NAMES.length)];
    String lastName = LAST_NAMES[new Random().nextInt(LAST_NAMES.length)];
    boolean isLatin = new Random().nextBoolean();
    boolean isVenezuelan = isLatin && (new Random().nextInt(10) == 0);
    return new Customer(firstName, lastName, isLatin, isVenezuelan);
  }

  public static Product generateProduct() {
    String name = PRODUCT_NAMES[new Random().nextInt(PRODUCT_NAMES.length)];
    double price = generatePrice(name);
    int code = generateCode(name);
    return new Product(name, price, code);
  }

  private static double generatePrice(String name) {
    if (!priceMap.containsKey(name)) {
      double randomPrice = MIN_PRICE + (MAX_PRICE - MIN_PRICE) * Math.random();
      priceMap.put(name, randomPrice);
    }
    return priceMap.get(name);
  }

  private static int generateCode(String name) {
    if (!codeMap.containsKey(name)) {
      int randomCode = MIN_CODE + (int) ((MAX_CODE - MIN_CODE + 1) * Math.random());
      codeMap.put(name, randomCode);
    }
    return codeMap.get(name);
  }

}
