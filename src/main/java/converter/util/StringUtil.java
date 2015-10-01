package converter.util;

/**
 * Created by Vyacheslav Predantsev on 01.10.2015
 */
public class StringUtil {

    public static boolean isEmpty(String str) {
        return str == null || str.isEmpty();
    }

    public static boolean isNotEmpty(String str) {
        return !isEmpty(str);
    }
}
