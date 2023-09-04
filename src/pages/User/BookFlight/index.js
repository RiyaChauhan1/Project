import { Link } from 'react-router-dom'
import { useEffect, useState } from 'react'
import { useLocation } from 'react-router'
import { toast } from 'react-toastify'
import axios from 'axios'
import { useNavigate } from 'react-router'


const BookFlight = () => {
  const { userId, firstName, lastName } = sessionStorage
    const { state } = useLocation()

    const [name, setPassengerName] = useState('')
    const [dob, setDob] = useState('')
    const [email, setEmail] = useState('')
    const [adharCardNo, setAdharCardNo] = useState('')
    const [phoneNo, setPhoneNo] = useState('')

    
 
    const navigate = useNavigate()

    
    const addPassengerInfo = () => {

        const body = {
            name,
            dob,
            email,
            adharCardNo,
            phoneNo
        }
        const url = `http://localhost:8080/passenger/info`
        axios.post(url, body).then((response) => {
      
          const result = response.data
          console.log(result)
          if (result['status'] == 'success') {
            const { passengerId } = result['data']
            navigate('/Payment', { state: { passengerId: passengerId }} )
           
            toast.success('passenger informaion added succesfully')
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
        
        console.log(state)
        sessionStorage['scheduleId'] = state.sheduleId
        sessionStorage['price'] = state.price
      },[])

    return (
        <div>
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
          </div>
          <h1>Enter passenger Details</h1>
    
          <div className="row">
            <div className="col"></div>
            <div className="col">
              <div className="form">
                <div className="mb-3">
                  <label htmlFor="" className="label-control">
                  Passenger  Name
                  </label>
                  <input
                    onChange={(e) => {
                        setPassengerName(e.target.value)
                    }}
                    type="text"
                    className="form-control"
                  />
                </div>
    
                <div className="mb-3">
                  <label htmlFor="" className="label-control">
                    Phone no
                  </label>
                  <input
                    onChange={(e) => {
                        setPhoneNo(e.target.value)
                    }}
                    type="text"
                    className="form-control"
                  />
                </div>
    
                <div className="mb-3">
                  <label htmlFor="" className="label-control">
                    Email Address
                  </label>
                  <input
                    onChange={(e) => {
                      setEmail(e.target.value)
                    }}
                    type="text"
                    className="form-control"
                  />
                </div>
    
                <div className="mb-3">
                  <label htmlFor="" className="label-control">
                    Enter Date of birth
                  </label>
                  <input
                    onChange={(e) => {
                        setDob(e.target.value)
                    }}
                    type="date"
                    className="form-control"
                  />
                </div>
    
                <div className="mb-3">
                  <label htmlFor="" className="label-control">
                    Enter adhar card no
                  </label>
                  <input
                    onChange={(e) => {
                        setAdharCardNo(e.target.value)
                    }}
                    type="number"
                    className="form-control"
                  />
                </div>
    
                <div className="mb-3">
                  <button onClick={addPassengerInfo} className="btn btn-primary">
                    Add passenger info
                  </button>
                </div>
              </div>
            </div>
            <div className="col"></div>
          </div>
        </div>
      )
    }
    
    export default BookFlight
