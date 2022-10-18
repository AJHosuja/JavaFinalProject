import StudentsTable from "./components/StudentsTable";

import {
  BrowserRouter as Router,
  Routes,
  Route,
  Link
} from "react-router-dom";
import CoursesTable from "./components/CoursesTable";
import StudentsInCourse from "./components/StudentsInCourse";
import Container from 'react-bootstrap/Container';
import Nav from 'react-bootstrap/Nav';
import Navbar from 'react-bootstrap/Navbar';

function App() {
  return (
    <Router>
      <Navbar bg="dark" variant="dark">
        <Container>
          <Nav className="me-auto">
            <Nav.Link href="/">Students</Nav.Link>
            <Nav.Link href="/courses">Courses</Nav.Link>
          </Nav>
        </Container>
      </Navbar>
      <Routes>
        <Route path="/" element={<StudentsTable />} />
        <Route path="/courses" element={<CoursesTable />} />
        <Route path="/course/:id" element={<StudentsInCourse />} />
      </Routes>
    </Router>
  );
}

export default App;
