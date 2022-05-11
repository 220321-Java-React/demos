import React from "react"

export const Home: React.FC<any> = () => {

    return(
        <div className="home-page">
            <div className="home-container">
                <h3>Search for your Pokemon!</h3>
                <input type="number" name="pokeSearch" placeholder="Enter PokeID"/>
                <button className="poke-button"></button>
            </div>
        </div>
    );
}