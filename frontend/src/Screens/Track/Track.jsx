import "./Track.scss"
import { useLocation } from "react-router-dom"
import { useEffect, useState } from "react";
import { Spinner } from "react-bootstrap";
import axios from "axios"

const Track = () => {
    const location = useLocation();
    const orderId = location.state.orderId;
    const [track, setTrack] = useState(null)

    useEffect(() => {
        if (track != null) return;
        let config = {
            method: 'get',
            maxBodyLength: Infinity,
            url: `http://backend.local:8088/order/track/` + orderId,
            headers: {
                'Content-Type': 'application/json',
            },
        };
        axios.request(config)
            .then((response) => {
                var data = response.data;
                setTrack(data)
            })
            .catch((error) => {
                console.log(error)
            });
    }, [track])
    if (track === null) return <div className="Track d-flex justify-content-center"><Spinner className="m-5" /></div>;
    return <div className="Track d-flex flex-column">
        <div className="heading m-2">
            <b>Order id <span className="idval">{orderId}</span></b>
        </div>
        <div className="row">
            <div className="col-12 col-md-6 col-lg-4">
                <div className="loc d-flex flex-column justify-content-center align-items-center p-3">
                    <span className="heading">Sender Location</span>
                    <span className="city">{`${track.sCity}, ${track.sDistrict}, ${track.sState}`}</span>
                </div>
            </div>
            <div className="col-12 col-md-6 col-lg-4">
                <div className="loc d-flex flex-column justify-content-center align-items-center p-3">
                    <span className="heading">Current Location</span>
                    <span className="city">{`${track.cCity}, ${track.cDistrict}, ${track.cState}`}</span>
                    <span className="status m-1">
                        {track.status}
                    </span>
                </div>
            </div>
            <div className="col-12 col-lg-4">
                <div className="loc d-flex flex-column justify-content-center align-items-center p-3">
                    <span className="heading">Receiver Location</span>
                    <span className="city">{`${track.dCity}, ${track.dDistrict}, ${track.dState}`}</span>
                </div>
            </div>
        </div>
        <div className="agent p-3 m-3">
            Delivery Agent<br />
            <div className="d-flex justify-content-around m-2">
                <div className="name">
                    {track.agentName}
                </div>
                <div className="name">
                    {track.agentPhoneNumber}
                </div>
            </div>
            Reception OTP<br />
            <div className="d-flex justify-content-center">
                <div className="name text-center pill">
                    {track.receptionOTP}
                </div>
            </div>
        </div>
    </div>
}

export default Track;