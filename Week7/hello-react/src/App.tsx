import React from 'react'; //we will always need to do this in most logic files

//The App.tsx file is where we put what we want displayed on the webpage
//You can add standard TSX, or entire components (which will have their own TSX)

//the return() funtion is where we put what we want to render
function App() {
  //the return() function takes TSX (Typscript XML) and asks like HTML. creates our view!
  return (
    <div className="App">
      <h1>Hello React</h1>
      <p>We are writing in TSX, which is like HTML for React </p>
    </div>
  );
}

export default App;
