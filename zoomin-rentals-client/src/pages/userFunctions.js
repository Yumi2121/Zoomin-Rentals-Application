//get user by id in local storage 
$(document).ready(function () {
    if(localStorage.getItem("loggedin") === null){
		alert("Login to book today");
	} else {
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

			},
		  });
	}
  });

$(document).ready(function () {
		var id = localStorage.getItem("loggedin");
		$.ajax({
            url: "http://localhost:9999/customers/" + id,
            type: "GET",
            dataType: "json",
            contentType: "application/json",
            success: function (data) {
                $("#nameIn").val(data.name);
                $("#emailIn").val(data.email);
                $("#mobileIn").val(data.mobile);
                $("#licenseIn").val(data.licenseno);
            },
            error: function () {
              alert("Error loading Customer Profile");
            },
        });
	}
);