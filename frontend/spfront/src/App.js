import './App.css';
import { BrowserRouter, Routes, Route } from 'react-router-dom';
import Register from './components/Register';
import Login from './components/Login';
import Home from './components/Home';
import ProcessDetails from './components/ProcessDetails';

function App() {
  return (
    <div className="App">
      <BrowserRouter>
          <Routes>
            <Route path="/register" element={<Register/>}/>
            <Route path="/login" element={<Login/>}/>
            <Route path="/home" element={<Home/>}/>
            <Route path="/process/:id" element={<ProcessDetails/>}>
            </Route>
          </Routes>
      </BrowserRouter>
    </div>
  );
}

export default App;
