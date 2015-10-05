package converter.handler;

import converter.util.StringUtil;
import converter.util.constant.HtmlConstant;
import converter.util.constant.SymbolConstant;
import converter.util.constant.TextToHtmlHelpConstant;
import converter.util.type.HtmlTagOrder;
import converter.util.type.HtmlTagType;
import org.springframework.stereotype.Component;

import java.util.StringTokenizer;

/**
 * Created by Vyacheslav Predantsev on 29.09.2015
 */
@Component
public class TextToHtmlHandler {

    public String convertToHtml(String stringToConvert) {
        return HtmlConstant.HTML_START_TAG
                + SymbolConstant.NEWLINE
                + HtmlConstant.BODY_START_TAG
                + SymbolConstant.NEWLINE
                + convert(stringToConvert)
                + HtmlConstant.BODY_END_TAG
                + SymbolConstant.NEWLINE
                + HtmlConstant.HTML_END_TAG;
    }

    private String convert(String stringToConvert) {
        StringBuilder sb = new StringBuilder();
        StringTokenizer st = new StringTokenizer(stringToConvert, SymbolConstant.NEWLINE);
        while (st.hasMoreTokens()) {
            String str = st.nextToken().trim();
            int sharp;
            if (str.trim().startsWith(SymbolConstant.SHARP)) {
                sharp = TextToHtmlHelpConstant.DEFAULT_H_TAG_DIGIT;
                while (str.startsWith(SymbolConstant.SHARP, sharp)) {
                    sharp++;
                }
                if (sharp < TextToHtmlHelpConstant.MAX_H_TAG_DIGIT) {
                    for (int i = 0; i < sharp; i++) {
                        str = str.replaceFirst(SymbolConstant.SHARP, SymbolConstant.EMPTY);
                    }
                    convertToTags(str, sb, HtmlTagType.H_TAG, sharp);
                } else {
                    convertToTags(str, sb, HtmlTagType.P_TAG);
                }
            } else {
                convertToTags(str, sb, HtmlTagType.P_TAG);
            }
            sb.append(SymbolConstant.NEWLINE);
        }
        return sb.toString();
    }

    private void convertToTags(String str, StringBuilder sb, HtmlTagType tagType, int sharpsForHTags) {
        while (str.contains(SymbolConstant.DOUBLE_ASTERISK)) {
            str = StringUtil.replaceFirst(str, SymbolConstant.DOUBLE_ASTERISK, HtmlConstant.STRONG_START_TAG);
            str = StringUtil.replaceFirst(str, SymbolConstant.DOUBLE_ASTERISK, HtmlConstant.STRONG_END_TAG);
        }
        while (str.contains(SymbolConstant.ASTERISK)) {
            str = StringUtil.replaceFirst(str, SymbolConstant.ASTERISK, HtmlConstant.EM_START_TAG);
            str = StringUtil.replaceFirst(str, SymbolConstant.ASTERISK, HtmlConstant.EM_END_TAG);
        }
        while (str.contains(TextToHtmlHelpConstant.LINK_DETECTION)) {
            int linkDetection = str.indexOf(TextToHtmlHelpConstant.LINK_DETECTION);
            int linkStart = str.lastIndexOf(SymbolConstant.OPEN_SQUARE_BRACKETS, linkDetection);
            int linkEnd = str.indexOf(SymbolConstant.CLOSE_BRACKETS, linkDetection) + 1;
            String link = str.substring(linkStart, linkEnd);
            str = convertToLink(str, link);
        }
        switch (tagType) {
            case H_TAG: {
                sb.append(hTag(sharpsForHTags, HtmlTagOrder.START)).append(str).append(hTag(sharpsForHTags, HtmlTagOrder.END));
                break;
            }
            case P_TAG: {
                sb.append(HtmlConstant.P_START_TAG).append(str).append(HtmlConstant.P_END_TAG);
                break;
            }
        }
    }

    private void convertToTags(String str, StringBuilder sb, HtmlTagType tagType) {
        convertToTags(str, sb, tagType, TextToHtmlHelpConstant.DEFAULT_H_TAG_DIGIT);
    }

    private String convertToLink(String str, String link) {
        String htmlLink = HtmlConstant.A_START_OPEN_TAG
                + link.substring(link.indexOf(SymbolConstant.OPEN_BRACKETS) + 1, link.indexOf(SymbolConstant.CLOSE_BRACKETS))
                + HtmlConstant.A_START_CLOSE_TAG
                + link.substring(link.indexOf(SymbolConstant.OPEN_SQUARE_BRACKETS) + 1, link.indexOf(SymbolConstant.CLOSE_SQUARE_BRACKETS))
                + HtmlConstant.A_END_TAG;
        return str.replace(link, htmlLink);
    }

    private String hTag(int digit, HtmlTagOrder order) {
        StringBuilder sb = new StringBuilder();
        sb.append("<");
        if (order == HtmlTagOrder.END) {
            sb.append("/");
        }
        sb.append("h").append(digit).append(">");
        return sb.toString();
    }
}
