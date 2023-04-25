import React, { useState, useContext } from "react";

const AuthContext = React.createContext();

const AuthProvider = ({ children }) => {
    const [loggedIn_, setLoggedIn_] = useState(false)
    const [phone_, setPhone_] = useState(null)
    const [key_, setKey_] = useState(null)
    const [type_,setType_] = useState("user")

    return <AuthContext.Provider value={
        {
            loggedIn_,
            setLoggedIn_,
            phone_,
            setPhone_,
            key_,
            setKey_,
            type_, setType_
        }
    }
    >
        {children}
    </AuthContext.Provider>
}

export {
    AuthProvider,
    AuthContext
}