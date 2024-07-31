import {  useState } from "react";
import { useAuth } from "../../hooks/useAuth";
import axios from "axios";
import { GrFormViewHide } from "react-icons/gr";
import { GrFormView } from "react-icons/gr";
import './LoginStyle.css';

function Login() {
  const [p_email, setProcuradoremail] = useState("");
  const [p_password, setProcuradorpassword] = useState("");
  const [visible, setVisible] = useState(false);
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
    <div className="container">      
      <form action="">
        <h1>Login</h1>

        <div className="input-box">
          <input type="email" className="form-control" id="email"
            value={p_email}
            onChange={(event) => {
              setProcuradoremail(event.target.value);
            } } />
          <label>Email</label>
        </div>

        <div className="input-box">
          <input type={visible ? "text" : "password"} className="form-control" id="password"
            value={p_password}
            onChange={(event) => {
              setProcuradorpassword(event.target.value);
            } } />
          <label>Senha</label>
        </div>
        <div id="icon" onClick={() => setVisible(!visible)}>
          {visible ? <GrFormView/> : <GrFormViewHide/>}
        </div>

        <button type="submit" className="btn btn-primary" onClick={handleLogin}>Entrar</button>

        <div className="register-link">
            <p>Novo procurador? <a href="/SitePGE/register">Registrar-se</a></p>
        </div>
      </form>
    </div>
  );
}

export default Login;