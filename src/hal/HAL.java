package hal;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;

/**
 *
 * @author ThePhong
 */
public class HAL {

    public static void main(String[] args) throws FileNotFoundException {
        boolean debugmode = false;

        if (args[0].equals("debug")) {
            debugmode = true;
        } //            System.out.println("Der erste Parameter ist: " + args[0]);
        else if (args[0].equals("1")) {
            System.out.println("Hallo Welt!");
        } //            System.out.println("Der Parameter ist nicht erlaubt!");

        File f = new File("/home/debian/NetBeansProjects/BSpraktikum03/src/hal/HALprogramm.txt");
        Parser p;
        p = new Parser(f);

        p.lesen();
        p.show();
        p.schliessen();
        p.interpreter(debugmode);
    }
}
