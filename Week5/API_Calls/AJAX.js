// First using the ID of the elements in the table
// We grab them
let pName = document.querySelector("#pName");
let pType = document.querySelector("#pType");
let pId = document.querySelector("#pId");
let pImg = document.querySelector("#pImg");

// We grab the form parent so we can grab the input of the
// users choice
let pokeSearch = document.querySelector("form");

// We now need to set the listener for the button element
let button = pokeSearch.lastElementChild;
button.addEventListener("click", getUserInput);

function getUserInput(){
    // This functions role is to get the users input from the form
    let input = document.querySelector("#pokeNumber").value;
    // We call the function the Pokemon from the PokeApi
    getAjaxPokemon(input);
}

function getAjaxPokemon(input){
    // Initialize an XHR object to send/receive data
    let xhr = new XMLHttpRequest();
    
    // XHR has a few status codes and states in built that indicate where it is in the
    // communication process

    // Open will create a request for us using the HTTP methods
    // And then we provide the URL, open creates the request
    xhr.open("GET", `https://pokeapi.co/api/v2/pokemon/${input}`, true);
    xhr.send();

    // We now asynchronously await the return of the request (response) from the
    // PokeApi server and react if it was successful
    xhr.onreadystatechange = function() {
        // If (and only if) the response is ready (status code == 200 and state == 4)
        if(this.readyState === 4 && this.status === 200){
            // The response contains within its body the JSON text
            // We use the JSON.parse method to get the text as a JavaScript Object
            let data = JSON.parse(xhr.responseText);

            // We use this function to now render the data for our HTML
            renderData(data);
        }
    }

}

function renderData(data){
    console.log(data);
    pName.innerHTML = data.name;
    pType.innerHTML = data.types[0].type.name;
    pId.innerHTML = data.id;
    pImg.innerHTML = `<img src="${data.sprites.front_shiny}">`;
}