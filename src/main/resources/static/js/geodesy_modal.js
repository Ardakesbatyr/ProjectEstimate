$(document).ready(function () {
    		
     
        $('#section').one("click", function(){
           var url = "http://localhost:8080/geodesy/sectionList";
           $.getJSON(url, function (data) {
           
                $.each(data, function (index, value) {
                    // APPEND OR INSERT DATA TO SELECT ELEMENT.
                    $('#section').append('<option value="' + value.section + '">' + value.section + '</option>');
            		});
                    
                });
            });
            
               
            $('#subsection').one("click", function(){
            var section = $("#section").val();
            var url = 'http://localhost:8080/geodesy/subsectionList/'+section;

            $.getJSON(url, function (data) {
           
                $.each(data, function (index, value) {
                  
                    $('#subsection').append('<option value="' + value.subsection + '">' + value.subsection + '</option>');
            		});
                    
                });
            });
            
           
            $('#chapter').one("click", function(){
            var subsection = $("#subsection").val();
            var url = 'http://localhost:8080/geodesy/chapterList/'+subsection;

            $.getJSON(url, function (data) {
           
                $.each(data, function (index, value) {
                  
                    $('#chapter').append('<option value="' + value.chapter + '">' + value.chapter + '</option>');
            		});
                    
                });
            });
            
 
           $('#table_name').one("click", function(){
            var chapter = $("#chapter").val();
            var url = 'http://localhost:8080/geodesy/tableList/'+chapter;

            $.getJSON(url, function (data) {
           
                $.each(data, function (index, value) {
                	
                    $('#table_name').append('<option value="' + value.tableName + '">' + value.tableName + '</option>');
            		});
                    
                });
            });
            
            $('#table_name').change(function(){
             
            	$('#position')
                .empty()
                .append('<option value=""> -- Select position-- </option>');
            	
            	 $('#position').one("click", function(){
              	   
                     var table_name = $("#table_name").val();
                      
                     var url = 'http://localhost:8080/geodesy/positionList/'+table_name;

                     $.getJSON(url, function (data) {
                    
                         $.each(data, function (index, value) {
                              $('#position').append('<option value="' + value.id + '">' + value.position + '</option>');
                       		});
                       	});
              		});
              });
            
            
            $('#position').change(function(){
        	   	$('#valueX').empty();  
                $('#price').empty();
		        $('#unit').empty();  
		        $('#currenttime').empty();
	          });
           
  				
  			$('#customName').click(function(){
  				
						var valueK = $("#valueK1").val();
			            var id = $("#position").val();
			            var url = 'http://localhost:8080/geodesy/'+id;
			            			            
			            var today = new Date();

						var date = today.getFullYear()+'-'+(today.getMonth()+1)+'-'+today.getDate();
						
						var time = today.getHours() + ":" + today.getMinutes() + ":" + today.getSeconds();
						
						var dateTime = date+' '+time;
			           
						var authorName = $("#authorName").val();
						$('#currenttime').val(dateTime);
			   			$('#authorName').val(authorName);
			   			
			 	        $.getJSON(url, function (data) {
			   			        $('#price').val(parseFloat(data.price));
			   			     	$('#unit').val(data.unit);  
				               	});
			       		});
			       		
			       		
			 	$('#showSubsectionComments').click(function () {
			 		var subsection = $("#subsection").val();
		            var url = 'http://localhost:8080/comments/'+subsection;
			        $.getJSON(url, function (data) {
		           	 	$('#subsectionComments').val(data.comments);
	            	 	$("#hide1").toggle();
		            });
		  		});
			 	
			 	$('#showChapterComments').click(function () {
			 		var chapter = $("#chapter").val();
			        var url = 'http://localhost:8080/comments/'+chapter;
		            $.getJSON(url, function (data) {
		            	 	$('#chapterComments').val(data.comments);
		            	 	$("#hide2").toggle();
		            });
		  		});
			 	
			 	$('#showTableComments').click(function () {
		            var table = $("#table_name").val();
		            var url = 'http://localhost:8080/comments/'+table;
		            $.getJSON(url, function (data) {
		            	 	$('#tableComments').val(data.comments);
		            	 	$("#hide3").toggle();
		            });
		  		});
			 	
	
});