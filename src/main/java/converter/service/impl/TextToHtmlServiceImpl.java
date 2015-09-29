package converter.service.impl;

import converter.service.api.TextToHtmlService;
import converter.util.TextToHtmlUtil;
import org.springframework.stereotype.Service;

import java.util.Collection;

/**
 * Created by Vyacheslav Predantsev on 29.09.2015
 */
@Service
public class TextToHtmlServiceImpl implements TextToHtmlService {

    @Override
    public String textToHtml(Collection<String[]> postRequestText) {
        return TextToHtmlUtil.processStrings(postRequestText);
    }
}
