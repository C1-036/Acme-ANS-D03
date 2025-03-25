
package acme.features.customer.passenger;

import java.util.Collection;

import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import acme.client.repositories.AbstractRepository;
import acme.entities.customers.Passenger;

@Repository
public interface CustomerPassengerRepository extends AbstractRepository {

	@Query("SELECT m.passenger FROM Make m WHERE m.booking.customer.id = :id")
	Collection<Passenger> findAllPassengerByCustomer(int id);

	@Query("SELECT m.passenger FROM Make m WHERE m.passenger.id = :passengerId")
	Passenger findPassengerByPassengerId(int passengerId);

	@Query("SELECT m.passenger FROM Make m WHERE m.booking.id = :bookingId")
	Collection<Passenger> findAllPassengerByBooking(int bookingId);

}
