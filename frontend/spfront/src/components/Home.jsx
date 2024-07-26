import axios from "axios";
import { useState } from "react";
import React from "react";

function Home() {
    const [buscaProcessos, setBuscaProcessos] = useState("");
    const [processos, setProcessos] = useState([]);

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
                        <li key={processo.id}>{processo.numeroProcesso}</li>
                    ))}
                </div>
            </ol>
        </div>
    );
}

export default Home;
