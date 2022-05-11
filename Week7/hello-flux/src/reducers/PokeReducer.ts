import { GET_POKE } from "../actions/actionTypes";
import { IPoke } from "../store/types";

//remember, reducers help us take in new data from actions, 
//which then gets calculated and sent to the store
let initialState:IPoke = {
    id: 0,
    name:"",
    sprite:null
}

type Action = {type: string, payload: any}

export const PokeReducer = (state:IPoke = initialState, action:Action) => {
    switch(action.type){

        //if the Action type coming in is GET_POKE,
        //the empty Pokemon object in initialState gets replaced with the payload Pokemon
        case GET_POKE:
            initialState = action.payload
            return{
                ...initialState 
                //for some reason, React Redux needs "..." to send objects
                //"property spread notation" in ES6
                //supported with transpilation, spread the properties of the object out as props
                //saves us a BUNCH of code instead of having to individually assign each value
            }
        default:
            return state
    }
}