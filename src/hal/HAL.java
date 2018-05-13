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
//        final long timeStart = System.currentTimeMillis(); 
        System.out.println("hello halinterpreter");
        File f = new File("C:\\Users\\ThePhong\\Dropbox\\h_da\\3. Semester\\Betriebssystem\\Praktikum\\HAL\\src\\hal\\test1.txt");
//        File f = new File("C:\\Users\\ThePhong\\Dropbox\\h_da\\3. Semester\\Betriebssystem\\Praktikum\\HAL\\src\\hal\\HALprogramm.txt");
        Parser p = new Parser(f);
        p.lesen();
        p.show();
        p.schliessen();
        p.interpreter();
//        final long timeEnd = System.currentTimeMillis(); 
//        System.out.println("Verlaufszeit der Schleife: " + (timeEnd - timeStart) + " Millisek."); 
               

    }
     

}
