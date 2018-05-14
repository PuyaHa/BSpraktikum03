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
        File f = new File("empty");
        if (args.length == 1) {
            f = new File("/home/debian/NetBeansProjects/BSpraktikum03/src/HALcodes/" + args[0]);
        } else {
            if (args[0].equals("-debug")) {
                debugmode = true;
                f = new File("/home/debian/NetBeansProjects/BSpraktikum03/src/HALcodes/" + args[1]);
            } else if (args[1].equals("-debug")) {
                debugmode = true;
                f = new File("/home/debian/NetBeansProjects/BSpraktikum03/src/HALcodes/" + args[0]);
            }
        }
        Parser p;
        p = new Parser(f);
        p.lesen();
//        p.show();
        p.schliessen();
        p.interpreter(debugmode);

    }
}
