import { api } from "../../config/apiConfig";
import { CREATE_ORDER_FAILURE, CREATE_ORDER_REQUEST, CREATE_ORDER_SUCCESS, GET_ORDER_BY_ID_REQUEST, GET_ORDER_BY_ID_SUCCESS, GET_ORDER_BY_ID_FAILURE } from "./ActionType";

export const createOrder = (reqData) => {
    return async (dispatch) => {
        dispatch({ type: CREATE_ORDER_REQUEST })
        console.log(reqData)
        try {
            const { data } = await api.post(`/api/orders`, reqData.address)
            if (data.id) {
                reqData.navigate({ search: `step=3&order_id=${data.id}` });
            }
            console.log('create order', data)
            dispatch({ type: CREATE_ORDER_SUCCESS, payload: data })
        } catch (error) {
            dispatch({ type: CREATE_ORDER_FAILURE, payload: error.message })
        }
    };
}

export const getOrderById = (orderId) => {
    return async (dispatch) => {
        dispatch({ type: GET_ORDER_BY_ID_REQUEST })

        try {
            const { data } = await api.get(`/api/orders/${orderId}`)
            dispatch({ type: GET_ORDER_BY_ID_SUCCESS, payload: data })
        } catch (error) {
            dispatch({ type: GET_ORDER_BY_ID_FAILURE, payload: error.message })
        }
    };
}
