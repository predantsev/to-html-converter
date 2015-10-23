package converter.handler;

import converter.util.StringUtil;
import converter.util.constant.SymbolConstant;
import org.springframework.stereotype.Component;

import java.util.Map;

/**
 * Created by Vyacheslav Predantsev on 30.09.2015
 * Post request body may consist of several string's pairs key-value
 * This situation will handle in such way that there is only one string with new lines
 */
@Component("requestBodyHandler")
public class RequestBodyHandler implements Handler<Map<String, String[]>> {

    @Override
    public String handle(Map<String, String[]> postRequestText) {
        StringBuilder sb = new StringBuilder();
        for (String param: postRequestText.keySet()) {
            if (StringUtil.isNotEmpty(param)) {
                sb.append(param);
            }
            String[] params = postRequestText.get(param);
            for (String str: params) {
                sb.append(SymbolConstant.NEWLINE);
                sb.append(str);
            }
        }
        return sb.toString();
    }
}
