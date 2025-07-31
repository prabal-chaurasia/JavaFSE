import './App.css';

function App() {
  // Page heading element
  const pageTitle = "Office Space, at Affordable Range";

  // List of office space objects
  const officeSpaces = [
    {
      name: 'DBS',
      rent: 50000,
      address: 'Chennai',
      image: 'https://images.unsplash.com/photo-1521737604893-d14cc237f11d?w=500&q=80'
    },
    {
      name: 'Innovate Hub',
      rent: 75000,
      address: 'Bangalore',
      image: 'https://images.unsplash.com/photo-1556761175-5973dc0f32e7?w=500&q=80'
    },
    {
      name: 'WorkLoft',
      rent: 45000,
      address: 'Mumbai',
      image: 'https://images.unsplash.com/photo-1552664730-d307ca884978?w=500&q=80'
    }
  ];

  return (
    <div className="App">
      <header className="App-header">
        <h1>{pageTitle}</h1>
      </header>
      <div className="office-list">
        {/* Loop through the office space list and render each item */}
        {officeSpaces.map((office, index) => {
          // Define inline style for rent based on condition
          const rentStyle = {
            color: office.rent <= 60000 ? 'red' : 'green',
            fontWeight: 'bold'
          };

          return (
            <div key={index} className="office-card">
              {/* JSX attribute for the image */}
              <img src={office.image} alt={office.name} className="office-image" />
              <h2>Name: {office.name}</h2>
              {/* Apply conditional inline CSS here */}
              <h3 style={rentStyle}>Rent: Rs. {office.rent}</h3>
              <h3>Address: {office.address}</h3>
            </div>
          );
        })}
      </div>
    </div>
  );
}

export default App;