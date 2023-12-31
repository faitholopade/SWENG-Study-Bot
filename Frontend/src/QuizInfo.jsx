import { useState , useEffect } from 'react';
const QuizInfo = ({moduleName}) => {
    const [questions, setQuestions] = useState(null);
    const [questionAt, setQuestionAt] = useState(0);

    useEffect(() => {
        const fetchQuestions = async () => {
            try {
                const res = await fetch(`http://localhost:8080/${moduleName}`);
                if (!res.ok) {
                    throw new Error('no network response');
                }
                const data = await res.json();
                if (questions == null && questionAt == 0) {
                    setQuestions(data);
                }
            } catch (error) {
                console.error('error fetching data:', error);
            }
        };
    
        fetchQuestions();
    }, []);

    const [score, setScore] = useState(0);
    const [quizStarted, setQuizStarted] = useState(false);
    const [quizFinished, setQuizFinished] = useState(false);
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
    const capitalizeWord = (str) => {
        return moduleName.charAt(0).toUpperCase() + str.slice(1);
    };
    const [moduleCap, setModuleCap] = useState(capitalizeWord(moduleName));

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
                        <div className="questions-completed">Question {questionAt+1} of 4:</div>
                        <h3 className="question-text">{questions[questionAt].question}</h3>
                        <div className='button-grid'>
                            {questions[questionAt].options.map((option) => (
                                <button className='answer-button' onClick={() => optionSelected(option)}>{option}</button>
                            ))}
                        </div>
                    </div>
                   
                ) : (
                    <div className="quiz-box">
                        <h3 className="question-text">Score: {(score/4).toFixed(2)*100}%</h3>
                        <h3 className="question-text">You got {score} out of 4 questions correct!</h3>
                        <button className='quiz-start-button' onClick={() => retry()}>Try Again!</button>
                        <button className='quiz-start-button' onClick={() => exit()}>Exit</button>

                    </div>
                )
            ) : ( 
                <div className="quiz-box">
                    <h3 className="question-text">{moduleCap} Quiz</h3>
                    <h3 className="question-text">Time per Question: 15s</h3>
                    <h3 className="question-text">Number of Questions: 4</h3>
                    {(questions != null) ? (   
                            
                        <button className='quiz-start-button' onClick={() => setQuizStarted(true)}>Start!</button>
                        
                        ) : (
                        <h3 className='questions-completed'> Loading...</h3>
                    )}
                </div>)
            }
            <img src="/images/quizbot mascot.png" alt="Description" className="login-image" /> 
        </div>
        
    );}
   
    
        

export default QuizInfo;