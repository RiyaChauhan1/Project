
import { useLocation } from 'react-router'
import { useEffect, useState } from 'react'
import { Link } from 'react-router-dom'

import { toast } from 'react-toastify'
import axios from 'axios'
import { useNavigate } from 'react-router'
const ModifyRoute= ()=>
{
  const { state } = useLocation()
  const [routeId, setRouteId] = useState('')
  const [source, setSource] = useState('')
  const [destination, setDestination] = useState('')
  const navigate = useNavigate()
  useEffect(() => {
    const { route } = state
    setRouteId(route.routeId)
    setSource(route.source)
    setDestination(route.destination)
     
  }, [])

  const AddRoute = () => {
    if (routeId == 0) {
      toast.warning('Please enter Route id')
    } else if (source.length == 0) {
      toast.warning('Please enter Source')
    } else if (destination.length == 0) {
      toast.warning('Please  enter destination')
    }  else {
      const body = {
          routeId,
          source,
          destination,
      }

      // url to call the api
      const url = `http://localhost:8080/route/edit/${routeId}`

      // http method: post
      // body: contains the data to be sent to the API
      axios.put(url, body).then((response) => {
        // get the data from the response
        const result = response.data
        console.log(result)
        if (result['status'] == 'success') {
          toast.success('Route modified Sucessfully')

          // navigate to the signin page
          navigate('/editRoute')
        } else {
          toast.error(result['error'])
        }
      })
    }
  }

  return(
    <div>
    <h1>Edit Route Details</h1>

    <div className="row">
      <div className="col"></div>
      <div className="col">
        <div className="form">
          <div className="mb-3">
            <label htmlFor="" className="label-control">
               Route Id
            </label>
            <input
              value={routeId}
              readOnly
              type="text"
              className="form-control"
            />
          </div>

          <div className="mb-3">
            <label htmlFor="" className="label-control">
              Enter Source
            </label>
            <input
             value={source}
              onChange={(e) => {
                setSource(e.target.value)
              }}
              type="text"
              className="form-control"
            />
          </div>

          <div className="mb-3">
            <label htmlFor="" className="label-control">
              Enter Destination
            </label>
            <input
              value={destination}
              onChange={(e) => {
                setDestination(e.target.value)
              }}
              type="text"
              className="form-control"
            />
          </div>

          <div className="mb-3">
            
            <button onClick={AddRoute} className="btn btn-primary">
              Add Route
            </button>
          </div>
        </div>
      </div>
      <div className="col"></div>
    </div>
  </div>
      
      
  )
}
export default ModifyRoute