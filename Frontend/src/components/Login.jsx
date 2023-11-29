import React, { useState } from 'react';

const Login = () => {
    const [username, setUsername] = useState('');
    const [password, setPassword] = useState('');

    const handleLogin = () => {
        // Implement login logic using 0Auth
        console.log("Hello, Worldewssrdtcfvghbjn!");
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

            <div className="LoginBox">
                <h2 className ="Logins">Login</h2>
                <form>
                    <label className="login-label">Username: </label>
                    <input type="text" value={username} onChange={(e) => setUsername(e.target.value)} />
                    <br />
                    <label className="login-label">Password: </label>
                    <input type="password" value={password} onChange={(e) => setPassword(e.target.value)} />
                    <br />
                    <button type="button" onClick={handleLogin}>Login</button>
                </form>

                <img src="/images/quizbot mascot1.png" alt="Description" className="login-image" />
            </div>
        </div>
    );
};

export default Login;
