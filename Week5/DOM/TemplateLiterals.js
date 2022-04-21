// Template Literals ===============================================

let personName = "Jeff"
let paragraph = "Hello \n There \n My \n Name \n Is " + personName

console.log(paragraph)

let tPara = `Hello
There
My
Name
Is
${personName.toUpperCase()}`

console.log(tPara);

let myString = String.raw`sum: \n ${10 + 5} ${personName}`;

console.log(myString);


function printNames(parameter1, parameter2, parameter3){
    console.log(`Hello there ${parameter1}, ${parameter2} and ${parameter3}`)
}

printNames("Mike", "Greg", "Jane");

printNames(1, 12, 34);

