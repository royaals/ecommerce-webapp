import React, { useEffect } from 'react'
import { useDispatch, useSelector } from 'react-redux'
import { getOrders } from '../../State/Admin/Order/Action'
import { Avatar, AvatarGroup, Card, CardHeader, Paper, Table, TableBody, TableCell, TableContainer, TableHead, TableRow } from '@mui/material'

const OrdersTableView = () => {
    const dispatch = useDispatch()
    const { adminOrder } = useSelector(store => store)


    useEffect(() => {
        dispatch(getOrders())

    }, [adminOrder.confirmed, adminOrder.shipped, adminOrder.delivered, adminOrder.deletedOrder])

    console.log("Admin Orders", adminOrder.orders)


    return (
        <div className='p-10'>
            <Card
                className='mt-2 bg-[#1b1b1b]'
                s
            >
                <CardHeader title="Recent Orders" />
                <TableContainer component={Paper}>
                    <Table sx={{ minWidth: 650 }} aria-label="simple table">
                        <TableHead>
                            <TableRow>
                                <TableCell>Image</TableCell>
                                <TableCell align="left">Title</TableCell>
                                <TableCell align="left">ID</TableCell>
                                <TableCell align="left">Price</TableCell>
                                <TableCell align="left">Status</TableCell>
                            </TableRow>
                        </TableHead>
                        <TableBody>
                            {adminOrder.orders?.map((row, index) => (
                                <TableRow
                                    key={row.id}
                                    sx={{ '&:last-child td, &:last-child th': { border: 0 } }}
                                >
                                    <TableCell align="" className=''>
                                        <AvatarGroup max={4} sx={{ justifyContent: 'start' }}>
                                            {row.orderItems.map((item) =>
                                                <Avatar src={item.product.imageUrl}>
                                                </Avatar>
                                            )}
                                        </AvatarGroup>

                                    </TableCell>
                                    <TableCell component="left" scope="row">
                                        {row.orderItems.map((item) =>
                                            <p>
                                                {item.product.title}
                                            </p>
                                        )}
                                    </TableCell>
                                    <TableCell align="left">{row.id}</TableCell>
                                    <TableCell align="left">{row.totalPrice}</TableCell>
                                    <TableCell align="left">
                                        <span className={`${row.orderStatus === "CONFIRMED" ? "bg-[#369234]" :
                                            row.orderStatus === "SHIPPED" ? "bg-[#4141ff]" :
                                                row.orderStatus === "PLACED" ? "bg-[#02B290]" :
                                                    row.orderStatus === "PENDING" ? "bg-[gray]" : "bg-[#025720]"} text-white px-5 py-2 rounded-full`}>
                                            {row.orderStatus}
                                        </span>
                                    </TableCell>

                                </TableRow>
                            ))}
                        </TableBody>
                    </Table>
                </TableContainer>

            </Card>
        </div>
    )
}

export default OrdersTableView