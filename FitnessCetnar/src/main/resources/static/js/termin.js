$(document).ready(function () {
    var id = sessionStorage.getItem("idTermina");
    $.ajax({
        type: "GET",
        url: "http://localhost:8080/api/terminskalista/"+id,
        dataType: "json",

        success: function (response) {

            $("#cena").html(response.cena);
            $("#vreme").html(response.dan);
            $("#fitnessCentar").html(response.fitnessCentar.naziv);
            $("#idTermina").val(response.id);


            console.log("SUCCESS:\n", response);
        },
        error: function (response) {
            console.log("ERROR:\n", response);
        }
    });
});

$(document).on('click','#prijava',function (e){
    e.preventDefault();

    var idTermina = $("#idTermina").val();
    var idKorisnika = sessionStorage.getItem("id");

    var formData = JSON.stringify({
        "termin_id": {"id":idTermina},
        "korisnik_id": {"id": idKorisnika}
    });
    console.log(formData);
    $.ajax({
        url: 'http://localhost:8080/api/prijava/',
        dataType: 'json',
        type: 'post',
        contentType: 'application/json',
        data: formData,
        success: function(data){


            alert("Uspesna prijava");

        },
        error: function( jqXhr, textStatus, errorThrown ){
            alert("Greska prilikom prijave");


        }
    });




});