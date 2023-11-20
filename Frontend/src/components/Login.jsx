import React, { useState } from 'react';

const Login = () => {
    const [username, setUsername] = useState('');
    const [password, setPassword] = useState('');

    const handleLogin = () => {
        // Implement login logic (e.g., send a request to the backend)
    };

    return (
        <div>
            <h2>Login</h2>
            <form>
                <label>Username: </label>
                <input type="text" value={username} onChange={(e) => setUsername(e.target.value)} />
                <br />
                <label>Password: </label>
                <input type="password" value={password} onChange={(e) => setPassword(e.target.value)} />
                <br />
                <button type="button" onClick={handleLogin}>Login</button>
            </form>
        </div>
    );
};

export default Login;
