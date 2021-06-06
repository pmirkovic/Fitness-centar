function sortTable(n) {
    var table, rows, switching, i, x, y, shouldSwitch, dir, switchcount = 0;
    table = document.getElementById("responseElement");
    switching = true;
    dir = "asc";
    var thead=document.getElementById("th"+n);
    thead.classList.add('fa-sort-asc');
    while (switching) {
        switching = false;
        rows = table.rows;
        for (i = 1; i < (rows.length - 1); i++) {
            shouldSwitch = false;
            x = rows[i].getElementsByTagName("TD")[n];
            y = rows[i + 1].getElementsByTagName("TD")[n];
            if (dir == "asc") {
                if (x.innerHTML.toLowerCase() > y.innerHTML.toLowerCase()) {
                    shouldSwitch = true;
                    break;
                }
            } else if (dir == "desc") {
                if (x.innerHTML.toLowerCase() < y.innerHTML.toLowerCase()) {
                    shouldSwitch = true;
                    break;
                }
            }
        }
        if (shouldSwitch) {
            rows[i].parentNode.insertBefore(rows[i + 1], rows[i]);
            switching = true;
            switchcount ++;
        } else {
            if (switchcount == 0 && dir == "asc") {
                dir = "desc";
                thead.classList.remove('fa-sort-asc');
                thead.classList.add('fa-sort-desc');
                switching = true;
            }
        }
    }
    for (i = 1; i <5 ; i++)
    {
        var trows=document.getElementById("th"+i);
        if(i!=n)
        {
            if(trows.classList.contains('fa-sort-asc')){
                trows.classList.remove('fa-sort-asc');
            } else if(trows.classList.contains('fa-sort-desc')){
                trows.classList.remove('fa-sort-desc');
            }
        }
    }
}

function filterData(treningDTO)
{
    var naziv=document.getElementById("moviename").value;
    var tip=document.getElementById("time").value;
    var trajanje=document.getElementById("rating").value;
    var filter=[];
    var trening=treningDTO.trening;
    for(let i=0;i<trening.length;i++)
    {
        document.getElementById(trening[i].id).style.display="";
    }
    if(naziv!="")
        filter["naziv"]=naziv;


    if(tip!="")
        filter["tip"]=tip;


    if(trajanje!="")
        filter["trajanje"]=trajanje;


    for (const [key, value] of Object.entries(filter)) {
        filterOne(trening,key,value);
    }
}

function filterOne(trening,key,value)
{
    for(let i=0;i<trening.length;i++)
    {
        finalFilter(trening[i],key,value);
    }
}