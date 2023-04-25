import './Navbar.scss'
import { useNavigate } from 'react-router-dom';
import { AuthContext } from '../../context/Auth';
import { useContext } from 'react';

const Navbar = () => {
    const navigate = useNavigate();
    const authobj = useContext(AuthContext);

    return <div className="Navbar d-flex flex-row">
        <button className="btn btn-light homebtn" onClick={() => {navigate("/")}}> Home </button>
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
                navigate("auth");
            }}>
                <b>Login</b>
            </button>
        }
    </div>

}
export default Navbar;