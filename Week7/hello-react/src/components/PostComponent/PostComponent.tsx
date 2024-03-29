//import React like usual, but we'll also import useState/useEffect, which are hooks we'll use below.
import React, {useEffect, useState} from "react"; 
import { IUser } from "../../interfaces/IUser";

//import the CSS file we'll style this component with
import "./PostComponent.css";

//export CONST instead of export class, this is a function component not a class component
//recall how lambdas/arrow functions work: they take in some data, and execute some code.
//in this case, we take in an object of type IUser as props and use it in this function
export const PostComponent: React.FC<IUser>=(user:IUser)  => {
    
let coolVar:string = "I won't be used, and can't be inherited :(";
//this variable is cool, but it's not part of state. We couldn't send this to other components

//we can declare variables like normal but below we see:
//destructuring, which is how we declare variables from props
//useState, which lets us declare state (which is data that can be sent to other components)

//destructuring -
//we're breaking apart the prop we passed into the component (that "IUser" object)
//in this case, we're taking its username variable and turning into a local variable.
//the name inside the curly braces must match a variable in the prop
const {username} = user;

//useState allows us to store and manipulate state 
//you declare a variable, a mutator function, and a default value within the useState
//so we can change the value of the "content" variable with the setContent() function. 
let [content, setContent] = useState('');

//useEffect allows us to execute some code at certain events in the component's life
//this can be anything from button clicks, to state change, to simply rendering the component
//useEffect is a function component's version of the componentDidMount lifecycle method
useEffect(() => {
    //for now, we'll use useEffect to call our useState mutators
    setContent("We are setting this text in the useEffect hook")
}, []) //empty square brackets because we want this useEffect to happen when the component renders



//return (not render since this is a function component) will provide the view
//note - we use "className" instead of "class" in TSX.
return(
    <div className="post-container">
        <div className="profile-container">
            <img className="profile-pic" src='https://t4.ftcdn.net/jpg/00/64/67/63/360_F_64676383_LdbmhiNM6Ypzb3FM4PPuFP9rHe7ri8Ju.jpg' alt='pic'/>
            <h2 className="profile-username">{username}</h2>
        </div>

        <div className="content-container">
            <p>{content}</p>
        </div>
    </div>
)
}