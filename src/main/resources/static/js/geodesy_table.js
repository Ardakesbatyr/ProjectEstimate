		$(document).ready(function() {
		
			$('#selectEstimateId').one("click", function(){
				
			        var url = 'http://localhost:8080/geodesyResult/listOfEstimateId';
					
					$.getJSON(url, function (data) {
							$.each(data, function (index, value) {
			               		$('#selectEstimateId').append('<option value="' + value.estimateId + '">' + value.estimateId + '</option>');
			  	      });      
				    });
			 	});
			 	
			 	
		
			$('#searchDataByEstimateId').click(function (){
				
				$("#tableId").find("tr").html('');
				
				var estimateId = $("#selectEstimateId").val();
					
				var url = 'http://localhost:8080/geodesyResult/estimateId/'+estimateId;
				
				var total = 0;
				
				$.getJSON(url, function(json) {
					
					var tr=[];
					for (var i = 0; i < json.length; i++) {
						tr.push('<tr>');
						tr.push('<td>' + json[i].id + '</td>');
						tr.push('<td>' + json[i].customName + '</td>');
						tr.push('<td>' + json[i].nameOfPrice + '</td>');
						tr.push('<td>' + json[i].valueX + '</td>');
						tr.push('<td>' + json[i].cost + '</td>');
	     				tr.push('<td><button class=\'edit\'>Edit</button>&nbsp;&nbsp;<button class=\'delete\' id=' + json[i].id + '>Delete</button></td>');
						tr.push('</tr>');
						total += parseFloat(json[i].cost)*100;  
					}
					
					$('table').append($(tr.join('')));
						
					$('#total_sum_value').val(parseFloat(total/100));
					$('#author').val(email);
					
				});
			});
				
			
				$('#submit').click(function (){
				
				event.preventDefault();
				
				var email = $('#authorName').val();
				
				var estimateId = $('#estimateId').val();
				
				var customName = $('#customName').val();
				
				var valueX = $('#valueX').val();
				
				var valueK1= $('#valueK1').val();
				var valueK2= $('#valueK2').val();
				var valueK3= $('#valueK3').val();
				var valueK4= $('#valueK4').val();
				
				var geodesyId= $('#position').val();
				
				var currentTime= $('#currenttime').val();
				
				$.ajax({
					type: "POST",
					contentType: "application/json; charset=utf-8",
					url: "http://localhost:8080/geodesyResult/save",
					data: JSON.stringify({'email': email, 'estimateId': estimateId, 'customName': customName, 'valueX':valueX, 'valueK1':valueK1, 'valueK2':valueK2, 'valueK3':valueK3,'valueK4':valueK4,'geodesyId': geodesyId, 'currentTime' : currentTime}),
					cache: false,
					success: function(result) {
						$("#searchDataByEstimateId").click();
						$("#close").click();
						alert("new row added successfully")
						},
					error: function(err) {
						alert("some field is not selected/input")
					}
				});
			});
			
			$(document).delegate('.delete', 'click', function() { 
				var id = $(this).attr('id');
				if (confirm('Do you really want to delete record id='+id+'?')) {
					
					var parent = $(this).parent().parent();
					
					$.ajax({
						type: "DELETE",
						url: "http://localhost:8080/geodesyResult/delete/" + id,
						cache: false,
						success: function() {
							parent.fadeOut('slow', function() {
								$(this).remove();
							});
							
							$("#searchDataByEstimateId").click();
						},
						error: function() {
							$('#err').html('<span style=\'color:red; font-weight: bold; font-size: 30px;\'>Error deleting record').fadeIn().fadeOut(4000, function() {
								$(this).remove();
							});
						}
					});
				}
			});
			
			$(document).delegate('.edit', 'click', function() {
				var parent = $(this).parent().parent();
				
				var id = parent.children("td:nth-child(1)");
				var customName = parent.children("td:nth-child(2)");
				var valueX = parent.children("td:nth-child(4)");
				var buttons = parent.children("td:nth-child(6)");
				
				customName.html("<input type='text' id='txtName' value='" + customName.html() + "'/>");
				valueX.html("<input type='number' id='txtName' value='" + valueX.html() + "'/>");
				buttons.html("<button id='save'>Save</button>&nbsp;&nbsp;<button class='delete' id='" + id.html() + "'>Delete</button>");
			});
			
			$(document).delegate('#save', 'click', function() {
				var parent = $(this).parent().parent();
				
				var id = parent.children("td:nth-child(1)");
				var customName = parent.children("td:nth-child(2)");
				var valueX = parent.children("td:nth-child(4)");
				var buttons = parent.children("td:nth-child(6)");
				
				$.ajax({
					type: "POST",
					contentType: "application/json; charset=utf-8",
					url: "http://localhost:8080/geodesyResult/edit",
					data: JSON.stringify({'id' : id.html(), 'customName' : customName.children("input[type=text]").val(),'valueX' : valueX.children("input[type=number]").val()}),
					cache: false,
					success: function() {
						alert("success");
						
						customName.html(customName.children("input[type=text]").val());
						valueX.html(valueX.children("input[type=number]").val());
						buttons.html("<button class='edit' id='" + id.html() + "'>Edit</button>&nbsp;&nbsp;<button class='delete' id='" + id.html() + "'>Delete</button>");
						$("#searchDataByEstimateId").click();
					},
					error: function() {
						alert("error");
						$('#err').html('<span style=\'color:red; font-weight: bold; font-size: 30px;\'>Error updating record').fadeIn().fadeOut(4000, function() {
							$(this).remove();
						});
					}
				});
			});

		});