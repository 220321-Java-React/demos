import React from "react"

//ben will import some CSS right here

export const ResultDisplay: React.FC<any> = (props:any) => {

    /*
        If the first and second value exist (if they're both truthy)
        populate the <p> to contain the result

        If there isn't a value for both the first and second, give the user a prompt to enter values
    */
    return(
        <div className="result-container">
            <p>
                {props.values.first && props.values.second ? `Hypotenuse is: ${props.result}`
                : "Enter both numbers for a value"}
            </p>
        </div>
    )

}