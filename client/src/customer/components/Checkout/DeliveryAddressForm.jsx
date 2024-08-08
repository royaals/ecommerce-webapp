import { Box, Button, Grid, TextField } from "@mui/material";
import React from "react";
import AddressCard from "../AddressCard/AddressCard";
import { useDispatch, useSelector } from "react-redux";
import { createOrder } from "../../../State/Order/Action";
import { useNavigate } from "react-router-dom";
const DeliveryAddressForm = () => {
    const dispatch = useDispatch();
    const navigate = useNavigate();
    const { order } = useSelector(store => store)
    const address = {
        firstName: "John",
        lastName: "Doe",
        streetAddress: "123 Main St",
        city: "New York",
        state: "NY",
        zipCode: '123123',
        mobile: '123123123'

    }
    const handleSubmit = (e) => {
        e.preventDefault();

        console.log("address")
        const data = new FormData(e.target);
        const address = {
            firstName: data.get('firstName'),
            lastName: data.get('lastName'),
            streetAddress: data.get('address'),
            city: data.get('city'),
            state: data.get('state'),
            zipCode: data.get('zip'),
            mobile: data.get('phoneNumber')
        }
        dispatch(createOrder({ address, navigate }))

        console.log(data.get('firstName'))
        console.log(data.get('lastName'))
        console.log(data.get('address'))
        console.log(data.get('city'))
        console.log(data.get('state'))
        console.log(data.get('zip'))
        console.log(data.get('phoneNumber'))

    }
    return (
        <div>
            <Grid container spacing={4}>
                <Grid
                    xs={12}
                    lg={5}
                    className="border rounded-e-md shadow-md h-[30.5rem] overflow-y-scroll">
                    <div className="p-5 y-7 border-b cursor-pointer">
                        <AddressCard address={address} />
                        <Button
                            sx={{ mt: 2, bgcolor: "RGB(145 85 253)" }}
                            size="large"
                            variant="contained">
                            Deliver Here
                        </Button>
                    </div>
                </Grid>

                <Grid item xs={12} lg={7}>
                    <Box className="border rounded-s-md shadow-md p-5">
                        <form onSubmit={handleSubmit}>
                            <Grid container spacing={3}>
                                <Grid item xs={12} sm={6}>
                                    <TextField
                                        required
                                        id="firstName"
                                        name="firstName"
                                        label="First Name"
                                        fullWidth
                                        autoComplete="given-name"
                                    />
                                </Grid>

                                <Grid item xs={12} sm={6}>
                                    <TextField
                                        required
                                        id="lastName"
                                        name="lastName"
                                        label="Last Name"
                                        fullWidth
                                        autoComplete="family-name"
                                    />
                                </Grid>

                                <Grid item xs={12}>
                                    <TextField
                                        required
                                        id="address"
                                        name="address"
                                        label="Address"
                                        fullWidth
                                        autoComplete="shipping address"
                                        multiline
                                        rows={4}
                                    />
                                </Grid>
                                <Grid item xs={12} sm={6}>
                                    <TextField
                                        required
                                        id="city"
                                        name="city"
                                        label="City"
                                        fullWidth
                                        autoComplete="shipping address-level2"
                                    />
                                </Grid>
                                <Grid item xs={12} sm={6}>
                                    <TextField
                                        required
                                        id="state"
                                        name="state"
                                        label="State/Province/Region"
                                        fullWidth
                                        autoComplete="shipping address-level1"
                                    />
                                </Grid>

                                <Grid item xs={12} sm={6}>
                                    <TextField
                                        required
                                        id="zip"
                                        name="zip"
                                        label="Zip / Postal code"
                                        fullWidth
                                        autoComplete="shipping postal-code"
                                    />
                                </Grid>

                                <Grid item xs={12} sm={6}>
                                    <TextField
                                        required
                                        id="phoneNumber"
                                        name="phoneNumber"
                                        label="Phone Number"
                                        fullWidth
                                        autoComplete="tel"
                                    />
                                </Grid>

                                <Grid item xs={12} sm={6}>
                                    <Button
                                        sx={{ py: 1.5, mt: 2, bgcolor: "RGB(145 85 253)" }}
                                        size="large"
                                        variant="contained"
                                        type="submit">
                                        Deliver Here
                                    </Button>
                                </Grid>
                            </Grid>
                        </form>
                    </Box>
                </Grid>
            </Grid>
        </div>
    );
};

export default DeliveryAddressForm;
