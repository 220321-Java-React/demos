const url = "http://localhost:3000"; //putting our base URL in a variable for cleaner code below
//eventually, we'll use this in fetch requests and make calls to our server by appending endpoints

//add an event listener to give our button functionality (using DOM selection)
//"When the getEmployeeButton gets clicked, execute the getEmployees function"
document.getElementById("getEmployeeButton").addEventListener("click", getEmployees);


//getEmployees is an async function which has a fetch request to get employees from our server
//remember, async makes a function return a Promise (which fetch requests return)
async function getEmployees() {

    //we will send a fetch request to get out employee data
    //by default, fetch requests send GET requests (see how to send others like POST below)
    let response = await fetch(url + "/employees");

    //log the response in the console just to see the response object (good for debugging)
    console.log(response);

    //control flow on the status code (which tells us whether the request was successful)
    //we can access the status code (as well as other stuff) through our response variable
    if(response.status === 200) { //"if the response has a status code of 200..."

        //parse the JSON we get back into a JS object
        //.json() is the JS method that takes json and turns it into a JS object
        let data = await response.json();

        //log the actual employee data that's been parsed from JSON (good for debugging)
        console.log(data);

        //For every Employee object we get back from our fetch request, put it in the table
        for(let employee of data){

            //create a table row
            let row = document.createElement("tr");

            //create a data cell for each employee field
            let cell = document.createElement("td");
            //fill the cell with the appropriate employee data
            cell.innerHTML = employee.employee_id;
            //add the td element (data cell) to the tr element (table row)
            row.appendChild(cell);

            //we do this^^^^ for every column in employees

            let cell2 = document.createElement("td");
            cell2.innerHTML = employee.first_name;
            row.appendChild(cell2);

            let cell3 = document.createElement("td");
            cell3.innerHTML = employee.last_name;
            row.appendChild(cell3);

            let cell4 = document.createElement("td");
            cell4.innerHTML = employee.role.role_title;
            row.appendChild(cell4);

            //append the tr (which we called "row") to the table body (tbody)
            //a new row will be appended FOR every employee that got returned in the fetch()
            document.getElementById("employeeBody").appendChild(row);

        }
        //so here, for every employee object, we create a new row, fill it with data, add it to table

    } else {
        //alert causes a popup!!
        alert("uh oh your request failed for some reason :/");
    }


}