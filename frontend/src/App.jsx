import './App.scss'

function App() {
  return (
    <div className="App">
      <div className="hero p-3 row">
          <div className="col-12 col-md-6 text-center">
              <img src='/courier.png' className='heroimg'/>
          </div>
          <div className="col-12 col-md-6 p-5 blackcol d-flex flex-column align-items-center justify-content-center">
              <div className="h2 text-center">
                Logisticks
              </div>
              <div className="h6 text-center m-3">
                Entrust all your shipping challenges in our wily hands. Strong, tech-driven solutions for all the problems on the road.
              </div>
              <button className="btn btn-light m-2">
              <b>Send Shipment</b>
              </button>
              <button className="btn btn-warning m-2">
              <b>View Past Orders</b>
              </button>
          </div>
      </div>
    </div>
  )
}

export default App
