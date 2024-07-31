import axios from "axios";
import { useState } from "react";
import { useNavigate } from 'react-router-dom';
import React from "react";
import "./HomeStyle.css";
import { useAuth } from "../../hooks/useAuth";
import { CgProfile } from "react-icons/cg";
import { GoLaw } from "react-icons/go";
import { IoIosLogOut } from "react-icons/io";


function Home() {
    const [buscaProcessos, setBuscaProcessos] = useState("");
    const [processos, setProcessos] = useState([]);
    const navigate = useNavigate();
    const { logout } = useAuth();
    const AuthStr = "Bearer ".concat(localStorage.getItem('token').replace(/"/g, '')); 

    async function getProcessos(event) {
        event.preventDefault();
        try {
            await axios.get("http://localhost:8080/SitePGE/api/home/processos/procurar-processo-por-numero", {
                    headers: {Authorization: AuthStr},
                    params: { numeroProcesso: buscaProcessos}
                }).then((res) => {
                if(res.status === 200)
                    setProcessos(res.data);
                else
                    alert(res.status);
              }, fail => {
                console.error(fail);
              }
            );
        } catch (err) {
            alert(err);
        }
    }

    const handleLogout = () => {
        logout();
    }

    return (
        <div className="hcontainer">
            <h1>Início</h1>

            <div className="button-box">
                <button className="btn btn-primary" type="submit" onClick={handleLogout}><IoIosLogOut/>Logout</button>
            </div>
            
            <div className="profile-box">
                <button className="btn btn-primary" type="submit" onClick={null}><CgProfile/>Perfil</button>
            </div>

            <GoLaw className="img"/>

            <div className="search-container">
                <input type="text" placeholder="Digite o número do processo para análise da prescrição..."
                    value={buscaProcessos}
                    onChange={(event) => setBuscaProcessos(event.target.value)}
                />
                <button type="submit" onClick={getProcessos}>
                    <span>&#x27A4;</span> 
                </button>
            </div>
            
            <div className="processos">
                <h2>Processos</h2> 
                
                {processos.map((processo) => (
                    <li key={processo.id}>
                        <button className= "btn btn-primary" type="submit" onClick={() => {navigate("/SitePGE/process/"+processo.numeroProcesso);}}>Processo número: {processo.numeroProcesso}</button>
                    </li>
                ))}
            </div>
        </div>

    );
}

export default Home;
