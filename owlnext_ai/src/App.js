import React, { Component } from 'react';
import logo from './logo.svg';
import './App.css';
import AIPicture from './components/AIPicture.js'

class App extends Component {
  render() {
    return (
      <div className="App">
        <AIPicture/>
      </div>
    );
  }
}

export default App;
