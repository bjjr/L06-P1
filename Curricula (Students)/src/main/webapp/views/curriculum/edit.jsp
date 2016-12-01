<%--
 * edit.jsp
 *
 * Copyright (C) 2016 Universidad de Sevilla
 * 
 * The use of this project is hereby constrained to the conditions of the 
 * TDG Licence, a copy of which you may download from 
 * http://www.tdg-seville.info/License.html
 --%>

<%@page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>

<%@taglib prefix="jstl" uri="http://java.sun.com/jsp/jstl/core"%>
<%@taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>
<%@taglib prefix="tiles" uri="http://tiles.apache.org/tags-tiles"%>
<%@taglib prefix="spring" uri="http://www.springframework.org/tags"%>
<%@taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<%@taglib prefix="security"	uri="http://www.springframework.org/security/tags"%>
<%@taglib prefix="display" uri="http://displaytag.sf.net"%>

<form:form action="curriculum/customer/edit.do" modelAttribute="curriculum">

	<form:hidden path="id" />
	<form:hidden path="version" />
	<form:hidden path="customer" />	

	<form:label path="title">
		<spring:message code="curriculum.title" />:
	</form:label>
	<form:input path="title" />
	<form:errors cssClass="error" path="title" />
	<br />

	<form:label path="academicRecord">
		<spring:message code="curriculum.academic.record" />:
	</form:label>
	<form:textarea path="academicRecord" />
	<form:errors cssClass="error" path="academicRecord" />
	<br />

	<form:label path="professionalRecord">
		<spring:message code="curriculum.professional.record" />:
	</form:label>
	<form:textarea path="professionalRecord" />
	<form:errors cssClass="error" path="professionalRecord" />
	<br />
	
	<form:label path="hobbies">
		<spring:message code="curriculum.hobbies" />:
	</form:label>
	<form:textarea path="hobbies" />
	<form:errors cssClass="error" path="hobbies" />
	<br />
	
	<input type="submit" name="save" value="<spring:message code="curriculum.save" />" />&nbsp; 
	<jstl:if test="${curriculum.id != 0}">
		<input type="submit" name="delete"
			value="<spring:message code="curriculum.delete" />"
			onclick="return confirm('<spring:message code="curriculum.confirm.delete" />')" />&nbsp;
	</jstl:if>
	<input type="button" name="cancel"
		value="<spring:message code="curriculum.cancel" />"
		onclick="javascript: window.location.replace('curriculum/customer/list.do')" />
	<br />

</form:form>