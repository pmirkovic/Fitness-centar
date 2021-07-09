
$(document).ready(function () {
    var idKorisnika = sessionStorage.getItem("id");
    $.ajax({
        type: "GET",
        url: "http://localhost:8080/api/prijava/korisnik/"+idKorisnika,
        dataType: "json",

        success: function (response) {

            for (let responseElement of response) {
                    let row = "<tr>";
                    row += "<td>" + responseElement.id + "</td>";
                    row += "<td>" + responseElement.trening.naziv + "</td>";

                    let btn = "<form id='otkazivanje'> <input type='hidden' value='" + responseElement.id + "'> <input type='submit' value='Otkazi'> </form>"
                    row += "<td>" + btn + "</td>";

                    let btn2 = "<form id='odradjen'> <input type='hidden' value='" + responseElement.id + "'> <input type='submit' value='Odradjen'> </form>"
                    row += "<td>" + btn2 + "</td>";
                    row += "</tr>";                                     // završavamo kreiranje reda
                    $('#responseElement').append(row);
            }
            console.log("SUCCESS:\n", response);
        },
        error: function (response) {
            console.log("ERROR:\n", response);
        }
    });
});


$(document).on('submit','#otkazivanje',function (){
    e.preventDefault();

    var id = $(this).find('input:hidden').val();

    $.ajax({
        type: "DELETE",
        url:"http://localhost:8080/api/prijava/"+id,
        dataType: "json",
        success: function (response){
            console.log("SUCCESS:\n",response);
            location.reload();
        },
        error:function (response){
            console.log("ERROR:\n", response);
        }
    });
});

$(document).on('submit','#odradjen',function (){
    e.preventDefault();

    var id = $(this).find('input:hidden').val();

    $.ajax({
        type: "DELETE",
        url:"http://localhost:8080/api/prijava/"+id,
        dataType: "json",
        success: function (response){
            console.log("SUCCESS:\n",response);
            location.reload();
        },
        error:function (response){
            console.log("ERROR:\n", response);
        }
    });
});


/*
$(document).on('submit','form',function (e){
    e.preventDefault();

    var id = $(this).find('input:hidden').val();
    sessionStorage.setItem("idTermina", id);
    window.location.replace("http://localhost:8080/termin.html");

});
*/
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

