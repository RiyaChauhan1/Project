import { useLocation } from 'react-router'
import { useEffect, useState } from 'react'
import { Link } from 'react-router-dom'

import { toast } from 'react-toastify'
import axios from 'axios'
import { useNavigate } from 'react-router'
import Navbar from '../../../components/Navebar'

const ModifySchedule= () =>
{
    const { state } = useLocation()
    let [scheduleId, setScheduleId] = useState("select route")
    const [airlineName, setAirlineName] = useState('')
    const [source, setSource] = useState('')
    const [destination, setDestination] = useState('')
    const[takeoffDate,setTakeoffDate]=useState('')
    const[landingDate,setLandingDate]=useState('')
    const[takeoffTime,setTakeoffTime]=useState('')
    const[landingTime,setLandingTime]=useState('')
    const navigate = useNavigate()
    useEffect(() => {
        const { schedule } = state
        setScheduleId(schedule.scheduleId)
        setAirlineName(schedule.airlineName)
        setSource(schedule.source)
        setDestination(schedule.destination)
        setTakeoffDate(schedule.takeoffDate)
        setLandingDate(schedule.landingDate)
        setTakeoffTime(schedule.takeoffTime)
        setLandingTime(schedule.landingTime)
        
      }, [])
   const   modifyScheduele=()=>{
    const body = {
        scheduleId,
        airlineName,
        takeoffDate,
        landingDate,
        takeoffTime,
        landingTime
      }
      const url = `http://localhost:8080/schedule/modify/${scheduleId}`
      axios.put(url, body).then((response) => {
        const result = response.data
        if (result['status'] == 'success') {
          toast.success('successfully modified schedule')
          navigate('/editschedule')
        } else {
          toast.error(result['error'])
        }
      })
    }

      

return(
    <div>
           <div className="mb-3">
              <label htmlFor="" className="label-control">
                Airline name
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

        
<div className="col-12">
<label htmlFor="" className="form-label">take off date</label>
<input
value={takeoffDate}
 onChange={(e)=>
{
  setTakeoffDate(e.target.value)
}} type="date" className="form-control" id="" placeholder=""/>
</div>
<div className="col-12">
<label htmlFor="" className="form-label">take off time</label>
<input
value={takeoffTime}
onChange={(e)=>
{
  setTakeoffTime(e.target.value)
}} type="time" className="form-control" id="" placeholder=""/>
</div>
<br/>
        <br/>
        
        <div className="col-12">
      <label htmlFor="" className="form-label">landing date</label>
      <input
      value={landingDate}
      onChange={(e)=>
      {
    setLandingDate(e.target.value)
      }} type="date" className="form-control" id="" placeholder=""/>
       </div>

       <div className="col-12">
      <label htmlFor="" className="form-label">landing time</label>
      <input
      value={landingTime}
      onChange={(e)=>
      {
    setLandingTime(e.target.value)
      }} type="time" className="form-control" id="" placeholder=""/>
       </div>
       <div className="mb-3">
                <button onClick={modifyScheduele} className="btn btn-primary">
                  Schedule
                </button>
              </div>

    </div>
)
}
export default ModifySchedule