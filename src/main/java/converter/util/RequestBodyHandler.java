package converter.util;

import converter.util.constant.SymbolConstants;

import java.util.Map;

/**
 * Created by Vyacheslav Predantsev on 30.09.2015
 * Post request body may consist of several string's pairs key-value
 * This situation will handle in such way that there is only one string with new lines
 */
public class RequestBodyHandler {

    public static String handle(Map<String, String[]> postRequestText) {
        StringBuilder sb = new StringBuilder();
        for (String param: postRequestText.keySet()) {
            if (StringUtil.isNotEmpty(param)) {
                sb.append(param);
            }
            String[] params = postRequestText.get(param);
            for (String str: params) {
                sb.append(SymbolConstants.NEWLINE);
                sb.append(str);
            }
        }
        return sb.toString();
    }
}
