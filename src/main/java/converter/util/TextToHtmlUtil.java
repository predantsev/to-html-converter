package converter.util;

import java.util.Collection;

/**
 * Created by Vyacheslav Predantsev on 29.09.2015
 */
public class TextToHtmlUtil {

    private final static String SPACE = " ";
    private final static String HTML_START_TAG = "<html>";
    private final static String HTML_END_TAG = "</html>";
    private final static String BODY_START_TAG = "<body>";
    private final static String BODY_END_TAG = "</body>";
    private final static String P_START_TAG = "<p>";
    private final static String P_END_TAG = "</p>";
    private final static String EM_START_TAG = "<em>";
    private final static String EM_END_TAG = "</em>";
    private final static String STRONG_START_TAG = "<strong>";
    private final static String STRONG_TAG = "</strong>";

    public static String convertToHtml(Collection<String[]> stringsToSplit) {
        String target = processStrings(stringsToSplit);
        StringBuilder sb = new StringBuilder();
        sb.append(HTML_START_TAG).append(BODY_START_TAG);
        // further logic
        sb.append(BODY_START_TAG).append(HTML_END_TAG);
        return sb.toString();
    }

    private static String processStrings(Collection<String[]> stringsToSplit) {
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
                sb.append(SPACE);
            }
        }
        return sb.toString();
    }

    private static String hTag(int digit, HtmlTagOrder order) {
        StringBuilder sb = new StringBuilder();
        sb.append("<");
        if (order == HtmlTagOrder.END) {
            sb.append("/");
        }
        sb.append("h").append(digit).append(">");
        return sb.toString();
    }
}
