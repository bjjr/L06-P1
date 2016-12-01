<%--
 * list.jsp
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

<display:table name="curricula" id="row" requestURI="curriculum/customer/list.do" pagesize="5" class="displaytag">
	
	<security:authorize access="hasRole('CUSTOMER')">
		<display:column>
			<a href="curriculum/customer/edit.do?curriculumId=${row.id}"><spring:message code="curriculum.edit" /></a>
		</display:column>			
	</security:authorize>
		
	<display:column property="title" titleKey="curriculum.title" sortable="true" />		
	
</display:table>

<security:authorize access="hasRole('CUSTOMER')">
	<div>
		<a href="curriculum/customer/create.do"> 
			<spring:message	code="curriculum.create" />
		</a>
	</div>
</security:authorize>
