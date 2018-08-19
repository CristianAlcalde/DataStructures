/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package montoescrito;

import java.util.Scanner;

/**
 *
 * @author juanc
 */
public class Montoescrito {
    
    private int numero;
    private char letra = 96;
    
    
    public Montoescrito () {
        
        
    } 
    
    
    public void recibeNumeros () {
        
        String cadena;
        Scanner teclado = new Scanner(System.in);
        System.out.print("Introduzca los numeros: ");
        cadena = teclado.nextLine();    
        
        String[] split = cadena.split(" +"); // EL SPLIT ES RECORTA LOS ESPACIOS de la cadena que estoy ingresando
        
        int x = 0;
        while (x < split.length) {
            
            this.numero = Integer.parseInt(split[x]);
            
            for (int i = 1; i <= numero; i = i + 1) {
            
                letra++;
            }
        
            System.out.println(letra);
            
            letra = 96;
            x++;
        }
        
                  
        
    }    
        
        
}       
        
    
      

