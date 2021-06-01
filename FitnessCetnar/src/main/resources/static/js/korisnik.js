/*// Prikaz svih zaposlenih
$(document).ready(function () {    // Čeka se trenutak kada je DOM(Document Object Model) učitan da bi JS mogao sa njim da manipuliše.
    // ajax poziv za dobavljanje svih zaposlenih sa backend-a i prikaz u tabeli
    $.ajax({
        type: "GET",                                                // HTTP metoda
        url: "http://localhost:8080/api/employees",                 // URL koji se gađa
        dataType: "json",                                           // tip povratne vrednosti
        success: function (response) {                              // ova f-ja se izvršava posle uspešnog zahteva
            console.log("SUCCESS:\n", response);                    // ispisujemo u konzoli povratnu vrednost radi provere

            for (let employee of response) {                        // prolazimo kroz listu svih zaposlenih
                let row = "<tr>";                                   // kreiramo red za tabelu
                row += "<td>" + employee.firstName + "</td>";       // ubacujemo podatke jednog zaposlenog u polja
                row += "<td>" + employee.lastName + "</td>";
                row += "<td>" + employee.position + "</td>";
                // kreiramo button i definisemo custom data atribut id = id zaposlenog
                let btn = "<button class='btnSeeMore' data-id=" + employee.id + ">See More</button>";
                row += "<td>" + btn + "</td>";                      // ubacujemo button u poslednju ćeliju reda
                btn = "<button class='btnDelete' data-id=" + employee.id + ">Delete</button>";
                row += "<td>" + btn + "</td>";
                row += "</tr>";                                     // završavamo kreiranje reda

                $('#employees').append(row);                        // ubacujemo kreirani red u tabelu čiji je id = employees
            }
        },
        error: function (response) {                                // ova f-ja se izvršava posle neuspešnog zahteva
            console.log("ERROR:\n", response);
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
        url: "http://localhost:8080/api/employees/" + employeeId,
        dataType: "json",
        success: function (response) {                          // ova f-ja se izvršava posle uspešnog zahteva
            console.log("SUCCESS:\n", response);                // ispisujemo u konzoli povratnu vrednost radi provere

            $('#firstName').text(response.firstName);
            $('#lastName').text(response.lastName);
            $('#position').text(response.position);

            let employeeDiv = $("#oneEmployee");                // dobavljamo element čiji je id = oneEmployee
            employeeDiv.show();                                 // prikazujemo taj element
        },
        error: function (response) {                            // ova f-ja se izvršava posle neuspešnog zahteva
            console.log("ERROR:\n", response);
        }
    });
});

// Dodavanje novog zaposlenog
$(document).on("submit", "#addEmployeeForm", function (event) {     // kada je submit-ovana forma za kreiranje novog zaposlenog
    event.preventDefault();                                         // sprečavamo automatsko slanje zahteva da bismo pokupili (i validirali) podatke iz forme

    // preuzimamo vrednosti unete u formi
    let firstName = $("#firstName").val();
    let lastName = $("#lastName").val();
    let jobPosition = $("#position").val();

    // kreiramo objekat zaposlenog
    // nazivi svih atributa moraju se poklapati sa nazivima na backend-u
    let newEmployee = {
        firstName,
        lastName,
        position: jobPosition     // zbog backend-a jobPosition moramo preimenovati u atribut position
    }

    // ajax poziv za kreiranje novog zaposlenog na backend-u
    $.ajax({
        type: "POST",                                               // HTTP metoda je POST
        url: "http://localhost:8080/api/employees",                 // URL na koji se šalju podaci
        dataType: "json",                                           // tip povratne vrednosti
        contentType: "application/json",                            // tip podataka koje šaljemo
        data: JSON.stringify(newEmployee),                          // u body-ju šaljemo novog zaposlenog (JSON.stringify() pretvara JavaScript objekat u JSON)
        success: function (response) {                              // ova f-ja se izvršava posle uspešnog zahteva
            console.log(response);                                  // ispisujemo u konzoli povratnu vrednost radi provere

            alert("Radnik " + response.id + " je uspešno kreiran!");// prikazujemo poruku uspeha korisniku
            window.location.href = "employees.html";                // redirektujemo ga na employees.html stranicu
        },
        error: function () {                                        // ova f-ja se izvršava posle neuspešnog zahteva
            alert("Greška prilikom dodavanja zaposlenog!");
        }
    });
});

// Brisanje postojećeg zaposlenog
$(document).on('click', '.btnDelete', function () {
    let employeeId = this.dataset.id;

    $.ajax({
        type: "DELETE",
        url: "http://localhost:8080/api/employees/" + employeeId,
        dataType: "json",
        success: function () {
            console.log("SUCCESS");
            $('[data-id="' + employeeId + '"]').parent().parent().remove();  // ukloni red tabele u kom se nalazi element sa data-id atributom = employeeId
        },
        error: function () {
            alert("Greška prilikom brisanja zaposlenog!");
        }
    });
});*/