import axios from "axios";

const api = axios.create({
    baseURL: process.env.NEXT_PUBLIC_API_URL,
    timeout: 5000,
})

api.interceptors.response.use(
    response => response,
    error => {
        console.error("Erro na API: ", error.response?.data || error.message)
        return Promise.reject(error)
    }
)

export default api
