import { useEffect, useState } from 'react'
import { Link } from 'react-router-dom'
import { useLocation } from 'react-router'
import { toast } from 'react-toastify'
import axios from 'axios'
import { useNavigate } from 'react-router'
import Navbar from '../../../components/Navebar'
const EditRoute= ()=>
{
    const navigate = useNavigate()
    const { state } = useLocation()
    const [routeList, setRouteList] = useState([])
    const getRouts = () => {
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
        useEffect(() => {
            getRouts()
            console.log('getting called')
          }, [])

          function deleteRoute (id) 
          {
            console.log(id)
            const url = `http://localhost:8080/route/delete/${id}`
            axios.delete(url).then((response) => {
                const result = response.data
                if (result['status'] == 'success') {
                  toast.success("route deleted sucessfully ")
                    window.location.reload()
                  // navigate('/editflight')
                } else {
                  toast.error(result['error'])
                }
              })
    
          }


    return(
        <div>
  <Navbar></Navbar>
  <br/>
  <br/>
<h1>Route List</h1>
<div class="d-grid gap-2 d-md-flex justify-content-md-end">
  <button class="btn btn-primary me-md-2" type="button"
  onClick={() => {
    navigate('/addroute')
  }}
  >Add Route</button>
</div>
<br/>
<br/>


    <table class="table">
  <thead>
    <tr>
      <th scope="col">Route Id</th>
      <th scope="col">Source</th>
      <th scope="col">Destination</th>

      <th scope="col">action 1</th>
      <th scope="col">action 2</th>
      </tr>
  </thead>
  <tbody>
    {routeList.map((route) => <tr> 
        <th scope="col">{route.routeId}</th>
      <th scope="col">{route.source}</th>
      <th scope="col">{route.destination}</th>
 
      <th scope="col"><button type="button" onClick={() => {
                navigate('/modifyroute', { state: { route: route } })
              }} className="btn btn-primary">Edit</button></th>
      <th scope="col"><button type="button" onClick={()=>deleteRoute(route.routeId)} className="btn btn-danger">Delete</button></th>
        
    </tr>)} 
    </tbody>
     </table>
     </div>
    )
}
export default EditRoute