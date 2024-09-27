package com.example.station9;
import java.util.Arrays;

public class Main {
    public static void main(String[] args) {
        int[] itemPrices1 = {1000, 1100, 1200, 1300};
        int[] itemPrices2 = {1000, 1100, 1200, 1300, 1600, 1800};
        int[] itemPrices3 = {1000, 2100, 3200, 2300};
        System.out.print("カート内: 1000円, 1100円, 1200円, 1300円。期待されるクーポン: A。結果: ");
        test(itemPrices1);
        System.out.print("カート内: 1000円, 1100円, 1200円, 1300円, 1600円, 1800円。期待されるクーポン: B。結果: ");
        test(itemPrices2);
        System.out.print("カート内: 1000円, 2100円, 3200円, 2300円。期待されるクーポン: C。結果: ");
        test(itemPrices3);
    }

    public static void test(int[] itemPrices) {
        // ここから
        double sumPrices = Arrays.stream(itemPrices).sum();
        // A：合計金額に関わらず送料無料となる。
        int couponA = ((int)sumPrices);
        // B：カート内の商品に対して、10%割引となる。
        int couponB = (int)((sumPrices) * 0.9);
        couponB = couponB >= 5000 ? couponB : (couponB + 800);
        // C：2000円以上の商品が全て20%割引となる。
        int discount20 = ((int)(Arrays.stream(itemPrices)
                                    .filter(p -> p >= 2000)
                                    .map(p -> (int)(p * 0.8))
                                    .sum()));
        int couponC = Arrays.stream(itemPrices)
                            .filter(p -> p < 2000)
                            .sum();
        couponC += discount20;
        couponC = couponC >= 5000 ? couponC : (couponC + 800);


        // 条件分岐（支払額が最小額クーポンの総額を出力）
        if (couponA <= couponB && couponA <= couponC) {
          System.out.println("A");
        } else if (couponB <= couponA && couponB <= couponC) {
          System.out.println("B");
        } else if (couponC <= couponA && couponC <= couponB) {
          System.out.println("C");
        }
        // ここまで
    }
}