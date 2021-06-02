/*$(document).on("click",".login",function (){

    let email = $("#email").val();
    let password = $("#password").val();

    var loginKorisnik = {
        email,
        password
    }

    $.ajax({
        url: 'http://localhost:8080/api/korisnik',
        dataType:'josn',
        type:'post',
        contentType:'application/json',
        data:JSON.stringify(),
        success: function (data){
            console.log(data);
            alert("Uspesno ste se prijavili" + data.id);
            window.location.href = "pocetna.html";
        },
        error:function (){
            alert("Greska prilikom prijave!");
        }
    });
});*/

function login() {
    // get the form data
    // there are many ways to get this data using jQuery (you can use the class or id also)
    let email = document.getElementById('email').value;
    let password = document.getElementById('password').value;
    var formData = JSON.stringify({
        "email": email,
        "password": password
    });
    console.log(formData);
    $.ajax({
        url: 'http://localhost:8080/api/korisnik/login',
        dataType: 'json',
        type: 'post',
        contentType: 'application/json',
        data: formData,
        success: function(data){

            alert("Uspesni ste se prijavili "+ data.id);
            location.window.href = "pocetna.html";

        },
        error: function( jqXhr, textStatus, errorThrown ){
            if (jqXhr.status == 404) {
                alert("Email not found!");
                return;
            } else if (jqXhr.status == 400) {
                alert("Wrong password");
                return;
            } else if (jqXhr.status == 406) {
                alert("Server error");
                return;
            }

        }
    });
}
function registracija(){
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
        url: '/registracija-korisnik',
        dataType: 'json',
        type: 'post',
        contentType: 'application/json',
        data:formData,
        success:function (){
            console.log("success");

            window.location.replace("/pocetna");
        },
        error: function( jqXhr, textStatus, errorThrown ){
            if (jqXhr.status == 409) {
                alert("Something went wrong!");
                return;
            }
        }
    });
}

function logOut(){
    sessionStorage.clear();
    window.location.replace("/");
}
function profile(){
    var id = sessionStorage.getItem("id");
    window.location.replace("/account/"+id);
}
function odradjeni_treninzi(){
    var id = sessionStorage.getItem("id");
    window.location.replace("/account/"+id+"/odradjeni_treninzi");
}
function prijavljeni_treninzi(){
    var id = sessionStorage.getItem("id");
    window.location.replace("/account/"+id+"/prijavljeni_treninzi");
}