import React, { useState } from 'react';
import './App.css';

function App() {
  const [count, setCount] = useState(0);

  const handleIncrement = () => {
    setCount(prevCount => prevCount + 1);
    sayHello();
  };

  const sayHello = () => {
    alert("Hello! Member1");
  };

  const handleDecrement = () => {
    setCount(prevCount => prevCount - 1);
  };

  const sayWelcome = (message) => {
    alert(message);
  };
  
  const handleClickOnMe = () => {
    alert("I was clicked");
  };

  const [amount, setAmount] = useState('');
  const [currency, setCurrency] = useState('Euro');

  const handleAmountChange = (e) => {
    const value = e.target.value;
    if (!isNaN(value)) {
      setAmount(value);
    }
  };

  const handleSubmit = (e) => {
    e.preventDefault();
    
    if (amount === '' || isNaN(amount)) {
        alert("Please enter a valid amount.");
        return;
    }
    
    const euroConversionRate = 80; 
    const convertedAmount = parseFloat(amount) * euroConversionRate;
    
    alert(`Converting to Euro Amount is ${convertedAmount}`);
  };

  return (
    <div className="App">
      <div className="counter-container">
        <h1>{count}</h1>
        <button onClick={handleIncrement}>Increment</button>
        <button onClick={handleDecrement}>Decrement</button>
        <button onClick={() => sayWelcome("welcome")}>Say welcome</button>
        <button onClick={handleClickOnMe}>Click on me</button>
      </div>

      <hr style={{ margin: '20px 0' }} />

      <div className="currency-converter-container">
        <h2 style={{ color: 'green' }}>Currency Convertor!!!</h2>
        <form onSubmit={handleSubmit}>
          <div className="form-group">
            <label htmlFor="amount">Amount:</label>
            <input 
              type="text" 
              id="amount"
              value={amount} 
              onChange={handleAmountChange} 
            />
          </div>
          <div className="form-group">
            <label htmlFor="currency">Currency:</label>
            <input 
              type="text" 
              id="currency"
              value={currency} 
              readOnly 
              style={{ backgroundColor: '#eee' }} 
            />
          </div>
          <button type="submit">Submit</button>
        </form>
      </div>
    </div>
  );
}

export default App;