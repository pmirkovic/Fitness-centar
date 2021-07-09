$(document).on("submit","#addFitnesscentarForm",function (event){
    event.preventDefault();

    let email =     $("#email").val();
    let naziv =       $("#naziv").val();
    let adresa =   $("#adresa").val();
    let btTelefona =   $("#btTelefona").val();


    let newKorisnik = {
        email,
        btTelefona,
        adresa,
        naziv,
    }
    $.ajax({
        type: "POST",
        url: "http://localhost:8080/api/fitnesscentar",
        dataType:"json",
        contentType: "application/json",
        data: JSON.stringify(newKorisnik),
        success:function (response){
            console.log(response);

            alert("Uspesno ste se registorvali " + response.id);
            window.location.href = "pocetna.html";
        },
        error:function (){
            alert("Greska prilikom registracije!");
        }
    });
});

$(document).ready(function () {

    $.ajax({
        type: "GET",
        url: "http://localhost:8080/api/fitnesscentar",
        dataType: "json",

        success: function (response) {

            for (let responseElement of response) {
                    let row = "<tr>";
                    row += "<td>" + responseElement.naziv + "</td>";
                    row += "<td>" + responseElement.email + "</td>";
                    let btn = "<form id='izmena'> <input type='hidden' value='" + responseElement.id + "'> <input type='submit' value='Edit'> </form>";
                    row += "<td>" + btn + "</td>";
                    let btn2 = "<form id='brisanje'> <input type='hidden' value='" + responseElement.id + "'> <input type='submit' value='Obrisi'> </form>";
                    row += "<td>" + btn2 + "</td>";
                    row += "</tr>";
                    $('#responseElement').append(row);
            }

            console.log("SUCCESS:\n", response);
        },
        error: function (response) {
            console.log("ERROR:\n", response);
        }
    });
});

$(document).on('submit','#izmena',function (e){
    e.preventDefault();

    var id = $(this).find('input:hidden').val();
    sessionStorage.setItem("idFt", id);
    window.location.replace("http://localhost:8080/fitnescentriedit.html");

});


$(document).on('submit', '#brisanje', function (e) {
    e.preventDefault();
    var fitnessCentarId = $(this).find('input:hidden').val();

    $.ajax({
        type: "DELETE",
        url: "http://localhost:8080/api/fitnesscentar/" + fitnessCentarId,
        success: function () {
            console.log("SUCCESS");
            alert("Uspešno obrisan fitness centar.")
            //$('[data-id="' + salaId + '"]').parent().parent().remove();
            location.reload();
        },
        error: function () {
            alert("Greška prilikom brisanja fitness centra!");
        }
    });
});