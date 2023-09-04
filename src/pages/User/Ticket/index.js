import { useEffect, useState } from 'react'
import { toast } from 'react-toastify'
import axios from 'axios'
import { useNavigate } from 'react-router'
import { Link } from 'react-router-dom'


const Ticket = ( ) => {
  const { userId, passengerId, scheduleId,seatType,firstName } = sessionStorage
    const [ticketDetails, setticketDetails] = useState("")
   // const [userId, setUserID] = useState("")

 // setUserID(id)
    const navigate = useNavigate()
    const genrateTicket = () => {
        const body = {
            passengerId,
            scheduleId,
            userId ,
           seatType 
          }
          const url = `http://localhost:8080/after/pay`
          axios.post(url, body).then((response) => {
        
            const result = response.data
            console.log(result)
            if (result['status'] == 'success') {
                setticketDetails(result['data'])
              toast.success('list of flights')
            } else {
              toast.error(result['error'])
            }
          })
        }

        const logoutUser = () => {
          // remove the logged users details from session storage
          sessionStorage.removeItem('id')
          sessionStorage.removeItem('firstName')
          sessionStorage.removeItem('lastName')
          sessionStorage.removeItem('loginStatus')
      
          // navigate to sign in component
          navigate('/signin')
        }

    useEffect( () => {
       genrateTicket()
    },[])

   return (
    
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
  <h2>Ticket</h2>
  <div class="container-fluid" >
  <div class="row justify-content-around">
    <div class="col-4">
    Airline name :<h4> {ticketDetails.companyName}</h4>
    </div>
    <div class="col-4">
      Flight id : <br/><h3><b>{ticketDetails.airlineName}</b></h3>
    </div>
  </div>
  <br/>
  <div class="row justify-content-around">
    <div class="col-4">
      From  :<b>{ticketDetails.source}</b>
    </div>
    <div class="col-4">
      To  : <b>{ticketDetails.destination}</b>
    </div>
  </div>
 

 <br/>
  <div class="row justify-content-around">
    <div class="col-4">
      Date : <br/>
      {ticketDetails.takeoffDate}
    </div>
    <div class="col-4">
      Time  :  <br/>
      {ticketDetails.takeoffTime}
    </div>
  </div>
  <br/>

  <div class="row justify-content-around">
    <div class="col-4">
      Passenger name : <br/>
      {ticketDetails.passengerName}
    </div>
    <div class="col-4">
     Seat no :  <br></br>  {ticketDetails.seatNo}
    </div>
  </div>
  <br/>


  <div class="row justify-content-around">
    <div class="col-4">
      Class  : {seatType}
     
    </div>
    <div class="col-4">
    
    </div>
  </div>
  
</div>

</div>

   )
}

export default Ticket