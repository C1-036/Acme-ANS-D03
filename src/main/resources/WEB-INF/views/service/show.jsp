<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>

<c:if test="${not empty service}">
    <div class="random-service" style="text-align: center; padding: 10px; border: 1px solid #ddd; border-radius: 5px; max-width: 200px; margin: auto;">
        <img src="${service.picture}" alt="Promoted Service" style="max-width: 150px; border-radius: 5px;">
    </div>
</c:if>
<c:if test="${empty service}">
    <p>No hay servicios promocionados en este momento.</p>
</c:if>
