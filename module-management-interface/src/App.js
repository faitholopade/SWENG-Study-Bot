import React, { useState } from 'react';
import './App.css';
import Module from './Module';

function App() {
  const [modules, setModules] = useState([]);
  const [newModuleName, setNewModuleName] = useState('');
  const [newModuleDescription, setNewModuleDescription] = useState('');

  const handleAddModule = () => {
    if (newModuleName && newModuleDescription) {
      setModules([...modules, { name: newModuleName, description: newModuleDescription, bestScore: null }]);
      setNewModuleName('');
      setNewModuleDescription('');
    }
  };

  return (
    <div className="App">
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
    </div>
  );
}

export default App;
