import { useState } from "react";
import Login from "./AgentLogin";
import Signup from "./AgentSignup";

const AgentAuth = ()=>{
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

export default AgentAuth;