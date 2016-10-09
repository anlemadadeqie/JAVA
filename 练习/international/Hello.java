package international;

import java.util.Locale;
import java.util.ResourceBundle;

/**
 * Created by hjh on 16-7-21.
 */
public class Hello {
    public static void main(String[] args){
        Locale mylocale = Locale.getDefault(Locale.Category.FORMAT);

        ResourceBundle bundle = ResourceBundle.getBundle("international.mess",mylocale);
        System.out.println(mylocale);
        System.out.println(bundle.getString("hello"));
    }
}
