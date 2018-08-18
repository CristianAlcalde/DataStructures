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
        
        
        Scanner teclado = new Scanner(System.in);
        System.out.print("Introduzca el numero: ");
        this.numero = teclado.nextInt();   
        
        
        
            
        for (int i = 1; i <= numero; i = i + 1) {

            letra++;
        }

        System.out.println(letra);
     
        
    }    
        
}       
        
    
      

