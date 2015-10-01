package converter.util;

import java.util.Map;

/**
 * Created by Vyacheslav Predantsev on 30.09.2015
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
