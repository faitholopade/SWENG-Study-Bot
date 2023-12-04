// import {questions} from './questions';
import { useState , useEffect } from 'react';
const QuizInfo = ({moduleName}) => {
    const [questions, setQuestions] = useState(null);
    useEffect(() => {
        fetch(`http://localhost:8080/${moduleName}`, {
            method: 'POST',
            headers: {
                'Content-Type': 'application/json',
            }
        })
            .then(response => {
                if (!response.ok) {
                    throw new Error('Network response was not ok');
                }
                return response.json();
            })
            .then(data => {
                setQuestions(data);
            })
            .catch(error => {
                console.error('There was a problem with the registration operation:', error);
            });
    }, []);


    const [questionAt, setQuestionAt] = useState(0);
    const [score, setScore] = useState(0);
    const [quizStarted, setQuizStarted] = useState(false);
    const [quizFinished, setQuizFinished] = useState(false);
    const {question, options, answer} = questions[questionAt];
    const optionSelected = (option) => {
        if (option == questions[questionAt].answer) {
            setScore(score+1);
        }
        nextQuestion();

    };

    const Timer = ({timeElapsed}) => {
        const [time, setTime] = useState(0);
        const [maxTime, setMaxTime] = useState(15)
        useEffect(() => {
            if (time <= maxTime) {
                const interval = setInterval(() => {
                    setTime(prev => prev+.01);
                }, 10);

                return () => clearInterval(interval);
            } else {
                setTime(0);
                timeElapsed();
            }
        }, [time]);

        return <div className='timer-bar' style={{width: `${100-((time/maxTime)*100)}%`}}></div>;
    };
    const nextQuestion = () => {
        if (questionAt < questions.length-1) {
            setQuestionAt(questionAt + 1);
        } else {
            setQuizFinished(true);
        }
    }
    const retry = () => {
        setQuizStarted(false);
        setQuizFinished(false);
        setQuestionAt(0);
        setScore(0);
    }

    const exit = () => {
        //return to main menu
    }

    return (
        <div>
            <div className="top-banner">
                Group 8 Quiz Bot
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
                        <Timer timeElapsed = {nextQuestion}/>
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
                        <h3 className="question-text">You got {score} out of {questions.length} questions correct!</h3>
                        <button className='quiz-start-button' onClick={() => retry()}>Try Again!</button>
                        <button className='quiz-start-button' onClick={() => exit()}>Exit</button>

                    </div>
                )
            ) : (
                <div className="quiz-box">
                    <h3 className="question-text">Quiz Topic</h3>
                    <h3 className="question-text">Time per Question: 15s</h3>
                    <h3 className="question-text">Number of Questions: {questions.length}</h3>
                    <button className='quiz-start-button' onClick={() => setQuizStarted(true)}>Start!</button>
                </div>)
            }
            <img src="/images/quizbot mascot.png" alt="Description" className="login-image" />
        </div>

    );}




export default QuizInfo;