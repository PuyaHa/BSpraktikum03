/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package hal;

import java.util.ArrayList;

/**
 *
 * @author ThePhong
 */
public class HalProgramm {
    private ArrayList<Programm>halprg;

    public HalProgramm(ArrayList<Programm> halprg) {
        this.halprg = halprg;
    }

    public HalProgramm() {
    }

    public void setHalprg(ArrayList<Programm> halprg) {
        this.halprg = halprg;
    }
    
//FDSAJFKDSAF
    //kdsjaföldsakjfsödalkfjsdaölkf
    public ArrayList<Programm> getHalprg() {
        return halprg;
    }
    
    
    
    public void show(){
        for(int i=0; i < halprg.size(); ++i){
            System.out.println(halprg.get(i).toString());
        }
    }
    
}
