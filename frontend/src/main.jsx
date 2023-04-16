import React from 'react'
import ReactDOM from 'react-dom/client'
import App from './App'
import './index.scss'
import 'bootstrap/dist/css/bootstrap.css'
import Navbar from './Components/Navbar/Navbar'
import { BrowserRouter, Routes, Route } from 'react-router-dom';
import Auth from './Screens/Auth/Auth'

import { AuthProvider } from './context/Auth'

ReactDOM.createRoot(document.getElementById('root')).render(
  <React.StrictMode>
    <AuthProvider>
      <BrowserRouter>
        <Navbar/>
        <Routes>
          <Route path='/' element={<App />} />
          <Route path='/auth' element={<Auth />} />
        </Routes>
      </BrowserRouter>
    </AuthProvider>
  </React.StrictMode>,
)
