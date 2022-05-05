import React from 'react';
import { HypotenuseComponent } from './components/HypotenuseComponent/HypotenuseComponent';

import "./App.css"

//Remember, App.tsx is the main page we'll render stuff on. 
//We can render TSX directly in the return(), or render entire Components 

function App() {
  return (
    <div className="App">
        <HypotenuseComponent/>
    </div>
  );
}

export default App;
