/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package lobosyconejos;

/**
 *
 * @author Moncho
 */
public class LobosyConejos {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        for(int i=0;i<50; i++){
            Parametros.conejos.add(new Conejos());
            Parametros.conejos.get(Parametros.conejos.size()-1).start();
        }
        for(int i=0;i<200; i++){
            Parametros.lobos.add(new Lobos());
            Parametros.lobos.get(Parametros.lobos.size()-1).start();
        }
        
        Isla miIsla=new Isla();
        miIsla.setVisible(true);
    }
    
}
