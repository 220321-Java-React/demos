//This is our actual store file, which will store all the active data in our application
import {configureStore} from "@reduxjs/toolkit";
import reducer from "../reducers/index";

import { AppState } from "./types";

//the initial state of the application in the store will have default user and poke
//this variable contains the state for the ENTIRE application
//when user or poke payload get dispatched here, this state will change
const initialState:AppState = {
    user: {
        id:0,
        username:"",
        password:""
    },
    poke: {
        id:0,
        name:"",
        sprite:null
    }   
} //these default values will get changed as we click around the application
//when the user logs in, this user object will get populated with the user's data
//when a pokemon is retrieved the poke object will get populated with pokemon data 

//here, I'm just configuring our store to be able to use reducers so we can dispatch new data here
//our entire folder of reducers is contained in this "reducer" object
//so now, when store data changes, reducers automatically notify components, which change their view
export const store = configureStore({
    reducer
})