import {  useState } from "react";
import axios from "axios";

function Register() {
  const [p_name, setProcuradorname] = useState("");
  const [p_email, setProcuradoremail] = useState("");
  const [p_password, setProcuradorpassword] = useState("");


  async function save(event) {
      event.preventDefault();
      try {
        await axios.post("http://localhost:8080/SitePGE/api/register", {
        name: p_name,
        email: p_email,
        password: p_password,
        });
        alert("Procurador registrado com sucesso!");

      } catch (err) {
        alert(err);
      }
    }

  return (
    <div class="container" >
      <div class="card">
        <h1>Registrar Procurador</h1>

        <form>
          <div class="form-group">
            <label>Nome:</label>
            <input type="text"  class="form-control" id="p_name" placeholder="Digite seu nome..."
        
            value={p_name}
            onChange={(event) => {
                setProcuradorname(event.target.value);
            }}
            />
          </div>

          <div class="form-group">
            <label>Email:</label>
            <input type="email"  class="form-control" id="p_email" placeholder="Digite seu email..."
            
            value={p_email}
            onChange={(event) => {
                setProcuradoremail(event.target.value);
            }}
            />
          </div>

          <div class="form-group">
            <label>Senha:</label>
            <input type="password"  class="form-control" id="p_password" placeholder="Digite sua senha..."
            
            value={p_password}
            onChange={(event) => {
                setProcuradorpassword(event.target.value);
            }}
            />
          </div>

          <button type="submit" class="btn btn-primary mt-4" onClick={save} >Salvar</button>
        </form>
      </div>
    </div>
  );
}
  
export default Register;