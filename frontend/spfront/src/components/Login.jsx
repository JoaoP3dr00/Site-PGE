import {  useState } from "react";
import { useAuth } from "../hooks/useAuth";
import axios from "axios";

function Login() {
  const [p_email, setProcuradoremail] = useState("");
  const [p_password, setProcuradorpassword] = useState("");
  const { login } = useAuth();

  async function handleLogin(event) {
      event.preventDefault();
      // alert(localStorage.getItem("token") + " " + localStorage.getItem("user"));
      try {
        await axios.post("http://localhost:8080/SitePGE/auth/login", {
          email: p_email,
          password: p_password,
          }).then(async (res) => 
          {            
            if(res.status === 200){ 
              await login(res.data);
              alert("Login efetuado com sucesso!");
            } else { 
              alert("Login falhou!");
            }
          }, fail => {
            alert("Login falhou!")
            console.error(fail);
          }
        );
      }
        catch (err) {
        alert(err);
      }
    }

  return (
    <div>
      <h2>Login</h2>
      <div className="col-sm-6">
        <form>
          <div className="form-group">
            <label>Email:</label>
            <input type="email" className="form-control" id="email" placeholder="Digite seu email..."
              value={p_email}
              onChange={(event) => {
                setProcuradoremail(event.target.value);
              } } />
          </div>

          <div className="form-group">
            <label>Senha:</label>
            <input type="password" className="form-control" id="password" placeholder="Digite sua senha..."
              value={p_password}
              onChange={(event) => {
                setProcuradorpassword(event.target.value);
              } } />
          </div>
          <button type="submit" className="btn btn-primary" onClick={handleLogin}>Login</button>
        </form>
      </div>
    </div>
  );
}

export default Login;