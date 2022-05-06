import React, { useEffect, useState } from "react"
import { data } from "../../data"

import { PostComponent } from "../PostComponent/PostComponent"

export const PostContainer: React.FC<any> = (data) => {

    //useState lets us declare a state variable, a mutator (like a setter), and a default value 
    //remember we need state to send data to other components
    let [posts, setPosts] = useState([]) //empty array because our post data is an array (data.ts)

    //useEffect will execute some code, either when something changes, 
    //OR for every piece of data in a given list
    //so our posts state variable will be filled with the Array from data.ts
    useEffect(() => {
        setPosts(data.data)
    }, [posts]) //for every piece of data in the data Array, put it in our posts state variable

    return(
        //for every post in our data array, render a Post component for it
        <div>

        </div>
    )

}