

$(document).ready(function (){

        let korisnikid = sessionStorage.getItem("id");

        $.ajax({
            type: "GET",
            url: "http://localhost:8080/api/korisnik/" + korisnikid,
            dataType: "json",
            success: function (response) {
                console.log("SUCCESS:\n", response);

                $('#firstName').text(response.ime);
                $('#lastName').text(response.prezime);
                $('#email').text(response.email);


                let employeeDiv = $("#oneEmployee");


            },
            error: function (response) {
                console.log("ERROR:\n", response);
            }
        });

});