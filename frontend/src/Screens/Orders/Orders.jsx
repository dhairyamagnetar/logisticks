import './Orders.scss'
import { useEffect, useState, useContext} from 'react';
import { AuthContext } from '../../context/Auth';
import axios from 'axios';
import { useNavigate } from 'react-router-dom';
const Orders = () => {
    const [rec, setRec] = useState(true);

    const [recvorders, setRecvorders] = useState([])
    const [transorders, setTransorders] = useState([])
    const [called, setCalled] = useState(false)

    const authobj = useContext(AuthContext)

    const fetchOrders = async () => {
        console.log("called")
        axios.request({
            method: 'get',
            maxBodyLength: Infinity,
            url: `http://127.0.0.1:8080/order/sent/${authobj.phone_}`,
            headers: {
                'Content-Type': 'application/json',
            }
        }).then((response) => {
            // console.log(response.data)
            setTransorders(response.data)
        }).catch((err) => {
            console.log(err);
        })

        axios.request({
            method: 'get',
            maxBodyLength: Infinity,
            url: `http://127.0.0.1:8080/order/received/${authobj.phone_}`,
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
    }, [recvorders, transorders])

    const navigate = useNavigate()

    return <div className="Orders">
        <div className="recbtns d-flex flex-row justify-content-around m-5">
            <div className={rec ? "dark p-3" : "light p-3"}
                onClick={() => { setRec(!rec) }}
            >
                <b>Received Orders</b>
            </div>
            <div className={!rec ? "dark p-3" : "light p-3"}
                onClick={() => { setRec(!rec) }}
            >
                <b>Sent Orders</b>
            </div>
        </div>
        <div className="orderdisplay d-flex flex-column justify-content-center">
            {
                !rec ?
                    recvorders.map((e) => {
                        const delivered  = e.status === "DELIVERED";
                        return <div className="recvorder m-3 d-flex flex-row p-3 justify-content-between">
                            <div className="details">
                                <div className="h6">{"Order id : " + e.id}</div>
                                <div className="d-flex flex-row flex-wrap">
                                    <div className='m-2'>{e.deliveryRate + " INR"}</div>
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
                            <button className={delivered ? "btn btn-success" : "btn btn-warning"} disabled = {delivered ? true : false} 
                            onClick={()=>{
                                navigate('/track', {state : {orderId : e.id}})
                            }}
                            >
                                <b>
                                {  
                                    delivered ? 
                                    "Delivered":
                                    "Track"
                                }
                                </b>
                            </button>
                        </div>
                    }) :
                    transorders.map((e) => {
                        const delivered  = e.status === "DELIVERED";
                        return <div className="transorder m-3  d-flex flex-row p-3 justify-content-between">
                            <div className="details">
                                <div className="h6">{"Order id : " + e.id}</div>
                                <div className="d-flex flex-row flex-wrap">
                                    <div className='m-2'>{e.deliveryRate + " INR"}</div>
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
                            <button className={delivered ? "btn btn-success" : "btn btn-warning"} disabled = {delivered ? true : false}
                            onClick={()=>{
                                navigate('/track', {state : {orderId : e.id}})
                            }} >
                                <b>
                                {  
                                    delivered ? 
                                    "Delivered":
                                    "Track"
                                }
                                </b>
                            </button>
                        </div>
                    })
            }
        </div>
    </div>
}

export default Orders;