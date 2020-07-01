/**
 * 
 */

$("#userAddress").click(function(){
	
	console.log("OK");
	
	if(navigator.geolocation){
		console.log("OK Geo");
		
		navigator.geolocation.getCurrentPosition(function(position){
			console.log(position);
			console.log("User Latitude  :"+position.coords.latitude);
			console.log("User Longitude :"+position.coords.longitude);
			
			latv  = position.coords.latitude;
			longv = position.coords.longitude;
			$.ajax({url: "SetMyLocation?loc=user&latV="+latv+"&longV="+longv,success : function(r){
				
			}});
		});
		
	}else{
		console.log("Not OK Geo");
	}
	
});

$("#workerAddress").click(function(){
	
	console.log("OK");
	
	if(navigator.geolocation){
		console.log("OK Geo");
		
		navigator.geolocation.getCurrentPosition(function(position){
			console.log(position);
			console.log("User Latitude  :"+position.coords.latitude);
			console.log("User Longitude :"+position.coords.longitude);
			
			latv  = position.coords.latitude;
			longv = position.coords.longitude;
			$.ajax({url: "SetMyLocation?loc=worker&latV="+latv+"&longV="+longv,success : function(r){
				
			}});
		});
		
	}else{
		console.log("Not OK Geo");
	}
	
});

$("#companyAddress").click(function(){
	
	console.log("OK");
	
	if(navigator.geolocation){
		console.log("OK Geo");
		
		navigator.geolocation.getCurrentPosition(function(position){
			console.log(position);
			console.log("User Latitude  :"+position.coords.latitude);
			console.log("User Longitude :"+position.coords.longitude);
			
			latv  = position.coords.latitude;
			longv = position.coords.longitude;
			$.ajax({url: "SetMyLocation?loc=company&latV="+latv+"&longV="+longv,success : function(r){
				
			}});
		});
		
	}else{
		console.log("Not OK Geo");
	}
	
});