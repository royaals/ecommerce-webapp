import axios from 'axios'
import { API_BASE_URL } from '../../config/apiConfig'
import { GET_USER_FAILURE, GET_USER_REQUEST, GET_USER_SUCCESS, LOGIN_FAILURE, LOGIN_REQUEST, LOGIN_SUCCESS, REGISTER_FAILURE, REGISTER_REQUEST, REGISTER_SUCCESS } from './ActionType'

const token = localStorage.getItem('jwt')

const registerRequest = () => ({ type: REGISTER_REQUEST })
const registerSuccess = (payload) => ({ type: REGISTER_SUCCESS, payload })
const registerFailure = (payload) => ({ type: REGISTER_FAILURE, payload })
export const register = (userData) => {
    return async (dispatch) => {
        dispatch(registerRequest())
        try {
            const response = await axios.post(`${API_BASE_URL}/auth/signup`, userData)
            const user = response.data;
            if (user.jwt) {
                localStorage.setItem('jwt', user.jwt)
            }
            console.log("user", user)

            dispatch(registerSuccess(user))
        } catch (error) {
            dispatch(registerFailure(error.message))
        }
    }
}

const loginRequest = () => ({ type: LOGIN_REQUEST })
const loginSuccess = (payload) => ({ type: LOGIN_SUCCESS, payload })
const loginFailure = (payload) => ({ type: LOGIN_FAILURE, payload })
export const login = (userData) => {
    return async (dispatch) => {
        dispatch(loginRequest())
        try {
            const response = await axios.post(`${API_BASE_URL}/auth/signin`, userData)
            const user = response.data;
            if (user.jwt) {
                localStorage.setItem('jwt', user.jwt)
            }
            console.log("user", user)

            dispatch(loginSuccess(user))
        } catch (error) {
            dispatch(loginFailure(error.message))
        }
    }
}


const getUserRequest = () => ({ type: GET_USER_REQUEST })
const getUserSuccess = (payload) => ({ type: GET_USER_SUCCESS, payload })
const getUserFailure = (payload) => ({ type: GET_USER_FAILURE, payload })
export const getUser = (jwt) => {
    return async (dispatch) => {
        dispatch(getUserRequest())
        try {
            const response = await axios.get(`${API_BASE_URL}/api/users/profile`, {
                headers: {
                    Authorization: `Bearer ${jwt}`
                }
            })
            const user = response.data;
            console.log("user", user)
            dispatch(getUserSuccess(user))
        } catch (error) {
            dispatch(getUserFailure(error.message))
        }
    }
}


export const logout = () => {
    return (dispatch) => {
        dispatch({ type: 'LOGOUT', payload: null })
        localStorage.clear()
    }
}