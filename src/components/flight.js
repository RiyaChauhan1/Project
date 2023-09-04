import moment from 'moment'

const Flight = (prope) => {

    const { flight } = prope
    return(
       // <h2>ok flight</h2>

        <table class="table">
        <thead>
          <tr>
            <th scope="col">#</th>
            <th scope="col">source</th>
            <th scope="col">destination</th>
            <th scope="col">Take off date</th>
            <th scope="col">take off time</th>
            <th scope="col">price</th>
            <th scope="col">Available seat</th>
           
          </tr>
        </thead>
        <tbody>
          <tr>
            <th scope="row">1</th>
            <td>{flight.sour}</td>
            <td>{flight.destination}</td>
            <td>{flight.takeoffDate }</td>
            
            <td>{flight.landingTime}</td>
            <td>{flight.pricee}</td>
            <td>{flight.avalableSeat}</td>
          </tr>         
        </tbody>
      </table>
     )
}

export default Flight