package com.example.coupon;
import java.util.Arrays;

// A：合計金額に関わらず送料無料
public class CouponA {
  public float calculate(int[] cartItems) {
    float result = (float)Arrays.stream(cartItems).sum();
    return result;
  }
}