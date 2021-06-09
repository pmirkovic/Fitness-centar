function init () {
    let id = sessionStorage.getItem("id");
    let offline=document.getElementById("offline");
    let online=document.getElementById("online");
    if (id == null) {
        offline.style.display="block";
        online.style.display="none";
    } else {
        online.style.display="block";
        offline.style.display="none";
    }
}