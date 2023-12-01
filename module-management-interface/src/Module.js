import React, { useState } from 'react';
import './Module.css';

function Module({ name, description, bestScore }) {
  const [isHovered, setIsHovered] = useState(false);

  const handleGenerateQuiz = () => {
    // Mimic generating a quiz for the module
    console.log(`Generating quiz for module: ${name}`);
  };

  return (
    <div className="module" onMouseEnter={() => setIsHovered(true)} onMouseLeave={() => setIsHovered(false)}>
      <div className="module-info">
        <h3>{name}</h3>
        <p>{description}</p>
        {isHovered && (
          <div className="module-hover-info">
            Best Score: {bestScore ? `${bestScore}%` : 'N/A'}
          </div>
        )}
      </div>
      <div className="module-actions">
        <button onClick={handleGenerateQuiz}>Generate Quiz</button>
      </div>
    </div>
  );
}

export default Module;
