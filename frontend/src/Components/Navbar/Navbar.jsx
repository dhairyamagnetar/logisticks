import './Navbar.scss'
import { useNavigate } from 'react-router-dom';
import { AuthContext } from '../../context/Auth';
import { useContext } from 'react';

const Navbar = () => {
    const navigate = useNavigate();
    const authobj = useContext(AuthContext);

    return <div className="Navbar d-flex flex-row">
        <button className="btn btn-light homebtn" onClick={() => { navigate("/") }}> Home </button>
        <button className='btn btn-light homebtn2' onClick={() => {
            console.log("Clicked!!")
            if (authobj.type_ === "user") {
                authobj.setType_("agent");
                navigate("/")
                console.log(authobj.key_);
            }
            else {
                authobj.setType_("user")
                navigate("/")
            }
        }}>{authobj.type_ === "user" ? "Switch to Agent" : "Switch to User"}</button>
        {
            authobj.loggedIn_ ?
                <button className="btn btn-light loginbtn" onClick={() => {
                    authobj.setLoggedIn_(false)
                    authobj.setPhone_(null);
                    authobj.setKey_(null);
                    navigate("/");
                }}>
                    <b>Logout</b>
                </button> :
                <button className="btn btn-light loginbtn" onClick={() => {
                    if (authobj.type_ === "user") {
                        navigate("auth");
                    }
                    else {
                        navigate("agentlogin");
                    }
                }}>
                    <b>Login</b>
                </button>
        }
    </div >

}
export default Navbar;