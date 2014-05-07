package edu.dod.core.controller;

import edu.dod.core.domain.ShortagePredictionCriteria;
import edu.dod.core.service.ItemShortagePredictorService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

/**
 * A controller having a set of methods to handle the request related to item shortage of the application.
 * This part has not fully implemented.
 *
 * @author sky
 * @version 140506
 */
@Controller
public class ItemShortagePredictorController {

    /**
     * ItemShortagePredictorService class which provides a business logic related to item shortage prediction.
     */
	@Autowired
    ItemShortagePredictorService isps;

    /**
     * Render /shortagepredictor page.
     *
     * @param model a holder for model attributes.
     */
	@RequestMapping(value = "/shortagepredictor", method = RequestMethod.GET)
	public void shortagePredictorGet(Model model) {
		model.addAttribute("shortagePredictionCriteria", new ShortagePredictionCriteria());
	}

    /**
     * Post a ShortagePredictionCriteria to predict when we need a specific item.
     *
     * @param shortageCriteria a ShortagePredictionCriteria object.
     * @return redirect to the /shortagepredictor page.
     */
	@RequestMapping(value = "/shortagepredictor", method = RequestMethod.POST)
	public String shortagePredictorPost(@ModelAttribute("shortagePredictionCriteria") ShortagePredictionCriteria shortageCriteria) {
		System.out.println(shortageCriteria.getReserveRatio());
		System.out.println(shortageCriteria.getExpectedDeliveryDate());
		return "redirect:/shortagepredictor";
	}

}
