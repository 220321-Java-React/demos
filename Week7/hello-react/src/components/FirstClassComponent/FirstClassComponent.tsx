//the first step in any component is to import React from "react";
import React from "react";

//Below, we're creating a CLASS BASED COMPONENT with Typescript. The component takes two parameters
//The parameters are props and state, which we'll mess with later
export class FirstClassComponent extends React.Component<{}, {}>{

    //creating a string variable, which we'll databind below
    //in a TS CLASS, we don't use let/var/const. They aren't recognized as keywords
    words:string = "I am stored in a variable in the class component";

    //Every Class Based Component must contain the render() function
    //This is what the component will actually display (hence render) onto the webpage
    render() {
        //the render function must contain a return statement, where the TSX is actually held
        return(
            <div>
                <h3>Hello from our first class-based component!</h3>
                <p>{this.words}</p>
            </div>
            /* 
                What is "this"? this.xyz just means we're getting the variable from THIS class 
                from within THIS class, we're calling the variable called "words"
            */
        )
    }

}