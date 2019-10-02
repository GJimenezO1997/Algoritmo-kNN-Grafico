//Autor Gustavo Jiménez Oaxaca
/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package knn;

import java.awt.Color;
import java.awt.Graphics;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import static java.lang.Math.sqrt;
import java.util.Random;
import java.util.Arrays; 

/**
 *
 * @author gusta_000
 */
public class Plano2D extends javax.swing.JPanel {
    int ponerX, ponerY;
    public Plano2D(){
        //addMouseListener(this);
    }
    
    public static Punto[] p = new Punto[900];
    int numeroPatronesN = 0;
   
    static {
       // Instanciar array de objetos
       for(int i = 0; i < p.length; i++)
           p[i] = new Punto();
    }

    @Override
    public void paintComponent(Graphics g) {
        super.paintComponent(g); //To change body of generated methods, choose Tools | Templates.
        //Dibuja el plano 
        g.setColor(Color.red);
        g.drawLine(296, this.getHeight(), 296, 0);
        g.drawLine(1920, 284, 0,284);
        //g.drawLine(0, this.getHeight()/2, this.getWidth(), this.getHeight()/2);
        //g.drawLine(this.getWidth()/2, 0,this.getWidth()/2 , this.getHeight());
    }

    public void generarPatrones(Graphics g, int numeroPatrones, int numeroClases){
        //Dibuja los patrones de forma aleatorea dentro del plano
        int numeroPartes = numeroPatrones/numeroClases;
        Random random = new Random();
        numeroPatronesN = numeroPatrones;
        int rangoRandomX = (int) (Math.random()*(290-100))+100;
        int rangoRandomY = (int) (Math.random()*(100-0))+0;
        int rangoRandom1X = (int) (Math.random()*(290-100))+100;
        int rangoRandom1Y = (int) (Math.random()*(320-140))+140;
        int rangoRandom2X = (int) (Math.random()*(290-100))+100;
        int rangoRandom2Y = (int) (Math.random()*(290-180))+180;
        int rangoRandom3X = (int) (Math.random()*(320-200))+200;
        int rangoRandom3Y = (int) (Math.random()*(290-180))+180;
        int rangoRandom4X = (int) (Math.random()*(320-100))+100;
        int rangoRandom4Y = (int) (Math.random()*(90-2))+2;
      
        for (int i = 0; i < numeroClases; i++) {
            if(i == 0){
                for( int j = 0; j <numeroPartes; j++){       
                    int X = (int) (Math.random()*(rangoRandomX-60))+60;
                    int Y = (int) (Math.random()*(200-rangoRandomY))+rangoRandomY;
                    //Se ingresan valores al objeto Punto
                    p[j].setCoordenadaX(X);
                    p[j].setCoordenadaY(Y);
                    p[j].setClase(i);
                    p[j].setDice("Clase 1");    
                    g.setColor(Color.GREEN);
                    g.drawOval(X, Y, 6, 6);
                }
            } else if(i == 1){
                for( int j = numeroPartes; j <numeroPartes*2; j++){
                    int X = (int) (Math.random()*(rangoRandom1X-10))+10;
                    int Y = (int) (Math.random()*(400-rangoRandom1Y))+rangoRandom1Y;
                    //Se ingresan valores al objeto Punto
                    p[j].setCoordenadaX(X);
                    p[j].setCoordenadaY(Y);
                    p[j].setClase(i);
                    p[j].setDice("Clase 2");
                    g.setColor(Color.BLUE);
                    g.drawOval(X, Y, 6, 6);
                }
            } else if(i == 2){
                for( int j = numeroPartes*2; j <numeroPartes*3; j++){
                    int X = (int) (Math.random()*(420-rangoRandom2X))+rangoRandom2X;
                    int Y = (int) (Math.random()*(400-rangoRandom2Y))+rangoRandom2Y;
                    //Se ingresan valores al objeto Punto
                    p[j].setCoordenadaX(X);
                    p[j].setCoordenadaY(Y);
                    p[j].setClase(i);
                    p[j].setDice("Clase 3");
                    g.setColor(Color.MAGENTA);
                    g.drawOval(X, Y, 6, 6);
                }
            } else if(i == 3){
                for( int j = numeroPartes*3; j <numeroPartes*4; j++){
                    int X = (int) (Math.random()*(rangoRandom3X-410))+410;
                    int Y = (int) (Math.random()*(100-rangoRandom3Y))+rangoRandom3Y;
                    //Se ingresan valores al objeto Punto
                    p[j].setCoordenadaX(X);
                    p[j].setCoordenadaY(Y);
                    p[j].setClase(i);
                    p[j].setDice("Clase 4");
                    g.setColor(Color.ORANGE);
                    g.drawOval(X, Y, 6, 6);
                }
            }else if(i == 4){
                for( int j = numeroPartes*4; j <numeroPartes*5; j++){
                    g.setColor(Color.BLACK);
                    int X = (int) (Math.random()*(400-rangoRandom4X))+rangoRandom4X;
                    int Y = (int) (Math.random()*(150-rangoRandom4Y))+rangoRandom4Y;
                    //Se ingresan valores al objeto Punto
                    p[j].setCoordenadaX(X);
                    p[j].setCoordenadaY(Y);
                    p[j].setClase(i);
                    p[j].setDice("Clase 5");            
                    g.drawOval(X, Y, 6, 6);
                }
            }     
        }
        //Cambia el tamaño del arreglo de objetos por el número de patrones
        p = Arrays.copyOf(p, numeroPatrones);
    }
    public void dibujaPuntoNuevo(Graphics g ,int coordX, int coordY){
        //Dibujar el nuevo punto
        g.setColor(Color.RED);
        g.drawOval(coordX, coordY, 6, 6);
    }
    
    public void dibujaPuntoNuevoClasificado(Graphics g ,int coordX, int coordY, int clase){
       if (clase == 1) {
            g.setColor(Color.GREEN);
            g.drawOval(coordX, coordY, 6, 6);
        }else if(clase == 2){
            g.setColor(Color.BLUE);
            g.drawOval(coordX, coordY, 6, 6);
        }else if(clase == 3){
            g.setColor(Color.MAGENTA);
            g.drawOval(coordX, coordY, 6, 6);
        }else if(clase == 4){
            g.setColor(Color.ORANGE);
            g.drawOval(coordX, coordY, 6, 6);
        }else if(clase == 5){
            g.setColor(Color.BLACK);
            g.drawOval(coordX, coordY, 6, 6);
        }
    }
    
    public int clasificar(Punto nuevoPunto, int k, int numeroPatrones, int numberClicks){
        // Calcular distancia con cada punto generado 
        for (int i = 0; i < p.length; i++){ 
            p[i].setDistancia(sqrt((p[i].getCoordenadaX() - nuevoPunto.getCoordenadaX()) * (p[i].getCoordenadaX() - nuevoPunto.getCoordenadaX()) + 
                     (p[i].getCoordenadaY() - nuevoPunto.getCoordenadaY()) * (p[i].getCoordenadaY() - nuevoPunto.getCoordenadaY()))); 
        }
        //-80, 89 X, 89, 95 Y
        //Ordenar la distancia mas cercana al punto ingresado
        Arrays.sort(p);

        int freq1 = 0;    
        int freq2 = 0;     
        int freq3 = 0;      
        int freq4 = 0;     
        int freq5 = 0;     
        //Se obtiene el mayor número de clases que tienen la distancia más corta
        for (int i = 0; i < k; i++){ 
            if (p[i].getClase() == 0){
                freq1++; 
                System.out.println("F1: "+ freq1);
            } else if (p[i].getClase() == 1) {
                freq2++; 
                System.out.println("F2: "+ freq2);
            } else if (p[i].getClase() == 2) {
                freq3++; 
                System.out.println("F3: "+ freq3);
            } else if (p[i].getClase() == 3){
                freq4++; 
            } else if (p[i].getClase() == 4){ 
                freq5++; 
            }
        }
      
        int pertenece = 0;
        //Se identifica a que clase pertenece el nuevo punto
        if(freq1 > freq2 && freq1 > freq3 && freq1 > freq4 && freq1 > freq5){
            pertenece = 1;
            System.out.println(""+ pertenece);
        }else if(freq2 > freq1 && freq2 > freq3 && freq2 > freq4 && freq2 > freq5){
            pertenece = 2;
            System.out.println(""+ pertenece);
        }else if(freq3 > freq1 && freq3 > freq2 && freq3 > freq4 && freq3 > freq5){
            pertenece = 3;
            System.out.println(""+ pertenece);
        } else if(freq4 > freq1 && freq4 > freq2 && freq4 > freq3 && freq4 > freq5){
            pertenece = 4;
            System.out.println(""+ pertenece);
        } else if(freq5 > freq1 && freq5 > freq2 && freq5 > freq4 && freq5 > freq4){
            pertenece = 5;
            System.out.println(""+ pertenece);
        }
        
        for (int i = 0; i < p.length; i++) {
            System.out.println(i+"-Coord: X "+p[i].getCoordenadaX()+" Y"+p[i].getCoordenadaY()+" Distancia   "+p[i].getDistancia()+"   "+p[i].getDice());
        }
        
        System.out.println("");
        int nuevoTamArray = 0;
        if(numberClicks == 1){
            nuevoTamArray = p.length + numberClicks;
        } else if(numberClicks > 1){
            nuevoTamArray = p.length + numberClicks - numberClicks + 1;
        }
        p = Arrays.copyOf(p, nuevoTamArray);
        int Xcoord = nuevoPunto.getCoordenadaX();  
        int Ycoord = nuevoPunto.getCoordenadaY(); 
        p[nuevoTamArray-1] = new Punto();
        p[nuevoTamArray-1].setCoordenadaX(Xcoord);   
        p[nuevoTamArray-1].setCoordenadaY(Ycoord);
        p[nuevoTamArray-1].setClase(pertenece - 1);
        p[nuevoTamArray-1].setDice("Clase "+pertenece);
        
        return pertenece;
    }

    
    public int ponerX(){
        int x = ponerX;
        return x;            
    }
    public int ponerY(){
        int y = ponerY;
        return y;            
    }
}