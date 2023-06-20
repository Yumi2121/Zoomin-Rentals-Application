//get user by id in local storage 

$(document).ready(function () {
    var id = localStorage.getItem("loggedin");
    $.ajax({
		url: "http://localhost:9999/customers/" + id,
		type: "GET",
		dataType: "json",
		contentType: "application/json",
		success: function (data) {
		 $("a#profilebtn").html(data.name);
         $("a#logbtn").hide();
		},
		error: function () {
		  alert("FAILURE!");
		},
	  });

  });