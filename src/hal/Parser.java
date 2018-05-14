package hal;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

/**
 *
 * @author ThePhong
 */
public class Parser {

    private ArrayList<Programm> elem;
//    Programm[] prog = new Programm[];

    Scanner s;

    Parser(File f) throws FileNotFoundException {
        s = new Scanner(f);
    }

    public void lesen() {

        elem = new ArrayList<>();

        while (s.hasNext()) {
            int zeile = s.nextInt();
            String instruktion = s.next();
            int var = s.nextInt();
            Programm prg = new Programm(zeile, instruktion, var);
            elem.add(prg);
        }
    }

    public void show() {
        for (int i = 0; i < elem.size(); ++i) {
            System.out.println(elem.get(i).toString());
        }
    }

    public void schliessen() {
        s.close();
    }

    public void interpreter(boolean debugmode) {
        final long timeStart = System.currentTimeMillis(); 
        
        Scanner eingabewert = new Scanner(System.in);
//       
        int[] regs;
        regs = new int[256];
        int acc = 0;

        for (int i = 0; i < elem.size(); ++i) {
//            if (debugmode == true) {
//                System.out.println("Instruction: " + elem.get(i).getInstruktion() + " RegValue of Reg " + elem.get(i).getVar() + " = " + regs[elem.get(i).getVar()] + " AccValue: " + acc);
//            }
            switch (elem.get(i).getInstruktion()) {
                case "START":
                    System.out.println("Programmstart...");
                    break;
                case "IN":
                    acc = eingabewert.nextInt();
                    if(debugmode == true){
                        System.out.println("AccValue: "+ acc);
                    }
                    break;
                case "STORE":
                    regs[elem.get(i).getVar()] = acc;
                    if(debugmode == true){
                        System.out.println("AccValue: "+ acc + " STORE in Reg: "+ elem.get(i).getVar());                      
                    }
                    break;
                case "LOAD":
                    acc = regs[elem.get(i).getVar()];
                     if(debugmode == true){
                        System.out.println("LOAD from Reg: "+ elem.get(i).getVar() + " AccValue: "+ acc);                      
                    }
                    break;
                case "LOADNUM":
                    acc = elem.get(i).getVar();
                    if(debugmode == true){
                        System.out.println("LOAD var in Acc: "+ elem.get(i).getVar() + " AccValue: "+ acc);                      
                    }
                    break;
                case "SUB":
                    if(debugmode == true){
                        System.out.printf("SUB = AccValue - RegValue = " + acc + " - " + regs[elem.get(i).getVar()] + "\n");                      
                    }
                    acc = acc - regs[elem.get(i).getVar()];
                     if(debugmode == true){
                        System.out.printf("AccRESULT = " + acc + "\n");                      
                    }
                    break;
                case "SUBNUM":
                    if(debugmode == true){
                        System.out.printf("SUB = AccValue - Value = " + acc + " - " + elem.get(i).getVar() + "\n");                      
                    }
                    acc = acc - elem.get(i).getVar();
                    if(debugmode == true){
                        System.out.printf("AccRESULT = " + acc + "\n");                      
                    }
                    break;
                case "ADD":
                    if(debugmode == true){
                        System.out.printf("ADD = AccValue + RegValue = " + acc + " + " + regs[elem.get(i).getVar()] + "\n");                      
                    }
                    acc = acc + regs[elem.get(i).getVar()];
                     if(debugmode == true){
                        System.out.printf("AccRESULT = " + acc + "\n");                      
                    }
                    break;         
                case "ADDNUM":
                    if(debugmode == true){
                        System.out.printf("ADDNUM = AccValue + Value = " + acc + " + " + elem.get(i).getVar() + "\n");                      
                    }
                    acc = acc + elem.get(i).getVar();
                     if(debugmode == true){
                        System.out.printf("AccRESULT = " + acc + "\n");                      
                    }
                    break;
                case "MUL":
                    if(debugmode == true){
                        System.out.printf("MUL = AccValue * RegValue = " + acc + " * " + regs[elem.get(i).getVar()] + "\n");                      
                    }
                    acc = acc * regs[elem.get(i).getVar()];
                     if(debugmode == true){
                        System.out.printf("AccRESULT = " + acc + "\n");                      
                    }
                    break;
                case "MULNUM":
                     if(debugmode == true){
                        System.out.printf("MULNUM = AccValue * Value = " + acc + " * " + elem.get(i).getVar() + "\n");                      
                    }
                    acc = acc * elem.get(i).getVar();
                     if(debugmode == true){
                        System.out.printf("AccRESULT = " + acc + "\n");                      
                    }
                    break;
                case "DIV":
                    if(debugmode == true){
                        System.out.printf("DIV = AccValue / RegValue = " + acc + " / " + regs[elem.get(i).getVar()] + "\n");                      
                    }
                    acc = acc / regs[elem.get(i).getVar()];
                     if(debugmode == true){
                        System.out.printf("AccRESULT = " + acc + "\n");                      
                    }
                    break;
                case "DIVNUM":
                    if(debugmode == true){
                        System.out.printf("DIVNUM = AccValue / Value = " + acc + " / " + elem.get(i).getVar() + "\n");                      
                    }
                    acc = acc / elem.get(i).getVar();
                     if(debugmode == true){
                        System.out.printf("AccRESULT = " + acc + "\n");                      
                    }
                    break;
                case "JUMP":
                    i = (elem.get(i).getVar() - 1);
                    if(debugmode == true){
                        System.out.println("JUMP: address: "+ elem.get(i).getVar());                      
                    }
                    break;
                case "JUMPNEG":
                    if (acc < 0) {
                        i = (elem.get(i).getVar() - 1);
                        if(debugmode == true){
                        System.out.println("JUMPNEG: address: "+ elem.get(i).getVar());                      
                    }
                    }
                    break;
                case "JUMPPOS":
                    if (acc > 0) {
                        i = (elem.get(i).getVar() - 1);
                        if(debugmode == true){
                        System.out.println("JUMPPOS: address: "+ elem.get(i).getVar());                      
                    }
                    }
                    break;
                case "JUMPNULL":
                    if (acc == 0) {
                        i = (elem.get(i).getVar() - 1);
                        if(debugmode == true){
                        System.out.println("JUMPNULL: address: "+ elem.get(i).getVar());                      
                    }
                    }
                    break;
                case "OUT":
                    System.out.println(acc);
                     if(debugmode == true){
                        System.out.println("AccValue: "+ acc);                      
                    }
                    break;
                case "STOP":
                    System.out.println("...Programmende");
                    break;
            }
//            if (debugmode == true) {
//                System.out.println("RegValue of Reg " + elem.get(i).getVar() + " = " + regs[elem.get(i).getVar()] + " AccValue: " + acc);
//            }
         
        }
        final long timeEnd = System.currentTimeMillis(); 
        System.out.println("Programmlaufzeit: " + (timeEnd - timeStart) + " Millisek."); 
        System.out.println("Programmlaufzeit: " + (timeEnd - timeStart)/1000 + " Sek."); 
    }
}
