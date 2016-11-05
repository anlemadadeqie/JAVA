package wenjian;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.util.Scanner;

/**
 * Created by hjh on 16-7-25.
 */
public class RedirectIn {
    public static void main(String[] args) {
        try {
            FileInputStream fil = new FileInputStream("./src/wenjian/RedirectIn.java");
            System.setIn(fil);
            Scanner c = new Scanner(System.in);
            c.useDelimiter("\n");
            while (c.hasNext()) {
                System.out.println(c.next());
            }
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }
    }
}
