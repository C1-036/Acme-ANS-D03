
package acme.constraints;

import java.util.Date;

import javax.validation.ConstraintValidatorContext;

import acme.client.components.validation.AbstractValidator;
import acme.client.components.validation.Validator;
import acme.entities.flightCrewMembers.ActivityLog;
import acme.entities.flights.Leg;

@Validator
public class ActivityLogValidator extends AbstractValidator<ValidActivityLog, ActivityLog> {

	@Override
	protected void initialise(final ValidActivityLog constraintAnnotation) {
		assert constraintAnnotation != null;
	}

	@Override
	public boolean isValid(final ActivityLog log, final ConstraintValidatorContext context) {
		assert context != null;

		boolean result;
		boolean isNull;
		isNull = log == null || log.getFlightAssignment() == null || log.getFlightAssignment().getFlightLeg() == null;

		if (!isNull) {
			Leg leg = log.getFlightAssignment().getFlightLeg();
			Date endMoment = leg.getScheduledArrival();
			Date registrationMoment = log.getRegistrationMoment();
			boolean isAfter = registrationMoment.after(endMoment);

			super.state(context, isAfter, "registrationMoment", "acme.validation.log.registration-moment.message");
		}

		result = !super.hasErrors(context);
		return result;
	}
}
