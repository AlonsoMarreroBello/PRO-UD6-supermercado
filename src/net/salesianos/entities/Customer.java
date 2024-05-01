package net.salesianos.entities;

public class Customer {
  private String firstName;
  private String lastName;
  private boolean isLatin;
  private boolean isVenezuelan;

  public Customer(String firstName, String lastName, boolean isLatin, boolean isVenezuelan) {
    this.firstName = firstName;
    this.lastName = lastName;
    this.isLatin = isLatin;
    this.isVenezuelan = isVenezuelan;
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
        "===================================\n";
  }
}
