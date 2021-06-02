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