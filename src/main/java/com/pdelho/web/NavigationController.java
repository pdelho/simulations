package com.pdelho.web;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.pdelho.web.ConstantsController.Pages;


/**
 * Handles requests for the application home page.
 */
@Controller
public class NavigationController {

	private static final Logger LOG = LoggerFactory.getLogger(NavigationController.class);

	/**
	 * Simply selects the home view to render by returning its name.
	 */
	@RequestMapping(value = "/", method = RequestMethod.GET)
	public String home(Model model)
	{
		LOG.debug("Loading home");
		return Pages.INDEX;
	}


}