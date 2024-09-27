package com.example.station10;

public class Main {
    public static void main(String[] args) {
        // テストする場合、以下の「//」を消してください。
        System.out.println("商品合計: 1000, 支払額: " + new Main().applyTaxAndShippingFee(1000));
        System.out.println("商品合計: 10000, 支払額: " + new Main().applyTaxAndShippingFee(10000));
        System.out.println("商品合計: 9999, 支払額: " + new Main().applyTaxAndShippingFee(9999));
    }

    // ここから
    // 「送料と消費税を含んだ支払額」を、返り値として float 型の値で返す関数
    float applyTaxAndShippingFee (int noTaxSubtotal) {
      float result = 0;
      if (noTaxSubtotal >= 10000) {
        result = (float)(noTaxSubtotal * 1.1);
      } else {
        result = (float)((noTaxSubtotal + 800) * 1.1);
      }
      return result;
    }
    // ここまで
}
