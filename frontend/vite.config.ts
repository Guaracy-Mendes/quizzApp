import { defineConfig, loadEnv } from 'vite'
import react from '@vitejs/plugin-react'

// https://vitejs.dev/config/
export default defineConfig(({ mode }) => {
  const env = loadEnv(mode, process.cwd(), '')
  
  console.log('Current mode is ' + env.VITE_API_PATH_VERSION)

  return {
    plugins: [
      react()
    ],
    server: {
      port: 3000,
      proxy: {
        [env.VITE_API_PATH_VERSION]: {
          target: 'http://localhost:8080',
          changeOrigin: true
        }
      }
    },
  }
})

