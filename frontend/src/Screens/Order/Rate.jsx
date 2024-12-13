import "./Rate.scss"

import IconButton from '@mui/material/IconButton';
import Input from '@mui/material/Input';
import FilledInput from '@mui/material/FilledInput';
import OutlinedInput from '@mui/material/OutlinedInput';
import InputLabel from '@mui/material/InputLabel';
import InputAdornment from '@mui/material/InputAdornment';
import FormHelperText from '@mui/material/FormHelperText';
import FormControl from '@mui/material/FormControl';
import TextField from '@mui/material/TextField';
import Visibility from '@mui/icons-material/Visibility';
import VisibilityOff from '@mui/icons-material/VisibilityOff';
import MenuItem from '@mui/material/MenuItem';
import axios from 'axios';
import { Button } from '@mui/material';
import { AuthContext } from '../../context/Auth';
import { ThemeProvider, createTheme } from '@mui/material';

import { useState, useEffect, useContext } from 'react'

const theme = createTheme({
    palette: {
        mode: "light",
        white: {
            main: "#ffffff",
        },
        yellow: {
            main: "#efd00b !important",
        },
    },
});

const Rate = () => {

    const authobj = useContext(AuthContext);

    const [locations, setLocations] = useState([])
    const [width, setWidth] = useState("80%")
    const [align, setAlign] = useState("center")
    const [butText, setButText] = useState("Calculate")
    const [Amount, setAmount] = useState(0)
    const [weight, setWeight] = useState(0);
    const [isfragile, setIsFragile] = useState(0);
    const [isExpress, setIsExpress] = useState(0);
    const [phone, setPhone] = useState(0);
    const [location, setIsLocation] = useState(locations[0]);
    const [senderPhone, setSenderPhone] = useState("9876543210");
    const [senderLocation, setSenderLocation] = useState(-1);
    

    const URL = "http://localhost:8080/";

    useEffect(() => {

        if (senderLocation === -1) {

            if (authobj.phone_) {
                setSenderPhone(authobj.phone_);
            }

            console.log("Called!!!", authobj.phone_);
            setSenderPhone(authobj.phone_)
            axios.request({
                method: 'get',
                maxBodyLength: Infinity,
                url: `http://127.0.0.1:30008/user/${authobj.phone_}`,
                headers: {
                    'Content-Type': 'application/json',
                }
            }).then((response) => {
                setSenderLocation(response.data.status ? response.data.locationId : 1);
                setSenderPhone(authobj.phone_);
                console.log(response);
            }).catch((err) => {
                console.log(err);
            })
        }
    })

    const getLocations = () => {
        // console.log("called")
        let config = {
            method: 'get',
            maxBodyLength: Infinity,
            url: 'http://127.0.0.1:30008/location',
            headers: {
                'Content-Type': 'application/json',
            },
        };
        axios.request(config)
            .then((response) => {
                var data = response.data;
                // console.log(data);
                setLocations(data)
            })
            .catch((error) => {
                // console.log(error)
            });
    }

    useEffect(() => {


    }, [weight, isfragile, isExpress, phone, location])

    const calculate = () => {
        let config = {
            method: 'post',
            maxBodyLength: Infinity,
            url: 'http://127.0.0.1:30008/order/placeorder',
            headers: {
                'Content-Type': 'application/json',
            },
        };
        // console.log("Location : ", location)

        var id = 0;

        // console.log(locations);

        for (var i = 0; i < locations.length; i++) {
            // console.log(locations[i].district)
            if (locations[i].district === location) {
                // console.log("FOUUND")
                id = locations[i].id;
                // console.log("IDD", locations[i].id)
            }
        }
        // console.log("ID", id);


        axios.post('http://127.0.0.1:30008/rate/calculate', {
            "weight": weight,
            "isFragile": isfragile,
            "isExpressDelivery": isExpress,
            "senderPhoneNumber": "9876543210",
            "receiverPhoneNumber": phone,
            "senderLocationId": senderLocation,
            receiverLocationId: id
        }).then((response) => {
            console.log(response);
            setAmount(response.data);
        }).catch((err) => {
            console.log(err);
        })
    }

    useEffect(() => {
        if (locations.length <= 0) {
            getLocations();
        }
    }, [locations])

    useEffect(() => {

    })

    const [showPassword, setShowPassword] = useState(false);

    const handleClickShowPassword = () => setShowPassword((show) => !show);

    const handleMouseDownPassword = (event) => {
        event.preventDefault();
    };

    useEffect(() => {
        if (window.screen.width < 768) {
            setWidth("100%");
        }
        if (window.screen.width < 1000) {
            setAlign("start")
        }
    })

    console.log(locations)

    const fragile = [
        {
            value: 0,
            label: "No"
        },
        {
            value: 1,
            label: "Yes"
        }
    ];

    const Express = [
        {
            value: 0,
            label: "No"
        },
        {
            value: 1,
            label: "Yes"
        }
    ];

    const handlePay = () => {

        var id = 0;

        // console.log(locations);

        for (var i = 0; i < locations.length; i++) {
            // console.log(locations[i].district)
            if (locations[i].district === location) {
                // console.log("FOUUND")
                id = locations[i].id;
                // console.log("IDD", locations[i].id)
            }
        }

        axios.post('http://127.0.0.1:30008/order/placeorder', {
            "weight": weight,
            "isFragile": isfragile,
            "isExpressDelivery": isExpress,
            "senderPhoneNumber": senderPhone,
            "receiverPhoneNumber": phone,
            "senderLocationId": senderLocation,
            receiverLocationId: id
        }).then((response) => {
            // console.log(response);
            alert("Order Was Placed Successfully")
        }).catch((err) => {
            // console.log(err);
            alert("Error")
        })
    }

    // console.log(weight);

    return (
        <ThemeProvider theme={theme}>
            <div className="Send">
                <div className="child rate">
                    <div className="container">
                        <div className="row mt-2">
                            <div className="col-12 d-flex justify-content-center">
                                <h2 className="heading">Calculate Rate</h2>
                            </div>
                        </div>
                        <div className="row d-flex justify-content-center">
                            <div className="col-10">
                                <div className="line"></div>
                            </div>
                        </div>
                        <div className={`row mt-4 d-flex justify-content-${align} me-2`}>
                            <div className="col-12 col-sm-6 col-md-3">
                                <FormControl sx={{ m: 1, width: '100%', color: 'white.main' }} variant="outlined">
                                    {/* <InputLabel htmlFor="outlined-adornment-weight">Weight</InputLabel> */}
                                    <OutlinedInput
                                        // label="Weight"
                                        id="outlined-adornment-weight"
                                        endAdornment={<InputAdornment position="end">kg</InputAdornment>}
                                        aria-describedby="outlined-weight-helper-text"
                                        value={weight}
                                        onChange={(val) => setWeight(val.target.value)}
                                        className="mui-inp"
                                        sx={{ bgcolor: 'main.white' }}
                                        inputProps={{
                                            'aria-label': 'weight',
                                        }}
                                    />
                                    <FormHelperText id="outlined-weight-helper-text">Weight</FormHelperText>
                                </FormControl>
                            </div>
                            <div className="col-12 col-sm-6 col-md-3">
                                <FormControl sx={{ m: 1, width: "100%" }} variant="outlined">
                                    <TextField
                                        id="outlined-select-currency"
                                        select
                                        // label="Fragility"
                                        value={isfragile}
                                        onChange={(event) => setIsFragile(event.target.value)}
                                        helperText="Choose yes if your item is fragile"
                                    >
                                        {fragile.map((option) => (
                                            <MenuItem key={option.value} value={option.value}>
                                                {option.label}
                                            </MenuItem>
                                        ))}
                                    </TextField>
                                </FormControl>
                            </div>
                            <div className="col-12 col-sm-12 col-md-3">
                                <FormControl sx={{ m: 1, width: '25ch' }} variant="outlined">
                                    <TextField
                                        id="outlined-select-currency"
                                        select
                                        // label="Express Delivery"
                                        value={isExpress}
                                        onChange={(event) => setIsExpress(event.target.value)}
                                        helperText="Select yes if you want express delivery"
                                    >
                                        {Express.map((option) => (
                                            <MenuItem key={option.value} value={option.value}>
                                                {option.label}
                                            </MenuItem>
                                        ))}
                                    </TextField>
                                </FormControl>

                            </div>
                        </div>

                        {/* <div className={`row d-flex justify-content-${align} mt-1`}>
                            <div className="col-12 col-sm-12 col-md-6">
                                {console.log(width)}
                                <FormControl sx={{ m: 1, width: `${width}` }} variant="outlined">

                                    <OutlinedInput

                                        id="outlined-adornment-weight"

                                        aria-describedby="outlined-weight-helper-text"
                                        helperText="Enter Receiver's Phone Number"
                                        value={phone}
                                        onChange={(event) => setPhone(event.target.value)}
                                        inputProps={{
                                            'aria-label': 'weight',
                                        }}
                                    />
                                    <FormHelperText id="outlined-weight-helper-text">Enter Receiver's Phone Number</FormHelperText>
                                </FormControl>
                            </div>
                            <div className="col-12 col-sm-12 col-md-3">

                            </div>

                        </div> */}

                        <div className={`row mt-md-1 mt-sm-1 d-flex justify-content-${align}`}>
                            <div className="col-12 col-sm-12 col-md-3">
                                <FormControl fullWidth className="ms-2 mt-2" variant="outlined">
                                    <TextField
                                        id="outlined-select-currency"
                                        select
                                        // label="Receiver's Location"
                                        value={location}
                                        onChange={(event) => setIsLocation(event.target.value)}
                                    >
                                        {locations.map((option) => (
                                            // console.log(option.district)
                                            <MenuItem key={option.district} value={option.district}>
                                                {option.district}
                                            </MenuItem>
                                        ))}
                                    </TextField>
                                    <FormHelperText id="outlined-weight-helper-text">Select Receiver's location</FormHelperText>
                                </FormControl>
                            </div>
                            <div className="col-12 col-sm-12 col-md-3">

                            </div>
                            <div className="col-6 col-sm-6 col-md-3 mt-3 mt-md-0 ">
                                <div className="pay d-flex w-100 align-items-center justify-content-center">
                                    <p1 className="">Amount : </p1>
                                    <p1 className="">{Amount}</p1>
                                </div>
                            </div>
                        </div>

                        <div className="row d-flex justify-content-center mt-4 ">
                            <div className="col-12 col-sm-4">
                                <button type="button" class="btn btn-warning w-100 but1" onClick={calculate}>{`${butText}`}</button>
                            </div>

                        </div>

                    </div>

                </div>
            </div>
        </ThemeProvider>
    )

}

export default Rate