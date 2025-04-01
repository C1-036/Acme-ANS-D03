
package acme.features.assistanceagent.service;

import java.util.List;
import java.util.concurrent.ThreadLocalRandom;

import org.springframework.beans.factory.annotation.Autowired;

import acme.client.components.models.Dataset;
import acme.client.components.principals.Any;
import acme.client.services.AbstractGuiService;
import acme.client.services.GuiService;
import acme.entities.airports.Service;

@GuiService
public class ServiceRandomShow extends AbstractGuiService<Any, Service> {

	// Internal state ---------------------------------------------------------

	@Autowired
	private ServiceRepository repository;

	// AbstractGuiService interface -------------------------------------------


	@Override
	public void authorise() {
		super.getResponse().setAuthorised(true);
	}

	@Override
	public void load() {
		List<Service> services = this.repository.findAllServices();
		System.out.println("Servicios obtenidos: " + services.size());

		if (!services.isEmpty()) {
			int randomIndex = ThreadLocalRandom.current().nextInt(services.size());
			Service randomService = services.get(randomIndex);

			super.getBuffer().addData(randomService);
			System.out.println("Servicio aleatorio cargado: " + randomService.getPicture());
		} else
			System.out.println("No hay servicios disponibles en la BD.");
	}

	@Override
	public void unbind(final Service service) {
		Dataset dataset;

		dataset = super.unbindObject(service, "picture");

		super.getResponse().addData(dataset);
	}
}
