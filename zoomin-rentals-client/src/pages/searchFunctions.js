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
            '<button id="selectedcar" class="btn btn-primary"  value=' +
            id +
            ">Book Now</button>" +
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

  $(document).ready(function () {
    $("#cartable").on("click", "#selectedcar", function () {
      var id = this.value;
      alert("ID: " + id);
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