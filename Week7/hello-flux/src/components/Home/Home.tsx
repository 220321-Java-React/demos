import React, { useState } from "react"
import { useDispatch, useSelector } from "react-redux";
import { getPoke } from "../../actions/PokeActions";
import { Pokemon } from "../Pokemon/Pokemon";

import "./Home.css"

export const Home: React.FC<any> = () => {

    //we need useSelector to access the store
    //we set it so that it can take <any state, and access any store>
    //our state object is set to change to whatever (state is in the store) 
    const appState = useSelector<any, any>((state) => state)

    //we need useDispatch to DISPATCH information to our Action (which dispatches to the store/reducers)
    const dispatch = useDispatch();

    //we need useState to store pokeID as state, and change it with it's mutator
    let [pokeID, setPokeID] = useState(0);

    //whenever pokeSearch changes, we'll save the number as our pokeID state (using the mutator)
    const handleChange = (e:any) => {
        if(e.target.name === "pokeSearch") {
            setPokeID(e.target.value) //use the mutator to get the value the user inputted
        }
    }

    //we need to actually send our pokeID state to the getPoke action
    const loadPoke = async () => {
        await dispatch(
            getPoke(pokeID) as any //we send the pokeID state variable to the getPoke action
            //"as any" because the component doesn't know what type this will return
        )
    }

    return(
        <div className="home-page">
            <div className="home-container">
                <Pokemon poke={appState.poke}/>
                <h3>Search for your Pokemon!</h3>
                <input type="number" name="pokeSearch" placeholder="Enter PokeID" onChange={handleChange}/>
                <button className="poke-button" onClick={loadPoke}>Find Pokemon</button>
            </div>
        </div>
    );
}