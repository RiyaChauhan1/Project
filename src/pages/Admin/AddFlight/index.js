import './index.css'
import { useState } from 'react'
import { Link } from 'react-router-dom'
import './index.css'
import { toast } from 'react-toastify'
import axios from 'axios'
import { useNavigate } from 'react-router'

const AddFlight=()=>
{
 // const [flightId, setFlightId] = useState('')
    const [airlineName, setAirlineName] = useState('')
    const [companyName, setCompanyName] = useState('')
    const [economyClassSeats, setEconomyClassSeats] = useState('')
    const [buisnessClassSeats, setBuisnessClassSeats] = useState('')
    const [firstClassSeats, setFirstClassSeats] = useState('')
    const [checkinBaggageCapacity, setCheckinBaggageCapacity] = useState('')
    const [cabinBaggageCapacity, setCabinBaggageCapacity] = useState('')

  
    // used to navigate from one component to another
    const navigate = useNavigate()
  
    const addFlight = () => 
    {
      if (airlineName.length == 0) {
        toast.warning('Please enter flight name')
      // }  else if (flightId == 0) {
      //   toast.warning('Please enter company name')
      }else if (companyName.length == 0) {
        toast.warning('Please enter company name')
      } else if (economyClassSeats == 0) {
        toast.warning('Please enter valid economy seats')
      } else if (buisnessClassSeats == 0) {
        toast.warning('Please enter valid buisness class seats')
      } else if (firstClassSeats == 0) {
        toast.warning('Please enter valid first class seats')
      } else if (checkinBaggageCapacity == 0) {
        toast.warning('please enter valid checkin bagage capacity')
      }else if (cabinBaggageCapacity == 0) {
        toast.warning('Please enter valid cabin baggage capacity')
      } 
      else {
        const body = {
          // flightId,
          airlineName,
          companyName,
          economyClassSeats,
          buisnessClassSeats,
          firstClassSeats,
          checkinBaggageCapacity,
          cabinBaggageCapacity
        }
  
        // url to call the api
        const url = `http://localhost:8080/flight/add`
  
        // http method: post
        // body: contains the data to be sent to the API
        axios.post(url, body).then((response) => {
          // get the data from the response
          const result = response.data
          console.log(result)
          if (result['status'] == 'success') {
            toast.success('flight added sucessfully')
  
            // navigate to the signin page
            navigate('/editflight')
          } else {
            toast.error(result['error'])
          }
        })
      }
     

    }

    return (
        //copy code from boot strap and do some editing
        
            
        <div>
        <h1>Add Fllight details </h1>
  
        <div className="row">
          <div className="col"></div>
          <div className="col">
            <div className="form">

            {/* <div className="mb-3">
                <label htmlFor="" className="label-control">
                  Flight Number
                </label>
                <input
                  onChange={(e) => {
                    setFlightId(e.target.value)
                  }}
                  type="number"
                  className="form-control"
                />
              </div> */}

              <div className="mb-3">
                <label htmlFor="" className="label-control">
                  Flight Name
                </label>
                <input
                  onChange={(e) => {
                    setAirlineName(e.target.value)
                  }}
                  type="text"
                  className="form-control"
                />
              </div>
  
              <div className="mb-3">
                <label htmlFor="" className="label-control">
                  Company Name
                </label>
                <input
                  onChange={(e) => {
                    setCompanyName(e.target.value)
                  }}
                  type="text"
                  className="form-control"
                />
              </div>
  
              <div className="mb-3">
                <label htmlFor="" className="label-control">
                  Economy class seats capacity 
                </label>
                <input
                  onChange={(e) => {
                    setEconomyClassSeats(e.target.value)
                  }}
                  type="number"
                  className="form-control"
                />
              </div>
              <div className="mb-3">
                <label htmlFor="" className="label-control">
                  Buisness class seats capacity 
                </label>
                <input
                  onChange={(e) => {
                    setBuisnessClassSeats(e.target.value)
                  }}
                  type="number"
                  className="form-control"
                />
              </div>
              <div className="mb-3">
                <label htmlFor="" className="label-control">
                  First class seats capacity 
                </label>
                <input
                  onChange={(e) => {
                    setFirstClassSeats(e.target.value)
                  }}
                  type="number"
                  className="form-control"
                />
              </div>
              <div className="mb-3">
                <label htmlFor="" className="label-control">
                    checkin baggage capacity in( KG)
                </label>
                <input
                  onChange={(e) => {
                    setCheckinBaggageCapacity(e.target.value)
                  }}
                  type="number"
                  className="form-control"
                />
              </div>
              <div className="mb-3">
                <label htmlFor="" className="label-control">
                    cabin baggage capacity in (KG)
                </label>
                <input
                  onChange={(e) => {
                    setCabinBaggageCapacity(e.target.value)
                  }}
                  type="number"
                  className="form-control"
                />
              </div>
  
              
  
             
  
            
                <button onClick={addFlight} className="btn btn-primary">
                  Add Flight
                </button>
              </div>
            </div>
          </div>

    
        </div>

        
      
          

    )
}
export default AddFlight