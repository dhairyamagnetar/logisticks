import React, { useState } from 'react';
import BootStrapModal from "react-bootstrap/Modal"
import axios from 'axios';
import { useNavigate } from 'react-router-dom';
import './Modal.scss';
const Modal = ({ isOpen, onClose, onSubmit }) => {

  const [otp, setOtp] = useState('');
  const [id,setId] = useState('');
  const navigate = useNavigate();
  const handleInputChangeOtp = (event) => {
    setOtp(event.target.value);
  };
  const handleInputChangeId = (event) => {
    setId(event.target.value);
  };

  const handleSubmit = (event) => {
    event.preventDefault();
    onSubmit(otp,id);
    let data = JSON.stringify({
      "id": id,
      "otp": otp
  });
  let config = {
      method: 'post',
      maxBodyLength: Infinity,
      url: `http://backend.local:8088/agent/markasdelivered`,
      headers: {
          'Content-Type': 'application/json',
      },
      data: data
  };
  axios.request(config)
      .then((response) => {
          var data = response.data;
          alert(data.message);
          navigate('/agent');
      })
      .catch((error) => {
          console.log(error);
      });
  };

  return (
    <>
        <BootStrapModal show={isOpen}>
          <div className="myModal">
            <div className="modal-content">
              <span className="close" onClick={onClose}>
                &times;
              </span>
              <h2>Enter OTP</h2>
              <form onSubmit={handleSubmit}>
              <label htmlFor="id-input"  className='modal-inside'>Order Id:</label>
                <input
                  type="text"
                  id="id-input"
                  value={id}
                  onChange={handleInputChangeId}
                />
                <br></br>
                <label htmlFor="otp-input" className='modal-inside'>OTP:</label>
                <input
                  type="text"
                  id="otp-input"
                  value={otp}
                  onChange={handleInputChangeOtp}
                />
                <br></br>
                <button type="submit" className='modal-button'>Submit</button>
              </form>
            </div>
          </div>

        </BootStrapModal>
    </>
  );
};

export default Modal;
