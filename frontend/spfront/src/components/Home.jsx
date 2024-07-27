import axios from "axios";
import { useState } from "react";
import { useNavigate } from 'react-router-dom';
import React from "react";

function Home() {
    const [buscaProcessos, setBuscaProcessos] = useState("");
    const [processos, setProcessos] = useState([]);
    const navigate = useNavigate();

    async function getProcessos(event) {
        event.preventDefault();
        try {
            await axios.get("http://localhost:8080/SitePGE/api/home/processos/procurar-processo-por-numero",
            {params: { numeroProcesso: buscaProcessos}}).then((res) => {
                setProcessos(res.data);
              }, fail => {
                console.error(fail);
              }
            );
        } catch (err) {
            alert(err);
        }
    }

    return (
        <div className="container">
            <h1>Home</h1>

            <div className="search-container">
                <input type="text" placeholder="Digite o número do processo"
                    value={buscaProcessos}
                    onChange={(event) => setBuscaProcessos(event.target.value)}
                />
                <button type="submit" onClick={getProcessos}>
                    <span>&#x27A4;</span> 
                </button>
            </div>
            <ol>
                <h4>Processos</h4>  
                <div>
                    {processos.map((processo) => (
                        <li key={processo.id}>
                            <button className= "btn btn-primary" type="submit" onClick={() => {navigate("/process/"+processo.numeroProcesso);}}>Processo número: {processo.numeroProcesso}</button>
                        </li>
                    ))}
                </div>
            </ol>
        </div>
    );
}

export default Home;
