import {  useState, useEffect } from "react";
import axios from "axios";
import { useParams } from "react-router-dom";

function Process() {
    const [processo, setProcesso] = useState({});
    const [movimentacoes, setMovimentacoes] = useState([]);
    const { id } = useParams("");

    useEffect(() => {
        async function getData() {
            try {
                const AuthStr = "Bearer ".concat(localStorage.getItem('token').replace(/"/g, '')); 
                const response = await axios.get("http://localhost:8080/SitePGE/api/home/processos/processo", {
                    headers: {Authorization: AuthStr},
                    params: { numeroProcesso: id }
                });
                if(response.status === 200){
                    setProcesso(response.data);
                    setMovimentacoes(Array.isArray(response.data.movimentacoes) ? response.data.movimentacoes : Array.from(response.data.movimentacoes));
                }else
                    alert(response.status);
            } catch (error) {
                console.error(error);
            }
        }
        getData();
    }, [id]);
    
    return (
        <div className="container" >
            <h1>Process{id}</h1>
            <div>
                <h1>Detalhes do Processo</h1>
                    <p><strong>ID:</strong> {processo.id}</p>
                    <p><strong>Número do Processo:</strong> {processo.numeroProcesso}</p>
                    <p><strong>Valor da Dívida:</strong> {processo.valorDivida}</p>
                    <p><strong>Juiz:</strong> {processo.juiz}</p>
                    <p><strong>Vara:</strong> {processo.vara}</p>
                    <p><strong>Executado:</strong> {processo.executado}</p>
                    <p><strong>Data de Distribuição:</strong> {processo.dataDistribuicao}</p>
                    <p><strong>Data de Prescrição:</strong> {processo.dataPrescricao}</p>
                    <p><strong>Status da Prescrição:</strong> {processo.statusPrescricao}</p>
                    <p><strong>Tipo de Assunto:</strong> {processo.tipoAssunto}</p>
                    <p><strong>Descrição:</strong> {processo.descricao}</p>
                    <p><strong>Movimentações:</strong></p>
                    
                    {movimentacoes.map((movimentacao) => (
                        <li key={movimentacao.m_id}>ID: {movimentacao.m_id}</li>
                    ))}
                    
            </div>
        </div>
    );
}
  
export default Process;