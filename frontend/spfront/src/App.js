import './App.css';
import { BrowserRouter, Routes, Route } from 'react-router-dom';
import Register from './components/Register';
import Login from './components/Login/Login';
import Home from './components/Home/Home';
import ProcessDetails from './components/Process/ProcessDetails';
import ProtectedRoutes from './utils/ProtectedRoutes';
import { AuthProvider } from './hooks/useAuth';

function App() {
  return (
    <AuthProvider>
      <Routes>
        <Route path="/SitePGE/register" element={<Register/>}/>
        <Route path="/SitePGE/login" element={<Login/>}/>
        <Route path="/SitePGE/home" element={<ProtectedRoutes> <Home/> </ProtectedRoutes>}/>
        <Route path="/SitePGE/process/:id" element={<ProtectedRoutes> <ProcessDetails/> </ProtectedRoutes>}></Route>
      </Routes>
    </AuthProvider>
  );
}

export default App;
