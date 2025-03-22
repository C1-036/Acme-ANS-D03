<%--
- form.jsp
-
- Copyright (C) 2012-2025 Rafael Corchuelo.
-
- In keeping with the traditional purpose of furthering education and research, it is
- the policy of the copyright owner to permit non-commercial use and redistribution of
- this software. It has been tested carefully, but it is not guaranteed for any particular
- purposes.  The copyright owner does not offer any warranties or representations, nor do
- they accept any liabilities with respect to them.
--%>

<%@page%>

<%@taglib prefix="jstl" uri="http://java.sun.com/jsp/jstl/core"%>
<%@taglib prefix="acme" uri="http://acme-framework.org/"%>

<acme:form>
	<acme:input-textbox code="customer.booking.form.label.locatorCode" path="locatorCode"/>
	<acme:input-textbox code="customer.booking.form.label.purchaseMoment" path="purchaseMoment"/>
	<acme:input-textbox code="customer.booking.form.label.travelClass" path="travelClass"/>
	<acme:input-textbox code="customer.booking.form.label.price" path="price"/>
	<acme:input-textbox code="customer.booking.form.label.creditCard" path="creditCard"/>
	
	<jstl:choose>	 
		<jstl:when test="${_command == 'show'}">
			<acme:button code="customer.booking.form.button.passenger" action="/customer/passenger/list-booking?bookingId=${id}"/>			
		</jstl:when>
		</jstl:choose>
</acme:form>