
$(document).ready(function() {
// 	$('input[name="daterange"]').daterangepicker({
// 		format: 'YYYY-MM-DD',
// 		// startDate: moment(),
// 		// endDate: moment(),
// 		showShortcuts: false,
// 	  	opens: 'left',
// 		function(startDate, endDate) {
// 			console.log("Callback has been called!");
// 			$('#search-slt input').html(start.format('YYYY-MM-DD') + ' - ' +  end.format('YYYY-MM-DD'));
// 			var startDate = start;
// 			var endDate = end;
// 	},
//   });

  $('input[name="daterange"]').on('apply.daterangepicker', function(ev, picker) {
	console.log(picker.startDate.format('YYYY-MM-DD'));
	console.log(picker.endDate.format('YYYY-MM-DD'));

	localStorage.setItem("pdate", picker.startDate.format('YYYY-MM-DD'));
	localStorage.setItem("rdate", picker.endDate.format('YYYY-MM-DD'));

	
  });
});

// var pickupDate = $("#pickupDate").val();
// var returnDate = $("#returnDate").val();

// $('input[name="daterange"]').data('daterangepicker').setData(pickupDate, returnDate);


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
	//   var pickupDate = $("#pickupDate").val();
	//   var returnDate = $("#returnDate").val();
	

	  localStorage.setItem("seatcount", selected);
	  location.href = "searchResult.html";
	});
});



