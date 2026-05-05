<%@ page contentType="text/html; charset=UTF-8" %> 
<%@taglib prefix="c" uri="jakarta.tags.core"  %>
<!DOCTYPE html> 
<html> 
<head> 
    <meta charset="UTF-8"> 
    <title>Liste des rendez-vous</title> 
    <style> 
        body { font-family: Arial, sans-serif; background:#f5f7fa; margin:30px; } 
        .container { width: 900px; margin:auto; background:white; padding:20px; border
radius:10px; } 
        h2 { color:#1f4e79; } 
        table { width:100%; border-collapse:collapse; } 
        th, td { border:1px solid #d0d7de; padding:10px; text-align:center; } 
        th { background:#eaf2f8; } 
        .ok { color:green; font-weight:bold; } 
        .ko { color:#b00020; font-weight:bold; } 
    </style> 
</head> 
<body> 
<div class="container"> 
    <h2>Rendez-vous de la clinique</h2> 
 
    <p class="ok"> 
        <c:if test="not Empty ${SessionScope.messageSuccees}">
        	${SessionScope.messageSuccees}
        </c:if>
    </p> 
 
    <p class="ko"> 
        <c:if test="not Empty${SessionScope.messageErreur}">
        	${SessionScope.messageErreur}
        </c:if>
    </p> 
 
    <table> 
        <tr> 
            <th>ID</th> 
            <th>Date</th> 
            <th>Heure</th> 
            <th>État</th> 
            <th>Patient</th> 
            <th>Action</th> 
        </tr> 
 
        <c:forEach var="rdv" items="${listeRdv}">
        <tr> 
            <td>${rdv.id}</td> 
            <td>${rdv.date}</td> 
            <td>${rdv.heure}</td> 
            <td> 
                <c:choose>
                	<c:when test="${rdv.disponible} == true">
                		Disponible
                	</c:when>
                	<c:otherwise>
                		Reserved
                	</c:otherwise>
                </c:choose> 
            </td> 
            <td>${rdv.patient}</td> 
            <td> 
                <c:choose>
                	<c:when test="${rdv.disponible == true}">
                		<form action="${pageContext.request.contextPath}/rendezVous" method="post">
                			<input type="hidden" value="${rdv.id}"/>
                			<input type="hidden" value="${rdv.patient}"/>
                			<button type="submit">Réserver</button>
                		</form>
                	</c:when>
                	<c:otherwise>
                		Indisponible
                	</c:otherwise>
                </c:choose> 
            </td> 
</tr> 
</c:forEach>
</table> 
</div> 
</body> 
</html>