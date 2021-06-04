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
            if(data.position == 2) {
                for (let responseElement of data) {
                    // prolazimo kroz listu svih zaposlenih
                    let row = "<tr>";                                   // kreiramo red za tabelu
                    row += "<td>" + responseElement.ime + "</td>";       // ubacujemo podatke jednog zaposlenog u polja
                    row += "<td>" + responseElement.prezime + "</td>";
                    row += "<td>" + responseElement.email + "</td>";
                    row += "<td>" + responseElement.position + "</td>";
                    // kreiramo button i definisemo custom data atribut id = id zaposlenog
                    let btn = "<button class='btnSeeMore' data-id=" + responseElement.id + ">See More</button>";
                    row += "<td>" + btn + "</td>";                      // ubacujemo button u poslednju ćeliju reda
                    btn = "<button class='btnDelete' data-id=" + responseElement.id + ">Delete</button>";
                    row += "<td>" + btn + "</td>";
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
    let employeesDiv = $("#allEmployees");                      // dobavljamo element čiji je id = allEmployees  (pogledati html)
    employeesDiv.hide();                                        // sakrivamo taj element

    // this je referenca na HTML element koji predstavlja kliknuto dugme See More
    // dataset je kolekcija svih custom data atributa datog HTML elementa iz koje uzimamo id
    // više o data atributima na: https://css-tricks.com/a-complete-guide-to-data-attributes/
    let employeeId = this.dataset.id;

    // ajax poziv za dobavljanje traženog zaposlenog sa backend-a i prikaz na stranici
    $.ajax({
        type: "GET",
        url: "http://localhost:8080/api/korisnik/" + employeeId,
        dataType: "json",
        success: function (data) {                          // ova f-ja se izvršava posle uspešnog zahteva
            console.log("SUCCESS:\n", data);                // ispisujemo u konzoli povratnu vrednost radi provere

            $('#naziv').text(data.ime);
            $('#opis').text(data.prezime);
            $('#tipTreninga').text(data.email);

            let employeeDiv = $("#oneEmployee");                // dobavljamo element čiji je id = oneEmployee
            employeeDiv.show();                                 // prikazujemo taj element
        },
        error: function (data) {                            // ova f-ja se izvršava posle neuspešnog zahteva
            console.log("ERROR:\n", data);
        }
    });
});

