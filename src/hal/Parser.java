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

//        for(int i=0; i < elem.size(); ++i){
//            System.out.println(elem.get(i).toString());
//        }
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
//        boolean debugmode = false;
//        System.out.println("Debugmode? [y/n]");
//        if ("y".equals(eingabewert.next())) {
//            debugmode = true;
//        }
        int[] regs;
        regs = new int[256];
        int acc = 0;

        for (int i = 0; i < elem.size(); ++i) {
            if (debugmode == true) {
                System.out.println("Instruction: " + elem.get(i).getInstruktion() + " RegValue of Reg " + elem.get(i).getVar() + " = " + regs[elem.get(i).getVar()] + " AccValue: " + acc);
            }
            switch (elem.get(i).getInstruktion()) {
                case "START":
                    System.out.println("Programmstart...");
                    break;
                case "IN":
                    acc = eingabewert.nextInt();
                    break;
                case "STORE":
                    regs[elem.get(i).getVar()] = acc;
                    break;
                case "LOAD":
                    acc = regs[elem.get(i).getVar()];
                    break;
                case "LOADNUM":
                    acc = elem.get(i).getVar();
                    break;
                case "SUB":
                    acc = acc - regs[elem.get(i).getVar()];
                    break;
                case "SUBNUM":
                    acc = acc - elem.get(i).getVar();
                    break;
                case "ADD":
                    acc = acc + regs[elem.get(i).getVar()];
                    break;
                case "ADDNUM":
                    acc = acc + elem.get(i).getVar();
                    break;
                case "MUL":
                    acc = acc * regs[elem.get(i).getVar()];
                    break;
                case "MULNUM":
                    acc = acc * elem.get(i).getVar();
                    break;
                case "DIV":
                    acc = acc / regs[elem.get(i).getVar()];
                    break;
                case "DIVNUM":
                    acc = acc / elem.get(i).getVar();
                    break;
                case "JUMP":
                    i = (elem.get(i).getVar() - 1);
                    break;
                case "JUMPNEG":
                    if (acc < 0) {
                        i = (elem.get(i).getVar() - 1);
                    }
                    break;
                case "JUMPPOS":
                    if (acc > 0) {
                        i = (elem.get(i).getVar() - 1);
                    }
                    break;
                case "JUMPNULL":
                    if (acc == 0) {
                        i = (elem.get(i).getVar() - 1);
                    }
                    break;
                case "OUT":
                    System.out.println(acc);
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
        System.out.println("Verlaufszeit der Schleife: " + (timeEnd - timeStart) + " Millisek."); 
        System.out.println("Verlaufszeit der Schleife: " + (timeEnd - timeStart)/1000 + " Sek."); 
    }
}
