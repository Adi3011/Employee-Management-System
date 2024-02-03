import React from "react"
import ListEmployeeComponent from "./components/ListEmployeeComponent"
import Navbar from "./components/Navbar"
import Footer from "./components/Footer"
import './App.css';
import { BrowserRouter as Router, Routes, Route } from "react-router-dom";
import AddEmployee from "./components/AddEmployee";

function App() {

  return (
    <>
    <Navbar />
    <Router>
      <Routes>
        <Route exact path ='/'  element={<ListEmployeeComponent />}/>
        <Route exact path ='/getAllEmployees'  element={<ListEmployeeComponent />}/>
        <Route exact path ='/createEmployee'  element={<AddEmployee />}/>
        <Route exact path ='/updateEmployee/:id'  element={<AddEmployee />}/>
      </Routes>
    </Router>
    
    <Footer />
    </>
  )
}

export default App
