import "./Track.scss"
import { useLocation } from "react-router-dom"

const Track = ()=>{
    const location = useLocation();
    const orderId = location.state.orderId;
    console.log(orderId);
    return <div className="Track">

    </div>
}

export default Track;