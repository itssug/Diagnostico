/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 */
package com.mycompany.diagnostico;

import java.util.Scanner;

/**
 *
 * @author parkl
 */
public class Diagnostico {

    static final int MAX = 1000000; 
    static boolean[] esPrimo = new boolean[MAX + 1];
    static int[] primosAcumulados = new int[MAX + 1];

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        cribaPrimos();
        contarPrimosAcumulados();

        while (true) {
            int L = sc.nextInt();
            int R = sc.nextInt();

            if (L == 0 && R == 0) break;

            if (L < 1) L = 1; 

            int cantidad = primosAcumulados[R] - primosAcumulados[L - 1];
            System.out.println(cantidad);
        }

        sc.close();
    }
    static void cribaPrimos() {
        for (int i = 2; i <= MAX; i++) esPrimo[i] = true;

        for (int i = 2; i * i <= MAX; i++) {
            if (esPrimo[i]) {
                for (int j = i * i; j <= MAX; j += i) {
                    esPrimo[j] = false;
                }
            }
        }
    }
    static void contarPrimosAcumulados() {
        primosAcumulados[0] = 0;
        for (int i = 1; i <= MAX; i++) {
            primosAcumulados[i] = primosAcumulados[i - 1] + (esPrimo[i] ? 1 : 0);
        }
    }
}
