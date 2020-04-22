import React, { useState } from 'react';
import logo from './logo.svg';
import './App.css';

const StoreContext = React.createContext<Array<string>>(["ghh"]);

const StoreProvider = ({childrens}: any) => {
  const store:string[] = [];
  return (<StoreContext.Provider value={store} >{childrens}</StoreContext.Provider>)
}

function App() {
  return (
    <StoreProvider> Hello</StoreProvider>
  );
}

function Counter() {
  const [value, setValue] = useState(0);
  return (
    <div className="color:green">
      <p onClick={()=> (setValue(value+1))}> increment</p>
      {value}
      <p onClick={()=> (value == 0? setValue(0):setValue(value-1))}> decrement</p>
    </div>
    );

}

export default App;
