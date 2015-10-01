package converter.service.impl;

import converter.service.api.TextToHtmlService;
import converter.util.RequestBodyHandler;
import converter.util.TextToHtmlUtil;
import org.springframework.stereotype.Service;

import java.util.Map;

/**
 * Created by Vyacheslav Predantsev on 29.09.2015
 */
@Service
public class TextToHtmlServiceImpl implements TextToHtmlService {

    @Override
    public String textToHtml(Map<String, String[]> postRequestText) {
        String handledRequest = RequestBodyHandler.handle(postRequestText);
        return TextToHtmlUtil.convertToHtml(handledRequest);
    }
}
