import './App.css';
import { BrowserRouter, Routes, Route } from 'react-router-dom';
import Register from './components/Register';
import Login from './components/Login';
import Home from './components/Home';
import ProcessDetails from './components/ProcessDetails';
import ProtectedRoutes from './utils/ProtectedRoutes';
import { AuthProvider } from './hooks/useAuth';

function App() {
  return (
    <AuthProvider>
      <Routes>
        <Route path="/register" element={<Register/>}/>
        <Route path="/login" element={<Login/>}/>
        <Route path="/home" element={<ProtectedRoutes> <Home/> </ProtectedRoutes>}/>
        <Route path="/process/:id" element={<ProtectedRoutes> <ProcessDetails/> </ProtectedRoutes>}></Route>
      </Routes>
    </AuthProvider>
  );
}

export default App;
