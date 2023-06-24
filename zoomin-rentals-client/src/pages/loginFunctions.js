$(document).ready(function () {
    if(localStorage.getItem("loggedin") === null){
		$("a#profilebtn").hide();
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
			 location.href = "home.html";
			},
			error: function () {

			},
		  });
	}
  });

$(window).on("hashchange", function () {
	if (location.hash.slice(1) == "signup") {
		$(".page").addClass("extend");
		$("#login").removeClass("active");
		$("#signup").addClass("active");
	} else {
		$(".page").removeClass("extend");
		$("#login").addClass("active");
		$("#signup").removeClass("active");
	}
});
$(window).trigger("hashchange");

function validateLoginForm() {
	var name = document.getElementById("logName").value;
	var password = document.getElementById("logPassword").value;
	var confirmPassword = document.getElementById("signConfirmPassword").value

	if (name == "" || password == "") {
		document.getElementById("errorMsg").innerHTML = "Please fill the required fields"
		return false;
	}

	else if (password.length < 8) {
		document.getElementById("errorMsg").innerHTML = "Your password must include atleast 8 characters"
		return false;
	}
	else {
		return true;
	}
}
function validateSignupForm() {
	var mail = document.getElementById("signEmail").value;
	var name = document.getElementById("signName").value;
	var password = document.getElementById("signPassword").value;

	if (mail == "" || name == "" || password == "") {
		document.getElementById("errorMsg").innerHTML = "Please fill the required fields"
		return false;
	}

	else if (password.length < 8) {
		document.getElementById("errorMsg").innerHTML = "Your password must include atleast 8 characters"
		return false;
	}
	else {
		alert("Successfully signed up");
		return true;
	}

}

$(document).ready(function () {
$("input#signup").click(function () {
  var id = localStorage.getItem("selectedId");
  var customer = {
	name: $("#name").val(),
	mobile: $("#mobile").val(),
	licenseno: $("#licence").val(),
	email: $("#email").val(),
	password: $("#signConfirmPassword").val(),
  };

  $.ajax({
	url: "http://localhost:9999/customers/anchor/" + email,
	type: "GET",
	dataType: "json",
	contentType: "application/json",
	success: function (data) {
		alert("Account already exists with email: " + email);
	},
	error: function () {
		var created = false;
		}
		});

		if(!created){
			$.ajax({
				url: "http://localhost:9999/customers",
				type: "POST",
				dataType: "json",
				contentType: "application/json",
				success: function (data) {
				  alert("Customer Successfully Registered!");
				},
				data: JSON.stringify(customer),
			  });
		}
	});
});

$(document).ready(function () {
	$("input#loginbtn").on("click", function () {
		var email = $("#logName").val();
		var pass = $("#logPassword").val();
		
	  $.ajax({
		url: "http://localhost:9999/customers/email/" + email +"/"+ pass,
		type: "GET",
		dataType: "json",
		contentType: "application/json",
		success: function (data) {
			console.log(data);
		  localStorage.setItem("loggedin", data.id);
		  location.href = "home.html";
		},
		error: function () {
		  alert("FAILURE!");
		},
	  });
	});
  })
