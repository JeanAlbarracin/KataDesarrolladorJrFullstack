/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
import java.util.ArrayList;
import java.util.List;
/**
 *
 * @author Yogernat
 */
public class Cuadrados {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        //Jean Nicolas Albarracin Romano
        //Hash: 16d67a89ebce69696a72388e2e7c23f9
        int S = 1;
        S = (S*10)+S; //Se asigna el valor del límite (SS)

         List<Integer>cuadrados = new ArrayList<>(); //Crea la lista
                 
        for (int numero = -100 ; numero<=100; numero++) { //Genera los numero que serán procesados
          
            if (numero*numero<S){ //Verifica que las potencias sean inferiores a límite (SS)
                
                cuadrados.add(numero*numero);    //Llena la lista
            }
            
        }    
        for (int i=0;i<=cuadrados.size()-1;i++){ //Recorre todas las posiciones de la lista
            for (int j=i+1;j<=cuadrados.size()-1;j++){  //Recorre todas las posiciones de la lista, desde la posición 1
                if (cuadrados.get(i)>cuadrados.get(j)){ //Método burbuja para organizar los numeros ascendentemente
                    int aux = cuadrados.get(i);
                    cuadrados.set(i,cuadrados.get(j));
                    cuadrados.set(j,aux);
                }
                
            }
        }
                
        System.out.println(cuadrados); //Imprime la lista resultante
        
        
    }
    
    
}
