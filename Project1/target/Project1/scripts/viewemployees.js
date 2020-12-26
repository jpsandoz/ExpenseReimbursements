let getEmployees = async () => {

    // Get employee list
    let employees = await fetch('/getemployees');
    let response = await employees.json();

    // Get employee table container
    let container = document.querySelector("body");


        // Create employee table element and add it to the container
        let table = document.createElement('table');
        container.appendChild(table);

        // Create header and add it to the table
        let header = document.createElement('tr');
        table.appendChild(header);

        // Populate table with headers
        let headerContents = ['Employee ID', 'First Name','Last Name', 'Email', 'Manager'];
        for (let i = 0; i < 4; i++) {

            // Create header cell and add it to the header row
            let headerCell = document.createElement('th');
            header.appendChild(headerCell);

            // Set the header's inner html (header text)
            headerCell.innerHTML = headerContents[i];
        }

        // Populate table with employee rows
        for(let i = 0; i < response.length; i++) {

            // Create new row element and add it to the table
            let row = document.createElement('tr');
            table.appendChild(row);
        }

};

getEmployees();
