import axios from 'axios';

const REST_API_BASE_URL = "http://localhost:8090/api/employees"

export const listEmployees = () => {
    return axios.get(REST_API_BASE_URL+"/getAllEmployees");
}

export const addEmployee = (data) => {
    return axios.post(REST_API_BASE_URL+"/createEmployee", data,{
        headers: {
            "Content-Type": "application/json",
        },
    });
}

export const getEmployee =(id) =>{
    return axios.get(REST_API_BASE_URL+'/getEmployee'+'/'+id);
}

export const updateEmployee = (id,data) => {
    return axios.put(REST_API_BASE_URL+'/updateEmployee'+'/'+id, data,{
        headers: {'Content-Type': 'application/json'
    },
    });
}

export const deleteEmployee =(id) =>{
    return axios.delete(REST_API_BASE_URL+'/deleteEmployee'+'/'+id);
}