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


