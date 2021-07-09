$(document).on("submit","#addTerminForm",function (event){
    event.preventDefault();

    let dan =     $("#dan").val();
    let cena =       $("#cena").val();
    let salaId =   $("#salaId").val();


    let naziv =   $("#naziv").val();
    let opis =   $("#opis").val();

    let trening = {naziv, opis}

    let sala = {"id": salaId}

    let termin = {
       dan, cena, trening, sala
    }
    $.ajax({
        type: "POST",
        url: "http://localhost:8080/api/terminskalista",
        dataType:"json",
        contentType: "application/json",
        data: JSON.stringify(termin),
        success:function (response){
            console.log(response);

            alert("Uspešno dodat termin " + response.id);
        },
        error:function (){
            alert("Greska prilikom dodavanje termina!");
        }
    });
});

