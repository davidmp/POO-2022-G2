/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package pe.edu.upeu.app.cinterna;

/**
 *
 * @author Lab Software
 */
public class ClasePrincipal {
    public static void main(String[] args) {
        Mama m=new Mama();
        Mama.Hijo h=m.new Hijo();
        
        System.out.println("La mama se llama "+m.nombre+ " y su hijo tiene por nombre " + h.nombre);
    }
}
