
$(document).ready(function () {

    $.ajax({
        type: "GET",
        url: "http://localhost:8080/api/korisnik/terms",
        dataType: "json",

        success: function (response) {

            for (let responseElement of response) {
                for (let terms of responseElement.terminskaListaDTOS){
                    let row = "<tr>";
                    row += "<td>" + responseElement.naziv + "</td>";
                    row += "<td>" + responseElement.trajanje + "</td>";
                    row += "<td>" + responseElement.tipTreninga + "</td>";

                    row += "<td>" + terms.cena + "</td>";
                    row += "<td>" + terms.dan + "</td>";
                    let btn = "<form> <input type='hidden' value='" + terms.id + "'> <input type='submit' value='Prijava'> </form>"
                    row += "<td>" + btn + "</td>";
                    row += "</tr>";                                     // završavamo kreiranje reda
                    $('#responseElement').append(row);
                }
            }
            console.log("SUCCESS:\n", response);
        },
        error: function (response) {
            console.log("ERROR:\n", response);
        }
    });
});

+

$(document).on('submit','form',function (e){
    e.preventDefault();

    var id = $(this).find('input:hidden').val();
    sessionStorage.setItem("idTermina", id);
    window.location.replace("http://localhost:8080/termin.html");

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


function myFunctiont() {
    var input, filter, table, tr, td, i, txtValue;
    input = document.getElementById("tip");
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

function myFunctionctr() {
    var input, filter, table, tr, td, i, txtValue;
    input = document.getElementById("trajanje2");
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

function myFunctioncp() {
    var input, filter, table, tr, td, i, txtValue;
    input = document.getElementById("price");
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

function myFunctioncd() {
    var input, filter, table, tr, td, i, txtValue;
    input = document.getElementById("dan");
    filter = input.value.toUpperCase();
    table = document.getElementById("responseElement");
    tr = table.getElementsByTagName("tr");
    for (i = 0; i < tr.length; i++) {
        td = tr[i].getElementsByTagName("td")[4];
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

