<%--
- list.jsp
-
- Copyright (C) 2012-2025 Rafael Corchuelo.
-
- In keeping with the traditional purpose of furthering education and research, it is
- the policy of the copyright owner to permit non-commercial use and redistribution of
- this software. It has been tested carefully, but it is not guaranteed for any particular
- purposes. The copyright owner does not offer any warranties or representations, nor do
- they accept any liabilities with respect to them.
--%>

<%@page%>

<%@taglib prefix="jstl" uri="http://java.sun.com/jsp/jstl/core"%>
<%@taglib prefix="acme" uri="http://acme-framework.org/"%>

<acme:list>
	<acme:list-column code="flight-crew-members.activity-log.list.label.registrationMoment" path="registrationMoment" width="34%"/>
	<acme:list-column code="flight-crew-members.activity-log.form.label.incidentType" path="incidentType" width="33%"/>
	<acme:list-column code="flight-crew-members.activity-log.list.label.severity" path="severity" width="33%"/>
	<acme:list-payload path="payload"/>	
	
</acme:list>

<jstl:if test="${_command == 'list'}">
	<acme:button code="flight-crew-members.activity-log.list.button.create" action="/flight-crew-members/activity-log/create"/>
</jstl:if>
