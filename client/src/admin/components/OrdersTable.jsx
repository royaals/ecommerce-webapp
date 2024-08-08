import React, { useEffect } from 'react'
import { useDispatch, useSelector } from 'react-redux'
import { confirmOrder, deleteOrder, deliveredOrder, getOrders, shipOrder } from '../../State/Admin/Order/Action'
import { Avatar, AvatarGroup, Button, Card, CardHeader, Menu, MenuItem, Paper, Table, TableBody, TableCell, TableContainer, TableHead, TableRow } from '@mui/material'

const OrdersTable = () => {
    const dispatch = useDispatch()
    const { adminOrder } = useSelector(store => store)
    const [anchorEl, setAnchorEl] = React.useState([]);

    const handleClick = (event, index) => {
        const newAnchorEl = [...anchorEl]
        newAnchorEl[index] = event.currentTarget
        setAnchorEl(newAnchorEl);
    }
    const handleClose = (index) => {
        const newAnchorEl = [...anchorEl]
        newAnchorEl[index] = null
        setAnchorEl(newAnchorEl);

    };

    useEffect(() => {
        dispatch(getOrders())

    }, [adminOrder.confirmed, adminOrder.shipped, adminOrder.delivered, adminOrder.deletedOrder])

    console.log("Admin Orders", adminOrder.orders)

    const handleShippedOrder = (orderId, index) => {
        dispatch(shipOrder(orderId))
        handleClose(index)
    }

    const handleConfirmedOrder = (orderId, index) => {
        dispatch(confirmOrder(orderId))
        handleClose(index)

    }
    const handleDeliveredOrder = (orderId, index) => {
        dispatch(deliveredOrder(orderId))
        handleClose(index)

    }

    const handleDeleteOrder = (orderId) => {
        dispatch(deleteOrder(orderId))
    }

    return (
        <div className='p-10'>
            <Card
                className='mt-2 bg-[#1b1b1b]'

            >
                <CardHeader title="All Orders" />
                <TableContainer component={Paper}>
                    <Table sx={{ minWidth: 650 }} aria-label="simple table">
                        <TableHead>
                            <TableRow>
                                <TableCell>Image</TableCell>
                                <TableCell align="left">Title</TableCell>
                                <TableCell align="left">ID</TableCell>
                                <TableCell align="left">Price</TableCell>
                                <TableCell align="left">Status</TableCell>
                                <TableCell align="left">Update</TableCell>
                                <TableCell align="left">Option</TableCell>
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
                                    <TableCell align="left">
                                        <Button
                                            id="demo-positioned-button"
                                            aria-haspopup="true"
                                            aria-controls={`demo-positioned-menu-${row.id}`}
                                            aria-expanded={Boolean(anchorEl[index])}
                                            onClick={(e) => handleClick(e, index)}
                                        >
                                            Status
                                        </Button>
                                        <Menu
                                            id={`demo-positioned-menu-${row.id}`}
                                            aria-labelledby="demo-positioned-button"
                                            anchorEl={anchorEl[index]}
                                            open={Boolean(anchorEl[index])}
                                            onClose={() => handleClose(index)}
                                            anchorOrigin={{
                                                vertical: 'top',
                                                horizontal: 'left',
                                            }}
                                            transformOrigin={{
                                                vertical: 'top',
                                                horizontal: 'left',
                                            }}
                                        >
                                            <MenuItem onClick={() => handleConfirmedOrder(row.id, index)}>Confirmed</MenuItem>
                                            <MenuItem onClick={() => handleShippedOrder(row.id, index)}>Shipped</MenuItem>
                                            <MenuItem onClick={() => handleDeliveredOrder(row.id, index)}>Delivered</MenuItem>

                                        </Menu>
                                    </TableCell>
                                    <TableCell align="left">
                                        <Button
                                            onClick={() => handleDeleteOrder(row.id)}
                                            variant='outlined'
                                        > Delete</Button>
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

export default OrdersTable