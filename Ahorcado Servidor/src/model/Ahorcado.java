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
public class Ahorcado {
    
    private char[] palabra;
    private char[] adivina;
    private int intentos;
    private boolean logrado;

    public Ahorcado() {
        
        Diccionario d = new Diccionario();
        String p = d.get((int)(Math.random()*d.size()));
        
        palabra = new char[p.length()];
        for (int i = 0; i < p.length(); i++) {
            palabra[i] = p.charAt(i);
        }
        
        adivina = new char[p.length()];
        for (int i = 0; i < p.length(); i++) {
            adivina[i] = '-';
        }
        
        intentos = 5;
    }
    
    public String intenta(char c) {
        if(intentos > 0) {
            c = Character.toUpperCase(c);
            boolean f = true;
            boolean g = true;
            for (int i = 0; i < palabra.length; i++) {
                if(palabra[i] == c) {
                    f = false;
                    adivina[i] = c;
                }
                if(palabra[i] != adivina[i]) {
                    g = false;
                }
            }
            logrado = g;
            if(f) {
                intentos--;
            }
            return toString();
        } else {
            return "perdiste";
        }
    }        
    
    public char[] getPalabra() {
        return this.palabra;
    }

    public char[] getAdivina() {
        return adivina;
    }
        
    public int getIntentos() {
        return intentos;
    }
    
    public boolean isLogrado() {
        return logrado;        
    }

    public String toString() {
        String s = new String();
        for (int i = 0; i < palabra.length; i++) {
            s += adivina[i];
        }
        return s;
    }
    
}
