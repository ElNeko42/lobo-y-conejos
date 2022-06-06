/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package lobosyconejos;

import java.awt.Point;
import java.util.Iterator;
import java.util.Random;
import java.util.logging.Level;
import java.util.logging.Logger;


public class Lobos extends Thread{
    int vida;
    Point posicion;

    Lobos(){
        vida = 1000 + (int) Math.random()*10;
        posicion= new Point(new Random().nextInt(Parametros.anchoTablero), new Random().nextInt(Parametros.altoTablero));
    }
    
    @Override
    public void run() {
        while( vida>0){
            posicion.setLocation(Acciones.mueve(posicion.getLocation()));
            Acciones.comprueba(this);
            //System.out.println(posicion.toString());
            try {
                Thread.sleep(500 + (int) Math.random()*100);
            } catch (InterruptedException ex) {
                Logger.getLogger(Conejos.class.getName()).log(Level.SEVERE, null, ex);
            }
            vida--;
        }
        Iterator it=Parametros.lobos.iterator();
        while(it.hasNext()){
            if(it.equals(this)){
                it.remove();
                break;
            }
        }
    }    
}
