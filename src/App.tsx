import { useState } from 'react'
import HomeView from './pages/HomeView'

function App() {
  const [count, setCount] = useState(0)

  return (
    <>
    <HomeView></HomeView>
    </>
  )
}

export default App
