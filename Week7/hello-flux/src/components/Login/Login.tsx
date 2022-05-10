import React from "react"

import "./Login.css"

export const Login: React.FC<any> = () => {



    //BEN NEEDS TO ADD A LOT OF JUNK INCLUDING ONCLICK AND ONCHANGE 
    return(
        <div className="login">

            <div className="text-container">
                <h1>Welcome to PokeMart!</h1>
                <h3>Sign in to browse for a pokemanz</h3>

                <div className="input-container">
                    <input type="text" name="username" placeholder="username"/>
                </div>
                <div className="input-container">
                    <input type="password" name="password" placeholder="password"/>
                </div>

                <button className="login-button">Catch 'em all!</button>
            </div>

            <div className="disclaimer">
                <p>PokeMart© and its affiliates do not condone the misuse or mistreatment of pokemon</p>
            </div>
        </div>
    )

} 