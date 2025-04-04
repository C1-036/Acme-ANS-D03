
package acme.entities.assistanceagents;

import java.util.Date;

import javax.persistence.Entity;
import javax.persistence.ManyToOne;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.validation.Valid;

import acme.client.components.basis.AbstractEntity;
import acme.client.components.mappings.Automapped;
import acme.client.components.validation.Mandatory;
import acme.client.components.validation.ValidEmail;
import acme.client.components.validation.ValidMoment;
import acme.client.components.validation.ValidString;
import acme.entities.flights.Leg;
import acme.realms.AssistanceAgent;
import lombok.Getter;
import lombok.Setter;

@Entity
@Getter
@Setter
public class Claim extends AbstractEntity {

	private static final long	serialVersionUID	= 1L;

	//Atributos ------------------------------------
	@Mandatory
	@ValidMoment(past = true)
	@Temporal(TemporalType.TIMESTAMP)
	private Date				registrationMoment;

	@Mandatory
	@Automapped
	@ValidEmail
	private String				passengerEmail;

	@Mandatory
	@Automapped
	@ValidString(max = 255)
	private String				description;

	@Mandatory
	@Automapped
	@Valid
	private ClaimType			type;

	@Mandatory
	@Valid
	@Automapped
	private ClaimState			accepted;

	@Mandatory
	@Automapped
	private boolean				draftMode;

	// Relationships ----------------------------------------------------------
	@Mandatory
	@Valid
	@ManyToOne(optional = false)
	private AssistanceAgent		assistanceAgent;

	@Mandatory
	@ManyToOne(optional = false)
	@Valid
	private Leg					legs;

}
