// Prikaz svih zaposlenih
$(document).ready(function () {    // Čeka se trenutak kada je DOM(Document Object Model) učitan da bi JS mogao sa njim da manipuliše.
    // ajax poziv za dobavljanje svih zaposlenih sa backend-a i prikaz u tabeli
    $.ajax({
        type: "GET",                                                // HTTP metoda
        url: "http://localhost:8080/api/trening",                 // URL koji se gađa
        dataType: "json",
        // tip povratne vrednosti
        success: function (response) {                              // ova f-ja se izvršava posle uspešnog zahteva
                                // ispisujemo u konzoli povratnu vrednost radi provere

            for (let responseElement of response) {                        // prolazimo kroz listu svih zaposlenih
                let row = "<tr>";                                   // kreiramo red za tabelu
                row += "<td>" + responseElement.naziv + "</td>";       // ubacujemo podatke jednog zaposlenog u polja
                row += "<td>" + responseElement.cena + "</td>";
                row += "<td>" + responseElement.tipTreninga + "</td>";
                row += "<td>" + responseElement.trajanje + "</td>";
                // kreiramo button i definisemo custom data atribut id = id zaposlenog
                let btn = "<button class='btnSeeMore' data-id=" + responseElement.id + ">See More</button>";
                row += "<td>" + btn + "</td>";

                row += "</tr>";                                     // završavamo kreiranje reda

                $('#responseElement').append(row);                        // ubacujemo kreirani red u tabelu čiji je id = employees
            }
            console.log("SUCCESS:\n", response);
        },
        error: function (response) {                                // ova f-ja se izvršava posle neuspešnog zahteva
            console.log("ERROR:\n", response);
        }
    });
});

$(document).on('click','.btnSeeMore',function (){

});

function myFunctioni() {
    var input, filter, table, tr, td, i, txtValue;
    input = document.getElementById("ime");
    filter = input.value.toUpperCase();
    table = document.getElementById("responseElement");
    tr = table.getElementsByTagName("tr");
    for (i = 0; i < tr.length; i++) {
        td = tr[i].getElementsByTagName("td")[0];
        if (td) {
            txtValue = td.textContent || td.innerText;
            if (txtValue.toUpperCase().indexOf(filter) > -1) {
                tr[i].style.display = "";
            } else {
                tr[i].style.display = "none";
            }
        }
    }
}

function myFunctionc() {
    var input, filter, table, tr, td, i, txtValue;
    input = document.getElementById("cena");
    filter = input.value.toUpperCase();
    table = document.getElementById("responseElement");
    tr = table.getElementsByTagName("tr");
    for (i = 0; i < tr.length; i++) {
        td = tr[i].getElementsByTagName("td")[1];
        if (td) {
            txtValue = td.textContent || td.innerText;
            if (txtValue.toUpperCase().indexOf(filter) > -1) {
                tr[i].style.display = "";
            } else {
                tr[i].style.display = "none";
            }
        }
    }
}

function myFunctiont() {
    var input, filter, table, tr, td, i, txtValue;
    input = document.getElementById("tip");
    filter = input.value.toUpperCase();
    table = document.getElementById("responseElement");
    tr = table.getElementsByTagName("tr");
    for (i = 0; i < tr.length; i++) {
        td = tr[i].getElementsByTagName("td")[2];
        if (td) {
            txtValue = td.textContent || td.innerText;
            if (txtValue.toUpperCase().indexOf(filter) > -1) {
                tr[i].style.display = "";
            } else {
                tr[i].style.display = "none";
            }
        }
    }
}

function myFunctionctr() {
    var input, filter, table, tr, td, i, txtValue;
    input = document.getElementById("trajanje2");
    filter = input.value.toUpperCase();
    table = document.getElementById("responseElement");
    tr = table.getElementsByTagName("tr");
    for (i = 0; i < tr.length; i++) {
        td = tr[i].getElementsByTagName("td")[3];
        if (td) {
            txtValue = td.textContent || td.innerText;
            if (txtValue.toUpperCase().indexOf(filter) > -1) {
                tr[i].style.display = "";
            } else {
                tr[i].style.display = "none";
            }
        }
    }
}

