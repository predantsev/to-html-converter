package converter.util;

import java.util.StringTokenizer;

/**
 * Created by Vyacheslav Predantsev on 29.09.2015
 */
public class TextToHtmlUtil {

    public static String convertToHtml(String stringToConvert) {
        StringBuilder sb = new StringBuilder();
        sb.append(HtmlConstants.HTML_START_TAG)
                .append(SymbolConstants.NEWLINE)
                .append(HtmlConstants.BODY_START_TAG)
                .append(SymbolConstants.NEWLINE);
        // further logic
        convert(stringToConvert);
        sb.append(stringToConvert);
        // further logic
        sb.append(SymbolConstants.NEWLINE)
                .append(HtmlConstants.BODY_START_TAG)
                .append(SymbolConstants.NEWLINE)
                .append(HtmlConstants.HTML_END_TAG);
        return sb.toString();
    }

    private static String convert(String stringToConvert) {
        StringTokenizer st = new StringTokenizer(stringToConvert, SymbolConstants.NEWLINE);
        while (st.hasMoreTokens()) {
            String str = st.nextToken();
        }
        return null;
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
