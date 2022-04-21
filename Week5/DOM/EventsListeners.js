let button = document.createElement("input");
button.setAttribute("type", "button");
button.setAttribute("value", "New Button");

let body = document.querySelector("body");
body.appendChild(button);

function alertUser(){
    alert("You clicked me!@!");
}

button.addEventListener("click", alertUser);

// First make a function that you want to attach to a button
function alertUser(){
    alert("Hey there!");
}

// Then we create the button of type button
let inputButton = document.createElement("button");
// We add the functionality to the button using its event and the name of the function
inputButton.setAttribute("onclick", "alertUser()");
// Add in some text to the button
inputButton.innerText = "Button";
// Add it to the HTML
body.appendChild(inputButton);



// Bubbling ================================================================
let bubbleContainer = document.createElement("div");
let title = document.createElement("h2");

title.innerText = "Click me for Bubbling";
bubbleContainer.appendChild(title);

body.appendChild(bubbleContainer);

title.addEventListener("click", () => alert("title click"), false);
bubbleContainer.addEventListener("click", () => alert("container clicked"), false);


// Capturing ==============================================================
let captureContainer = document.createElement("div");
let img = document.createElement("img");
img.setAttribute("src", "https://upload.wikimedia.org/wikipedia/commons/thumb/3/3a/Cat03.jpg/1200px-Cat03.jpg");
img.setAttribute("style", "width: 200px; height: auto");
captureContainer.appendChild(img);

body.appendChild(captureContainer);

captureContainer.addEventListener("mouseenter", () => console.log("Mouse hovered over container"), true);
img.addEventListener("mouseenter", () => console.log("Mouse hovered over Cat"), true);


