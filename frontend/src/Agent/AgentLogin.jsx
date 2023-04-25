import './Auth.scss'
import { useContext, useState } from 'react';
import { sha256 } from 'crypto-hash';
import axios from 'axios';
import { AuthContext } from '../context/Auth';
import { useNavigate } from 'react-router-dom';
const Login = (props) => {
    const [phone, setPhone] = useState(null)
    const [passhash, setPasshash] = useState(null)
    const [message, setMessage] = useState(null)
    const authobj = useContext(AuthContext)

    const navigate = useNavigate();

    const login = async () => {
        let data = JSON.stringify({
            "phoneNumber": phone,
            "password": passhash
        });
        let config = {
            method: 'post',
            maxBodyLength: Infinity,
            url: 'http://127.0.0.1:8080/agent/signin',
            headers: {
                'Content-Type': 'application/json',
            },
            data: data
        };
        axios.request(config)
            .then((response) => {
                var data = response.data;
                console.log(data);
                if (data.login) {
                    authobj.setPhone_(phone)
                    authobj.setLoggedIn_(true)
                    authobj.setKey_(data.key)
                    navigate("/")
                } else {
                    setMessage("Invalid credentials")
                }

            })
            .catch((error) => {
                console.log(error);
            });
    }
    return <div className="Login">
        <div className="hero p-3 row">
            <div className="col-12 col-md-6 text-center">
                <div className="img">
                    <img src='/courier.png' className='heroimg' />
                </div>

                <div className="switchbtn">
                    <button className="btn btn-dark m-2"
                        onClick={() => { navigate("/agentsignup") }}
                    >
                        <b>Sign Up Instead</b>
                    </button>
                </div>
            </div>
            <div className="col-12 col-md-6 p-5 blackcol d-flex flex-column align-items-center">
                <div className="h2 text-center">
                    Log In (Agent)
                </div>
                <div className="loginform text-center">
                    <div className="m-2">
                        Enter your phone number
                    </div>
                    <input type="text" className="forminp shadow-none"
                        onChange={(event) => {
                            setPhone(event.target.value);
                        }}
                    />
                    <div className="m-2">
                        Enter your password
                    </div>
                    <input type="password" className="forminp shadow-none"
                        onChange={async (event) => {
                            var hash = await sha256(event.target.value)
                            setPasshash(hash);
                        }}
                    />
                </div>
                <button className="btn btn-light m-2"
                    onClick={login}
                >
                    <b>Submit</b>
                </button>

                {
                    message === null ?
                        null :
                        <div className="message m-2 p-3">
                            {message}
                        </div>
                }
            </div>
        </div>
    </div>
}
export default Login;