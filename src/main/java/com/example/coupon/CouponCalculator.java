package com.example.coupon;

public class CouponCalculator {
  public static void main(String[] args) {
    int[] itemPrices1 = {1000, 1100, 1200, 1300};
    int[] itemPrices2 = {1000, 1100, 1200, 1300, 1600, 1800};
    int[] itemPrices3 = {1000, 2100, 3200, 2300};
    System.out.print("カート内: 1000円, 1100円, 1200円, 1300円。期待されるクーポン: A。結果: ");
    CouponCalculator couponCalculator1 = new CouponCalculator();
    System.out.println(couponCalculator1.findBestCoupon(itemPrices1));
    System.out.print("カート内: 1000円, 1100円, 1200円, 1300円, 1600円, 1800円。期待されるクーポン: B。結果: ");
    CouponCalculator couponCalculator2 = new CouponCalculator();
    System.out.println(couponCalculator2.findBestCoupon(itemPrices2));
    System.out.print("カート内: 1000円, 2100円, 3200円, 2300円。期待されるクーポン: C。結果: ");
    CouponCalculator couponCalculator3 = new CouponCalculator();
    System.out.println(couponCalculator3.findBestCoupon(itemPrices3));
  }

  public String findBestCoupon(int[] cartItems) {
    float A = 0;
    CouponA couponA = new CouponA();
    A = couponA.calculate(cartItems);

    float B = 0;
    CouponB couponB = new CouponB();
    B = couponB.calculate(cartItems);

    float C = 0;
    CouponC couponC = new CouponC();
    C = couponC.calculate(cartItems);

    // 支払総額が最小額になるクーポンを判定して出力
    String result = "";
    if (A <= B && A <= C) {
      result = "A";
    } else if (B <= A && B <= C) {
      result = "B";
    } else if (C <= A && C <= B) {
      result = "C";
    }
    return result;
  }
}
