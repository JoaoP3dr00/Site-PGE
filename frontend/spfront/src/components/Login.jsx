import {  useState } from "react";
import { useNavigate } from 'react-router-dom';
import axios from "axios";


function Login() {
  const [p_email, setProcuradoremail] = useState("");
  const [p_password, setProcuradorpassword] = useState("");
  const navigate = useNavigate();


  async function login(event) {
      event.preventDefault();
      try {
        await axios.post("http://localhost:8080/SitePGE/api/login", {
          email: p_email,
          password: p_password,
          }).then((res) => 
          {
            console.log(res.data);
            
            if (res.data.message === "Email não existe!") 
            {
            alert("Email não existe!");
            } 
            else if(res.data.message === "Login efetuado com sucesso!")
            { 
            alert("HOME");
            //navigate('/home');
            } 
            else 
            { 
            alert("Login falhou!");
            }
          }, fail => {
            console.error(fail); // Error!
          }
        );
      }


        catch (err) {
        alert(err);
      }
    
    }

  return (
    <div class="container">
      <div class="row">
        <h2>Login</h2>
        <hr/>
      </div>

      <div class="row">
        <div class="col-sm-6">
          <form>
            <div class="form-group">
              <label>Email:</label>
              <input type="email"  class="form-control" id="email" placeholder="Digite seu email..."
                value={p_email}
                onChange={(event) => {
                  setProcuradoremail(event.target.value);
                }}
              />
            </div>

            <div class="form-group">
              <label>Senha:</label>
              <input type="password" class="form-control" id="password" placeholder="Digite sua senha..."
                value={p_password}
                onChange={(event) => {
                  setProcuradorpassword(event.target.value);
                }}
              />
            </div>
            <button type="submit" class="btn btn-primary" onClick={login} >Login</button>
          </form>
        </div>
      </div>
    </div>
  );
}

export default Login;