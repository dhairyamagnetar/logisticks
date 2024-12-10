import './Mark.scss'
import { useContext, useState } from 'react';
import { sha256 } from 'crypto-hash';
import axios from 'axios';
import { AuthContext } from '../../context/Auth';
import { useNavigate } from 'react-router-dom';
const Mark = (props) => {
    const [status, setStatus] = useState(false)
    const [message, setMessage] = useState(null)
    const authobj = useContext(AuthContext)
     
    const navigate = useNavigate();

    const login = async () => {
        let data = JSON.stringify({
            "id": id,
            "otp": otp
        });
        let config = {
            method: 'post',
            maxBodyLength: Infinity,
            url: `http://192.168.49.2:31755/agent/markasdelivered`,
            headers: {
                'Content-Type': 'application/json',
            },
            data: data
        };
        axios.request(config)
            .then((response) => {
                var data = response.data;
                console.log(data);
                navigate('/agent');
            })
            .catch((error) => {
                console.log(error);
            });
    }
    return <div>Yes</div>
}
export default Mark;