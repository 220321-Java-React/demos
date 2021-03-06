import React from "react";

//notice props is of type any because we're expected a state object from the parent component
//state we'll also make any so that we can create our own state based on the parent state

//the parent sends a state of any type. this child accepts props of any type. see the connection?
//the state in a parent component will be the props in a child component
export class ChildComponent extends React.Component<any, any>{

    //this is a constructor, which is one way to initialize a class component and it's state
        //In English, it "gives values to a component's variables"
    //remember, "props" is the variable coming in the left parameter of this class declaration
    //the constructor takes in our props object, which has the data we'll use
    constructor(props:any) {
        super(props); //remember, super calls the parent constructor
        //let's initialize this component's state
        this.state = {
            favColor: props.color,
            favAnimal: props.animal
        }
    }

    //child component gets these values from its props, which is data coming from the parent
    render() {
        return(
            <div>
                <h3 style={{color: this.state.favColor}}>My parent's favorite color is: {this.state.favColor}</h3>
                <h3>My parent's favorite animal is: {this.state.favAnimal}</h3>
            </div>
        )
    }

}