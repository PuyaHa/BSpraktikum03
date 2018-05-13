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
        File f = new File("/home/debian/Dokumente/Betriebssystem/HAL_interpreter/BSpraktikum03/src/hal/HALprogramm.txt");

        if (args[0].equals("debug")) {
            debugmode = true;
            Parser p;
            p = new Parser(f);

            p.lesen();
            p.show();
            p.schliessen();
            p.interpreter(debugmode);
        } else if (args[0].equals(f)) {

            Parser p;
            p = new Parser(f);

            p.lesen();
            p.show();
            p.schliessen();
            p.interpreter(debugmode);
        }
    }
}
