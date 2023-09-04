import { useNavigate } from 'react-router'
import { useState } from 'react'
import { toast } from 'react-toastify'
import { Link } from 'react-router-dom'
import axios from 'axios'
import { useEffect } from 'react'


 const Serch = ()  => {

    const { userId, firstName, lastName } = sessionStorage

    const [routeList, setRouteList] = useState([])
    let [source, setSource] = useState('select source')
   //let [routeId, setRouteId] = useState("select route")
    const [destination, setDestination] = useState('select route')
    const [date, setDate] = useState('')
    const [classType, setClassType] = useState('')
    const [noOfSeat, setNoOfSeat] = useState('')
   


    const navigate = useNavigate()

    let handleSourceChange = (e) => {
      setSource(e.target.value)
    }
    let handleDestinationChange = (e) => {
      setDestination(e.target.value)
    }


    const getRoute = () => {
      const url = `http://localhost:8080/route/getAll`
      axios.get(url).then((response) => {
          const result = response.data
          if (result['status'] == 'success') {
            setRouteList(result['data'])
          } else {
            toast.error(result['error'])
          }
        })
      }
      //to calll function to get list of routes
      useEffect(() => {
        getRoute()
        console.log('getting called')
      }, [])

    const SearchFlight = (props) => {

      if (source.length < 3 || source.length > 15) {
        console.log(source)
        toast.warning('Please enter source')
      } else 
      if (destination.length < 3 || destination.length > 15) {
        toast.warning('Please enter destination')
        console.log(destination)
      } else if (date.length === 0) {
        toast.warning('Please enter date')
      } else if (classType.length === 0) {
        toast.warning('Please enter class type')
      } 
      // else if (noOfSeat != 1) {
      //   toast.warning('Please enter 1 ')
      // } 
      else {

        setNoOfSeat(1)

        // persist the logged in user's information for future use
        sessionStorage['source'] = source
        sessionStorage['destination'] = destination
        sessionStorage['date'] = date
        sessionStorage['classType'] = classType
        sessionStorage['noOfSeat'] = noOfSeat
        sessionStorage['seatType'] = classType
        
        navigate('/FlightList')
        
     
    }

    }
    const upcomingBooking = () => {

        navigate ('/upcomingBookings')
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
    
    
  
   return (
    <div>
      <h1>Home</h1>

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
                    profile
                  </Link>
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
                {/* <li>
                <button onClick={upcomingBooking} className="dropdown-item">
                    Upcoming Bookings
                    </button>
                </li> */}
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
             
              <div className="col-12"> Select Source     <br/>   
              <select onChange={handleSourceChange}> 
                <option value=" Select a Route"> -- Select a source -- </option>
                {routeList.map((route) => <option key={route.source} value={route.source}>{route.source}  </option>)}
       
              </select> 
            </div>
        

            </div>

            <div className="mb-3">
            <div className="col-12"> Select Destination       
            <select onChange={handleDestinationChange}> 
            <option value=" Select a Route"> -- Select a Destination -- </option>
        {routeList.map((route) => <option key={route.destination} value={route.destination}>{route.destination}  </option>)}
       
        </select> 
        </div>
            </div>

            <div className="mb-3">
              <label htmlFor="" className="label-control">
                Date
              </label>
              <input
                onChange={(e) => {
                  setDate(e.target.value)
                }}
                type="date"
                className="form-control"
              />
            </div>

            <div className="mb-3">
              <label htmlFor="" className="label-control">
                Seat Type
              </label>
              <input
                onChange={(e) => {
                  setClassType(e.target.value)
                }}
                type="test"
                className="form-control"
              />
            </div>

            {/* <div className="mb-3">
              <label htmlFor="" className="label-control">
                noOfSeat
              </label>
              <input
              value={1}
                onChange={(e) => {
                  setNoOfSeat(1)
              
                }}
                type="number"
                className="form-control"
              />
            </div> */}

          
            <div className="mb-3">
              {/* <div>
                Already have an account? <Link to="/signin">Signin here.</Link>
              </div> */}
              <button onClick={SearchFlight} className="btn btn-primary">
                Search
              </button>
            </div>
          </div>
        </div>
        <div className="col"></div>
      </div>
    </div>
    )
 }
  
 

export default Serch
