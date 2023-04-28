import { useState } from "react";
import Login from "./Login";
import Signup from "./Signup";
import AgentLogin from "../../Agent/AgentLogin";
import AgentSignup from "../../Agent/AgentSignup";

const Auth = () => {
  const [page, setPage] = useState("login");
  const [usertype, setUserType] = useState("user");
  if (usertype == "user") {
    const pagemap = {
      login: (
        <Login
          authSwitcher={() => {
            setPage("signup");
          }}
          userTypeSwitcher={() => {
            setUserType("agent");
          }}
        />
      ),
      signup: (
        <Signup
          authSwitcher={() => {
            setPage("login");
          }}
          userTypeSwitcher={() => {
            setUserType("agent");
          }}
        />
      ),
    };
    return pagemap[page];
  } else {
    const pagemap = {
      login: (
        <AgentLogin
          authSwitcher={() => {
            setPage("signup");
          }}
          userTypeSwitcher = {() => {
            setUserType("user")
          }}
        />
      ),
      signup: (
        <AgentSignup
          authSwitcher={() => {
            setPage("login");
          }}
          userTypeSwitcher = {() => {
            setUserType("user")
          }}
        />
      ),
    };
    return pagemap[page];
  }
};

export default Auth;
