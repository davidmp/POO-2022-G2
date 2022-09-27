/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package pe.edu.upeu.app.enumx;

/**
 *
 * @author Lab Software
 */



public class EjemploEnum {
enum GENERO{Masculino, Femenino}
    public static void main(String[] args) {
        for (GENERO arg : GENERO.values()) {
            System.out.println(arg);
        }
    }
}
