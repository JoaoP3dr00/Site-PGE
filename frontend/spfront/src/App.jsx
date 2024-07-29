import { useRoutes } from "react-router-dom";
import Home from "./components/Home";
import Login from "./components/Login/Login";
// ...

export default function App() {
  const routes = useRoutes([
    {
      path: "/home",
      element: <Home />
    },
    {
      path: "/login",
      element: <Login />
    }
  ]);
  return routes;
}