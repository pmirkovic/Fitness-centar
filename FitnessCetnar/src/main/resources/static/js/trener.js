// Prikaz svih zaposlenih
$(document).ready(function () {    // Čeka se trenutak kada je DOM(Document Object Model) učitan da bi JS mogao sa njim da manipuliše.


       // ajax poziv za dobavljanje svih zaposlenih sa backend-a i prikaz u tabeli
       $.ajax({
           type: "GET",                                                // HTTP metoda
           url: "http://localhost:8080/api/korisnik",                 // URL koji se gađa
           dataType: "json",
           // tip povratne vrednosti
           success: function (data) {                              // ova f-ja se izvršava posle uspešnog zahteva
               // ispisujemo u konzoli povratnu vrednost radi provere

                for (let responseElement of data) {
                    if(responseElement.position == "TRENER") {
                        // prolazimo kroz listu svih zaposlenih
                        let row = "<tr>";                                   // kreiramo red za tabelu
                        row += "<td>" + responseElement.ime + "</td>";       // ubacujemo podatke jednog zaposlenog u polja
                        row += "<td>" + responseElement.prezime + "</td>";
                        row += "<td>" + responseElement.email + "</td>";
                        row += "<td>" + responseElement.position + "</td>";
                        // kreiramo button i definisemo custom data atribut id = id zaposlenog
                        let btn = "<button class='btnSeeMore' data-id=" + responseElement.id + ">Odobri</button>";
                        row += "<td>" + btn + "</td>";                      // ubacujemo button u poslednju ćeliju reda

                        row += "</tr>";                                     // završavamo kreiranje reda

                        $('#responseElement').append(row);
                        // ubacujemo kreirani red u tabelu čiji je id = employees
                    }

                }

               console.log("SUCCESS:\n", data);
           },
           error: function (data) {                                // ova f-ja se izvršava posle neuspešnog zahteva
               console.log("ERROR:\n", data);
           }
       });
});

// Prikaz detalja o odabranom zaposlenom
$(document).on('click', '.btnSeeMore', function () {            // kada je kliknut button čija je klasa class = btnSeeMore
                                           // sakrivamo taj element

    // this je referenca na HTML element koji predstavlja kliknuto dugme See More
    // dataset je kolekcija svih custom data atributa datog HTML elementa iz koje uzimamo id
    // više o data atributima na: https://css-tricks.com/a-complete-guide-to-data-attributes/
    let employeeId = this.dataset.id;

    var formData = JSON.stringify({
        "aktivan":true
    });

    // ajax poziv za dobavljanje traženog zaposlenog sa backend-a i prikaz na stranici
    $.ajax({
        url: "http://localhost:8080/api/korisnik/" + employeeId,
        type: "put",
        dataType: "json",
        contentType:'application/json',
        data:formData,
        complete: function (xhr, status) {
            if (status === 'error') {
                alert("Something's wrong!");
            }
            else {
                window.location.href='pocetna.html';
            }
        }
    });
});

