import React from "react"

//This component will take in user inputs for triangle sides (so we can calculate hypotenuse)
//it takes in any kind of prop, and we'll call the prop object props.
export const SideComponent: React.FC<any> = (props:any) => {

    //we render the name of the triangle side we're looking for
    //the user inputs a value, which gets associated with one or the other side in the Hypotenuse
    //onChange (when the user changes the value in the input), run onChange from Hypotenuse Comp.
    return(
        <div>
            <p>Enter {props.name} side value: </p>
            <input name={props.name} type="number" onChange={props.onChange}/>
        </div>
    )

} 