/*function acc(){
    let id = sessionStorage.getItem("id");
    let offline=document.getElementById("offline");
    let online=document.getElementsByClassName("online");
    let clan=document.getElementsByClassName("clan");
    let admin=document.getElementsByClassName("admin");
    let trener=document.getElementsByClassName("trener");

    if (id == null) {
        for (let i = 0; i < online.length; i++) {
            online[i].style.display = "none";
        }
        offline.style.display="block";
        for (let i = 0; i < viewer.length; i++) {
            viewer[i].style.display = "none";
        }
        for (let i = 0; i < admin.length; i++) {
            admin[i].style.display = "none";
        }
        for (let i = 0; i < manager.length; i++) {
            manager[i].style.display = "none";
        }
        alert("You have to be logged in to view your profile!");
        window.location.replace("/");
    } else {
        let role=sessionStorage.getItem("position");
        if (role == "VIEWER") {
            for (let i = 0; i < viewer.length; i++) {
                viewer[i].style.display = "";
            }
            for (let i = 0; i < admin.length; i++) {
                admin[i].style.display = "none";
            }
            for (let i = 0; i < manager.length; i++) {
                manager[i].style.display = "none";
            }
        } else if(role=="ADMIN"){
            for (let i = 0; i < viewer.length; i++) {
                viewer[i].style.display = "none";
            }
            for (let i = 0; i < admin.length; i++) {
                admin[i].style.display = "";
            }
            for (let i = 0; i < manager.length; i++) {
                manager[i].style.display = "none";
            }
        }else{
            for (let i = 0; i < viewer.length; i++) {
                viewer[i].style.display = "none";
            }
            for (let i = 0; i < admin.length; i++) {
                admin[i].style.display = "none";
            }
            for (let i = 0; i < manager.length; i++) {
                manager[i].style.display = "";
            }
        }


        for (let i = 0; i < online.length; i++) {
            online[i].style.display = "";
        }
        offline.style.display="none";
    }
}*/