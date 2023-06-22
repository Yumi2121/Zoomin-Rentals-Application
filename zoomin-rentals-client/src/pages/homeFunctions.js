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
	$("#searchbtn").on("click", function () {
	  var selected = $('#seatoptions').find(":selected").text();
	  var pickupDate = $("#pickupDate").val();
	  var returnDate = $("#returnDate").val();

	  localStorage.setItem("pdate", pickupDate);
	  localStorage.setItem("rdate", returnDate);

	  localStorage.setItem("seatcount", selected);
	  location.href = "searchResult.html";
	});
  });


  $(function() {
	$('input[name="daterange"]').daterangepicker({
		format: 'MMDDYYYY',
		showShortcuts: false,
	  	opens: 'left',
		setValue: function(start, end, label) {
			$('#pickupDate').val(start);
			$('#returnDate').val(end);
	  	console.log("A new date selection was made: " + start.format('YYYY-MM-DD') + ' to ' + end.format('YYYY-MM-DD'));
	},
  });
})

var pickupDate = $("#pickupDate").val();
var returnDate = $("#returnDate").val();

$('input[name="daterange"]').data('daterangepicker').setData(pickupDate, returnDate);