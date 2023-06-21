$(document).ready(function () {
    var seats = localStorage.getItem("seatcount");
    if(seats == "Any"){
        $.ajax({
            type: "GET",
            url: "http://localhost:9999/cars/",
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
    
  });
  