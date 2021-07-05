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

                sessionStorage.setItem("id", data["id"]);
                sessionStorage.setItem("position", data["position"]);

                alert("Uspesni ste se prijavili " + data.id);
                window.location.href = "pocetna.html";

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