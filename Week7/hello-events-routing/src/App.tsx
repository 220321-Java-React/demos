import React from 'react';
import { HypotenuseComponent } from './components/HypotenuseComponent/HypotenuseComponent';

//this import is kinda janky, make sure to write it in this order
import { BrowserRouter as Router, Routes, Route } from 'react-router-dom';

import "./App.css"
import { PostContainer } from './components/PostContainerComponent/PostContainer';
import { data } from './data';

//Remember, App.tsx is the main page we'll render stuff on. 
//We can render TSX directly in the return(), or render entire Components 

//note the syntax for Routing:
//the Router, hold the different Routes tags, which each hold a different Route
//The Route tag will hold a url path and the component that gets rendered on that url
function App() {
  return (
    <Router>
      <Routes>
        <Route path="/hyp" element={<HypotenuseComponent/>}/>
      </Routes>
      <Routes>
        <Route path="/posts" element={<PostContainer data={data}/>}></Route>
      </Routes>
    </Router>
  );
}

export default App;
