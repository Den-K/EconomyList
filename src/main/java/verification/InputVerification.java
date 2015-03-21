package verification;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 * Created by Den on 15.03.2015.
 */
public class InputVerification {

    public static boolean validateEmail(String email){
        Pattern p = Pattern.compile(".+[@].+\\.(com|ua|ru|net)");
        Matcher m = p.matcher(email);
        return m.matches();
    }
}
