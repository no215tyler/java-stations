package com.example.coupon;
import java.util.Arrays;

// C：2000円以上の商品が全て20%割引
public class CouponC {
  public float calculate(int[] cartItems) {
    float discountPrices = (float)Arrays.stream(cartItems)
                                .filter(i -> i >= 2000)
                                .map(i -> (int)(i * 0.2))
                                .sum();
    float subTotalPrices = (float)Arrays.stream(cartItems)
                                .sum();
    float result = subTotalPrices - discountPrices;
    // ¥5,000未満なら送料追加
    result = (result >= 5000) ? result : (result + 800);

    return result;
  }
}
