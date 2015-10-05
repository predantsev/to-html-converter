package converter.service.impl;

import converter.service.api.TextToHtmlService;
import converter.handler.RequestBodyHandler;
import converter.handler.TextToHtmlHandler;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Map;

/**
 * Created by Vyacheslav Predantsev on 29.09.2015
 */
@Service
public class TextToHtmlServiceImpl implements TextToHtmlService {

    @Autowired
    private RequestBodyHandler requestBodyHandler;

    @Autowired
    private TextToHtmlHandler textToHtmlHandler;


    @Override
    public String textToHtml(Map<String, String[]> postRequestText) {
        String handledRequest = requestBodyHandler.handle(postRequestText);
        return textToHtmlHandler.convertToHtml(handledRequest);
    }
}
