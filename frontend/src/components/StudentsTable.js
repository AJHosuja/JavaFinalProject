import React, { useEffect, useState } from 'react'
import axios from 'axios'
import Table from 'react-bootstrap/Table';
import 'bootstrap/dist/css/bootstrap.min.css';

const StudentsTable = () => {

    const [userData, setUserData] = useState([]);

    const [name, setName] = useState("");
    const [age, setAge] = useState();
    const [avg, setAvg] = useState();
    const [studentNum, setStudentNum] = useState();

    useEffect(() => {
        axios.get("http://localhost:8080/students")
            .then(response => {
                setUserData(response.data);
            }).catch(e => {
                console.log(e)
            })
    }, [])


    const deleteItem = (id) => {
        axios.delete("http://localhost:8080/delete/" + id)
            .then(response => {
                setUserData(response.data);
            }).catch(e => {
                console.log(e)
            })
    }

    const addStudent = (e) => {
        e.preventDefault();
        console.log(name + age + avg + studentNum)

        const params = new URLSearchParams()
        params.append('name', name)
        params.append('age', age)
        params.append('avg', avg)
        params.append('usernumber', studentNum)

        const config = {
            headers: {
                'Content-Type': 'application/x-www-form-urlencoded'
            }
        }

        axios.post("http://localhost:8080/addstudent", params, config)
            .then(response => {
                setUserData(response.data);
                setName("");
                setAge("");
                setAvg("");
                setStudentNum("");
            }).catch(e => {
                console.log(e)
            })
    }

    return (
        <div className='flex justify-center items-center bg-blue-500 h-screen'>
            <div className=' bg-white p-3 rounded-xl shadow-xl'>
                <Table responsive="sm" className='min-w-[800px]'>
                    <thead>
                        <tr>
                            <th>#</th>
                            <th>Name</th>
                            <th>Age</th>
                            <th>avg</th>
                            <th>Student Number</th>
                            <th>Delete</th>
                        </tr>
                    </thead>
                    <tbody>
                        {userData.map((mappedData, index) => {
                            console.log(mappedData)
                            return (
                                <tr>
                                    <td>{mappedData.userID}</td>
                                    <td>{mappedData.name}</td>
                                    <td>{mappedData.age}</td>
                                    <td>{mappedData.avg}</td>
                                    <td>{mappedData.userNumber}</td>
                                    <td className='cursor-pointer' onClick={() => deleteItem(mappedData.userID)}>
                                        <svg xmlns="http://www.w3.org/2000/svg" viewBox="0 0 24 24" fill="currentColor" className="w-6 h-6">
                                            <path fillRule="evenodd" d="M16.5 4.478v.227a48.816 48.816 0 013.878.512.75.75 0 11-.256 1.478l-.209-.035-1.005 13.07a3 3 0 01-2.991 2.77H8.084a3 3 0 01-2.991-2.77L4.087 6.66l-.209.035a.75.75 0 01-.256-1.478A48.567 48.567 0 017.5 4.705v-.227c0-1.564 1.213-2.9 2.816-2.951a52.662 52.662 0 013.369 0c1.603.051 2.815 1.387 2.815 2.951zm-6.136-1.452a51.196 51.196 0 013.273 0C14.39 3.05 15 3.684 15 4.478v.113a49.488 49.488 0 00-6 0v-.113c0-.794.609-1.428 1.364-1.452zm-.355 5.945a.75.75 0 10-1.5.058l.347 9a.75.75 0 101.499-.058l-.346-9zm5.48.058a.75.75 0 10-1.498-.058l-.347 9a.75.75 0 001.5.058l.345-9z" clipRule="evenodd" />
                                        </svg>
                                    </td>
                                </tr>
                            )
                        })

                        }
                    </tbody>
                </Table>
                <form onSubmit={addStudent}>
                    <div className='flex space-x-3 items-center'>
                        Add Student
                        <input className='bg-gray-300 w-32 h-7 rounded-sm shadow-sm pl-2 ml-2 ' placeholder='Name' type="text" value={name} onChange={e => setName(e.target.value)} />
                        <input className='bg-gray-300 w-32 h-7 rounded-sm shadow-sm pl-2' placeholder='Age' type="number" value={age} onChange={e => setAge(e.target.value)} />
                        <input className='bg-gray-300 w-32 h-7 rounded-sm shadow-sm pl-2' placeholder='Avg' type="text" value={avg} onChange={e => setAvg(e.target.value)} />
                        <input className='bg-gray-300 w-32 h-7 rounded-sm shadow-sm pl-1' placeholder='Student Number' type="number" value={studentNum} onChange={e => setStudentNum(e.target.value)} />
                        <button className='bg-blue-600 w-28 h-7 text-white rounded-sm shadow-lg' type='submit'>Submit</button>
                    </div>
                </form>
            </div>
        </div>
    )
}

export default StudentsTable