
package acme.features.assistanceagent.service;

import java.util.List;

import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import acme.client.repositories.AbstractRepository;
import acme.entities.airports.Service;

@Repository
public interface ServiceRepository extends AbstractRepository {

	@Query("SELECT s FROM Service s")
	List<Service> findAllServices();
}
