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
        url: '/login',
        dataType: 'json',
        type: 'post',
        contentType: 'application/json',
        data: formData,
        success: function(data){

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

    var fromData = JSON.stringify({
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
    console.log(fromData);
    $.ajax({
        url: '/registracija-korisnik',
        dataType: 'json',
        type: 'post',
        contentType: 'application/json',
        data:fromData,
        success:function (data){
            console.log("success");
            sessionStorage.setItem("id", data["id"]);
            sessionStorage.setItem("position",data["position"]);
            window.location.replace("/account/"+data["id"]);
        },
        error: function( jqXhr, textStatus, errorThrown ){
            if (jqXhr.status == 409) {
                alert("Something went wrong!");
                return;
            }
        }
    });
}

