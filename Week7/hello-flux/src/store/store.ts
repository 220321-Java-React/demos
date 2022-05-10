//This is our actual store file, which will store all the active data in our application
import {configureStore} from "@reduxjs/toolkit";

import { AppState } from "./types";


//the initial state of the application in the store will have default user and poke
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

export const store = configureStore()