import { Avatar, Button, Card, CardHeader, Paper, Table, TableBody, TableCell, TableContainer, TableHead, TableRow } from '@mui/material'
import React, { useEffect } from 'react'
import { findProducts } from '../../State/Product/Action'
import { useDispatch, useSelector } from 'react-redux'

const ProductsTableView = () => {
    const dispatch = useDispatch()
    const { products } = useSelector(state => state)



    useEffect(() => {
        const data = {
            category: "mens_kurta",
            colors: [],
            sizes: [],
            minPrice: 0,
            maxPrice: 10000000,
            minDiscount: 0,
            sort: "price_low",
            pageNumber: 0,
            pageSize: 100,
            stock: ""
        }
        dispatch(findProducts(data))
    }, [products.deletedProduct])
    return (
        <div className='p-5  '>
            <Card
                className='mt-2 bg-[#1b1b1b]'

            >
                <CardHeader title="Recent Products" />
                <TableContainer component={Paper}>
                    <Table sx={{ minWidth: 650 }} aria-label="simple table">
                        <TableHead>
                            <TableRow>
                                <TableCell>Image</TableCell>
                                <TableCell align="left">Title</TableCell>
                                <TableCell align="left">Category</TableCell>
                                <TableCell align="left">Price</TableCell>
                                <TableCell align="left">Quantity</TableCell>
                            </TableRow>
                        </TableHead>
                        <TableBody>
                            {products?.products?.content?.slice(0, 7).map((row) => (
                                <TableRow
                                    key={row.id}
                                    sx={{ '&:last-child td, &:last-child th': { border: 0 } }}
                                >
                                    <TableCell align="left">
                                        <Avatar src={row.imageUrl}>
                                        </Avatar>
                                    </TableCell>
                                    <TableCell component="left" scope="row">
                                        {row.title}
                                    </TableCell>
                                    <TableCell align="left">{row.category.name}</TableCell>
                                    <TableCell align="left">{row.price}</TableCell>
                                    <TableCell align="left">{row.quantity}</TableCell>

                                </TableRow>
                            ))}
                        </TableBody>
                    </Table>
                </TableContainer>

            </Card>

        </div>
    )
}

export default ProductsTableView