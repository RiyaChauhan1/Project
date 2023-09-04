import { useEffect, useState } from 'react'
import { Link } from 'react-router-dom'
import { useLocation } from 'react-router'
import { toast } from 'react-toastify'
import axios from 'axios'
import { useNavigate } from 'react-router'
import Navbar from '../../../components/Navebar'
const PriceList= () =>
{
    const navigate = useNavigate()
    const { state } = useLocation()
    const [priceList, setPriceList] = useState([])
    const getPrice = () => {
        const url = `http://localhost:8080/price/getAll`
        axios.get(url).then((response) => {
            const result = response.data
            if (result['status'] == 'success') {
                setPriceList(result['data'])
            } else {
              toast.error(result['error'])
            }
          })
        }
         //to call function to get list of flights
      useEffect(() => {
        getPrice()
        console.log('getting called')
      }, [])
         
    
     
return(
    <div>
  <Navbar></Navbar>
  <br/>
  <br/>
<h1>Ticket Price List</h1>
<div class="d-grid gap-2 d-md-flex justify-content-md-end">
  <button class="btn btn-primary me-md-2" type="button"
  onClick={() => {
    navigate('/addPrice')
  }}
  >Add price</button>
</div>
<br/>
<br/>

    <table class="table">
  <thead>
    <tr>
      <th scope="col">Airline Name</th>
      <th scope="col">Source </th>
      <th scope="col">Destination</th>
      <th scope="col">businessClassPrice</th>
      <th scope="col">economyClassPrice</th>
      <th scope="col">firstClassPrice</th>
      <th scope="col">action 1</th>
      </tr>
  </thead>
  <tbody>
    {priceList.map((price) => <tr> 
      <th scope="col">{price.airlineName}</th>
      <th scope="col">{price.source}</th>
      <th scope="col">{price.destination}</th>
      <th scope="col">{price.businessClassPrice}</th>
      <th scope="col">{price.economyClassPrice}</th>
      <th scope="col">{price.firstClassPrice}</th>

      <th scope="col"><button type="button" onClick={() => {
                navigate('/modifyprice', { state: { price: price } })
              }} className="btn btn-primary">Edit</button></th>
      
        
    </tr>)} 
    </tbody>
     </table>
     </div>
)
}
export default PriceList