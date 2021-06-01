$(document).on("submit","addKorisnikForm",function (event){
    event.preventDefault();

    let ime = $("#ime").val();
    let prezime = $("#prezime").val();
    let username = $("#username").val();
    let email = $("#email").val();
    let password = $("#password").val();
    let telefon = $("#telefon").val();
    let datum = $("#datum").val();

    let noviKorisnik = {
        ime,
        prezime,
        username,
        password,
        email,
        telefon,
        datum
    }
    $.ajax({
        type: "POST",
        url: "http://localhost:8080/api/korisnik",
        dataType:"json",
        contentType: "application/json",
        data:JSON.stringify(noviKorisnik),
        success:function (response){
            console.log(response);
            alert("Uspesno ste se registorvali" + response.id);
            window.location.href = "pocetna.html";
        },
        error:function (){
            alert("Greska prilikom registracije!");
        }
    });
});