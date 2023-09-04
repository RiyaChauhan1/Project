
import { useEffect, useState } from 'react'
import { Link } from 'react-router-dom'
import { toast } from 'react-toastify'
import axios from 'axios'
import { useNavigate } from 'react-router'
import Navbar from '../../../components/Navebar'
const AddPrice= () =>
{

    const [flightList, setFlightList] = useState([])
    const [routeList, setRouteList] = useState([])
    let [flightId, setFlightId] = useState("select flight")
    let [routeId, setRouteId] = useState("select route")
    const[businessClassPrice,setBusinessClassPrice]=useState('')
    const[economyClassPrice,setEconomyClassPrice]=useState('')
    const[firstClassPrice,setFirstClassPrice]=useState('')
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
          const addPrice = () =>
          {
              if(flightId ==null)
              console.log("please enter flight")
              
              const body = {
                flightId,
                  routeId,
                  businessClassPrice,
                  economyClassPrice,
                  firstClassPrice
              
                }
                const url = `http://localhost:8080/price/add`
    
                axios.post(url, body).then((response) => {
                  // get the data from the response
                  const result = response.data
                  console.log(result)
                  if (result['status'] == 'success') {
                    toast.success('Successfully price is assign to flight')
                    navigate('/priceList')
                  } else {
                    toast.error(result['error'])
                  }
                })
          }
return(
    <div>
              <Navbar></Navbar>
    <h1>Set Price for flight </h1>

    <div className="row">
      <div className="col"></div>
      <div className="col">
        <div className="form">
        <div className="col-12">
            <div className="dropdown"> select flight    :    
            <select onChange={handleFlightChange}> 
            <option value=" Select a flight"> -- Select a flight -- </option>
        {flightList.map((flight) => <option key={flight.flightId} value={flight.flightId}>{flight.airlineName}</option>)}
       
        </select>
         
        </div>
        </div>
        <br/>
            <br/>
            <div className="col-12"> select route    :    
            <select onChange={handleRouteChange}> 
            <option value=" Select a Route"> -- Select a Route -- </option>
        {routeList.map((route) => <option key={route.routeId} value={route.routeId}>{route.source} To {route.destination}</option>)}
       
        </select> 
        <br/>
        <br/>
        </div>

          <div className="mb-3">
            <label htmlFor="" className="label-control">
            setBusinessClassPrice
            </label>
            <input
              onChange={(e) => {
                setBusinessClassPrice(e.target.value)
              }}
              type="number"
              className="form-control"
            />
          </div>

          <div className="mb-3">
            <label htmlFor="" className="label-control">
            setEconomyClassPrice
            </label>
            <input
              onChange={(e) => {
                setEconomyClassPrice(e.target.value)
              }}
              type="number"
              className="form-control"
            />
          </div>

          <div className="mb-3">
            <label htmlFor="" className="label-control">
            setFirstClassPrice
            </label>
            <input
              onChange={(e) => {
                setFirstClassPrice(e.target.value)
              }}
              type="number"
              className="form-control"
            />
          </div>

        

          <div className="mb-3">
            <button onClick={addPrice} className="btn btn-primary">
              Add Pice
            </button>
          </div>
        </div>
      </div>
      <div className="col"></div>
    </div>
  </div>
)
}
export default AddPrice