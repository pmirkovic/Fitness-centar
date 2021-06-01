/*function addFitnessCentar(){
    let id = sessionStorage.getItem("id");
    let naziv = document.getElementById('naziv').value;
    let email = document.getElementById('email').value;
    let brTelfona = document.getElementById('brTelefona').value;
    let adresa = document.getElementById('adresa').value;

    var formData = JSON.stringify({
        "email" : email,
        "naziv":naziv,
        "brTelefona":brTelfona,
        "adresa":adresa
    });

    console.log(formData);
    $.ajax({
        url:'/add_fitnescentar',
        dataType:'json',
        type:'post',
        contentType:'application/json',
        data:fromData,
        success:function (){
            console.log("success");
            window.location.replace("/fitnesscentar");
        },
        error:function (jqXhr,textStatus,errorThrown){
            if(jqXhr.status==409) {
                alert("Something wen wrong!");
                return;
            }
        }

    });
}

function deleteFitnessCentar(id){
    $.ajax({
        url: '/delete_fitnescentar/'+id,
        type:'delete',
        success:function (){
            console.log("success");
            window.location.replace("/fitnesscentars");
        },
        error:function (jqXhr,textStatus,errorThrown){
            if (jqXhr.status == 409) {
                alert("Something went wrong!");
                return;
            }
        }
    });
}

function edit(fitnesscentar_id){
    window.location.replace("/fitnesscentar/"+fitnesscentar_id);
}

function editFitnessCentar(fitnesscentar_id){
    let naziv = document.getElementById('naziv').value;
    let email = document.getElementById('email').value;
    let brTelfona = document.getElementById('brTelefona').value;
    let adresa = document.getElementById('adresa').value;

    var formData = JSON.stringify({
        "email" : email,
        "naziv":naziv,
        "brTelefona":brTelfona,
        "adresa":adresa
    });
    $.ajax({
        url: '/edit_fitnesscentar',
        dataType:'json',
        type:'put',
        contentType:'application/json',
        data:formData,
        complete:function (xhr,status){
            if(status === 'error'){
                alert("Something's wrong!");
            }
            else{
                window.location.replace("/fitnesscentars");
            }
        }
    });
}*/