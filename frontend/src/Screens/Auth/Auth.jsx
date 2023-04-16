import { useState } from "react";
import Login from "./Login";
import Signup from "./Signup";

const Auth = ()=>{
    const [page, setPage] = useState("login");
    const pagemap = {
        "login" : <Login switch = {
            ()=>{
                setPage("signup")
            }
        }/>,
        "signup" : <Signup switch = {
            ()=>{
                setPage("login")
            }
        }/>
    }
    return pagemap[page];
}

export default Auth;