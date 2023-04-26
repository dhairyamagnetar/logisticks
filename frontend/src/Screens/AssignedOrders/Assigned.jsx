import './Assigned.scss'
import { useEffect, useState, useContext} from 'react';
import { AuthContext } from '../../context/Auth';
import axios from 'axios';
import { useNavigate } from 'react-router-dom';
const Assigned = () => {
    // const [rec, setRec] = useState(false);
    // console.log(1)
    const [recvorders, setRecvorders] = useState([])
    const [called, setCalled] = useState(false)
    // console.log(2)
    const authobj = useContext(AuthContext)

    const fetchOrders = async () => {
        console.log("called")
        axios.request({
            method: 'get',
            maxBodyLength: Infinity,
            url: `http://127.0.0.1:8080/agent/viewAssignedOrders`,
            headers: {
                'Content-Type': 'application/json',
            }
        }).then((response) => {
            console.log(response.data)
            setRecvorders(response.data)
        }).catch((err) => {
            console.log(err);
        })
    }
    useEffect(() => {
        if(called) return;
        setCalled(true)
        fetchOrders()
    }, recvorders)

    const navigate = useNavigate()

    return <div className="Orders">
        <div className="recbtns d-flex flex-row justify-content-around m-5">
            <div className="dark p-3">
                <b>Assigned Orders</b>
            </div>
            </div>
        <div className="orderdisplay d-flex flex-row justify-content-center">
            {
                called == true ?
                    recvorders.map((e) => {
                        {/* console.log(e.id) */}
                        return <div className="recvorder m-3 d-flex flex-row p-3 justify-content-between">
                            <div className="details">
                                <div className="h6">{"Order id : " + e.id}</div>
                                <div className="d-flex flex-row flex-wrap">
                                <div className='m-2'>{"Receiver Phone Number:"+e.receiverPhoneNumber}</div>
                                <div className='m-2'>{"Receiver Address:"+e.receiverAddress}</div>
                                    <div className='m-2'>{e.weight + " grams"}</div>
                                    {
                                        e.isFragile ?
                                            <div className="fragile m-2">
                                                Fragile item
                                            </div> :
                                            <div className="notfragile m-2">
                                                Not Fragile
                                            </div>
                                    }
                                    {
                                        e.isExpressDelivery ?
                                            <div className="express m-2">
                                                Express Delivery
                                            </div> :
                                            null
                                    }
                                </div>
                            </div>
                        </div>
                    }) : console.log("1")
            }
        </div>
    </div>
}

export default Assigned;