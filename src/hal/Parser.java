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
    private ArrayList<Programm>elem;
    

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
    
    public void show(){
          for(int i=0; i < elem.size(); ++i){
            System.out.println(elem.get(i).toString());
        }        
    }
    //kajfölkdsajfasf

    public void schliessen() {
        s.close();
    }
}
