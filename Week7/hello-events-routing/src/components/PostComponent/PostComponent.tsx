import React from "react";

//Ben will import some css later

export const PostComponent: React.FC<any> = (post:any) => {


    return(
        <div className="post-container">
            <div className="post-profile">
                <h3>Post user will go here</h3>
            </div>
            <div className="post-content">
                <p>Post content will go here</p>
            </div>
        </div>
    )

}