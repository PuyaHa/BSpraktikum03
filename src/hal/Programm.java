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
public class Programm {

    private int zeile;
    private String instruktion;
    private int var;
    private ArrayList<Programm> Halprg;
    
    public ArrayList<Programm> getHalprg(){
        return Halprg;
    }

    public String getInstruktion() {
        return instruktion;
    }

    public void setInstruktion(String instruktion) {
        this.instruktion = instruktion;
    }

    public int getVar() {
        return var;
    }

    public void setVar(int var) {
        this.var = var;
    }

    public int getZeile() {
        return zeile;
    }

    public void setZeile(int zeile) {
        this.zeile = zeile;
    }

    public Programm() {//Standardkonstruktor
    }

    public Programm(int zeile, String instruktion, int var) {
        this.zeile = zeile;
        this.instruktion = instruktion;
        this.var = var;
    }

    public String toString(){
        return String.format("%s %s %s", zeile, instruktion, var);
    }

}
