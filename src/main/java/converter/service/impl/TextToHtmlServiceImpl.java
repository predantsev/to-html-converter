package converter.service.impl;

import converter.dao.api.RequestDao;
import converter.handler.Handler;
import converter.service.api.TextToHtmlService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;

import java.util.Map;

/**
 * Created by Vyacheslav Predantsev on 29.09.2015
 */
@Service
public class TextToHtmlServiceImpl implements TextToHtmlService {

    @Autowired
    @Qualifier("requestBodyHandler")
    private Handler<Map<String, String[]>> requestBodyHandler;

    @Autowired
    private RequestDao requestDao ;

    @Autowired
    @Qualifier("textToHtmlHandler")
    private Handler<String> textToHtmlHandler;

    @Override
    public String textToHtml(boolean persist, Map<String, String[]> postRequestText) {
        String handledRequest = requestBodyHandler.handle(postRequestText);
        if (persist) {
            requestDao.saveRequest(handledRequest);
        }
        return textToHtmlHandler.handle(handledRequest);
    }
}
