package net.salesianos.objects;

import java.util.Stack;

public class ShoppingCart {
  private Stack<Product> products;

  public ShoppingCart() {
    this.products = new Stack<>();
  }

  public void addProduct(Product product) {
    products.add(product);
  }

  public Stack<Product> getProducts() {
    return products;
  }

  public int getTotalProducts() {
    return products.size();
  }

  @Override
  public String toString() {
    StringBuilder sb = new StringBuilder();
    sb.append("Lista de artículos en la cesta:\n");
    for (Product product : products) {
      sb.append(product.getName()).append("\n");
    }
    return sb.toString();
  }
}