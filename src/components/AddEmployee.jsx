import React, { useState, useEffect } from 'react'
import { addEmployee, getEmployee, updateEmployee } from '../services/EmployeeService';
import { useNavigate, useParams } from 'react-router-dom';

const AddEmployee = () => {
    const [firstName, setFirstName] = useState('');
    const [lastName, setLastName] = useState('');
    const [email, setEmail] = useState('');
    const [errors, setErrors] = useState({
        firstName:'',
        lastName:'',
        email:'',
    })

    const navigator = useNavigate();

    const handleFirstName = (e) => {
        setFirstName(e.target.value);
    };
    const handleLastName = (e) => {
        setLastName(e.target.value);
    };
    const handleEmail = (e) => {
        setEmail(e.target.value);
    };

    const handleOnSubmit = (e) =>{
        e.preventDefault();

        if(validateForm()){

            if(id){
                const employee = {firstName,lastName,email};
                updateEmployee(id,employee)
                .then((response) => {
                    response.data;
                }).catch((err) => console.error(err));
                navigator('/getAllEmployees');
            }
            else{
                const employee = {firstName,lastName,email};
                addEmployee(employee)
                .then((response) => {
                    response.data;
                }).catch((err) => console.error(err));
                navigator('/getAllEmployees');
            }      
    }
}

    const validateForm = (e) => {
        let valid = true;

        const errorsCopy = {...errors}
        if(firstName.trim()){
            errorsCopy.firstName= '';
        }
        else{
            errorsCopy.firstName = 'First name is required'
            valid = false;
        }
        if(lastName.trim()){
            errorsCopy.lastName= '';
        }
        else{
            errorsCopy.lastName = 'Last name is required'
            valid = false;
        }
        if(email.trim()){
            errorsCopy.firstName= '';
        }
        else{
            errorsCopy.email = 'Email is required'
            valid = false;
        }

        setErrors(errorsCopy);
        return valid;
    };

    const {id} = useParams();
    const pageTitle = () =>{
        if(id){
            return <h2 className='text-center'>Update Employee</h2>
        }
        else{
            return <h2 className='text-center'>Add Employee</h2>
        }
    }
    useEffect(() =>{
       if(id){
        getEmployee(id).then((response) => {
           setFirstName(response.data.firstName);
           setLastName(response.data.lastName);
           setEmail(response.data.email);
         }).catch((error) => {
             console.error(error);
         })
       }
    },[id]);
  return (
    <div className='container'>
        <br/><br/>
        <div className='row'>
            <div className='card col-md-6 offset-md-3 offset-md-3'>
                {
                    pageTitle()
                }
                <div className='card-body '>
                    <form>
                        <div className='form-group mb-2'>
                            <label className='form-label'>First Name</label>
                            <input type='text'
                            placeholder='Enter your first name'
                            name='firstName'
                            value={firstName}
                            required 
                            className={`form-control ${errors.firstName ? 'is-invalid':''}`}
                            onChange={handleFirstName}/>
                            {errors.firstName && <div className='invalid-feedback'>{errors.firstName}</div>}
                        </div>
                        <div className='form-group mb-2'>
                            <label className='form-label'>Last Name</label>
                            <input type='text'
                            placeholder='Enter your last name'
                            name='lastName'
                            value={lastName}
                            required
                            className={`form-control ${errors.lastName ? 'is-invalid':''}`}
                            onChange={handleLastName}/>
                             {errors.lastName && <div className='invalid-feedback'>{errors.lastName}</div>}
                        </div>
                        <div className='form-group mb-2'>
                            <label className='form-label'>Email</label>
                            <input type='email'
                            placeholder='Enter your email'
                            name='email'
                            required
                            value={email} 
                            className={`form-control ${errors.email ? 'is-invalid':''}`}
                            onChange={handleEmail}/>
                             {errors.email && <div className='invalid-feedback'>{errors.email}</div>}
                        </div>
                        
                    </form>
                    <button className='btn btn-success mt-3' onClick={handleOnSubmit}>Submit</button>
                </div>
            </div>
        </div>
      
    </div>
  )
}

export default AddEmployee
