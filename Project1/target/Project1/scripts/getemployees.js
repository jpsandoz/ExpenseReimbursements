const getEmployees = async () => {
    const reimb = await fetch('/getemployees');
    res = await reimb.json();
    console.log(res);
    const table = document.getElementById("employees");

    const tbody = document.createElement("tbody");
    table.appendChild(tbody);
    tbody.innerHTML = "";
    for(i=0; i< res.length; i++){
        const tr = document.createElement("tr");
        tbody.appendChild(tr);
        tr.innerHTML = `<tr><td>${res[i].firstName} ${res[i].lastName}</td><td>${res[i].phone}</td><td>${res[i].username}</td></tr>`
    }
}
