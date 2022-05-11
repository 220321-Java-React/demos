//This file will contain actions we can take that deal with Pokemon

import axios from "axios";
import { IPoke } from "../store/types"
import { GET_POKE } from "./actionTypes";

//this Action will GET Pokemon from the PokeAPI, when given an id to search with
export const getPoke = (pokeID:number) => async (dispatch:any) => {

    //empty object of type IPoke which we'll populate with our GET request
    let incomingPoke:IPoke;

    try{

        //making an axios HTTP request to GET a pokemon from pokeAPI, with the ID sent in
        //remember, we need to AWAIT async functions because they return a promise object
        const response = await axios.get("https://pokeapi.co/api/v2/pokemon" + pokeID)

        //fill out the empty incomingPoke object with Pokemon data
        incomingPoke = {
            id: response.data.id,
            name: response.data.name,
            sprite: response.data.sprites.front_default
        }

        //we need to use the dispatcher to send this new data to the store/reducer
        return dispatch({
            type: GET_POKE,
            payload: incomingPoke
        })

    } catch (e) {
        console.log("GET POKE FAILED!!")
    }

}