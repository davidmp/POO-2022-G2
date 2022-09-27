/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package pe.edu.upeu.app.herencia;

/**
 *
 * @author Lab Software
 */
public class Car extends Vehicle{
    
    public void probar(){
        emiteSonido();
        marca="Toyota";
        
    }
    
    public static void main(String[] args) {
        marca="Toyota";
        //emiteSonido();
        System.out.println(""+marca);
        
        Vehicle v=new Vehicle();
        v.emiteSonido();
        
    }
}
