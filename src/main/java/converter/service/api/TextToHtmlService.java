package converter.service.api;

import java.util.Collection;

/**
 * Created by Vyacheslav Predantsev on 29.09.2015
 */
public interface TextToHtmlService {

    String textToHtml(Collection<String[]> postRequestText);
}
