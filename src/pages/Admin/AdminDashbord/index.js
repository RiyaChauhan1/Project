import { useNavigate } from 'react-router'
import Navbar from '../../../components/Navebar'

const AdminDashbord= () =>
{
    const navigate = useNavigate()
    const { id, firstName, lastName } = sessionStorage
   
    const toAddFlight =()=>
    {
        navigate('/addFlight')
    }
    const toAddRoute =()=>
    {
        navigate('/addRoute')
    }
    const scheduleFlight =()=>
    {
        navigate('/addSchedule')
    }
    const toViewFlight =()=>
    {
        navigate('/editflight')
    }
    const toViewRoute =()=>
    {
        navigate('/editRoute')
    }
    const toViewSchedule =()=>
    {
        navigate('/editSchedule')
    }
    const toSetPrice =()=>
    {
        navigate('/addPrice')
    }
    const toViewPrice =()=>
    {
        navigate('/priceList')
    }

return(
    <div>
        <br></br>
        <Navbar></Navbar>
    <h1>Hello {firstName} Welcome to admin page</h1>
    
    <div className="row">
      <div className="col">
          <br></br>
          <br></br>
          <br></br>

      <button onClick={toAddFlight} type="button" class="btn btn-info">add new flight</button>
      <br></br>
      <br></br>
          <br></br>
          <br></br>
          <button onClick={toSetPrice} type="button" class="btn btn-info">SetPrice</button>
      <br></br>
      <br></br>
          <br></br>
          <br></br>
          <button onClick={toViewFlight} type="button" class="btn btn-info">view and edit flights</button>
          
      </div>
      <div className="col">
      <br></br> <br></br>  <br></br>
        
      <button onClick={toAddRoute} type="button" class="btn btn-info">add new Route</button>
      <br></br>
      <br></br>
          <br></br>
          <br></br>
          <button onClick={toViewRoute} type="button" class="btn btn-info">view and edit Route</button>
          <br></br>
      <br></br>
          <br></br>
          <br></br>
          <button onClick={toViewPrice} type="button" class="btn btn-info">view Price Details</button>
      </div>
      <div className="col">
      <br></br> <br></br>  <br></br>
        
      <button onClick={scheduleFlight} type="button" class="btn btn-info">Schedule Flight</button>
      <br></br>
      <br></br>
          <br></br>
          <br></br>
          <button onClick={toViewSchedule} type="button" class="btn btn-info">view and edit Schedule</button>
      </div>
   
      
    </div>
  </div>
)
}
export default AdminDashbord