
import { useLocation } from 'react-router'
import { useEffect, useState } from 'react'
import { Link } from 'react-router-dom'

import { toast } from 'react-toastify'
import axios from 'axios'
import { useNavigate } from 'react-router'
import Navbar from '../../../components/Navebar'
const ModifyFlight= ()=>
{
  const { state } = useLocation()
  const [flightId, setFlightId] = useState('')
  const [airlineName, setAirlineName] = useState('')
  const [companyName, setCompanyName] = useState('')
  const [economyClassSeats, setEconomyClassSeats] = useState('')
  const [buisnessClassSeats, setBuisnessClassSeats] = useState('')
  const [firstClassSeats, setFirstClassSeats] = useState('')
  const [checkinBaggageCapacity, setCheckinBaggageCapacity] = useState('')
  const [cabinBaggageCapacity, setCabinBaggageCapacity] = useState('')
 // const [flight, setFlight]=useLocation('')
 const navigate = useNavigate()
  useEffect(() => {
      const { flight } = state
      setFlightId(flight.flightId)
      setAirlineName(flight.airlineName)
      setCompanyName(flight.companyName)
      setEconomyClassSeats(flight.economyClassSeats)
      setBuisnessClassSeats(flight.buisnessClassSeats)
      setFirstClassSeats(flight.firstClassSeats)
      setCheckinBaggageCapacity(flight.checkinBaggageCapacity)
      setCabinBaggageCapacity(flight.cabinBaggageCapacity)
      
    }, [])
    const modifyFlight = () => 
    {
      if (airlineName.length == 0) {
        toast.warning('Please enter flight name')
      }  else if (companyName.length == 0) {
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
          flightId,
          airlineName,
          companyName,
          economyClassSeats,
          buisnessClassSeats,
          firstClassSeats,
          checkinBaggageCapacity,
          cabinBaggageCapacity
        }
  
        // url to call the api
        const url = `http://localhost:8080/flight/modify/${flightId}`
  
        // http method: post
        // body: contains the data to be sent to the API
        axios.put(url, body).then((response) => {
          const result = response.data
          if (result['status'] == 'success') {
            toast.success('successfully modified flight')
            navigate('/editflight')
          } else {
            toast.error(result['error'])
          }
        })
      }
       
  
      }
    return(
      <div>
              <Navbar></Navbar>
      <h1>Modify flight details </h1>

      <div className="row">
        <div className="col"></div>
        <div className="col">
          <div className="form">

          <div className="mb-3">
              <label htmlFor="" className="label-control">
                Flight Number
              </label>
              <input
              value={flightId}
                readOnly
                type="number"
                className="form-control"
              />
            </div>

            <div className="mb-3">
              <label htmlFor="" className="label-control">
                Flight Name
              </label>
              <input
               value={airlineName}
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
               value={companyName}
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
               value={economyClassSeats}
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
               value={buisnessClassSeats}
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
               value={firstClassSeats}
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
               value={checkinBaggageCapacity}
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
               value={cabinBaggageCapacity}
                onChange={(e) => {
                  setCabinBaggageCapacity(e.target.value)
                }}
                type="number"
                className="form-control"
              />
            </div>

            

           

          
              <button onClick={modifyFlight} className="btn btn-primary">
                Modify
              </button>
            </div>
          </div>
        </div>

  
      </div>
    )
}
export default ModifyFlight