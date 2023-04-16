import './Orders.scss'
import { useEffect, useState } from 'react';

const Orders = () => {
    const [rec, setRec] = useState(true);

    const [recvorders, setRecvorders] = useState([])
    const [transorders, setTransorders] = useState([])

    const fetchOrders = async () => {
        setRecvorders([
            {
                "id": 5,
                "deliveryRate": 78,
                "weight": 789.6,
                "isFragile": 0,
                "isExpressDelivery": 1,
                "to": "heliospook"
            }
        ])
        setTransorders([
            {
                "id": 6,
                "deliveryRate": 78.5,
                "weight": 7900,
                "isFragile": 1,
                "isExpressDelivery": 0,
                "to": "heliospook"
            }
        ])
    }

    useEffect(() => {
        if (transorders.length > 0 || recvorders.length > 0) return
        fetchOrders()
    }, [recvorders, transorders])

    return <div className="Orders">
        <div className="recbtns d-flex flex-row justify-content-around m-5">
            <div className={rec ? "dark p-3" : "light p-3"}
                onClick={() => { setRec(!rec) }}
            >
                <b>Received / Sent Orders</b>
            </div>
            <div className={!rec ? "dark p-3" : "light p-3"}
                onClick={() => { setRec(!rec) }}
            >
                <b>Orders in Transit</b>
            </div>
        </div>
        <div className="orderdisplay d-flex flex-row justify-content-center">
            {
                !rec ?
                    recvorders.map((e) => {
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
                            <button className="btn btn-success">
                                <b>Track</b>
                            </button>
                        </div>
                    }) :
                    transorders.map((e) => {
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
                            <button className="btn btn-warning">
                                <b>Delivered</b>
                            </button>
                        </div>
                    })
            }
        </div>
    </div>
}

export default Orders;