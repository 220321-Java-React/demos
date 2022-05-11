import { LOGIN_USER } from "../actions/actionTypes";
import { IUser } from "../store/types";

//reducers are responsible for calculating and sending new state data to the store
//this is the user reducer, which will help us calculate changes in the User
let initialState:IUser = {
    id:0,
    username:"",
    password:"",
}

//this is an object that will determine what actions to take
type Action = {type:string, payload:any};

//the reducer will take in an IUser object, which is meant to update intialState^
//it will also take in an Action that contains what action to take, and what data it has (payload)
export const UserReducer = (state:IUser = initialState, action: Action) => {
    //switch based on the type in the Action object
    //look at loginUser in the UserACtions to see where this is coming from
    switch(action.type){
        case LOGIN_USER:
            //we change the default IUser to the User we sent in (the payload)
            //in this way, we change the initial state to the data that came from the server
            initialState = action.payload 
            return {
                ...initialState //return that object so it can be used in the view
            }
        //THIS BROKE MY CODE BEFORE
        //since there is no action when the application starts, we need a default case
        //or else the application will break.
        default:
            return state
        }
}