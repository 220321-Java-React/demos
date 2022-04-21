// Get the Elements that will be updated
let pName = document.querySelector("#pName");
let pType = document.querySelector("#pType");
let pId = document.querySelector("#pId");
let pImg = document.querySelector("#pImg");

let userInput = document.querySelector("#pokeNumber");

userInput.addEventListener("input", getData);

async function getData(){
    let url = `https://pokeapi.co/api/v2/pokemon/${userInput.value}`;

    let response = await fetch(url);

    if(response.status === 200){
        let data = await response.json();
        renderPokemon(data);
    }else{
        console.log("whoops!");
    }
}


function renderPokemon(data){
    pName.innerHTML = data.name;
    let types = [];
    for (value of data.types){
        let type = value.type.name;
        types.push(type);
    }
    pType.innerHTML = types;
    pId.innerHTML = data.id;
    pImg.innerHTML = `<img src="${data.sprites.front_shiny}">`;
}