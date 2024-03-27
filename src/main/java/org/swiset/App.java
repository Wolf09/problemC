package org.swiset;

import java.util.*;

public class App 
{
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.print("Ingrese el Número de casos de prueba: ");
        int t = scanner.nextInt(); // Número de casos de prueba

        while (t-- > 0) {
            System.out.print("Ingrese la Longitud de la matriz b: ");
            int n = scanner.nextInt(); // Longitud de la matriz b
            System.out.print("Ingrese el Número de operaciones: ");
            long k = scanner.nextLong(); // Número de operaciones

            long[] b = new long[n];
            System.out.println("Ingrese los "+n+" elementos de la matriz: ");
            for (int i = 0; i < n; i++) {
                b[i] = scanner.nextLong();
            }

            if (isPossible(n, k, b)) {
                System.out.println("Ouput: Sí");
            } else {
                System.out.println("Output: No");
            }
        }
        scanner.close();
    }

    // Funcion que verifica si el informante anonimo dice la VERDAD
    public static boolean isPossible(int n, long k, long[] b) {
        long x = -1;
        long[] a= b.clone();
        boolean res=false;

            // Encontrar el posible mínimo elemento en la matriz b
            for (int i = 0; i < n; i++) {
                if (b[i] == i + 1) {
                    x = b[i];
                    break;
                }
            }
        if(k==1 && x==1){
            return false;
        }

        if(x!=-1) {
            // Realizar las rotaciones cíclicas a la izquierda según las operaciones especificadas
            for (int i = 1; i <= k; i++) {
                if (i + 1 >= n) {
                    break;
                } else {
                    x = b[i + 1];
                }
                rotateLeft(a, x); // Realizar rotación cíclica a la izquierda con x como punto fijo
            }

            // Imprimir la matriz resultante
            for (long num : a) {
                System.out.print(num + " ");
            }
            System.out.println();
            if(Arrays.equals(a,b)){
                res= true;
            }
        }


        return res;
    }

    // Función para realizar la rotación cíclica a la izquierda con un punto fijo dado
    public static void rotateLeft(long[] arr, long x) {
        int index = -1;

        // Encontrar el índice del punto fijo x en la matriz
        for (int i = 0; i < arr.length; i++) {
            if (arr[i] == x) {
                index = i;
                break;
            }
        }

        // Realizar la rotación cíclica a la izquierda
        long temp = arr[index];
        for (int i = index; i < arr.length - 1; i++) {
            arr[i] = arr[i + 1];
        }
        arr[arr.length - 1] = temp;
    }




}
