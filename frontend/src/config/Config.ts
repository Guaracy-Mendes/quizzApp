const apiPath = import.meta.env.VITE_API_PATH_VERSION;

const prod = {
    BACKEND_BASE_URL: window.location.origin + apiPath,
}
  
const local = {
    BACKEND_BASE_URL: 'http://localhost:8080' + apiPath,
}

    console.log('Current mode is ' + import.meta.env.MODE);

export const config = import.meta.env.MODE === 'development' ? local : prod