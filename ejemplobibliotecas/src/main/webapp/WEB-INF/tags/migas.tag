<%@ taglib uri="jakarta.tags.core" prefix="c" %>
<%@ attribute name="pathInfo" %>
<nav class="bg-body-tertiary py-2 px-3" aria-label="breadcrumb">
	<ol class="breadcrumb">
		<c:forEach items="${pathInfo.substring(1).split('/')}" var="path">
			<c:set var="enlace"
				value="${enlace}${enlace == null ? 'fc/': '/'}${path}" />

			<li class="breadcrumb-item"><a href="${enlace}">${path}</a></li>
		</c:forEach>
	</ol>
</nav>