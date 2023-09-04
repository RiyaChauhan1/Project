import './index.css'
import { useEffect, useState } from 'react'
import { Link } from 'react-router-dom'
import { toast } from 'react-toastify'
import axios from 'axios'
import { useNavigate } from 'react-router'
import Navbar from '../../../components/Navebar'
const Schedule= ()=>
{
    const [flightList, setFlightList] = useState([])
    const [routeList, setRouteList] = useState([])
    let [flightId, setFlightId] = useState("select flight")
    let [routeId, setRouteId] = useState("select route")
    
    const[takeoffDate,setTakeoffDate]=useState('')
    const[landingDate,setLandingDate]=useState('')
    const[takeoffTime,setTakeoffTime]=useState('')
    const[landingTime,setLandingTime]=useState('')
    const navigate = useNavigate()

    let handleFlightChange = (e) => {
      setFlightId(e.target.value)
      }
      let handleRouteChange = (e) => {
        setRouteId(e.target.value)
      }
   //get llist of fllight from datase
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
    //to call function to get list of flights
      useEffect(() => {
        getFlights()
        console.log('getting called')
      }, [])
      //to calll function to get list of routes
      useEffect(() => {
        getRoute()
        console.log('getting called')
      }, [])
        //after click on signup button
        const scheduleFlight = () =>
        {
            if(flightId ==null)
            console.log("please enter flight")
            
            const body = {
              flightId,
                routeId,
                takeoffDate,
               landingDate,
               takeoffTime,
               landingTime
              }
              const url = `http://localhost:8080/schedule/add`
  
              // http method: post
              // body: contains the data to be sent to the API
              axios.post(url, body).then((response) => {
                // get the data from the response
                const result = response.data
                console.log(result)
                if (result['status'] == 'success') {
                  toast.success('Successfully schedule the fllilght')
        
                 //  navigate to the signin page
                  navigate('/editschedule')
                } else {
                  toast.error(result['error'])
                }
              })
        }
      
    return(

        <div>
                <Navbar></Navbar>
            <h1> Schedule flight</h1>
            <div class="d-grid gap-2 d-md-flex justify-content-md-end">
  <button class="btn btn-primary me-md-2" type="button"
  onClick={() => {
    navigate('/addPrice')
  }}
  >Set price for route</button>
</div>
<br/>
<br/>
            <br/>

            <div className="col-12">
            <div className="dropdown"> select flight    :    
            <select onChange={handleFlightChange}> 
            <option value=" Select a flight"> -- Select a flight -- </option>
        {flightList.map((flight) => <option key={flight.flightId} value={flight.flightId}>{flight.flightId} :- {flight.airlineName}</option>)}
       
        </select>
         
        </div>
        </div>
        
        <br/>
            <br/>
            <div className="col-12"> select route    :    
            <select onChange={handleRouteChange}> 
            <option value=" Select a Route"> -- Select a Route -- </option>
        {routeList.map((route) => <option key={route.routeId} value={route.routeId}>{route.routeId} :- {route.source} To {route.destination}</option>)}
       
        </select> 
        </div>
        <br/>
        <br/>

        <div className="col-12">
<label htmlFor="" className="form-label">take off date</label>
<input onChange={(e)=>
{
  setTakeoffDate(e.target.value)
}} type="date" className="form-control" id="" placeholder=""/>
</div>
<div className="col-12">
<label htmlFor="" className="form-label">take off time</label>
<input onChange={(e)=>
{
  setTakeoffTime(e.target.value)
}} type="time" className="form-control" id="" placeholder=""/>
</div>
<br/>
        <br/>

        <div className="col-12">
      <label htmlFor="" className="form-label">landing date</label>
      <input onChange={(e)=>
      {
    setLandingDate(e.target.value)
      }} type="date" className="form-control" id="" placeholder=""/>
       </div>

       <div className="col-12">
      <label htmlFor="" className="form-label">landing time</label>
      <input onChange={(e)=>
      {
    setLandingTime(e.target.value)
      }} type="time" className="form-control" id="" placeholder=""/>
       </div>
       <div className="mb-3">
                <button onClick={scheduleFlight} className="btn btn-primary">
                  Schedule
                </button>
              </div>




        </div>
    )
}
export default Schedule