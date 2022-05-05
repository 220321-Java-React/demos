import React, { useState } from "react";
import { ResultDisplay } from "../ResultDisplayComponent/ResultDisplayComponent";
import { SideComponent } from "../SideComponent/SideComponent";

import "./HypotenuseComponent.css";

//This is a function component, not a clas component: hence React.FC (React.FunctionComponent)
//best practice to make a component take "any" as props, in case the application gets scaled up
//Lastly, function components are just one big lambda/arrow function (hence () => {})
export const HypotenuseComponent: React.FC<any> = () => {

    //use the useState hook to let us set variables (state), mutators (like setters), and defaults
    let [values, setValues] = useState({first:0, second:0}) //yes we can use objects as default val!
    let [result, setResult] = useState(0)//set to zero by default

    //declare an function that takes in an object to calculate hypotenuse
    //this will be called every time a SideComponent changes.
    //within this function, we'll use our setValues mutator to set side values for calculation
    const calculateResult = (e:any) => {
        //fill out setValues object with whatever side comes in
        //we'll take the name of the side, and give the value to the specified side
        setValues(
            {
                //remember we need "..." if we're referring to an object
                ...values,

                //the value inserted will be assigned to either "first" or "second"...
                //depending on which of the Sides got new data
                //e.g. first:value OR second:value. IT'S VALUE ASSIGNMENT!!!
                [e.target.name]:e.target.value
            }
        )

    //do the result calculation, and put the result into this resultCalc variable 
    //(the square root of the sum of both sides to the second power)
    let resultCalc = Math.sqrt(
        Math.pow(values.first, 2) + Math.pow(values.second, 2)
    );

    //round resultCalc so it's a prettier number
    resultCalc = Math.round(resultCalc * 100)/100 //might need to mess with 100s?

    //finally, assign this resultCalc variable to our result variable (useState)
    setResult(resultCalc);
}

    //render our TSX!
    //The Hypotenuse Component will be rendered on the main page... 
    //...and use the SideComponent to ask the user to enter the first and second values.
    //every time the user enters a value, we put it into the result calulator logic
    //and then render the result onto the page!
    return(
        <div className="input-container">
            <h3>Hypotenuse Component Does Not Work! But it renders :)</h3>
            <SideComponent name="first" onChange={calculateResult}/>
            <SideComponent name="second" onChange={calculateResult}/>
            <ResultDisplay values={values} result={result}/>
        </div>
    )
}