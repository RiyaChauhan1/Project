import { useLocation } from 'react-router'
import { useEffect, useState } from 'react'
import { useNavigate } from 'react-router'
import { Link } from 'react-router-dom'

const Payment = ( ) => {
  const { userId, firstName, lastName } = sessionStorage
  const { state } = useLocation()
  const navigate = useNavigate()
  const { price } = sessionStorage

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
        
    console.log(state)
    sessionStorage['passengerId'] = state.passengerId
    
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
        <div className="row">
            <div className="col"></div>
            <div className="col">
              <div className="form">
                <div className="mb-3">
                  <label htmlFor="" className="label-control">
                 Ticket price
                  </label>
                  <input value={ price }
                    // onChange={(e) => {
                    //     setPassengerName(e.target.value)
                    // }}
                    type="text"
                    className="form-control"
                  />
                </div>
    

                <div className="mb-3">
                <button type="button" onClick={() => {
                navigate('/Ticket')
              }} className="btn btn-primary">Pay</button>
                </div>
              </div>
            </div>
            <div className="col"></div>
          </div>
          </div>
    )
}
export default Payment