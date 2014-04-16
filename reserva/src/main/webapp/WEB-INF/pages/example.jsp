<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<html>
<head>

<script src="<c:url value="/resources/script/jquery.1.10.2.min.js" />"></script>
<script src="<c:url value="/resources/script/jquery.autocomplete.min.js" />"></script>
<link href="<c:url value="/resources/style/main.css" />" rel="stylesheet">

</head>
<body>
	<h2>Spring MVC + jQuery + Autocomplete example</h2>

	<div>
		<input type="text"  id="w-input-search" value="">
		<span>
			<button id="w-button-search" type="button">Search</button>
		</span>
	</div>
	
	<script>
	$(document).ready(function() {

		$('#w-input-search').autocomplete({
			serviceUrl: '${pageContext.request.contextPath}/getTags',
			paramName: "tagName",
			delimiter: ",",
		    transformResult: function(response) {
		    	
		        return {
		        	
		            suggestions: $.map($.parseJSON(response), function(item) {
		            	
		                return { value: item.tagName, data: item.id };
		            })
		            
		        };
		        
		    }
		    
		});
		
		
	});
	</script>
	
</body>
</html>