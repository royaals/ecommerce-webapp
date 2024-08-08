import React from 'react'
import AddressCard from '../AddressCard/AddressCard'
import OrderTracker from './OrderTracker'
import { Box, Grid } from '@mui/material'
import { deepPurple } from '@mui/material/colors'
import { Star, StarBorder } from '@mui/icons-material'
const OrderDetail = () => {
    return (
        <div className='px:5 lg:px-20'>
            <div>
                <h1 className='font-bold text-xl py-10'>Delivery Address</h1>
                <AddressCard />
            </div>
            <div className='py-20'>
                <OrderTracker activeStep={3} />
            </div>

            <Grid className='space-y-5' container>
                {[1, 1, 1, 1, 1].map((item, index) =>
                    <Grid item container className='shadow-xl rounded-md p-5 border' sx={{ alignItems: 'center', justifyContent: 'space-between' }}>
                        <Grid item xs={6}>
                            <div className='flex items-center space-x-4'>
                                <img
                                    className='w-[5rem] h-[5rem] object-cover object-top'
                                    src="https://rukminim1.flixcart.com/image/612/612/xif0q/jean/d/s/c/36-mj-bk-pl-48-comfits-original-imagqbrnyjfzhs8v.jpeg?q=70" alt="" />
                                <div className='space-y-2 ml-5'>
                                    <p className='font-semibold'>
                                        Men Jeans
                                    </p>
                                    <p className='space-x-5 opacity-50 text-xs font-semibold'>
                                        <span>
                                            Color : pink
                                        </span>
                                        <span>Size : M</span>
                                    </p>

                                    <p>Seller: Tien</p>
                                    <p>$399</p>
                                </div>
                            </div>
                        </Grid>
                        <Grid item>
                            <Box sx={{ color: deepPurple[500] }}>
                                <StarBorder sx={{ fontSize: "2rem" }} className='px-2' />
                                <span>Rate & Review Product</span>

                            </Box>

                        </Grid>
                    </Grid>
                )}

            </Grid>

        </div>
    )
}

export default OrderDetail