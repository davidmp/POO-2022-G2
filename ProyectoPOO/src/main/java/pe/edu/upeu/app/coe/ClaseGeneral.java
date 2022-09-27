/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package pe.edu.upeu.app.coe;

/**
 *
 * @author Lab Software
 */
public class ClaseGeneral {
    public static void main(String[] args) {
        System.out.println("Hola Mundo");
        int a=54;
        int b=4;
        int suma=a+b;
        System.out.println("Suma:" + suma);
        
        Persona p;//variable
        p=new Persona();//Objerto
    
        System.out.println("Nombre:"+p.nombre+" Edad: "+p.edad);//Sin aplicar encapsulamiento -llamada directa
        System.out.println("Nombre:"+p.getNombre()+" Edad: "+p.getEdad());//aplicando concepto de encapsulamiento
        
        
    }
}
