package edu.dod.core.controller;

import edu.dod.core.domain.DemandForm;
import edu.dod.core.service.DemandHistoryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

/**
 * A controller having a set of methods to handle the request to the root of the application.
 *
 * @author sky
 * @version 140506
 */
@Controller
public class DemandController {

    /**
     * DemandHistoryService class which provides a business logic related to demand history.
     */
	@Autowired
    private DemandHistoryService ds;
	
    /**
     * Handle a GET request for the root page.
     *
     * @param model a holder for model attributes.
     * @return mapping to the demand jsp page.
     */
	@RequestMapping(value = "/", method = RequestMethod.GET)
	public String demandGet(Model model) {
		DemandForm demandForm = new DemandForm();
		model.addAttribute("demandForm", demandForm);
		return "demand";
	}

    /**
     * Handle a POST request for the root page.
     *
     * @param demandForm a view model to get the user input.
     * @return redirect to the root page.
     */
	@RequestMapping(value = "/", method = RequestMethod.POST)
	public String demandPost(@ModelAttribute("demandForm") DemandForm demandForm) {
		ds.updateDemandHistory(demandForm);
		return "redirect:/";
	}
	
}
