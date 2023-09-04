import { useNavigate, useLocation } from "react-router"
import { useState, useEffect } from "react"
import { URL } from "../../../../config"
import axios from "axios"
import { toast } from "react-toastify"
import './index.css'

// import Bookings from '../../components/bookings'


const ShowUpcomingBookings = () =>{

//get logged in users information
const { userId, firstName, lastName }= sessionStorage
const navigate= useNavigate()
 const state={ useLocation }

const [bookings, setBookings] =useState([])

// make a call to the search api to get the results
const getBookings = () => {
  
    const url = `${URL}/bookings/upcoming/${userId}`
    axios.post(url).then((response) =>
   {
      const result = response.data
      if (result['status'] == 'success') {
        console.log("ala")
        setBookings(result['data'])
      } else {
        toast.error(result['error'])
      }
      })
    }

    // load the data in the beginning
  useEffect(() => {
    getBookings()
    console.log('getting called')
  }, [])


  const home = () => {
    // sessionStorage['id'] = id
    // sessionStorage['firstName'] = firstName
    // sessionStorage['lastName'] = lastName
    // sessionStorage['loginStatus'] = 1

    navigate('/home')
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

  function cancelBooking (id) 
  {
    console.log(id)
    const url = `http://localhost:8080/bookings/cancel/${id}`
    axios.put(url).then((response) => {
        const result = response.data
        if (result['status'] == 'success') {
          toast.success("flight cancelled sucessfully ")
            window.location.reload()
          
        } else {
          toast.error(result['error'])
        }
      })
    }

    return (
      <div>
       <br/>
       <br/>
        <h1 class="title">Upcoming Bookings</h1>
        <div className="row" >
        <div className="col"></div>
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
              <button onClick={home} className="dropdown-item">
                    Home
                  </button>
                </li>
                <li>
                  <a className="dropdown-item">Profile</a>
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
      
        {/* <div className="row" style={{ marginTop: '20px', marginBottom: '20px' }}>
        <div className="col">
          {bookings.map((booking) => 
            <h2>{booking.source}</h2>

            //  <Bookings booking={booking} />
          )}
        </div>
      </div> */}

<br/>
<br/>



    <table class="table" border="2">
  <thead class="table-success">
    <tr>
    <th scope="col">Booking No</th>
    <th scope="col">Passenger Name</th>
    <th scope="col">Seat No</th>
    <th scope="col">Company Name </th>
    <th scope="col">Airline Name </th>
      <th scope="col">Source</th>
      <th scope="col">Destination</th>
      <th scope="col">Takeoff Date</th>
      <th scope="col">Takeoff time</th>
      <th scope="col">Landing Date</th>
      <th scope="col">Landing time</th>
      <th scope="col">Price</th>
      <th scope="col">BookingStatus</th>
   
     
      </tr>
  </thead>
  <tbody>
    {bookings.map((booking) => {
   if(booking.bookingStatus == 'Booked')
   return(
    <tr> 
      <th scope="col">{booking.bookingNo}</th>
      <th scope="col">{booking.passengerName}</th>
      <th scope="col">{booking.seatNo}</th>
      <th scope="col">{booking.companyName}</th>
      <th scope="col">{booking.airlineName}</th>
      <th scope="col">{booking.source}</th>
      <th scope="col">{booking.destination}</th>
      <th scope="col">{booking.takeoffDate}</th>
      <th scope="col">{booking.takeoffTime}</th>
      <th scope="col">{booking.landingDate}</th>
      <th scope="col">{booking.landingTime}</th>
      <th scope="col">{booking.totalPrice}</th>
      <th scope="col">{booking.bookingStatus}</th>
     
     
      <th scope="col"><button type="button" onClick={() => 
               cancelBooking(booking.bookingNo)
              }className="btn btn-danger">Cancel</button></th>
      
            </tr>)})} 
    </tbody>
     </table>
     </div>
            
              

    )
}


export default ShowUpcomingBookings