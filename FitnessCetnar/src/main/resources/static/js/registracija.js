$(document).on("submit","#addKorisnikForm",function (event){
    event.preventDefault();

    let email =     $("#email").val();
    let ime =       $("#ime").val();
    let prezime =   $("#prezime").val();
    let telefon =   $("#telefon").val();
    let password =  $("#password").val();
    let username =  $("#username").val();
    let datum =     $("#datum").val();

    let newKorisnik = {
        email,
        ime,
        telefon,
        prezime,
        password,
        username,
        datum,
        position: 0,
        aktivan: true

    }
    $.ajax({
        type: "POST",
        url: "http://localhost:8080/api/korisnik",
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