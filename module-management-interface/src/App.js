import React, { useState } from 'react';
import './App.css';
import Module from './Module';
import logo from './logo.png';

function App() {
  const [modules, setModules] = useState([]);
  const [newModuleName, setNewModuleName] = useState('');
  const [newModuleDescription, setNewModuleDescription] = useState('');

  const handleAddModule = () => {
    if (newModuleName && newModuleDescription) {
      const newModule = {
        name: newModuleName,
        description: newModuleDescription,
        bestScore: null
      };
      console.log('Sending data to backend:', newModule);
      setModules([...modules, newModule]);
      setNewModuleName('');
      setNewModuleDescription('');
    }
  };

  return (
    <div className="App">
      <div className="top-banner">
        Group 8 Quiz Bot
        <div className="group-members">
          Group Members
          <div className="member-list">
            <div>Faith</div>
            <div>Mahir</div>
            <div>Rohn</div>
            <div>Sab</div>
            <div>Milena</div>
            <div>Dario</div>
          </div>
        </div>
      </div>
      <header className="App-header"> 
        <h1>Module Management Interface</h1>
      </header>
      <div className="module-form">
        <input
          type="text"
          placeholder="Module Name"
          value={newModuleName}
          onChange={(e) => setNewModuleName(e.target.value)}
        />
        <input
          type="text"
          placeholder="Module Description"
          value={newModuleDescription}
          onChange={(e) => setNewModuleDescription(e.target.value)}
        />
        <button onClick={handleAddModule}>Add Module</button>
      </div>
      <div className="module-container">
        {modules.map((module, index) => (
          <Module key={index} name={module.name} description={module.description} bestScore={module.bestScore} />
        ))}
      </div>
      <img src={logo} alt="QuizBot Logo" className="App-logo" />
    </div>
  );
}

export default App;
