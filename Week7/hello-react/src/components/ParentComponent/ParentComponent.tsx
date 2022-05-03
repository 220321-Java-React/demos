import React from "react";

//again, every Class component has two paremeters, props and state
//by leaving the state parameter as "any", we can define whatever object we want to store state
//and we're leaving the props parameter empty, since we aren't sending any data to this component
export class ParentComponent extends React.Component<{}, any> {

    //state object to store data
    //these are two pieces of data we intend to send to our child component
    state = {
        color: 'blue',
        animal: 'dog'
    }

    //if you don't create a constructor there will be a default one
    //but chances are we usually don't need a constructor in components unless we're accepting props

    render() {
        return(
            <div>
                <h1>Hello from the parent component! My favorite color is: {this.state.color}</h1>
                {/*Ben will call the child component here*/}
            </div>
        )
    }

}