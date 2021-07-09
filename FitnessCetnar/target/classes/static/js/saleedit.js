$(document).on('submit', '#prijava', function (e) {

    e.preventDefault();
    let idSale = $("#idSale").val();

    let kapacitet=document.getElementById("kapacitet").value;
    let oznaka=document.getElementById("oznaka").value;
    var formData = JSON.stringify({
        "kapacitet": kapacitet,
        "oznaka_sale": oznaka,
    });
    $.ajax({
        url: 'http://localhost:8080/api/sala/' + idSale,
        dataType: 'json',
        type: 'put',
        contentType: 'application/json',
        data: formData,
        complete: function (xhr, status) {
            if (status === 'error') {
                alert("Something's wrong!");
            }
            else {
                window.location.href="pocetna.html";
            }
        }
    });

});
