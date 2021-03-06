import React from 'react'; //we will always need to do this in most logic files
import { FirstClassComponent } from './components/FirstClassComponent/FirstClassComponent';
import { ParentComponent } from './components/ParentComponent/ParentComponent';
import { UserComponent } from './components/UserComponent/UserComponent';


//THE APP.TSX IS OUR MAIN PAGE IN REACT. We won't often be using it, but everything roots to here

//The App.tsx file is where we put what we want displayed on the webpage
//You can add standard TSX, or entire components (which will have their own TSX)

//the return() funtion is where we put what we want to render
function App() {
  //the return() function takes TSX (Typscript XML) and asks like HTML. creates our view!
  //this acts much like the HTML body
  return (
    <div className="App">
      <h1>Hello React</h1>
      <p>We are writing in TSX, which is like HTML for React </p>

      <FirstClassComponent/>
      <ParentComponent/>
      <UserComponent/>
    </div>
  );
}

//This lets us export this App.tsx to potentially be used in other applications. Which we won't do
export default App;