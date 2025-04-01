
package acme.features.assistanceagent.service;

import javax.annotation.PostConstruct;

import org.springframework.beans.factory.annotation.Autowired;

import acme.client.components.principals.Any;
import acme.client.controllers.AbstractGuiController;
import acme.client.controllers.GuiController;
import acme.entities.airports.Service;

@GuiController
public class ServiceController extends AbstractGuiController<Any, Service> {

	// Internal state ---------------------------------------------------------

	@Autowired
	private ServiceRandomShow randomShowService;

	// Constructors -----------------------------------------------------------


	@PostConstruct
	protected void initialise() {
		System.out.println("✅ ServiceController inicializado.");
		super.addBasicCommand("show", this.randomShowService);
	}

}
