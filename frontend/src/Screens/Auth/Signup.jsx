import './Auth.scss'
import { useContext, useEffect, useState } from 'react';
import { sha256 } from 'crypto-hash';
import axios from 'axios';
import { AuthContext } from '../../context/Auth';
import Dropdown from 'react-bootstrap/Dropdown';
import { useNavigate } from 'react-router-dom';


const Signup = (props) => {
    const [phone, setPhone] = useState(null)
    const [passhash, setPasshash] = useState(null)
    const [name, setName] = useState(null)
    const [location, setLocation] = useState(null)
    const [houseNumber, setHouseNumber] = useState(null)
    const [locality, setLocality] = useState(null)

    const [message, setMessage] = useState(null)
    const [locations, setLocations] = useState([])
    const authobj = useContext(AuthContext)

    const navigate = useNavigate();

    const getLocations = () => {
        console.log("called")
        let config = {
            method: 'get',
            maxBodyLength: Infinity,
            url: `http://127.0.0.1:8080`+'/location',
            headers: {
                'Content-Type': 'application/json',
            },
        };
        axios.request(config)
            .then((response) => {
                var data = response.data;
                setLocations(data)
            })
            .catch((error) => {
                console.log(error)
            });
    }

    useEffect(() => {
        if (locations.length <= 0) {
            getLocations();
        }
    }, [locations])

    const signup = async () => {
        let data = JSON.stringify({
            "phoneNumber": phone,
            "password": passhash,
            "name": name,
            "houseNumber": houseNumber,
            "locality": locality,
            "locationId": location.id
        });
        let config = {
            method: 'post',
            maxBodyLength: Infinity,
            url: 'http://127.0.0.1:8080/auth/signup',
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
                    setMessage("Some error occured")
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
                        onClick={props.switch}
                    >
                        <b>Log In Instead</b>
                    </button>
                </div>
            </div>
            <div className="col-12 col-md-6 p-5 blackcol d-flex flex-column align-items-center">
                <div className="h2 text-center">
                    Sign Up
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
                    <div className="m-2">
                        Enter your name
                    </div>
                    <input type="text" className="forminp shadow-none"
                        onChange={async (event) => {
                            setName(event.target.value);
                        }}
                    />
                    <div className="m-2">
                        Enter your house number
                    </div>
                    <input type="text" className="forminp shadow-none"
                        onChange={async (event) => {
                            setHouseNumber(event.target.value);
                        }}
                    />
                    <div className="m-2">
                        Enter your locality
                    </div>
                    <input type="text" className="forminp shadow-none"
                        onChange={async (event) => {
                            setLocality(event.target.value);
                        }}
                    />
                    <div className="m-2">
                        Select your location
                    </div>
                    <Dropdown>
                        <Dropdown.Toggle variant="light" id="dropdown-basic">
                            {location === null ? "Locations": location.city + ", "+location.state}
                        </Dropdown.Toggle>

                        <Dropdown.Menu>
                            {locations.map((e)=>{
                                return <Dropdown.Item
                                    onClick={()=>{
                                        setLocation(e);
                                    }}
                                >{e.city + ", " + e.state}</Dropdown.Item>
                            })}
                        </Dropdown.Menu>
                    </Dropdown>
                </div>
                <button className="btn btn-light mt-4"
                    onClick={signup}
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

export default Signup;