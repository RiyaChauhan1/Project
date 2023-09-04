import './index.css'
import { useState } from 'react'

const Home=()=>
{
  const { id, firstName, lastName } = sessionStorage
    const[source,setSource]=useState('')
    const[Destination,setDestination]=useState('')
    const[date,setDate]=useState('')
    const[category,setCategory]=useState('')
    
    const searchFlight = () =>{
        
   console.log("source ="+source)
   console.log("Destination ="+Destination)
   console.log("date ="+date)
   console.log("category ="+category)

    }



    return (
        <div className="container">
        <div className="row">
          <div className="col align-self-start">
            {/*code for column 1 left upper corner */}
          </div>
          <div className="col align-self-center">
         <h1>hello {firstName}</h1>
          </div>
          <div className="col align-self-end" >
            {/*code for third column right bottom corner */}
       <h1>Find Flights</h1>
            <form className="row g-3" className="border">
<div className="col-md-6">
<label htmlFor="" className="form-label">Source
</label>
<input onChange={(e)=>
{
    setSource(e.target.value)
}} type="text" className="form-control" id=""/>
</div>
<div className="col-md-6">
<label htmlFor="" className="form-label">Destination</label>
<input onChange={(e)=>
{
    setDestination(e.target.value)
}}
 type="text" className="form-control" id=""/>
</div>
<div className="col-12">
<label htmlFor="" className="form-label">Depart on</label>
<input onChange={(e)=>
{
    setDate(e.target.value)
}} type="date" className="form-control" id="" placeholder=""/>
</div>
   
<br></br>
<br></br>

<div className="btn-group">
  <button type="button" className="btn btn-danger">Action</button>
  <button type="button" className="btn btn-danger dropdown-toggle dropdown-toggle-split" data-bs-toggle="dropdown" aria-expanded="false">
    <span className="visually-hidden">select class</span>
  </button>
  <ul className="dropdown-menu">
    <li><button onClick={(e)=>
{
    setCategory(e.target.value='first')
}} type="button" className="btn btn-primary">First</button></li>
<li><button onClick={(e)=>
{
    setCategory(e.target.value='buisness')
}} type="button" className="btn btn-primary">buisness</button></li>
<li><button onClick={(e)=>
{
    setCategory(e.target.value='economy')
}} type="button" className="btn btn-primary">Economy</button></li>
    
   
  </ul>
</div>

<br></br>
<br></br>
<br></br>



<div className="col-12">
<button onClick={searchFlight}  className="btn btn-primary">Search</button>
</div>
</form>



          </div>
        </div>
      </div>




        
        

          

    )
}
export default Home


