//import React like usual, but we'll also import useState, which is a hook we will below.
import React, {useEffect, useState} from "react"; 
import { IUser } from "../../interfaces/IUser";

//import the CSS file we'll style this component with

//export CONST instead of export class, this is a function component not a class component
//recall how lambdas/arrow functions work: they take in some data, and execute some code
//in this case, we take in a object of type IUser and use it in this function
export const PostComponent: React.FC<IUser>=(user:IUser)  => {
    
//destructuring -
//we're breaking apart the prop we passed into the component (that "IUser" object)
//in this case, we're taking its username variable and turning into a local variable.
//the name inside the curly braces must match a variable in the prop
const {username} = user;

//useState allows us to store and manipulate state (remember state is like component variables)
//you declare a state variable and a mutator function, and a default value within the useState 
let [userName, setUserName] = useState('');
let [content, setContent] = useState('');

//useEffect allows us to execute some code at certain points in the application's life
//this can be anything from button clicks, to state change, to simply rendering the component
//useEffect is a function component's version of the componentDidMount lifecycle method
useEffect(() => {
    //for now, we'll use useEffect to call our useState mutators
    setUserName(username);
    setContent("We are setting this text in the useEffect hook")
}, []) //empty square brackets because we want this useEffect to happen when the component renders



//return (not render since this is a function component) here
return(
    <div className="post-container">
        <div className="profile-container">
            <img className="profile-pic" src='https://t4.ftcdn.net/jpg/00/64/67/63/360_F_64676383_LdbmhiNM6Ypzb3FM4PPuFP9rHe7ri8Ju.jpg' alt='pic'/>
            <h2 className="profile-username">{userName}</h2>
        </div>

        <div className="content-container">
            <p>{content}</p>
        </div>
    </div>
)
}