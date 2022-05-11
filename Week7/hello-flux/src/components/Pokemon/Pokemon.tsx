//this component will simply render a Pokemon and get nested in the Home component

import React from "react"

import "./Pokemon.css"

export const Pokemon: React.FC<any> = (props) => {

    return(
        <div className="pokemon-container">
            <img src={props.poke.sprite}/>
            <h3>{props.poke.name}</h3>
        </div>
    )

}