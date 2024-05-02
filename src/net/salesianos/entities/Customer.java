package net.salesianos.entities;

import java.util.Random;

import net.salesianos.objects.Product;
import net.salesianos.objects.ShoppingCart;
import net.salesianos.utils.Generator;

public class Customer {
  private String firstName;
  private String lastName;
  private boolean isLatin;
  private boolean isVenezuelan;
  private ShoppingCart shoppingCart;

  public Customer(String firstName, String lastName, boolean isLatin, boolean isVenezuelan) {
    this.firstName = firstName;
    this.lastName = lastName;
    this.isLatin = isLatin;
    this.isVenezuelan = isVenezuelan;
    this.shoppingCart = new ShoppingCart();
  }

  public String getFirstName() {
    return firstName;
  }

  public String getLastName() {
    return lastName;
  }

  public boolean isLatin() {
    return isLatin;
  }

  public boolean isVenezuelan() {
    return isVenezuelan;
  }

  public ShoppingCart getShoppingCart() {
    return shoppingCart;
  }

  public void fillShoppingCart() {
    int numProducts = new Random().nextInt(5) + 1;
    for (int i = 0; i < numProducts; i++) {
      Product product = Generator.generateProduct();
      shoppingCart.addProduct(product);
    }
  }

  public boolean stealProduct() {
    if (isVenezuelan) {
      System.out.println("¡Un venezolano ha robado un producto!");
      return true;
    }
    return false;
  }

  @Override
  public String toString() {
    return "Cliente\n" +
        "===================================\n" +
        "* Nombre: " + firstName + " " + lastName + "\n" +
        "* venezolano: " + (isVenezuelan ? " si " : " no ") + "\n" +
        "* Total de productos: " + shoppingCart.getTotalProducts() + "\n" +
        shoppingCart.toString() +
        "===================================\n";
  }
}