$(document).on("submit","#addFitnesscentarForm",function (event){
    event.preventDefault();

    let kapacitet =     $("#kapacitet").val();
    let oznaka =       $("#oznaka").val();

    let newKorisnik = {
        kapacitet,
        "oznakaSale": oznaka

    }
    $.ajax({
        type: "POST",
        url: "http://localhost:8080/api/sala",
        dataType:"json",
        contentType: "application/json",
        data: JSON.stringify(newKorisnik),
        success:function (response){
            console.log(response);

            alert("Uspesno ste dodali salu " + response.id);
            window.location.href = "pocetna.html";
        },
        error:function (){
            alert("Greska prilikom registracije!");
        }
    });
});

$(document).ready(function () {

    $.ajax({
        type: "GET",
        url: "http://localhost:8080/api/sala",
        dataType: "json",

        success: function (response) {

            for (let responseElement of response) {
                let row = "<tr>";
                row += "<td>" + responseElement.kapacitet + "</td>";
                row += "<td>" + responseElement.oznakaSale + "</td>";
                let btn = "<form id='izmena'> <input type='hidden' value='" + responseElement.id + "'> <input type='submit' value='Edit'> </form>";
                row += "<td>" + btn + "</td>";
                btn2 = "<form id='brisanje'> <input type='hidden' value='" + responseElement.id + "'> <input type='submit' value='Obrisi'> </form>";
                row += "<td>" + btn2 + "</td>";
                row += "</tr>";
                $('#responseElement').append(row);
            }

            console.log("SUCCESS:\n", response);
        },
        error: function (response) {
            console.log("ERROR:\n", response);
        }
    });
});

$(document).on('submit','#izmena',function (e){
    e.preventDefault();

    var id = $(this).find('input:hidden').val();
    sessionStorage.setItem("idSale", id);
    window.location.replace("http://localhost:8080/saleedit.html");

});


$(document).on('submit', '#brisanje', function (e) {
    e.preventDefault();
    var salaId = $(this).find('input:hidden').val();

    $.ajax({
        type: "DELETE",
        url: "http://localhost:8080/api/sala/" + salaId,
        success: function () {
            console.log("SUCCESS");
            alert("Uspešno obrisana sala.")
            //$('[data-id="' + salaId + '"]').parent().parent().remove();
            location.reload();
        },
        error: function () {
            alert("Greška prilikom brisanja sale!");
        }
    });
});