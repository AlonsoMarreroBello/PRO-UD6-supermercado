import java.util.Scanner;

import net.salesianos.entities.Cashier;

public class App {
  public static void main(String[] args) {
    Scanner scanner = new Scanner(System.in);
    String choice;
    do {
      System.out.println("""
          Menu
          1. Abrir caja
          2. Añadir cliente a la cola
          3. Atender cliente
          4. Ver clientes pendientes
          5. Cerrar caja
          0. Cerrar supermercado
          """);
      System.out.print("Seleccione una opción: ");
      choice = scanner.nextLine();
      switch (choice) {
        case "1":
          Cashier.openCheckout();
          break;
        case "2":
          Cashier.addCustomer();
          break;
        case "3":
          Cashier.serveCustomer();
          break;
        case "4":
          Cashier.showCustomerQueue();
          break;
        case "5":
          Cashier.closeCheckout();
          break;
        case "0":
          System.out.println("Saliendo del programa...");
          break;
        default:
          System.out.println("Opción no válida. Intente de nuevo.");
      }
    } while (!choice.equals("0"));
    scanner.close();
  }
}
