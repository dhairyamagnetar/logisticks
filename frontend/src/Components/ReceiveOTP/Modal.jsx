import React, { useState } from 'react';
import BootStrapModal from "react-bootstrap/Modal"
const Modal = ({ isOpen, onClose, onSubmit }) => {
  const [otp, setOtp] = useState('');
  console.log("modal kholenge", isOpen)
  const handleInputChange = (event) => {
    setOtp(event.target.value);
  };

  const handleSubmit = (event) => {
    event.preventDefault();
    onSubmit(otp);
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
                <label htmlFor="otp-input">OTP:</label>
                <input
                  type="text"
                  id="otp-input"
                  value={otp}
                  onChange={handleInputChange}
                />
                <button type="submit">Submit</button>
              </form>
            </div>
          </div>

        </BootStrapModal>
    </>
  );
};

export default Modal;
