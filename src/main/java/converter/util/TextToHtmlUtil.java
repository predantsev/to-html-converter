package converter.util;

import converter.util.constant.HtmlConstants;
import converter.util.constant.SymbolConstants;
import converter.util.type.HtmlTagOrder;
import converter.util.type.HtmlTagType;

import java.util.StringTokenizer;

/**
 * Created by Vyacheslav Predantsev on 29.09.2015
 */
public class TextToHtmlUtil {

    public static final int DEFAULT_H_TAG_DIGIT = 1;
    public static final int MAX_H_TAG_DIGIT = 7;

    public static String convertToHtml(String stringToConvert) {
        StringBuilder sb = new StringBuilder();
        sb.append(HtmlConstants.HTML_START_TAG)
                .append(SymbolConstants.NEWLINE)
                .append(HtmlConstants.BODY_START_TAG)
                .append(SymbolConstants.NEWLINE);
        // todo: further logic
        sb.append(convert(stringToConvert));
        // todo: further logic
        sb.append(HtmlConstants.BODY_START_TAG)
                .append(SymbolConstants.NEWLINE)
                .append(HtmlConstants.HTML_END_TAG);
        return sb.toString();
    }

    private static String convert(String stringToConvert) {
        StringBuilder sb = new StringBuilder();
        StringTokenizer st = new StringTokenizer(stringToConvert, SymbolConstants.NEWLINE);
        while (st.hasMoreTokens()) {
            String str = st.nextToken().trim();
            int sharp;
            if (str.trim().startsWith(SymbolConstants.SHARP)) {
                sharp = DEFAULT_H_TAG_DIGIT;
                while (str.startsWith(SymbolConstants.SHARP, sharp)) {
                    sharp++;
                }
                if (sharp < MAX_H_TAG_DIGIT) {
                    for (int i = 0; i < sharp; i++) {
                        str = str.replaceFirst(SymbolConstants.SHARP, SymbolConstants.EMPTY);
                    }
                    convertToTags(str, sb, HtmlTagType.H_TAG, sharp);
                } else {
                    convertToTags(str, sb, HtmlTagType.P_TAG);
                }
            } else {
                convertToTags(str, sb, HtmlTagType.P_TAG);
            }
            sb.append(SymbolConstants.NEWLINE);
        }
        return sb.toString();
    }

    private static void convertToTags(String str, StringBuilder sb, HtmlTagType tagType, int sharpsForHTags) {
        while (str.contains(SymbolConstants.DOUBLE_ASTERISK)) {
            str = StringUtil.replaceFirst(str, SymbolConstants.DOUBLE_ASTERISK, HtmlConstants.STRONG_START_TAG);
            str = StringUtil.replaceFirst(str, SymbolConstants.DOUBLE_ASTERISK, HtmlConstants.STRONG_END_TAG);
        }
        while (str.contains(SymbolConstants.ASTERISK)) {
            str = StringUtil.replaceFirst(str, SymbolConstants.ASTERISK, HtmlConstants.EM_START_TAG);
            str = StringUtil.replaceFirst(str, SymbolConstants.ASTERISK, HtmlConstants.EM_END_TAG);
        }
        switch (tagType) {
            case H_TAG: {
                sb.append(hTag(sharpsForHTags, HtmlTagOrder.START)).append(str).append(hTag(sharpsForHTags, HtmlTagOrder.END));
                break;
            }
            case P_TAG: {
                sb.append(HtmlConstants.P_START_TAG).append(str).append(HtmlConstants.P_END_TAG);
                break;
            }
        }
    }

    private static void convertToTags(String str, StringBuilder sb, HtmlTagType tagType) {
        convertToTags(str, sb, tagType, DEFAULT_H_TAG_DIGIT);
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
