package converter.web.controller;

import converter.service.api.TextToHtmlService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import javax.servlet.http.HttpServletRequest;

/**
 * Created by Vyacheslav Predantsev on 29.09.2015
 */
@RestController
public class Controller {

    @Autowired
    private TextToHtmlService textToHtmlService;

    @RequestMapping(value = "/", method = RequestMethod.POST)
    public String postBodyTextToHtml(HttpServletRequest request) {
        boolean persist = Boolean.valueOf(request.getHeader("save"));
        return textToHtmlService.textToHtml(persist, request.getParameterMap());
    }
}
