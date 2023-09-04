import { useEffect, useState } from 'react'
import { toast } from 'react-toastify'
import axios from 'axios'
import { useNavigate } from 'react-router'
import { Link } from 'react-router-dom'

const FlightList = ( ) => {
  const { firstName } = sessionStorage
    const [flightList, setFlightList] = useState([])
    const navigate = useNavigate()
    const { source, destination, date,classType ,noOfSeat} = sessionStorage
 
    const findAllFlight = () => {

      const body = {
        source,
        destination,
        date,
        classType,
        noOfSeat
      }
      const url = `http://localhost:8080/searchFlight`
      axios.post(url, body).then((response) => {
    
        const result = response.data
        console.log(result)
        if (result['status'] == 'success') {
          setFlightList(result['data'])
          toast.success('list of flights')
        } else {
          toast.error(result['error'])
        }
      })
    }
    const logoutUser = () => {
      // remove the logged users details from session storage
      sessionStorage.removeItem('userId')
      sessionStorage.removeItem('firstName')
      sessionStorage.removeItem('lastName')
      sessionStorage.removeItem('loginStatus')
      sessionStorage.removeItem('source')
      sessionStorage.removeItem('destination')
      sessionStorage.removeItem('date')
      sessionStorage.removeItem('classType')
      sessionStorage.removeItem('noOfSeat')
      sessionStorage.removeItem('seatType')
  
      sessionStorage.removeItem('scheduleId')
      sessionStorage.removeItem('price')
  
      sessionStorage.removeItem('passengerId')
  
      // navigate to sign in component
      navigate('/signin')
    }
    

    useEffect( () => {
        findAllFlight()
    },[])

 return(
  <div>
  <div className="row">
  <div className="col">
      <div className="float-end">
        <div className="btn-group " role="group">
          <button
            id="btnGroupDrop1"
            type="button"
            className="btn btn-primary dropdown-toggle"
            data-bs-toggle="dropdown"
            aria-expanded="false"
          >
            Welcome {firstName}
          </button>
          <ul className="dropdown-menu" aria-labelledby="btnGroupDrop1">
            <li>
              <Link to="/Profile" className="dropdown-item">
                Profile
              </Link>
            </li>
            <li>
              <button onClick={() => {
                navigate('/Home')
              }} className="dropdown-item">Home
              </button>
            </li>
            <li>
                  <button onClick={() => {  navigate ('/upcomingBookings')}} className="dropdown-item">
                   Upcoming Bookings
                  </button>
                </li>

                <li>
                  <button onClick={() => {  navigate ('/completedBookings')}} className="dropdown-item">
                   Completed Bookings
                  </button>
                </li>

                <li>
                  <button onClick={() => {  navigate ('/cancelledBookings')}} className="dropdown-item">
                   Cancelled Bookings
                  </button>
                </li>
            <li>
              <button onClick={logoutUser} className="dropdown-item">
                Logout
              </button>
            </li>
          </ul>
        </div>
      </div>
    </div>
  </div>
 

  
  <br/>
  <br/>
<h1>Flight List</h1>


    <table class="table" >
    <thead>
    <tr>
    <th scope="col">Company name </th>
    
      <th scope="col">Source</th>
      <th scope="col">Destination</th>
      <th scope="col">Takeoff Date</th>
      <th scope="col">Takeoff time</th>
     
      <th scope="col">Landing time</th>

      <th scope="col">Price</th>
      <th scope="col">Avalable seat</th>
      <th scope="col"></th>
    
      </tr>
  </thead>
  <tbody>
    {flightList.map((flight) => <tr> 
      <th scope="col">{flight.companyName}</th>
      <th scope="col">{flight.source}</th>
      <th scope="col">{flight.destination}</th>
      <th scope="col">{flight.takeoffDate}</th>
      <th scope="col">{flight.takeoffTime}</th>
      
      <th scope="col">{flight.landingTime}</th>
      <th scope="col">{flight.price}</th>
      <th scope="col">{flight.avalable_Seat}</th>
     
      <th scope="col"><button type="button" onClick={() => {
                navigate('/Bookflight', { state: { sheduleId: flight.sheduleId ,price :flight.price } })
              }} className="btn btn-primary">book</button></th>
      
    </tr>)} 
    </tbody>
     </table>
</div>

     
    
 )
}

export default FlightList