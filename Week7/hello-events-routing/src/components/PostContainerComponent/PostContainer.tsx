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
        //for every post in our posts array, render a Post component for it (.map())
        <div>
            {posts.map((posts:any) => {
                return <PostComponent {...posts} key={posts.postId}/>
            })}
        </div>
        //looks confusing... but let me try to elaborate. we use .map on our posts state variable!
        //so, for every piece of data in posts (posts:any), render one PostComponent
        //in that post component, we send the appropriate post and a key, which is our postId
    )

}