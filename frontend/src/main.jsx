import React from 'react'
import ReactDOM from 'react-dom/client'
import App from './App'
import './index.scss'
import 'bootstrap/dist/css/bootstrap.css'
import Navbar from './Components/Navbar/Navbar'
import { BrowserRouter, Routes, Route } from 'react-router-dom';
import Auth from './Screens/Auth/Auth'
import AgentApp from './Components/ReceiveOTP/AgentApp'

import Send from './Screens/Order/Send'

import { AuthProvider } from './context/Auth'
import Orders from './Screens/Orders/Orders'
import Track from './Screens/Track/Track'

ReactDOM.createRoot(document.getElementById('root')).render(
  <React.StrictMode>
    <AuthProvider>
      <BrowserRouter>
        <Navbar />
        <Routes>
          <Route path='/' element={<App />} />
          <Route path='/auth' element={<Auth />} />
          <Route path='/agent' element={<AgentApp />} />
          <Route path='/placeorder' element={<Send />} />
          <Route path="/orders" element={<Orders/>}/>
      
        </Routes>
      </BrowserRouter>
    </AuthProvider>
  </React.StrictMode>,
)
