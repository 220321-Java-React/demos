import { IPoke } from "../store/types";

//remember, reducers help us take in new data from actions, 
//which then gets calculated and sent to the store
const initialState:IPoke = {
    id: 0,
    name:"",
    sprite:null
}

type Action = {type: string, payload: object}

export const PokeReducer = (state:IPoke = initialState, action:Action) => {
    //again, leaving this empty for now
}