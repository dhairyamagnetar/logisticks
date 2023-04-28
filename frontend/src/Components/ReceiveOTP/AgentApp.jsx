
import './AgentApp.scss'
import { useNavigate } from 'react-router-dom';
import Modal from './Modal';
import React,{ useState } from 'react';

export default function AgentApp() {
  const [isModalOpen, setIsModalOpen] = useState(false);
  const navigate = useNavigate();
  const handleModalOpen = () => {
    setIsModalOpen(true);
  };

  const handleModalClose = () => {
    setIsModalOpen(false);
  };

  const handleOtpSubmit = (otp,id) => {
    console.log(`OTP submitted: ${otp}`);
    console.log(`Id submitted: ${id}`);
    setIsModalOpen(false);
  };

  return (
    <div className="App">
      <div className="hero p-3 row">
          <div className="col-12 col-md-6 text-center">
              <img src='/courier.png' className='heroimg'/>
          </div>
          <div className="col-12 col-md-6 p-5 blackcol d-flex flex-column align-items-center justify-content-center">
              <div className="h2 text-center">
                Logisticks
              </div>
              <div className="h6 text-center m-3">
                Entrust all your shipping challenges in our wily hands. Strong, tech-driven solutions for all the problems on the road.
              </div>
              <button className="btn btn-light m-2" onClick= {() => { navigate("/agent/assignedorders") }}>
              <b>Pending Orders</b>
              </button>
              <div>
                <button className="btn btn-warning m-2" onClick={handleModalOpen}>
                <b>Delivery assigned order</b>
                </button>
                <Modal isOpen={isModalOpen} onClose={handleModalClose} onSubmit={handleOtpSubmit} />          </div>
              </div>
      </div>
    </div>
  )
}

