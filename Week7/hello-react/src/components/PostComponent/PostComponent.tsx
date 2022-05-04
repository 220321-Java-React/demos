//import React like usual, but we'll also import useState, which is a hook we will below.
import React, {useState} from "react"; 
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

//useState allows us to store and manipulate state
//you declare a state variable and a mutator function, and a default value within the useState 
let [userName, setUserName] = useState('');
//BEN WILL DO SOMETHING WITH POST CONTENT USE

//useEffect



//return (not render since this is a function component) here
return(
    <div>
        
    </div>
)

}