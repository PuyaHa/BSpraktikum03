package hal;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;

/**
 *
 * @author ThePhong
 */
public class HAL {
    
    public static void main(String[] args) throws FileNotFoundException, IOException {
        System.out.println("hello halinterpreter");
        File f = new File("/home/debian/NetBeansProjects/BSpraktikum03/src/hal/HALprogramm.txt");
        Parser p = new Parser(f);
        p.lesen();
        p.show();
//        prg.show();
//        System.out.println(prg.toString());
        p.schliessen();
        //dsafjdslkafjdslaf
        //lkdjsaöflkjdsaölfkadjf
        //abctest
     
    }
    
}

