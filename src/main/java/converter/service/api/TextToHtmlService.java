package converter.service.api;

import java.util.Map;

/**
 * Created by Vyacheslav Predantsev on 29.09.2015
 */
public interface TextToHtmlService {

    String textToHtml(boolean persist, Map<String, String[]> postRequestText);
}
