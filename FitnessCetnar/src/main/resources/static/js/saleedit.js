$(document).ready(function () {
    var id = sessionStorage.getItem("idSale");
    $.ajax({
        type: "GET",
        url: "http://localhost:8080/api/sala/"+id,
        dataType: "json",

        success: function (response) {
            $("#idSale").val(id);
            $("#kapacitet").val(response.kapacitet);
            $("#oznaka").val(response.oznakaSale);


            console.log("SUCCESS:\n", response);
        },
        error: function (response) {
            console.log("ERROR:\n", response);
        }
    });
});




$(document).on('submit', '#editFitnesscentarForm', function (e) {

    e.preventDefault();
    let idSale = $("#idSale").val();

    let kapacitet=document.getElementById("kapacitet").value;
    let oznaka=document.getElementById("oznaka").value;
    var formData = JSON.stringify({
        "kapacitet": kapacitet,
        "oznakaSale": oznaka,
    });
    $.ajax({
        url: 'http://localhost:8080/api/sala/edit_sala/' + idSale,
        dataType: 'json',
        type: 'put',
        contentType: 'application/json',
        data: formData,
        complete: function (xhr, status) {
            if (status === 'error') {
                alert("Something's wrong!");
            }
            else {
                alert("Uspešno izmenjena sala.")
            }
        }
    });

});
