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

    let email =     $("#email").val();
    let ime =       $("#ime").val();
    let prezime =   $("#prezime").val();
    let telefon =   $("#telefon").val();
    let password =  $("#password").val();
    let username =  $("#username").val();
    let datum =     $("#datu").val();

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
        url: "/registracija-korisnik",
        type: "POST",
        dataType:"json",
        contentType: "application/json",
        data: JSON.stringify(),
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