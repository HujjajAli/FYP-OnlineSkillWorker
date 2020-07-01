/**
 * 
 */
$("#country").click(function(){
	id = $("#country").val();
	if(id == 0){
		console.log("Dont Do Anything");	
	}else{
		$.ajax({url: "GetAddressDataService?cid="+id, success: function(result){
		    $("#city").html(result);
		  }});
	}
  
	
});

