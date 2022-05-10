import React, { useState } from "react"
import { useDispatch, useSelector } from "react-redux"

import "./Login.css"

export const Login: React.FC<any> = () => {

    //this is how we access the state in the store. The data in the universal data file.
    const appState = useSelector((state) => state)

    //we need this object to actually dispatch data to our store
    const dispatch = useDispatch();

    //useState hooks to declare a state object, a mutator (which changed state), and a default value
    let [username, setUsername] = useState('');
    let [password, setPassword] = useState('');



    return(
        <div className="login">

            <div className="text-container">
                <h1>Welcome to PokeMart!</h1>
                <h3>Sign in to browse for a pokemanz</h3>

                <div className="input-container">
                    <input type="text" name="username" placeholder="username" onChange={handleChange}/>
                </div>
                <div className="input-container">
                    <input type="password" name="password" placeholder="password" onChange={handleChange}/>
                </div>

                <button className="login-button" onClick={loginFunc}>Catch 'em all!</button>
            </div>

            <div className="disclaimer">
                <p>PokeMart© and its affiliates do not condone the misuse or mistreatment of pokemon</p>
            </div>
        </div>
    )

} 