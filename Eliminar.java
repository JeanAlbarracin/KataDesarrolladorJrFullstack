/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
import java.util.ArrayList;
import java.util.List;

public class Eliminar {

    public static void main(String[] args) {
        //Jean Nicolas Albarracin Romano
        //Hash: 16d67a89ebce69696a72388e2e7c23f9
        int S = 1;

        List<Integer> numeros = new ArrayList<>(); //Declaro lista de numeros iniciales
        for (int i = 0; i <= 100; i++) { //Llena la lista
            numeros.add(i);
        }
        List<String> orden = procesarNumeros(numeros, S);
        // Imprime el resultado
        System.out.println(orden);
    }

    public static List<String> procesarNumeros(List<Integer> numeros, int S) {
         // Crear una nueva lista para almacenar los números modificados sin números vacíos
        List<String> numerosModificados = new ArrayList<>(); //Declara la lista de los numeros sin S
        boolean centinela = false; //Verifica que hubo al menos un S
        int cero = 0; //Contará cantidad de 0 en el número

        if (numeros.get(0) == 0) { //Para el caso único cuando es 0,ingresa un 0  correspondientemente
            numerosModificados.add("0");
        }
        // Elimina el dígito S de los números y agrega solo los números no vacíos a la nueva lista
        for (int numero : numeros) {
            int[] resultado = eliminarDigito(numero, S, centinela); //Envia los parametros y recibe los resultados de la función 
            centinela = resultado[0] == 1; //Asigna true si en la posición 0 el valor es 1
            cero = resultado[1]; //Asigna el valor de la posición 1

            int numeroSinS = resultado[2]; //Asigna el valor de la posición 2, el número que ya no contiene S

            if (numeroSinS != 0) {// Verifica si el es diferente de 0
                numerosModificados.add("" + numeroSinS); //Añade el número a lista como String
            } else {
                if (centinela && cero > 0) { //Verifica que hubo un S en el número y que hubo al menos un 0
                    StringBuilder cadena = new StringBuilder(); //Se crea una instancia de la clase StringBuilder
                    for (int x = 1; x <= cero; x++) { //Construye la cadena con cero veces 0
                        cadena.append("0"); //Agrega los 0 
                    }
                    numerosModificados.add(cadena.toString()); //Añade a la lista,asegurando la naturaleza String
                }
            }
        }

        List<String> orden = new ArrayList<>(); //Se crea las lista que será mostrada
        for (int x = numerosModificados.size() - 1; x >= 0; x--) { //Invierte el orden a descendente
            orden.add(numerosModificados.get(x));//Llena la lista orden
        }

        return orden;
    }

    public static int[] eliminarDigito(int numero, int digito, boolean centinela) { //Diseñado para recorrer el cada dígito y borrar S
        int resultado = 0;
        int multiplicador = 1;
        int cero = 0;

        while (numero > 0) {  //Verifica cada digito del numero mientras sea mayor a cero
            int digitoActual = numero % 10;

            if (digitoActual != digito) {  //Discrimina el número S
                resultado += digitoActual * multiplicador; //Almacena el dígito verificado
                multiplicador *= 10; //Se modifica de acuerdo a la posición del siguiente dígito
                cero += 1; //Cuenta la cantidad de digitos diferentes de S en cada número revisado
            } else {
                centinela = true; //Alerta la presencia de almenos un S
              }

            numero /= 10; //Mueve al siguiente dígito para analizarlo en la siguiente iteración While
        }

        return new int[]{centinela ? 1 : 0, cero, resultado}; //Retorna 3 valores al arreglo
    }
}

