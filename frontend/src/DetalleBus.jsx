import React, { useEffect, useState } from 'react';
import { useParams, Link } from 'react-router-dom';
import axios from 'axios';
import './DetalleBus.css';

function DetalleBus() {
  const { id } = useParams();
  const [bus, setBus] = useState(null);

  useEffect(() => {
    axios.get(`http://localhost:8080/bus/${id}`)
      .then(response => setBus(response.data))
      .catch(error => console.error('Error al obtener el bus:', error));
  }, [id]);

  if (!bus) return <div className="detalle-container">Cargando...</div>;

  return (
    <div className="detalle-container">
      <h2>Detalle del Bus</h2>
      <p><strong>ID:</strong> {bus.id}</p>
      <p><strong>Número:</strong> {bus.numeroBus}</p>
      <p><strong>Placa:</strong> {bus.placa}</p>
      <p><strong>Fecha de creación:</strong> {bus.fechaCreacion}</p>
      <p><strong>Características:</strong> {bus.caracteristicas}</p>
      <p><strong>Marca:</strong> {bus.marca?.nombre}</p>
      <p><strong>Estado:</strong> {bus.activo ? 'Activo' : 'Inactivo'}</p>
      <Link to="/" className="volver-btn">Volver a la lista</Link>
    </div>
  );
}

export default DetalleBus;