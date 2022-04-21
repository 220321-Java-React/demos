// Selecting by ID ==================================
let title = document.getElementById("firstTitle");

console.log(title);


// Selecting by Class Name ===========================

let paras = document.getElementsByClassName("para");

console.log(paras);


// Selecting by tag name ==============================================================

let body = document.getElementsByTagName("body")[0];

console.log(body);


// CSS selectors in JS ================================================================
// Selecting by ID in CSS
let cssTitle = document.querySelector("#firstTitle");
console.log(cssTitle);

// Select by Class in CSS, query selector will grab first occurrence
let para = document.querySelector(".para");
console.log(para);

// If you wish to grab all of them use query selector all
let multiPara = document.querySelectorAll(".para");
console.log(multiPara);



//DOM Manipulation ==================================================================
// Creating elements in JS 
let newTitle = document.createElement("h2");
newTitle.innerText = "I was made in JS";
body.appendChild(newTitle);

// Replace child elements in JS

// First we create the element that we want to replace the other one with
let newPara = document.createElement("p");
// Add in some text
newPara.innerText = "I was made in JS, and I replaced the previous paragraph";
// Then we get a reference to the element we want to replace
let replacePara = document.querySelectorAll('.para')[1];
// We grab the parent of the element, the element in which our selected one resides
let cssBody = document.querySelector("body");
// We use the replaceChild method with the parent element
cssBody.replaceChild(newPara, replacePara);

// Remove child element
//cssBody.removeChild(newPara);



// Insert a node before another ==============================================
let siblingPara = document.createElement("p");
siblingPara.innerText = "I am on top of this";
cssBody.insertBefore(siblingPara, newPara);


// Managing attributes =======================================================

// Setting attribute
newPara.setAttribute("class", "para");

// Getting attribute
console.log(document.querySelector("#firstTitle").getAttribute("id"));

// Removing attribute
newPara.removeAttribute("class");

// Adding an image with DOM manipulation

let dog = document.createElement("img");
let container = document.createElement("div");
container.appendChild(dog);
dog.setAttribute("src", "https://i.natgeofe.com/n/4f5aaece-3300-41a4-b2a8-ed2708a0a27c/domestic-dog_thumb_4x3.jpg");
dog.setAttribute("style", "width: 540px; height: auto");

body.appendChild(container);


// Traversing the DOM =============================================================
// Topmost Nodes
console.log(document.documentElement);
console.log(document.head);
console.log(document.body);

// Parent Nodes
console.log(dog.parentNode);
console.log(dog.parentElement);

console.log(document.documentElement.parentNode);
console.log(document.documentElement.parentElement);

// Child nodes
console.log(body.childNodes);
console.log(body.firstChild);
console.log(body.lastChild);

// Child elements
console.log(body.children);
console.log(body.firstElementChild);
console.log(body.lastElementChild);
console.log(body.children[2]);


// Sibling Elements
console.log(newPara.previousElementSibling);
console.log(newPara.nextElementSibling);