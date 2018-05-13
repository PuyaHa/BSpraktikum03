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
        
        for (int i = 0; i < args.length; i++) {
            System.out.println(args[i]);
        }
        if (args[0].equals("0"))
            System.out.println("Der erste Parameter ist: " + args[0]);
        else if (args[0].equals("1"))
            System.out.println("Hallo Welt!");
        else
            System.out.println("Der Parameter ist nicht erlaubt!");
    }
} 

//        System.out.println("hello halinterpreter");
//        File f = new File("C:\\Users\\ThePhong\\Dropbox\\h_da\\3. Semester\\Betriebssystem\\Praktikum\\HAL\\src\\hal\\HALprogramm.txt");
//        Parser p = new Parser(f);
//        p.lesen();
//        p.show();
//        p.schliessen();
//        p.interpreter();
//
//    }
//
//}
