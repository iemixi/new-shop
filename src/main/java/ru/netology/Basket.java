package ru.netology;

import java.util.Map;

public class Basket {
    private final Purchase[] purchases;

    public Basket(int productsAmount) {
        purchases = new Purchase[productsAmount];
    }

    public void addPurchase(String title, int count) {
        for (int i = 0; i < purchases.length; i++) {
            if (purchases[i] == null) {
                purchases[i] = new Purchase(title, count);
                return;
            }
            if (purchases[i].title.equals(title)) {
                purchases[i].count += count;
                return;
            }
        }
    }

    public long sum(Map<String, Integer> prices) {
        long sum = 0;

        System.out.println("КОРЗИНА:");
        for (int i = 0; i < purchases.length && purchases[i] != null; i++) {
            Purchase purchase = purchases[i];

//            плохая практика использовать continue, тем более по логике addPurchase начиная с некоторого индекса
//            не будет элементов (если не полностью заполнили массив покупок)
//            if (purchase == null) continue;
//            слишко длинная строка, поэтому разобьем ее

            int purchasePrice = purchase.count * prices.get(purchase.title);
            sum += purchasePrice;

            System.out.printf("\t %s %d шт. в сумме %d руб.\n", purchase.title, purchase.count, purchasePrice);
        }

        return sum;
    }
}
