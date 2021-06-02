$(document).ready(function () {    // Čeka se trenutak kada je DOM(Document Object Model) učitan da bi JS mogao sa njim da manipuliše.
    // ajax poziv za dobavljanje svih zaposlenih sa backend-a i prikaz u tabeli
    $.ajax({
        type: "GET",                                                // HTTP metoda
        url: "http://localhost:8080/api/korisnik",                 // URL koji se gađa
        dataType: "json",                                           // tip povratne vrednosti
        success: function (response) {                              // ova f-ja se izvršava posle uspešnog zahteva
            console.log("SUCCESS:\n", response);                    // ispisujemo u konzoli povratnu vrednost radi provere
        },
        error: function (response) {                                // ova f-ja se izvršava posle neuspešnog zahteva
            console.log("ERROR:\n", response);
        }
    });
});

$(document).on("submit","#addKorisnikForm",function (event){
    event.preventDefault();

    let email = document.getElementById('email').value;
    let ime = document.getElementById('ime').value;
    let prezime = document.getElementById('prezime').value;
    let telefon = document.getElementById('telefon').value;
    let password = document.getElementById('password').value;
    let username = document.getElementById('username').value;
    let datum = document.getElementById('datum').value;

    var formData = JSON.stringify({
        "email":email,
        "ime":ime,
        "telefon":telefon,
        "prezime":prezime,
        "password":password,
        "username":username,
        "datum":datum,
        "position":0,
        "aktivan":true,

    });
    console.log(formData);
    $.ajax({
        url: "http://localhost:8080/api/korisnik",
        type: "POST",
        dataType:"json",
        contentType: "application/json",
        data: formData,
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