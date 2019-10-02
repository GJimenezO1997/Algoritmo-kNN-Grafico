//Autor Gustavo Jiménez Oaxaca
/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package knn;

import java.io.*;
/**
 *
 * @author gusta_000
 */
public class Punto implements Comparable<Punto>{
    private int coordenadaX, coordenadaY, clase;
    private double distancia;
    private String dice;
    
    //Geters y Setters
    public int getCoordenadaX(){
        return coordenadaX;
    }
    public void setCoordenadaX(int coordenadaX){
        this.coordenadaX = coordenadaX;
    }
    public int getCoordenadaY(){
        return coordenadaY;
    }
    public void setCoordenadaY(int coordenadaY){
        this.coordenadaY = coordenadaY;
    }
    public int getClase(){
        return clase;
    }
    public void setClase(int clase){
        this.clase = clase;
    }
    public double getDistancia(){
        return distancia;
    }
    public void setDistancia(double distancia){
        this.distancia = distancia;
    }
    public String getDice(){
        return dice;
    }
    public void setDice(String dice){
        this.dice = dice;
    }
    
    @Override
    public int compareTo(Punto compareDistancia){	
	return Double.compare(this.distancia, compareDistancia.getDistancia());
    }	
}
