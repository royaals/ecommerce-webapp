import { api } from "../../../config/apiConfig";
import { CANCELLED_ORDER_FAILURE, CANCELLED_ORDER_REQUEST, CANCELLED_ORDER_SUCCESS, CONFIRM_ORDER_FAILURE, CONFIRM_ORDER_REQUEST, CONFIRM_ORDER_SUCCESS, DELETE_ORDER_FAILURE, DELETE_ORDER_REQUEST, DELETE_ORDER_SUCCESS, DELIVERED_ORDER_FAILURE, DELIVERED_ORDER_REQUEST, DELIVERED_ORDER_SUCCESS, GET_ORDERS_FAILURE, GET_ORDERS_REQUEST, GET_ORDERS_SUCCESS, SHIP_ORDER_FAILURE, SHIP_ORDER_REQUEST, SHIP_ORDER_SUCCESS } from "./ActionType";


export const getOrders = (reqData) => {
    return async (dispatch) => {
        dispatch({ type: GET_ORDERS_REQUEST })

        try {
            const { data } = await api.get(`/api/admin/orders`)
            dispatch({ type: GET_ORDERS_SUCCESS, payload: data })
        } catch (error) {
            dispatch({ type: GET_ORDERS_FAILURE, payload: error.message })
        }
    };
}

export const confirmOrder = (orderId) => {
    return async (dispatch) => {
        dispatch({ type: CONFIRM_ORDER_REQUEST })

        try {
            const { data } = await api.put(`/api/admin/orders/${orderId}/confirmed`)
            dispatch({ type: CONFIRM_ORDER_SUCCESS, payload: data })
        } catch (error) {
            dispatch({ type: CONFIRM_ORDER_FAILURE, payload: error.message })
        }
    };
}

export const shipOrder = (orderId) => {
    return async (dispatch) => {
        dispatch({ type: SHIP_ORDER_REQUEST })

        try {
            const { data } = await api.put(`/api/admin/orders/${orderId}/shipped`)
            dispatch({ type: SHIP_ORDER_SUCCESS, payload: data })
        } catch (error) {
            dispatch({ type: SHIP_ORDER_FAILURE, payload: error.message })
        }
    };
}

export const deliveredOrder = (orderId) => {
    return async (dispatch) => {
        dispatch({ type: DELIVERED_ORDER_REQUEST })

        try {
            const { data } = await api.put(`/api/admin/orders/${orderId}/delivered`)
            dispatch({ type: DELIVERED_ORDER_SUCCESS, payload: data })
        } catch (error) {
            dispatch({ type: DELIVERED_ORDER_FAILURE, payload: error.message })
        }
    };
}

export const cancelledOrder = (orderId) => {
    return async (dispatch) => {
        dispatch({ type: CANCELLED_ORDER_REQUEST })

        try {
            const { data } = await api.put(`/api/admin/orders/${orderId}/cancelled`)
            dispatch({ type: CANCELLED_ORDER_SUCCESS, payload: data })
        } catch (error) {
            dispatch({ type: CANCELLED_ORDER_FAILURE, payload: error.message })
        }
    };
}

export const deleteOrder = (orderId) => {
    return async (dispatch) => {
        dispatch({ type: DELETE_ORDER_REQUEST })

        try {
            const { data } = await api.delete(`/api/admin/orders/${orderId}/delete`)
            dispatch({ type: DELETE_ORDER_SUCCESS, payload: data })
        } catch (error) {
            dispatch({ type: DELETE_ORDER_FAILURE, payload: error.message })
        }
    };
}