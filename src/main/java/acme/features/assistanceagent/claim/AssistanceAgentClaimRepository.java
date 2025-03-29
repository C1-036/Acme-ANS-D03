
package acme.features.assistanceagent.claim;

import java.util.Collection;

import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import acme.client.repositories.AbstractRepository;
import acme.entities.assistanceagents.Claim;

@Repository
public interface AssistanceAgentClaimRepository extends AbstractRepository {

	@Query("select c from Claim c where c.id = :id")
	Claim findClaimById(int id);

	@Query("SELECT c FROM Claim c WHERE c.assistanceAgent.id = :id AND (c.accepted = acme.entities.assistanceagents.ClaimState.ACCEPTED OR c.accepted = acme.entities.assistanceagents.ClaimState.REJECTED)")
	Collection<Claim> findCompletedClaimsByAssistanceAgentId(int id);

}
