package spring.mvc.thymeleaf.controller;

import java.util.Locale;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.MessageSource;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

@Controller
public class BaseController {

	@Autowired
	private MessageSource messageSource;

	@RequestMapping(value = "/", method = RequestMethod.GET)
	public ModelAndView index(HttpServletRequest request, Locale locale) {
		System.out.println("Message:" + messageSource.getMessage("hello", null, locale) + "- Locale: " + locale);

		return new ModelAndView("index", "message",messageSource.getMessage("hello", null, "default message", request.getLocale()));

		/* return new ModelAndView("index"); */
	}
}
