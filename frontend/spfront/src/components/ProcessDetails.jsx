import {  useState, useEffect } from "react";
import axios from "axios";
import { useParams } from "react-router-dom";

function Process() {
    const [processo, setProcesso] = useState({});
    const { id } = useParams("");

    useEffect(() => {
        async function getData() {
            try {
                const response = await axios.get("http://localhost:8080/SitePGE/api/home/processos/processo", {
                    params: { numeroProcesso: id }
                });
                setProcesso(response.data);
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
                    {/* <ul>
                        {processo.movimentacoes.map((movimentacao, index) => (
                            <li key={index}>{movimentacao}</li>
                        ))}
                    </ul> */}
            </div>
        </div>
    );
}
  
export default Process;