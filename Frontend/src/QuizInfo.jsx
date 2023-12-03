import {questions} from './questions';
import { useState } from 'react';

const QuizInfo = () => {
    const [questionAt, setQuestionAt] = useState(0);
    const [score, setScore] = useState(0);
    const {question, options, answer} = questions[questionAt];
    const optionSelected = (option) => {
        if (option === questions[questionAt].answer) {
            setScore(score + 1);
        }
        if (questionAt < questions.length-1) {
            setQuestionAt(questionAt + 1);
        } else {
            return;
            //show result
        }
    };

    return (
        <div>
            <div className="top-banner">
                Group 8 Quizbot
                <div className="group-members">
                    Group Members
                    <div className="member-list">
                        <div>Faith</div>
                        <div>Mahir </div>
                        <div>Rohn</div>
                        <div>Sab </div>
                        <div>Milena </div>
                        <div>Dario </div>
                    </div>
                </div>
            </div>

            <div className="quiz-box">
                <div className="questions-completed">Question {questionAt+1} of {questions.length}:</div>
                <h3 className="question-text">{question}</h3>
                <div className='button-grid'>
                    {questions[questionAt].options.map((option) => (
                        <button className='answer-button' onClick={() => optionSelected(option)}>{option}</button>
                    ))}
                </div>
            </div>
            <img src="/images/quizbot mascot.png" alt="Description" className="login-image" />

        </div>
    );}




export default QuizInfo;