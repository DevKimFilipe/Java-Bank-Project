import React, { useState } from 'react';
import './App.css';

function App() {
  const [balance, setBalance] = useState(1000.00);
  const [amount, setAmount] = useState('');
  const [transactions, setTransactions] = useState([
    { id: 1, desc: 'Initial Deposit', val: 1000.00, type: 'plus' }
  ]);

  const handleTransaction = (type) => {
    const value = parseFloat(amount);
    if (isNaN(value) || value <= 0) return alert("Enter a valid amount");

    if (type === 'withdraw' && value > balance) {
      return alert("Insufficient funds");
    }

    const newBalance = type === 'deposit' ? balance + value : balance - value;
    setBalance(newBalance);
    
    // Adding to the history list
    setTransactions([{
      id: Date.now(),
      desc: type === 'deposit' ? 'Manual Deposit' : 'ATM Withdrawal',
      val: value,
      type: type === 'deposit' ? 'plus' : 'minus'
    }, ...transactions]);

    setAmount(''); // Clear input
  };

  return (
    <div className="App">
      <nav className="navbar">
        <div className="logo">JavaBank<span>PRO</span></div>
        <div className="user-profile">DevKimFilipe</div>
      </nav>

      <main className="main-container">
        <section className="card-visual">
          <div className="card-info">
            <small>Total Balance</small>
            <h1>${balance.toLocaleString('en-US', { minimumFractionDigits: 2 })}</h1>
            <p>**** **** **** 2026</p>
          </div>
        </section>

        <section className="action-center">
          <input 
            type="number" 
            placeholder="0.00" 
            value={amount}
            onChange={(e) => setAmount(e.target.value)}
          />
          <div className="button-group">
            <button className="btn deposit" onClick={() => handleTransaction('deposit')}>Deposit</button>
            <button className="btn withdraw" onClick={() => handleTransaction('withdraw')}>Withdraw</button>
          </div>
        </section>

        <section className="history">
          <h3>Transaction History</h3>
          <div className="transaction-list">
            {transactions.map(t => (
              <div key={t.id} className="transaction-item">
                <span>{t.desc}</span>
                <span className={t.type === 'plus' ? 'positive' : 'negative'}>
                  {t.type === 'plus' ? '+' : '-'}${t.val.toFixed(2)}
                </span>
              </div>
            ))}
          </div>
        </section>
      </main>
    </div>
  );
}

export default App;