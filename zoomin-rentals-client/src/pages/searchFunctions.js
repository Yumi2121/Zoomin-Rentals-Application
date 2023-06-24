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
			 $("a#logbtn").html("Logout");
			},
			error: function () {

			},
		  });
	}
  });

$(document).ready(function () {
  var seats = localStorage.getItem("seatcount");
  var pdate = localStorage.getItem("pdate");
  var rdate = localStorage.getItem("rdate");

  console.log(localStorage.getItem("pdate"));
	console.log(localStorage.getItem("rdate"));

  var unavailable = [];
  if (seats == "Any") {
    $.ajax({
      type: "GET",
      url: "http://localhost:9999/bookings/",
      success: function (bookingsArray) {
        $.each(bookingsArray, function (index, booking) {
          if ((pdate >= booking.pickupdate) & (pdate <= booking.returndate)) {
            unavailable.push(booking.carid);
          } else if (
            (rdate >= booking.pickupdate) &
            (rdate <= booking.returndate)
          ) {
            unavailable.push(booking.carid);
          } else if (
            (pdate < booking.pickupdate) &
            (rdate > booking.returndate)
          ) {
            unavailable.push(booking.carid);
          }

        });
      },
      error: function () {
        alert("Error loading availabile dates!");
      },
    });

    $.ajax({
      type: "GET",
      url: "http://localhost:9999/cars/",
      success: function (carArray) {
        $.each(carArray, function (index, car) {
          var temp = true;
          for (var i = 0; i < unavailable.length; i++) {
            if (car.id == unavailable[i]) {
              temp = false;
            }
          }
          if (temp != false) {
            var selected = $("#cartable");
            var id = car.id;
            var carInfo = "<tr>";
            carInfo += "<td id='test'>" + car.year + "</td>";
            carInfo += "<td>" + car.brand + "</td>";
            carInfo += "<td>" + car.model + "</td>";
            carInfo += "<td>" + car.seats + "</td>";
            carInfo += "<td>" + car.transmission + "</td>";
            carInfo += "<td>" + car.fuel + "</td>";
            carInfo +=
              "<td>" +
              '<button class="btn btn-primary" id="selectedcar" value=' +
              id +
              ">Book Now</button>" +
              "</td>";
            carInfo += "</tr>";
            selected.append(carInfo);
          }
        });
      },
      error: function () {
        alert("Error loading Cars!");
      },
    });
  } else {
    $.ajax({
      type: "GET",
      url: "http://localhost:9999/cars/seats/" + seats,
      success: function (carArray) {
        $.each(carArray, function (index, car) {
          var selected = $("#cartable");
          var id = car.id;
          var carInfo = "<tr>";
          carInfo += "<td id='test'>" + car.year + "</td>";
          carInfo += "<td>" + car.brand + "</td>";
          carInfo += "<td>" + car.model + "</td>";
          carInfo += "<td>" + car.seats + "</td>";
          carInfo += "<td>" + car.transmission + "</td>";
          carInfo += "<td>" + car.fuel + "</td>";
          carInfo +=
            "<td>" +
            '<button type="button" id="selectedcar" class="btn btn-primary" data-bs-toggle="modal" data-bs-target="#staticBackdrop" value=' +
            id +
            ">Rent Now</button>" +
            "</td>";
          carInfo += "</tr>";
          selected.append(carInfo);
        });
      },
      error: function () {
        alert("Error loading Cars with: " + seats);
      },
    });
  }
});


  $(document).ready(function() {
    $("#cartable").on("click", "#selectedcar", function () {
      var id = this.value;
      var carDetailsDiv = $(".modal-body div#carDetails");
     
      var myModal = document.getElementById("myModal");
      var myInput = document.getElementById("myInput");
 
      var pickupDate = localStorage.getItem("pdate");
      var returnDate = localStorage.getItem("rdate");


      $.ajax({
        type: 'GET',
        contentType: "application/json; charset=utf-8",
        url: "http://localhost:9999/cars/" + id,
        success: function(car) {

          console.log(car);
          var carInfo = '<p>'

          carInfo += '<b>Car Brand:  </b>' + car.brand + '<br>';
          carInfo += '<b>Car Model:</b>  ' + car.model + '<br>';
          carInfo += '<b>Car Seats:</b>  ' + car.seats + '<br>';
          carInfo += '<b>Car Rego:</b>  ' + car.name + '<br>';
          carInfo += '<b>Price: </b>    $' + ' &nbsp;' + car.price + '<br>';
          carInfo += '<b>PickupDat:</b>  ' + pickupDate + '<br>';
          carInfo += '<b>ReturnDate:</b>  ' + returnDate + '<br>';
          carInfo += '</p><hr>';
          carInfo += '<button type="button" class="btn btn-primary" id="booking" value=' +
          id +
          ">confirm and Book</button><hr>";
          
          carDetailsDiv.append(carInfo);
          
          $("#myModal").modal("show");
          
        }, 
        error: function() {
          alert("Something went wrong, please go to Home page to re-start! ")
        }
      });
    });
  });

  // $(document).ready(function () {
  //   $("#cartable").on("click", "#selectedcar", function () {
  //     var id = this.value;
  //     alert("ID: " + id);
  //   });
  // });


  $(document).ready(function () {
    $("div#carDetails").on("click", "#booking", function () {
        var carid = this.value;
        var custid = localStorage.getItem("loggedin");
        var pickupDate = localStorage.getItem("pdate");
        var returnDate = localStorage.getItem("rdate");
        var testData = JSON.stringify({'carid': carid, 'custid': custid, 'pickupdate': pickupDate, 'returndate': returnDate});

        $.ajax({
          type: 'POST',
          contentType: "application/json; charset=utf-8",
          url: 'http://localhost:9999/bookings',
          dataType: "json",
          data: JSON.stringify({'carid': carid, 'custid': custid, 'pickupdate': pickupDate, 'returndate': returnDate}),
          success: function(booking) {
              alert("Booking added succesfully! Please go to user Profile check your bookings.");
              alert(testData);
          },
          error: function() {
              alert("Booking added faile, please try again!");
          }
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

$(document).ready(function () {
	$("#logbtn").on("click", function () {
	  if($("#logbtn").html() == "Logout"){
        localStorage.clear();
        location.href = "login.html";
      }
	});
  });