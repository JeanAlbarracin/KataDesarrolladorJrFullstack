/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
import java.util.Arrays;
//import java.util.Scanner;
/**
 *
 * @author Yogernat
 */
public class Monedas {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        
        //Jean Nicolas Albarracin Romano
        
       int[] monedas = {1, 5, 1, 1, 1, 10, 15, 20, 100}; //Crea el arreglo que contiene las monedas a analizar
       int resultado = minCambioNoPosible(monedas); //Llama la función, le da el arreglo moendas como parametro de entrada y recibe el cambio mínimo
        System.out.println("La cantidad mínima de cambio que no puedes dar es: " + resultado); //Imprime la respuesta
    
       
    }
    
     public static int minCambioNoPosible(int[] coins) {
        Arrays.sort(coins); // Ordena las monedas en orden ascendente.
        int cambioMinimo = 1; // El valor mínimo que podemos representar inicialmente es 1.

        for (int coin : coins) {
            
            if (coin <= cambioMinimo) {//Verifica que la moneda sea menor al cambio mínimo
                cambioMinimo += coin; //Actualiza el cambio mínimo sumando el valor actual
            } else {
                break; // Si la moneda actual es mayor al cambio mínomo, no puede dar más cambio
            }
        }

        return cambioMinimo; //Retorna el cambio mínimo que no puede dar
    }
}
