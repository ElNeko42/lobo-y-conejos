/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package lobosyconejos;

import java.awt.Point;
import java.util.Iterator;
import java.util.Random;

/**
 *
 * @author Moncho
 */
public class Acciones {

    public static Point mueve(Point punto){
        switch(new Random().nextInt(9)){
            case 0:
                return punto;
            case 1:
                if(punto.getY()>0)
                    punto.setLocation(punto.getX(), punto.getY()-1);
                return punto;
            case 2:
                if(punto.getY()>0)
                    punto.setLocation(punto.getX(), punto.getY()-1);
                if(punto.getX()<Parametros.anchoTablero)
                    punto.setLocation(punto.getX()+1, punto.getY());
                return punto;
            case 3:
                if(punto.getX()<Parametros.anchoTablero)
                    punto.setLocation(punto.getX()+1, punto.getY());
                return punto;
            case 4:
                if(punto.getY()<Parametros.altoTablero)
                    punto.setLocation(punto.getX(), punto.getY()+1);
                if(punto.getX()<Parametros.anchoTablero)
                    punto.setLocation(punto.getX()+1, punto.getY());
                return punto;
            case 5:
                if(punto.getY()<Parametros.altoTablero)
                    punto.setLocation(punto.getX(), punto.getY()+1);
               return punto;
            case 6:
                if(punto.getY()<Parametros.altoTablero)
                    punto.setLocation(punto.getX(), punto.getY()+1);
                if(punto.getX()>0)
                    punto.setLocation(punto.getX()-1, punto.getY());
                return punto;
            case 7:
                if(punto.getX()>0)
                    punto.setLocation(punto.getX()-1, punto.getY());
                return punto;
            default:
                if(punto.getY()>0)
                    punto.setLocation(punto.getX(), punto.getY()-1);
                if(punto.getX()>0)
                    punto.setLocation(punto.getX()-1, punto.getY());
                return punto;
        }   
    }
    
    public static void comprueba(Lobos objeto){
        
        // Recorro los conejos
        Iterator it= Parametros.conejos.iterator();
        while(it.hasNext()){
            Conejos conejo=(Conejos) it.next();
            if(objeto.posicion.equals(conejo.posicion)){
                if(conejo.semaforo.tryAcquire()){
                    System.out.println("Un lobo se ha comido un conejo");
                    conejo.vida=0;
                    conejo.semaforo.release();
                    it.remove();
                    System.out.println("Quedan "+Parametros.conejos.size()+" conejos");   
                }
            }
        }
        
        // Recorro los lobos
        it= Parametros.lobos.iterator();
        while(it.hasNext()){
            Lobos lobo=(Lobos) it.next();
            if(!lobo.equals(objeto)){
                if(lobo.posicion.equals(objeto.posicion)){
                    Parametros.lobos.add(new Lobos());
                    Parametros.lobos.get(Parametros.lobos.size()-1).start();
                }
            }
                
        }
    }
    
    public static boolean comprueba(Conejos objeto){
        // Devuelve true si sigue vivo y false si muere
        Iterator it= Parametros.lobos.iterator();
        while(it.hasNext()){
            Lobos lobo=(Lobos) it.next();
            if(objeto.posicion.equals(lobo.posicion)){
                System.out.println("Un lobo se ha comido un conejo 2");
                mataconejo(objeto);
                System.out.println("Quedan "+Parametros.conejos.size()+" conejos");
                return false;
            }
        }
        if(Math.random()>.75){
            it = Parametros.conejos.iterator();
            while(it.hasNext()){
                Conejos conejo= (Conejos) it.next();
                if(!conejo.equals(objeto)){
                    Parametros.conejos.add(new Conejos());
                    Parametros.conejos.get(Parametros.conejos.size()-1).start();

                }
            }
        }
        return true;
    }

    private static void mataconejo(Conejos objeto) {
        Iterator it= Parametros.conejos.iterator();
        while(it.hasNext()){
            Conejos conejo=(Conejos) it.next();
            if(objeto.equals(conejo)){
                it.remove();
                System.out.println("Un lobo se ha comido un conejo");
                
                System.out.println("Quedan "+Parametros.conejos.size()+" conejos");
            }
        }
    }
}
