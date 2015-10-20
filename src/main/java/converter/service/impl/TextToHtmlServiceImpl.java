package converter.service.impl;

import converter.dao.api.RequestDao;
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
    private RequestDao requestDao ;

    @Autowired
    private TextToHtmlHandler textToHtmlHandler;

    @Override
    public String textToHtml(boolean persist, Map<String, String[]> postRequestText) {
        String handledRequest = requestBodyHandler.handle(postRequestText);
        if (persist) {
            requestDao.saveRequest(handledRequest);
        }
        return textToHtmlHandler.convertToHtml(handledRequest);
    }
}
