
// Data Types ================================================================
// Number
let num = 1;
let num2 = 2342.234;

// BigInt
// Used for dealing with BIG Numbers
let bigNumber = 1234124123n;
console.log(typeof bigNumber);

// Boolean 
let bool = true;
let bool2 = false;

// Simple Conditional statements using logical operators ====================
if(num < num2){
    console.log(num + " is less than " + num2);
}else{
    console.log(num2 + " is less than " + num);
}


// New Data type Symbol

let symb = Symbol("Hello");

console.log(symb);
console.log(typeof symb);

// Symbols are unique data types introduced to ensure unique variables
// even if they are the same type and value within them
let sym1 = Symbol("val");
let sym2 = Symbol("val");

console.log(sym1 == sym2);
console.log(sym1 === sym2);
console.log(sym1 == sym1);


// If you want to get the value inside the Symbol
console.log(sym1.description);
console.log(sym2.description);
console.log(sym1.description == sym2.description);


// Null 
// A null is a type of object
console.log(null);
console.log(typeof null);

// Undefined
// Undefined is a primitive type
let und;
console.log(und);
console.log(typeof und);


// Objects
// Syntax is shown below
// Key value pairs
let cake = {
    flavour: "chocolate",
    bakingTime: 60,
    tasty: true
}

let fruitCake = {
    flavour: "fruit",
    bakingTime: 40,
    tasty: false
}

console.log(cake);
console.log(cake.flavour);
console.log(typeof fruitCake);

// Objects are not strict so you can add additional fields to them
fruitCake.authour = "Brian";
fruitCake.flavor = "Mango";
console.log(fruitCake);

// We can access each part of an object through '.' notation or [] notation
console.log(fruitCake.flavour);
console.log(fruitCake["flavour"]);


// OOP ===========================================================================================
// We can use class to provide some consistency to our objects
class Car {

    // The constructor is declared using the word "constructor"
    constructor(wheels, colour, engine, transmission, driveType, doorNumber, turboCharged){

        // This refers to the object, not the class when it is created
        // Fields do not have to be declared beforehand
        this.wheels = wheels;
        this.colour = colour;
        this.engine = engine;
        this.transmission = transmission;
        this.driveType = driveType;
        this.doorNumber = doorNumber;
        this.turboCharged = turboCharged;
    }
}

// Declaring an array
let names = ["greg", "MIke", "Franklin"];

// Declaring a function
// return is optional
/* You use the syntax function funcName(param1, param2){
    ...function utiliity...
    return value;
}
*/
function loopPrint(list){
    for (value of list){
        console.log(value);
    }
}

loopPrint(names);

class Engine{
    constructor(Boxers, VType, cylinder){
        this.Boxers = Boxers;
        this.VType = VType;
        this.cylinder = cylinder;
    }

    // Adding a function to a class is done below
    // This makes it a method
    vroom(){
        console.log("vroom");
    }
}

let boxers = ["Subaru", "BMW"]

let V8 = new Engine(boxers[0], 8, true);
let sion = new Car(4, "silver", V8, "Automatic", 4, 3, true);

let cars = ["Hyundai", "Toyota", "Honda", "Elmacho"];

sion.driver = "brian";
console.log(typeof Car);


// Function is also a datatype in itself
function throwaway(){
    return 1 + 1;
}
console.log(typeof throwaway);

// Calling a method
V8.vroom();

// Arrays ===============================================================
// Arrays are objects in JS
console.log(typeof cars);

cars.push(235);

console.log(cars);

console.log(sion["colour"]);
console.log(cars[0]);

console.log(cars);
console.log(cars);

let newCars = cars.filter(a => a != 235);

console.log(cars);
console.log(newCars);


let allCapsNames = names.map(personName => personName.toUpperCase());
console.log(names);
console.log(allCapsNames);


let slicedNames = names.slice(0, 2);
console.log(slicedNames);


// Type Coercion in JS
let age = 4;
let stringAge = "4";
console.log(age == stringAge);

// If I want to make sure they are both the same type and value, use
// ===

console.log(age === stringAge);



//Implicit conversion
console.log(typeof(123 + ''));

//Explicit conversion
console.log(typeof String(123));

// Implicit due to logical context
if (2) {
    console.log("2");
}
// Implicit due to logical operator
console.log('Greet' || 7);

// Explicit
console.log(Boolean(21));

console.log(typeof Number('123'))   // explicit
console.log(typeof +'123')          // implicit
let uniqueNum = 123 != '456'    // implicit


console.log(uniqueNum);

//Falsy ========================================================
console.log(Boolean(0));
console.log(Boolean(""));
console.log(Boolean(false));
console.log(Boolean(undefined));
console.log(Boolean(null));
console.log(Boolean(1/"no"));


//Truthy =========================================================
console.log(Boolean(" "));
console.log(Boolean([]));
console.log(Boolean({}));
console.log(Boolean({}));
console.log(Boolean(new Boolean(false)));

let isMorning = true;
let isAfternoon = false;
let isEvening = false;

function greetSomeone(){
    if(isMorning){
        console.log("Good Morning!");
    }else if(isAfternoon){
        console.log("Good Afternoon!");
    }else if(isEvening){
        console.log("Good Evening!");
    }else{
        console.log("Hello there!");
    }
}

greetSomeone();


// Variable Scopes =======================================

// Variables declared outside of any functions or whatnot will be accessible by everything
let globalVar = "I am globally accessible";

{
    // Anything in between a {} are inside of a block
    console.log(globalVar);
}


let hiddenInFunc = "I am outside the function";

// Function scopes are anything declared inside of a function
// These variables are only accessible inside the function
// When the function is called it will prioritize the function scope variables
// At the end of the function call, the variables lifetime is over and it is removed
function hideMyVars(){
    let hiddenInFunc = "I am in a function";
    console.log(hiddenInFunc);
}

console.log(hiddenInFunc);
hideMyVars();
console.log(hiddenInFunc);


// Lexical scope referes to variables accessing other variables inside a function inside a function
function func1(){
    let animal1 = "Lion"; // This now exists in Lexical Scope
    function func2(){
        // This is now an inner function
        let animal2 = "Tiger";
        // The outside animal1 is availabel inside func 2
        console.log(animal1);
        console.log(animal2);
    }
    func2();
}

func1();

// Hoisting ======================================================================================

// Functions are callable before a function is defined
thisFunkIsNotDefined();

function thisFunkIsNotDefined(){
    console.log("what");
}

// Variables defined using a var also is hoisted so you can access it
// However the initialization happens after the call, only the declaration is hoisted
// This means the variable is undefined
console.log(thisVarIsNotDefined);

var thisVarIsNotDefined = "Hi there";

// Let and Const ==================================================================================
// const variables must be initialized on declaration

const variable = "Hello";

// let variables prevent hoisting from occurring before accessing, a run time issue is thrown
// of variable not being defined
let aLetVar;
aLetVar = "Greetings";

console.log(aLetVar);

// var also allows access to variables inside other blocks
// It also allows you to redeclare variables and update both which is not good
var hello = "hello";

// const and let stay within their scope
const outside = "I am outside";
{
    const outside = "I am now inside";
    var hello = "changed Hello";
    console.log(hello);
    console.log(outside);  
    globalvariable = "I am global from inside";
}

console.log(globalvariable);





