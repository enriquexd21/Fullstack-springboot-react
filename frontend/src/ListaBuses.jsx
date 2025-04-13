import React, { useEffect, useState } from 'react';
import axios from 'axios';
import { Link } from 'react-router-dom';
import './ListaBuses.css';

function ListaBuses() {
  const [buses, setBuses] = useState([]);

  const fetchBuses = () => {
    axios.get('http://localhost:8080/bus')
      .then(response => setBuses(response.data))
      .catch(error => console.error("Error al obtener buses:", error));
  };

  useEffect(() => {
    fetchBuses();
  }, []);

  return (
    <div className="bus-list-container">
      <h2>Lista de autobuses</h2>
      <table className="bus-table">
        <thead>
          <tr>
            <th>ID</th>
            <th>Número</th>
            <th>Placa</th>
            <th>Acciones</th>
          </tr>
        </thead>
        <tbody>
          {buses.map(bus => (
            <tr key={bus.id}>
              <td>{bus.id}</td>
              <td>{bus.numeroBus}</td>
              <td>{bus.placa}</td>
              <td><Link to={`/bus/${bus.id}`} className="ver-mas-btn">Ver más</Link></td>
            </tr>
          ))}
        </tbody>
      </table>
    </div>
  );
}

export default ListaBuses;