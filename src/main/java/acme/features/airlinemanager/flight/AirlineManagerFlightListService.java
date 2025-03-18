
package acme.features.airlinemanager.flight;

import java.util.Collection;

import org.springframework.beans.factory.annotation.Autowired;

import acme.client.components.models.Dataset;
import acme.client.services.AbstractGuiService;
import acme.client.services.GuiService;
import acme.entities.flights.Flight;
import acme.realms.AirlineManager;

@GuiService
public class AirlineManagerFlightListService extends AbstractGuiService<AirlineManager, Flight> {

	// Internal state ---------------------------------------------------------

	@Autowired
	private AirlineManagerFlightRepository repository;

	// AbstractGuiService interface -------------------------------------------


	@Override
	public void authorise() {
		super.getResponse().setAuthorised(true);
	}

	@Override
	public void load() {
		Collection<Flight> flights;
		int airlineManagerId;

		airlineManagerId = super.getRequest().getPrincipal().getActiveRealm().getId();
		flights = this.repository.findFlightsByAirlineManagerId(airlineManagerId);

		super.getBuffer().addData(flights);
	}

	@Override
	public void unbind(final Flight flight) {
		Dataset dataset;

		dataset = super.unbindObject(flight, "tag", "indication", "cost", "description");
		super.addPayload(dataset, flight, "scheduledDeparture", "scheduledArrival", "originCity", "destinationCity", "layovers");

		super.getResponse().addData(dataset);
	}

}
