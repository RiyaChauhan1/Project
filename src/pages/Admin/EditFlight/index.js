import { useEffect, useState } from 'react'
import { Link } from 'react-router-dom'
import { useLocation } from 'react-router'
import { toast } from 'react-toastify'
import axios from 'axios'
import { useNavigate } from 'react-router'
import Navbar from '../../../components/Navebar'
const EditFlight= () =>
{
    const navigate = useNavigate()
    const { state } = useLocation()
    const [flightList, setFlightList] = useState([])
    const getFlights = () => {
        const url = `http://localhost:8080/flight/getAll`
        axios.get(url).then((response) => {
            const result = response.data
            if (result['status'] == 'success') {
              setFlightList(result['data'])
            } else {
              toast.error(result['error'])
            }
          })
        }
         //to call function to get list of flights
      useEffect(() => {
        getFlights()
        console.log('getting called')
      }, [])
         
    
      function deleteFlight (id) 
      {
        console.log(id)
        const url = `http://localhost:8080/flight/delete/${id}`
        axios.delete(url).then((response) => {
            const result = response.data
            if (result['status'] == 'success') {
              toast.success("flight deleted sucessfully ")
                window.location.reload()
              // navigate('/editflight')
            } else {
              toast.error(result['error'])
            }
          })

      }
return(
    <div>
  <Navbar></Navbar>
  <br/>
  <br/>
<h1><u>Flight List</u></h1>
<div class="d-grid gap-2 d-md-flex justify-content-md-end">
  <button class="btn btn-primary me-md-2" type="button"
  onClick={() => {
    navigate('/addflight')
  }}
  >Add Flight</button>
</div>
<br/>
<br/>


    <table class="table">
  <thead>
    <tr>
      <th scope="col">Airline-Id</th>
      <th scope="col">Flight Name</th>
      <th scope="col">Company name</th>
      <th scope="col">Economy seats</th>
      <th scope="col">Buisness seats</th>
      <th scope="col">First seats</th>
      <th scope="col">Checkin baggage capacity</th>
      <th scope="col">Cabin baggage capacity</th>
      <th scope="col"> </th>
      <th scope="col"> </th>
      </tr>
  </thead>
  <tbody>
    {flightList.map((flight) => 
      
    <tr> 
        
        <th scope="col">{flight.flightId}</th>
      <th scope="col">{flight.airlineName}</th>
      <th scope="col">{flight.companyName}</th>
      <th scope="col">{flight.economyClassSeats}</th>
      <th scope="col">{flight.buisnessClassSeats}</th>
      <th scope="col">{flight.firstClassSeats}</th>
      <th scope="col">{flight.checkinBaggageCapacity}</th>
      <th scope="col">{flight.cabinBaggageCapacity}</th>
      <th scope="col"><button type="button" onClick={() => {
                navigate('/modifyflight', { state: { flight: flight } })
              }} className="btn btn-primary">Edit</button></th>
      <th scope="col"><button type="button" onClick={()=>deleteFlight(flight.flightId)} className="btn btn-danger">Delete</button></th>
        
    </tr>)} 
    
    </tbody>
     </table>
     </div>
)
}
export default EditFlight