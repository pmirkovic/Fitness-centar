
$(document).ready(function () {



       $.ajax({
           type: "GET",
           url: "http://localhost:8080/api/korisnik",
           dataType: "json",
           // tip povratne vrednosti
           success: function (data) {


                for (let responseElement of data) {
                    if(responseElement.position == "TRENER") {

                        let row = "<tr>";
                        row += "<td>" + responseElement.ime + "</td>";
                        row += "<td>" + responseElement.prezime + "</td>";
                        row += "<td>" + responseElement.email + "</td>";
                        row += "<td>" + responseElement.position + "</td>";
                        let btn = "<button class='btnSeeMore' data-id=" + responseElement.id + ">Odobri</button>";
                        row += "<td>" + btn + "</td>";
                        btn = "<button class='btnDelete' data-id=" + responseElement.id + ">Delete</button>";
                        row += "<td>" + btn + "</td>";
                        row += "</tr>";

                        $('#responseElement').append(row);

                    }

                }

               console.log("SUCCESS:\n", data);
           },
           error: function (data) {
               console.log("ERROR:\n", data);
           }
       });
});


$(document).on('click', '.btnSeeMore', function () {

    let pozicija    = true;

    let employeeId = this.dataset.id;

    var formData = JSON.stringify({
        aktivan:pozicija
    });


    $.ajax({
        type: "put",
        url: "http://localhost:8080/api/korisnik/" + employeeId,
        dataType: "json",
        contentType:'application/json',
        data:formData,
        complete: function (xhr, status) {
            if (status === 'error') {
                alert("Something's wrong!" + employeeId);
            }
            else {
                window.location.href='pocetna.html';
            }
        }
    });
});


$(document).on('click', '.btnDelete', function () {
    let employeeId = this.dataset.id;

    $.ajax({
        type: "DELETE",
        url: "http://localhost:8080/api/korisnik/" + employeeId,
        dataType: "json",
        success: function () {
            console.log("SUCCESS");
            $('[data-id="' + employeeId + '"]').parent().parent().remove();
        },
        error: function () {
            alert("Greška prilikom brisanja zaposlenog!");
        }
    });
});
