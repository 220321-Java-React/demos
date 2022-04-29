//This is a TypeScript file. TS is a quirky little language that is like a java/JS hybrid
//It's a SUPERSET of javascript
//console log just like in JS
console.log("Hello Typescript");
//we should strongly type our typescript
var greeting = "hi";
//WOAH not like JS - can't make a string an int so easily
//greeting = 500;
//one TS-exclusive data type is the "any" datatype
//used for type flexibility.
var coolVar = 789000;
coolVar = "Now I'm a String!";
coolVar = 8327274867264872364873264832;
coolVar = true;
//we can make classes in TS, good for holding data (or stuff like objects that come from the server)
var Person = /** @class */ (function () {
    //constructor
    function Person(name, motive) {
        this.name = name;
        this.motive = motive;
    }
    return Person;
}());
//instantiate a Person object
var ben = new Person("Ben", "Vengeance");
//DOM selection and event listeners are the same as in JS
document.getElementById("button").addEventListener("click", messageFunc);
//functions are just like JS as well
//this function will change the <p> when the button is clicked
function messageFunc() {
    //here, we're using values of our Person object to get rendered on the HTML
    document.getElementById("message").innerHTML = ben.name + " is out for: " + ben.motive;
}
