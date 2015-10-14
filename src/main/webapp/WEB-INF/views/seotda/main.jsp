<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<!DOCTYPE>
<html>
<head>
<meta charset="UTF-8">
<title>섯다</title>
<script src="//code.jquery.com/jquery-1.11.3.min.js"></script>
<script src="//code.jquery.com/jquery-migrate-1.2.1.min.js"></script>
<style type="text/css">

	#seotda-container {
		margin: 100px;
		width: 500px;
		border: 1px solid;
		margin: auto auto;
		padding: 50px;
	}
	
	#seotda-ai {
		border: 1px solid;
		margin: 10px;
		min-height: 100px;
	}
	
	#seotda-player {
		border: 1px solid;
		margin: 10px;
		min-height: 100px;
	}
	
	#seotda-counting1, #seotda-counting2 {
		float: left;
	}

</style>
<script type="text/javascript">
$(document).ready(function() {
	var flag = 0;
	var card1 = "";
	var card2 = "";
	
	// 패뽑기
	$('#seotda-counting').click(function() {
		
		if (flag == 0) {
			$.getJSON('seotda/counting', function(data) {
				$('#seotda-counting1').html('<img src="resources/img/seotda/' + data + '.jpg" width="60px">')
				flag = 1;
				card1 = data;
				console.log(data)
			});
		}
		
		if (flag == 1) {
			$.getJSON('seotda/counting', function(data) {
				if (card1 != data) {
					$('#seotda-counting2').html('<img src="resources/img/seotda/' + data + '.jpg" width="60px">')
					flag = 2;
					card2 = data;
					console.log(data)
				}
			});
		}
		
		
		
		
	});
});
</script>
</head>
<body>
<button id="seotda-counting">패뽑기</button>
<div id="seotda-container">

	<div id="seotda-ai"></div>
	<div id="seotda-player">
		<div id="seotda-counting1"></div>
		<div id="seotda-counting2"></div>
	</div>

</div>
<div id="seotda-counting2"></div>

</body>
</html>