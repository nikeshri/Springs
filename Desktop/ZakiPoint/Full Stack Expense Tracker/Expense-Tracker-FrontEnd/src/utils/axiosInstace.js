
import axios from 'axios';

const instance = axios.create({
  baseURL: 'http://localhost:8080', // Replace with your Spring Boot backend URL
  timeout: 10000, // Adjust timeout as needed
  headers: {
    'Content-Type': 'application/json',
  },
});

export default instance;
