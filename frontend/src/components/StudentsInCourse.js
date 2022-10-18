import React, { useEffect, useState } from 'react'
import { Table } from 'react-bootstrap';
import axios from 'axios'
import { useParams } from 'react-router-dom'
import Dropdown from 'react-bootstrap/Dropdown';
import Button from 'react-bootstrap/Button';

const StudentsInCourse = () => {
    let id = useParams();
    const [studentData, setStudentsData] = useState([]);
    const [studentsNotInCourse, setStudentsNotInCourse] = useState([]);
    const [selectedStudent, setSelectedStudent] = useState("");
    const [selectedStudentID, setSelectedStudentID] = useState("");

    const getStudentsInCourse = async () => {

        await axios.get("http://localhost:8080/coursesandstudents/course/" + id.id)
            .then(response => {
                setStudentsData(response.data);
            }).catch(e => {
                console.log(e)
            })
    }
    const getStudentsNotInCourse = async () => {
        await axios.get("http://localhost:8080/coursesandstudents/course/getstudentsnotincourse/" + id.id)
            .then(response => {
                setStudentsNotInCourse(response.data);
            }).catch(e => {
                console.log(e)
            })

    }


    useEffect(() => {
        console.log(id)
        getStudentsInCourse();
        getStudentsNotInCourse();
    }, [])

    const addStudent = (e) => {
        e.preventDefault();
        const params = new URLSearchParams()
        params.append('studentID', selectedStudentID)
        params.append('courseID', id.id)

        const config = {
            headers: {
                'Content-Type': 'application/x-www-form-urlencoded'
            }
        }

        axios.post("http://localhost:8080/coursesandstudents/course/addstudent/", params, config)
            .then(response => {
                setStudentsData(response.data);
                getStudentsNotInCourse();
                setSelectedStudent("")
                setSelectedStudentID("")
            }).catch(e => {
                console.log(e)
            })
    }

    const deleteItem = (studentId) => {

        axios.delete("http://localhost:8080/coursesandstudents/course/" + studentId + "/" + id.id)
            .then(response => {
                setStudentsData(response.data);
                getStudentsNotInCourse();
                setSelectedStudent("")
                setSelectedStudentID("")
            }).catch(e => {
                console.log(e)
            })
    }

    return (
        <div className='flex justify-center items-center bg-blue-500 h-screen'>
            <div className=' bg-white p-3 rounded-xl shadow-xl'>
                Students in this course
                <Table responsive="sm" className='min-w-[800px]'>

                    <thead>
                        <tr>
                            <th>Name</th>
                            <th>Age</th>
                            <th>Avg</th>
                            <th>Student Number</th>
                            <th>Delete</th>
                        </tr>
                    </thead>

                    <tbody>
                        {studentData.map((mappedData, index) => {
                            console.log(mappedData)
                            return (
                                <tr key={index}>
                                    <td>{mappedData.name}</td>
                                    <td>{mappedData.age}</td>
                                    <td>{mappedData.avg}</td>
                                    <td>{mappedData.userNumber}</td>
                                    <td className='cursor-pointer' onClick={() => deleteItem(mappedData.userNumber)}>
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
                <div className='flex justify-between pr-20'>
                    <Dropdown>
                        <Dropdown.Toggle id="dropdown-variants-Primary" variant={selectedStudent.length > 3 ? "success" : "primary"}>
                            {selectedStudent.length > 3 ? selectedStudent : "Add student to this course"}
                        </Dropdown.Toggle>
                        <Dropdown.Menu variant="primary">
                            <Dropdown.Item onClick={(e) => setSelectedStudent("")}>
                                Clear
                            </Dropdown.Item>
                            {studentsNotInCourse.map((studentData, index) => {
                                return (
                                    <Dropdown.Item key={index} onClick={(e) => {
                                        setSelectedStudent(studentData.name)
                                        setSelectedStudentID(studentData.userNumber)
                                    }}>
                                        {studentData.name} : {studentData.userNumber}
                                    </Dropdown.Item>
                                )
                            })}
                        </Dropdown.Menu>
                    </Dropdown>
                    <Button variant={selectedStudent.length > 3 ? "success" : "danger"}
                        disabled={selectedStudent.length > 3 ? false : true}
                        onClick={addStudent}
                    >
                        {selectedStudent.length > 3 ? "Add student" : "Select Student"}
                    </Button>
                </div>
            </div>
        </div>
    )
}

export default StudentsInCourse