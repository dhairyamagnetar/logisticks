import React, { useState } from 'react';

const Modal = ({ isOpen, onClose, onSubmit }) => {
  const [otp, setOtp] = useState('');

  const handleInputChange = (event) => {
    setOtp(event.target.value);
  };

  const handleSubmit = (event) => {
    event.preventDefault();
    onSubmit(otp);
  };

  return (
    <>
      {isOpen && (
        <div className="modal">
          <div className="modal-content">
            <span className="close" onClick={onClose}>
              &times;
            </span>
            <h2>Enter OTP</h2>
            <form onSubmit={handleSubmit}>
              <label htmlFor="otp-input">OTP:</label>
              <input
                type="number"
                id="otp-input"
                value={otp}
                onChange={handleInputChange}
              />
              <button type="submit">Submit</button>
            </form>
          </div>
        </div>
      )}
    </>
  );
};

export default Modal;
