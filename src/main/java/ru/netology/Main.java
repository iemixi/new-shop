package ru.netology;

import java.util.HashMap;
import java.util.Scanner;

public class Main {

    public static void main(String[] args) {
//        выделил код в отдельные функции, выполняющие каждая свою задачу
        HashMap<String, Integer> products = buildPurchases();

        printPurchases(products);

        Basket basket = getUserBasket(products);

        System.out.println("\nИТОГО: " + basket.sum(products));
    }

    private static Basket getUserBasket(HashMap<String, Integer> products) {
        System.out.println("\nВведите два слова: название товара и количество. Или end");

        Scanner scanner = new Scanner(System.in);

        Basket basket = new Basket(products.keySet().size());
        String line = scanner.nextLine();
//      упрощаем обработку завершения работы с программой и избавляемся от создания переменной каждую итерацию
        while (!"end".equals(line)) {
            String[] parts = line.split(" ");

            String product = parts[0];
            int count = Integer.parseInt(parts[1]);

            basket.addPurchase(product, count);

            line = scanner.nextLine();
        }

//        добавил закрытие потока ввода
        scanner.close();
        return basket;
    }

    private static HashMap<String, Integer> buildPurchases() {
        HashMap<String, Integer> products = new HashMap<>();

        products.put("Хлеб", 56);
        products.put("Масло", 153);
        products.put("Колбаса", 211);
        products.put("Пирожок", 45);

        return products;
    }

    private static void printPurchases(HashMap<String, Integer> products) {
        System.out.println("В МАГАЗИНЕ В НАЛИЧИИ");

        products.forEach(
                (product, price) -> System.out.printf("%s за %d руб./шт.\n", product, price));
    }

}