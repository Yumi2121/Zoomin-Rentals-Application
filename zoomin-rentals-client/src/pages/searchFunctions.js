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
              '<button class="btn btn-primary" id="selectstu" value=' +
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
            '<button class="btn btn-primary" id="selectstu" value=' +
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

  var myModal = document.getElementById('myModal')
  var myInput = document.getElementById('myInput')
  
  
  myModal.addEventListener('shown.bs.modal', function () {
    myInput.focus();

    var id = 
    var pickupDate = localStorage.getItem("pdate");
    var returnDate = localStorage.getItem("rdate");

    $.ajax({
      type: 'GET',
      url: "http://localhost:9999/cars/" + id,

    })





  })


});






