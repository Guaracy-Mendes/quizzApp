const prod = {
    BACKEND_BASE_URL: window.location.origin + '/api/v1',
}
  
const local = {
    BACKEND_BASE_URL: 'http://localhost:8080/api/v1',
}

export const config = process.env.NODE_ENV === 'development' ? local : prod