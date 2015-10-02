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

    /**
     * It can be used instead of {@link String#replaceFirst(String, String)}
     * It helps resolve problems like replacing special symbols into another one
     * @param source handling string
     * @param target
     * @param replacement
     * @return converted string
     */
    public static String replaceFirst(String source, String target, String replacement) {
        if (source == null || target == null || replacement == null) {
            return null;
        }
        int targetIndex = source.indexOf(target);
        int targetSize = target.length();
        StringBuilder sb = new StringBuilder();
        sb.append(source.substring(0, targetIndex))
                .append(replacement)
                .append(source.substring(targetIndex + targetSize, source.length()));
        return sb.toString();
    }
}
