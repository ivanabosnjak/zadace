package zadaca1;/* 4. Napisati program u Javi koji unosi broj u dekadskom obliku te izračunava i ispisuje njegovu
  heksadekadsku vrijednost (npr. 2548 -> 9F4).*/

//Ivana Bošnjak, 2200/RR

import java.util.Scanner;

public class z4 {
    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);
        System.out.print("Unesite broj u dekadskom obliku: ");
        int dekadski = sc.nextInt();

        String heksadekadski = Integer.toHexString(dekadski).toUpperCase();

        System.out.println("Heksadekadski oblik: " + heksadekadski);
    }
}
