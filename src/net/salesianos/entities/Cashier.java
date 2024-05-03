package net.salesianos.entities;

import java.util.LinkedList;
import java.util.Queue;

import net.salesianos.objects.Product;
import net.salesianos.utils.Generator;

public class Cashier {
  private static Queue<Customer> customerQueue = new LinkedList<>();
  private static boolean isOpen = false;

  public static void openCheckout() {
    if (!isOpen) {
      isOpen = true;
      System.out.println("La caja ha sido abierta.");
    } else {
      System.out.println("La caja ya está abierta.");
    }
  }

  public static void addCustomer() {
    if (isOpen) {
      Customer customer = Generator.generateCustomer();
      customer.fillShoppingCart();
      customerQueue.add(customer);
      System.out.println("Cliente añadido a la cola: " + customer.getFirstName() + " " + customer.getLastName());
    } else {
      System.out.println("La caja está cerrada. No se pueden añadir clientes a la cola.");
    }
  }

  public static void serveCustomer() {
    if (!customerQueue.isEmpty()) {
      Customer customer = customerQueue.remove();
      System.out.println("Atendiendo al cliente: " + customer.getFirstName() + " " + customer.getLastName());
      if (customer.getFirstName().equals("Adri")) {
        for (Product product : customer.getShoppingCart().getProducts()) {
          if (product.getName().equals("Atun Calvo")) {
            System.out.println(
                "La compra del Atun Calvo es gratuita para este cliente, no tiene pelo, pero si atun de calidad.");
          }
        }
      } else if (customer.stealProduct()) {
        System.out.println(
            "Cliente " + customer.getFirstName() + " " + customer.getLastName() + " ha sido expulsado por robo.");
      } else {
        System.out.println("Cliente atendido.");
      }
    } else {
      System.out.println("No hay clientes en la cola.");
    }
  }

  public static void showCustomerQueue() {
    if (!customerQueue.isEmpty()) {
      System.out.println("Clientes en la cola:");
      for (Customer customer : customerQueue) {
        System.out.println(customer);
      }
    } else {
      System.out.println("No hay clientes en la cola.");
    }
  }

  public static void closeCheckout() {
    if (isOpen) {
      if (customerQueue.isEmpty()) {
        isOpen = false;
        System.out.println("La caja ha sido cerrada.");
      } else {
        System.out.println("No se puede cerrar la caja. Hay clientes esperando en la cola.");
      }
    } else {
      System.out.println("La caja ya está cerrada.");
    }
  }
}