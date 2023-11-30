import React, { useState } from 'react';

const Login = () => {
    const [username, setUsername] = useState('');
    const [password, setPassword] = useState('');

const handleLogin = () => {
/* fetch('http://localhost:8080/account/hello')
.then(response => {
        if (!response.ok) {
            throw new Error('Network response was not ok');
        }
        return response.json();
    })
    .then(data => {
        console.log('Login successful', data);
        // Handle login success (e.g., redirect to another page or store token)
    })
    .catch(error => {
        console.error('There was a problem with the fetch operation:', error);
    }); */
    fetch('http://localhost:8080/account/login', {
        method: 'POST',
        headers: {
            'Content-Type': 'application/json',
        },
        body: JSON.stringify({
            account: {
                email: username, //"test1@test.com",
                password: password //"test"
            }
        }),
    })
    .then(response => {
        if (!response.ok) {
            throw new Error('Network response was not ok');
        }
        return response.json();
    })
    .then(data => {
        console.log('Login successful', data);
        // Handle login success (e.g., redirect to another page or store token)
    })
    .catch(error => {
        console.error('There was a problem with the fetch operation:', error);
    });
};

    return (
        <div>
        <div className="top-banner">
                Group 8 Quizbot
                <div className="group-members bgh">
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
