import { IUser } from "../store/types";

//reducers are responsible for calculating and sending new state data to the store
//this is the user reducer, which will help us calculate changes in the User
const initialState:IUser = {
    id:0,
    username:"",
    password:""
}

//this is an object that will determine what actions to take
type Action = {type:string, payload:object};

//the reducer will take in an IUser object, which is meant to update intialState^
//it will also take in an Action that contains what action to take, and what data it has (payload)
export const UserReducer = (state:IUser = initialState, action: Action) => {
    //empty for now, we need some logic before we can do this.
}