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

        case GET_POKE:
            initialState = action.payload
            return{
                ...initialState
            }
        default:
            return state
    }
}