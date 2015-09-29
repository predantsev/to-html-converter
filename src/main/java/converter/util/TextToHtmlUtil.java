package converter.util;

import java.util.Collection;

/**
 * Created by Vyacheslav Predantsev on 29.09.2015
 */
public class TextToHtmlUtil {

    public static String processStrings(Collection<String[]> stringsToSplit) {
        String[] array = new String[stringsToSplit.size()];
        int i = 0;
        for (String[] item : stringsToSplit) {
            array[i] = splitStrings(item);
            i++;
        }
        return splitStrings(array);
    }

    private static String splitStrings(String[] items) {
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < items.length; i++) {
            sb.append(items[i]);
            if (i < items.length - 1) {
                sb.append(" ");
            }
        }
        return sb.toString();
    }
}
