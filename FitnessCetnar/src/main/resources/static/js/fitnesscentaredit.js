$(document).ready(function () {
    var id = sessionStorage.getItem("idFt");
    $.ajax({
        type: "GET",
        url: "http://localhost:8080/api/fitnesscentar/"+id,
        dataType: "json",

        success: function (response) {
            $("#idFt").val(id);
            $("#naziv").val(response.naziv);
            $("#email").val(response.email);


            console.log("SUCCESS:\n", response);
        },
        error: function (response) {
            console.log("ERROR:\n", response);
        }
    });
});




$(document).on('submit', '#editFitnesscentarForm', function (e) {

    e.preventDefault();
    let idFt = $("#idFt").val();

    let naziv=document.getElementById("naziv").value;
    let email=document.getElementById("email").value;
    var formData = JSON.stringify({
        "naziv": naziv,
        "email": email,
    });
    $.ajax({
        url: 'http://localhost:8080/api/fitnesscentar/edit_ft/' + idFt,
        dataType: 'json',
        type: 'put',
        contentType: 'application/json',
        data: formData,
        complete: function (xhr, status) {
            if (status === 'error') {
                alert("Something's wrong!");
            }
            else {
                alert("Uspešno izmenjena ftc.")
            }
        }
    });

});
