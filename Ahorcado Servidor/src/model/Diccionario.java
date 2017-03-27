/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package model;

/**
 *
 * @author j4v13
 */
public class Diccionario {
    
    private String[] diccionario;

    public Diccionario() {
        String []diccionario = {"ALREDEDOR",
        "ASIA",
        "BALANZA",
        "DIAMANTE",
        "ESCRITOR",
        "GRANERO",
        "MEDIA",
        "PLASTICO",
        "QUESO",
        "ROLLO",
        "SAL",
        "SIESTA",
        "VUELTA"};
        this.diccionario = diccionario;
    }
    
    public int size() {
        return diccionario.length;
    }
    
    public String get(int i) {
        return diccionario[i];
    }
            
}
