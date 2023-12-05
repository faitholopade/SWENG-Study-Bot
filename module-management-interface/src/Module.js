import React, { useState } from 'react';
import './Module.css';

function Module({ name, description, bestScore, onSelectModule }) {
  const [isHovered, setIsHovered] = useState(false);
  const [isGenerating, setIsGenerating] = useState(false);

  const handleGenerateQuiz = () => {
    setIsGenerating(true);
    console.log(`Generating quiz for module: ${name}`);
    // Simulate API call delay
    setTimeout(() => {
      setIsGenerating(false);
    }, 2000); // 2 seconds delay
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
      {isGenerating && <div className="generating-popup">Generating quiz...</div>}
    </div>
  );
}


export default Module;
