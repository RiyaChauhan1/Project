
import { useEffect, useState } from 'react'
import { Link } from 'react-router-dom'
import { toast } from 'react-toastify'
import axios from 'axios'
import { useNavigate } from 'react-router'
import { useLocation } from 'react-router'
import Navbar from '../../../components/Navebar'

const EditSchedule= () =>
{
  const navigate = useNavigate()
  const { state } = useLocation()
    const [scheduleList, setScheduleList] = useState([])
    const getSchedule = () => {
        const url = `http://localhost:8080/schedule/get`
        axios.get(url).then((response) => {
            const result = response.data
            if (result['status'] == 'success') {
              setScheduleList(result['data'])
            } else {
              toast.error(result['error'])
            }
          })
        }
        useEffect(() => {
            getSchedule()
            console.log('getting called')
          }, [])

          function deleteSchedule (id) 
          {
            console.log(id)
            const url = `http://localhost:8080/schedule/delete/${id}`
            axios.delete(url).then((response) => {
                const result = response.data
                if (result['status'] == 'success') {
                  toast.success("schedule deleted sucessfully ")
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
<h1>Flight Schedule</h1>
<div class="d-grid gap-2 d-md-flex justify-content-md-end">
  <button class="btn btn-primary me-md-2" type="button"
  onClick={() => {
    navigate('/addschedule')
  }}
  >Add Schedule</button>
</div>
<br/>
<br/>

    <table class="table">
  <thead>
    <tr>
      <th scope="col">Airline Name</th>
      <th scope="col">source </th>
      <th scope="col">Destination</th>
      <th scope="col">takeoffDate</th>
      <th scope="col">takeoffTime</th>
      <th scope="col">landingDate</th>
      <th scope="col">landingTime</th>
      <th scope="col">action 1</th>
      <th scope="col">action 2</th>
      </tr>
  </thead>
  <tbody>
    {scheduleList.map((schedule) => <tr> 
      <th scope="col">{schedule.airlineName}</th>
      <th scope="col">{schedule.source}</th>
      <th scope="col">{schedule.destination}</th>
      <th scope="col">{schedule.takeoffDate}</th>
      <th scope="col">{schedule.takeoffTime}</th>
      <th scope="col">{schedule.landingDate}</th>
      <th scope="col">{schedule.landingTime}</th>
      <th scope="col"><button type="button" onClick={() => {
                navigate('/modifyschedule', { state: { schedule: schedule } })
              }} className="btn btn-primary">Edit</button></th>
       <th scope="col"><button type="button" onClick={()=>deleteSchedule(schedule.scheduleId)} className="btn btn-danger">Delete</button></th>
        
    </tr>)} 
    </tbody>
     </table>
     </div>
)
}
export default EditSchedule