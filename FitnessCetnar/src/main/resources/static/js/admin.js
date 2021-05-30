function registracijaTrenera(){
    let email = document.getElementById("email").value;
    let name = document.getElementById('name').value;
    let lastname = document.getElementById('lastname').value;
    let phone = document.getElementById('phone_number').value;
    let password = document.getElementById('password').value;
    let username = document.getElementById('username').value;
    let date = document.getElementById('date').value;
    let id = sessionStorage.getItem("id");

        var fromData = JSON.stringify({
            "email":email,
            "ime":name,
            "telefon":phone,
            "prezime":lastname,
            "password":password,
            "username":username,
            "datum":date,
            "position":1,
            "aktivan":true
        });

    $.ajax({
            url:'/registracija-trener',
            dataType:'json',
            type:'post',
            contentType:'application/json',
            data: formData,
            success: function (data){
                window.location.replace("/pocetna");
            },
            error: function (jqXhr,textStatus,errorThrown){
                window.location.replace("/account/"+id+"/trener")
            }
        });
}

function trener(){
    var id=sessionStorage.getItem("id");
    window.location.replace("/account/"+id+"/trener");
}

function createTrener(){
    var id = sessionStorage.getItem("id");
    window.location.replace("/account"+id+"/registracija_trenera");
}

function deleteTrener(trener_id){
    let id = sessionStorage.getItem("id");
    $.ajax({
        url: '/remove_trener'+trener_id,
        dataType: 'json',
        type: 'delete',
        contentType: 'application/json',
        success: function (){
            window.location.replace("/account"+id+"trener");
        },
        error: function (jqXhr,textStatus,errorThrown){
            window.location.replace("/account"+id+"/trener");
        }
    });
}