package com.example.coupon;
import java.util.Arrays;

// B：カート内の商品に対して、10%割引
public class CouponB {
  public float calculate(int[] cartItems) {
    float result = (float)Arrays.stream(cartItems).map(i -> (int)(i * 0.9)).sum();
    // ¥5,000未満なら送料追加
    result = (result >= 5000) ? result : (result + 800);
    return result;
  }
}
