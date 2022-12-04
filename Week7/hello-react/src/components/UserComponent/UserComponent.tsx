import React from "react"

import { IUser } from "../../interfaces/IUser"
import { PostComponent } from "../PostComponent/PostComponent";

//Because we only ever intend to use data found in IUser, we'll put IUser as the state
export class UserComponent extends React.Component<any, IUser> {


    //constructor that initializes the User's variables to empty strings (we'll change later)
    constructor(props:any){
        super(props);
        this.state = {
            firstName: "",
            lastName: "",
            username: "",
            email: ""
        }
    }

    //The componentDidMount() lifecycle method is usually used for populating data after page load
    //in other words... once this component is rendered, the body of this method will execute
    componentDidMount(){
        //hardcoding - but imagine we're making a call to a server that populates this user data
        //to set the state object, we use this.setState()
        this.setState(
            {
                firstName: "Bon",
                lastName: "Jovi",
                username: "bigbon",
                email: "email@fakemail.com"
            }
        )
    }
    //big picture of this code block: 
    //when this component renders, the state will be set due to the code executing in componentDidMount()

    //as usual, we need a render function that renders the view of this ClassComponent
    render() {
        return(
            <div>
                <h2>User: {this.state.firstName} {this.state.lastName} 
                ({this.state.username}) Email: {this.state.email}</h2>
                <PostComponent {...this.state}/>
            </div>
        )
        //to send the entire state object to a child component, we use {...this.state}
    }

}