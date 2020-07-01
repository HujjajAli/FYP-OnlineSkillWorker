/**
 * 
 */



function hireworker(workerID,userID,html_Date,html_frmHour,html_frmMinutes,html_ToHour,html_ToMinutes){
	
	console.log("workerID "+workerID);
	console.log("userID "+userID);
	
	date       = html_Date.item(0).value;
	
	frmHour    = html_frmHour.item(0).value;
	frmMinutes = html_frmMinutes.item(0).value;
	
	ToHour     = html_ToHour.item(0).value;
	ToMinutes  = html_ToMinutes.item(0).value;
	
	console.log("frm cosole log :"+date);
	console.log("frm Hour V :"+frmHour);
	console.log("frm Minutes V :"+frmMinutes);
	console.log("To Hour V :"+ToHour);
	console.log("To Minutes V :"+ToMinutes);
	
	query = "date="+date+"&frmHour="+frmHour+"&frmMinutes="+frmMinutes+"&ToHour="+ToHour+"&ToMinutes="+ToMinutes;
	console.log(query);
	$.ajax({url: "HireWorkerService?wID="+workerID+"&userID="+userID+"&"+query,success: function(r){
		console.log(r);
		$("#workerhired").html(r);
	}});
	
}
