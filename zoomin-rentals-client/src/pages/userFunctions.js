//get user by id in local storage 
$(document).ready(function () {
    if(localStorage.getItem("loggedin") === null){
        
	} else {
		var id = localStorage.getItem("loggedin");
		$.ajax({
			url: "http://localhost:9999/customers/" + id,
			type: "GET",
			dataType: "json",
			contentType: "application/json",
			success: function (data) {
			 $("a#profilebtn").html(data.name);
			 $("a#logbtn").html("Logout");
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
                $("#passwordIn").val(data.password);
            },
            error: function () {
              alert("Error loading Customer Profile");
            },
        });
	}
);

$(document).ready(function () {
    $("button#updatebtn").click(function () {
    var cid = localStorage.getItem("loggedin"); 
    var cust = {
        id: localStorage.getItem("loggedin"),
        name: $("#nameIn").val(),
        email: $("#emailIn").val(),
        mobile: $("#mobileIn").val(),
        licenseno: $("#licenseIn").val(),
        password: $("#passwordIn").val(),
      };
  
      $.ajax({
        url: "http://localhost:9999/customers/",
        type: "POST",
        dataType: "json",
        contentType: "application/json",
        success: function (data) {
          alert("Customer Successfully Updated! " + cid);
        },
        data: JSON.stringify(cust),
      });
    });
  });

  $(document).ready(function () {
	$("#logbtn").on("click", function () {
	  if($("#logbtn").html() == "Logout"){
        localStorage.clear();
        location.href = "login.html";
      }
	});
  });