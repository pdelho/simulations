package com.pdelho.web;

import java.util.Map;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.pdelho.model.PartyVotesForm;
import com.pdelho.service.DistrictDistributionService;
import com.pdelho.web.ConstantsController.Pages;


/**
 * Handles requests for the application home page.
 */
@Controller
@RequestMapping(value = "/elections")
public class ElectionsController {

	private static final Logger LOG = LoggerFactory.getLogger(NavigationController.class);

	/**
	 * Simply selects the home view to render by returning its name.
	 */
	@RequestMapping(method = RequestMethod.GET)
	public String home(Model model)
	{
		LOG.debug("Loading elections");
		return Pages.Elections.ELECTIONS_DATA;
	}
	
	@RequestMapping(method = RequestMethod.POST)
	public String resultSimulation(@ModelAttribute("partyVotesForm") PartyVotesForm partyVotesForm, Model model) 
	{
		Map<String, Integer> result = DistrictDistributionService.getSeatsByProvince(partyVotesForm.getPartyVotes(), partyVotesForm.getSeats());
		model.addAttribute("result", result);
		return Pages.Elections.ELECTIONS_RESULT;
	}


}