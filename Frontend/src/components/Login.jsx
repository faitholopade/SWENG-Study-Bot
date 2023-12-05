import React, { useState } from 'react';

const Login = () => {
    const [username, setUsername] = useState('');
    const [regUsername, setRegUsername] = useState('');
    const [password, setPassword] = useState('');
    const [regPassword, setRegPassword] = useState('');
    const [showRegister, setShowRegister] = useState(false);
    const [name, setName] = useState('');
    const [email, setEmail] = useState('');
    const [registrationSuccess, setRegistrationSuccess] = useState('');

    const resetForm = () => {
       setName('');
       setUsername('');
       setRegUsername('');
       setEmail('');
       setPassword('');
       setRegPassword('');
       setRegistrationSuccess('');
    };
    const showRegistrationForm = () => {
    setRegistrationSuccess('');
    setShowRegister(true);
    };

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

const handleRegister = () => {
    fetch('http://localhost:8080/account/register', {
        method: 'POST',
        headers: {
            'Content-Type': 'application/json',
        },
        body: JSON.stringify({
            account: {
                name: name,
                username: regUsername,
                email: email,
                password: regPassword
            }
        }),
    })
    .then(response => {
        if (!response.ok) {
            throw new Error('Network response was not ok');
        }

        return response.text();
    })
    .then(data => {
        console.log('Registration successful', data);
        setRegistrationSuccess('Registration successful');
        setTimeout(() => {
                    resetForm(); // Reset form fields after showing the success message for a while
                    setShowRegister(false); // Hide the form
                }, 5000); // 3 seconds delay
    })
    .catch(error => {
        console.error('There was a problem with the registration operation:', error);
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
                    <div className="register regH" onMouseOver={() => setShowRegister(true)} onMouseOut={() => registrationSuccess && setTimeout(() => setShowRegister(false), 5000)}>
                      Register
                      {showRegister && (
                            <div className="register-form regS">
                            <input type="text" value={name} onChange={(e) => setName(e.target.value)} placeholder="Name" />
                            <input type="text" value={regUsername} onChange={(e) => setRegUsername(e.target.value)} placeholder="Username" />
                            <input type="email" value={email} onChange={(e) => setEmail(e.target.value)} placeholder="Email" />
                            <input type="password" value={regPassword} onChange={(e) => setRegPassword(e.target.value)} placeholder="Password" />
                            <button onClick={handleRegister}>Register</button>
                            {registrationSuccess && <div className="success-message">{registrationSuccess}</div>}
                            </div>

                       )}

                </div>
            </div>

            <div className="LoginBox">
                <h2 className ="Logins">Login</h2>
                <form>
                    <label className="login-label">Email: </label>
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
