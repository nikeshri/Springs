// src/pages/LoginPage/LoginPage.jsx
import React from 'react';
import Login from '../../component/login/Login';

const LoginPage = () => {
  const handleLogin = (credentials) => {
    console.log('Logged in with:', credentials);
  };

  return (
    <div className="login-page">
      <h1>Login Page</h1>
      <Login onLogin={handleLogin} />
    </div>
  );
};

export default LoginPage;
