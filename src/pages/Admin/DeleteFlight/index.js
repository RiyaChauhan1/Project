
import { useLocation } from 'react-router'
import { useEffect, useState } from 'react'
import { Link } from 'react-router-dom'

import { toast } from 'react-toastify'
import axios from 'axios'
import { useNavigate } from 'react-router'
const DeleteFlight= () =>
{
    const { state } = useLocation()
    const [flightNo, setFlightNo] = useState('')
    const navigate = useNavigate()
    useEffect(() => {
        const { flight } = state
        setFlightNo(flight.flightNo)
               
      }, [])

return(
    <div><h1>In Delete flight page</h1> </div>
)
}
export default DeleteFlight