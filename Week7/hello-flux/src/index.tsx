import React from 'react';
import ReactDOM from 'react-dom/client';
import './index.css';
import App from './App';
import reportWebVitals from './reportWebVitals';
import { Provider } from 'react-redux';
import { store } from './store/store';

const root = ReactDOM.createRoot(
  document.getElementById('root') as HTMLElement
);

//THIS IS THE ONLY TIME WE NEED TO MESS WITH THE INDEX.TSX:
//we need to set a Provider, equal to our store
//this is how we make the store universally visible to the application
root.render(
  <React.StrictMode>
    <Provider store = {store}>
      <App />
    </Provider> 
  </React.StrictMode>
);

// If you want to start measuring performance in your app, pass a function
// to log results (for example: reportWebVitals(console.log))
// or send to an analytics endpoint. Learn more: https://bit.ly/CRA-vitals
reportWebVitals();
