import { initializeApp } from "firebase/app";
import { getAuth } from "firebase/auth";
import { getStorage } from "firebase/storage";
import { getFirestore, collection } from "firebase/firestore";

const firebaseConfig = {
  apiKey: "AIzaSyAmX8EwSQnkVKIbuO_1buLFU2aZxjTBj3I",
  authDomain: "notenik-f9c4c.firebaseapp.com",
  databaseURL: "https://notenik-f9c4c-default-rtdb.firebaseio.com",
  projectId: "notenik-f9c4c",
  storageBucket: "notenik-f9c4c.appspot.com",
  messagingSenderId: "660459695353",
  appId: "1:660459695353:web:5f4e29d529b5525a078628",
  measurementId: "G-2YRL96YWLH"
};

// Initialize Firebase
const app = initializeApp(firebaseConfig);
const auth = getAuth(app);
const storage = getStorage();
const db = getFirestore();

const notesRef = collection(db, "note");

export { app, auth, storage, db, notesRef };
