function changeValue(number){
    console.log(number)
    number = 42
    console.log(number)
}

let myNumber = 20
changeValue(myNumber)
console.log(myNumber)


let myObject = {'Pet': 'Cat'}
console.log(myObject.Pet)
function feedCat(obj){
    obj.Pet = 'Fed Cat'
}
feedCat(myObject)
console.log(myObject.Pet)


let secondObject = {'Pet': 'Cat'}
console.log(secondObject.Pet)
function adoptDog(obj){
    obj = {'Pet': 'Dog'}
}
adoptDog(secondObject)
console.log(secondObject.Pet)


function reverseString(str){
    let splitStr = str.split("");
    // This breaks apart the string into a char array
    let reverseArray = splitStr.reverse();
    // Reverses index of the array
    let joinArray = reverseArray.join("");
    // Joins the array into a string
    return joinArray;
}

function printReversedName(name, callback){
    console.log(`Hello there ${callback(name)}`)
}

printReversedName("Greg", reverseString)


function greeting(){
    let message = "Hello!";

    function sayHi(){
        console.log(message)
    }

    return sayHi;
}

let hi = greeting();
hi()



// Arrow Functions -============================================

// One-line arrow functions
let hello = () => "helloWorld";

console.log(hello());

// Multi-line arrow functions
let sum = (a, b) => {
    let result = a + b;
    return `Sum is ${result}`
};

console.log(sum(15, 234124123413));

// anonymous function, a function without an explicit name

let anon = function(){
    console.log("I am anonymous")
}

anon();

// Self invoking function
(function(){
    console.log("I am activating on my declaration");
})();