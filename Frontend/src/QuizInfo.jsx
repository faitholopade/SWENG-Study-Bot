import {questions} from './questions';
import { useState } from 'react';

const QuizInfo = () => {
    const [questionAt, setQuestionAt] = useState(0);
    const [score, setScore] = useState(0);
    const [quizStarted, setQuizStarted] = useState(false);
    const [quizFinished, setQuizFinished] = useState(false);
    const {question, options, answer} = questions[questionAt];
    const optionSelected = (option) => {
        if (option == questions[questionAt].answer) {
            setScore(score+1);
        }
        if (questionAt < questions.length-1) {
            setQuestionAt(questionAt + 1);
        } else {
            setQuizFinished(true);
        }
    };

    const retry = () => {
        setQuizStarted(false);
        setQuizFinished(false);
        setQuestionAt(0);
        setScore(0);
    }

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
            {(quizStarted) ? (
                (!quizFinished) ? (
                    <div className="quiz-box">
                        <div className="questions-completed">Question {questionAt+1} of {questions.length}:</div>
                        <h3 className="question-text">{question}</h3>
                        <div className='button-grid'>
                            {questions[questionAt].options.map((option) => (
                                <button className='answer-button' onClick={() => optionSelected(option)}>{option}</button>
                            ))}
                        </div>
                    </div>
                ) : (
                    <div className="quiz-box">
                        <h3 className="question-text">Score: {(score/questions.length).toFixed(2)*100}%</h3>
                        <h3 className="question-text">You got {score} of {questions.length} questions correct!</h3>
                        <button className='start-button' onClick={() => retry()}>Try Again!</button>

                    </div>
                )
            ) : (
                <div className="quiz-box">
                    <h2>Quiz Topic</h2>
                    <button className='start-button' onClick={() => setQuizStarted(true)}>Start!</button>
                </div>)
            }
            <img src="/images/quizbot mascot.png" alt="Description" className="login-image" />


        </div>

    );}




export default QuizInfo;