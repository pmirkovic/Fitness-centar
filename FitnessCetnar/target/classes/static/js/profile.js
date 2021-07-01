

$(document).ready(function (){

        let korisnikid = sessionStorage.getItem("id");

        $.ajax({
            type: "GET",
            url: "http://localhost:8080/api/korisnik/" + korisnikid,
            dataType: "json",
            success: function (response) {                          // ova f-ja se izvršava posle uspešnog zahteva
                console.log("SUCCESS:\n", response);                // ispisujemo u konzoli povratnu vrednost radi provere

                $('#firstName').text(response.ime);
                $('#lastName').text(response.prezime);
                $('#email').text(response.email);


                let employeeDiv = $("#oneEmployee");                // dobavljamo element čiji je id = oneEmployee
                                                   // prikazujemo taj element

            },
            error: function (response) {                            // ova f-ja se izvršava posle neuspešnog zahteva
                console.log("ERROR:\n", response);
            }
        });

});