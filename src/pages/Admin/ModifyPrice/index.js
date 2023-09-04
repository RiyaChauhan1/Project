
import { useLocation } from 'react-router'
import { useEffect, useState } from 'react'
import { Link } from 'react-router-dom'

import { toast } from 'react-toastify'
import axios from 'axios'
import { useNavigate } from 'react-router'
const ModifyPrice= ()=>
{
  const { state } = useLocation()
  const [priceId, setPriceId] = useState('')
  const [airlineName, setAirlineName] = useState('')
  const [source, setSource] = useState('')
  const [destination, setDestination] = useState('')
  const [businessClassPrice, setBusinessClassPrice] = useState('')
  const [economyClassPrice, setEconomyClassPrice] = useState('')
  const [firstClassPrice, setFirstClassPrice] = useState('')
  const navigate = useNavigate()
  useEffect(() => {
    const { price } = state

    setPriceId(price.priceId)
    setAirlineName(price.airlineName)
    setSource(price.source)
    setDestination(price.destination)
    setBusinessClassPrice(price.businessClassPrice)
    setEconomyClassPrice(price.economyClassPrice)
    setFirstClassPrice(price.firstClassPrice) 
    console.log(priceId);

  }, [])

  

  const ModifyPrices = () => {
     if (source.length == 0) {
      toast.warning('Please enter Source')
    } else if (destination.length == 0) {
      toast.warning('Please  enter destination')
    }  else {
      const body = {

          businessClassPrice,
          economyClassPrice,
          firstClassPrice

      }

      // url to call the api
      console.log(priceId);
      const url = `http://localhost:8080/price/edit/${priceId}`

      // http method: post
      // body: contains the data to be sent to the API
      axios.put(url, body).then((response) => {
        // get the data from the response
        const result = response.data
        console.log(result)
        if (result['status'] == 'success') {
          toast.success(' price modified Sucessfully')

          // navigate to the signin page
          navigate('/priceList')
        } else {
          toast.error(result['error'])
        }
      })
    }
  }

  return(
    <div>
    <h1>Edit Price Details</h1>

    <div className="row">
      <div className="col"></div>
      <div className="col">
        <div className="form">
          <div className="mb-3">
            <label htmlFor="" className="label-control">
            airlineName
            </label>
            <input
              value={airlineName}
              readOnly
              type="text"
              className="form-control"
            />
          </div>

          <div className="mb-3">
            <label htmlFor="" className="label-control">
            source
            </label>
            <input
             value={source}
             readOnly
              type="text"
              className="form-control"
            />
          </div>

          <div className="mb-3">
            <label htmlFor="" className="label-control">
            destination
            </label>
            <input
             value={destination}
             readOnly
              type="text"
              className="form-control"
            />
          </div>

          <div className="mb-3">
            <label htmlFor="" className="label-control">
            setBusinessClassPrice
            </label>
            <input
              value={businessClassPrice}
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
              value={economyClassPrice}
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
              value={firstClassPrice}
              onChange={(e) => {
                setFirstClassPrice(e.target.value)
              }}
              type="number"
              className="form-control"
            />
          </div>
       

          <div className="mb-3">
            
            <button onClick={ModifyPrices} className="btn btn-primary">
              Modify price
            </button>
          </div>
        </div>
      </div>
      <div className="col"></div>
    </div>
  </div>
      
      
  )
}
export default ModifyPrice