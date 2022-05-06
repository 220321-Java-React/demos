import React from "react";

import "./PostComponent.css"

//post is the props that we're getting from PostContainer
export const PostComponent: React.FC<any> = (post:any) => {

    return(
        <div className="post-container">
            <div className="post-profile">
                <h3>{post.username}</h3>
            </div>
            <div className="post-content">
                <p>{post.content}</p>
            </div>
        </div>
    )

}