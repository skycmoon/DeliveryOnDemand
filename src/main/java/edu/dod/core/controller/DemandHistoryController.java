package edu.dod.core.controller;


import edu.dod.core.domain.DeliveryStatusForm;
import edu.dod.core.service.DemandHistoryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

/**
 * A controller having a set of methods to handle the request related to demand history of the application.
 *
 * @author sky
 * @version 140506
 */
@Controller
public class DemandHistoryController {

    /**
     * DemandHistoryService class which provides a business logic related to demand history.
     */
	@Autowired
	private DemandHistoryService dhs;
	
	/**
     * Map the ModelAttribute to "deliveryStatusForm".
     *
	 * @return a DeleveryStatusForm to the view, demandhistory.jsp.
	 */
	@ModelAttribute("deliveryStatusForm")
	public DeliveryStatusForm mapModelAttribute() {
	    return dhs.extractDeliveryStatusForm(this.dhs.findAllDemandHistory());
	}

    /**
     * Get the /demandhistory page with the DeliveryStatusForm attributes.
     */
    @RequestMapping(value = "/demandhistory", method = RequestMethod.GET)
    public void demandHistoryGet() {

    }

    /**
     * Post the DeliveryStatusForm.
     *
     * @param deliveryStatusForm a DeliveryStatusForm class.
     * @return redirect to /demandhistory.
     */
	@RequestMapping(value = "/demandhistory", method = RequestMethod.POST)
	public String demandHistoryPost(
			@ModelAttribute("deliveryStatusForm") DeliveryStatusForm deliveryStatusForm) {
		dhs.updateDeliveryStatus(deliveryStatusForm);
		return "redirect:/demandhistory";
	}

}
