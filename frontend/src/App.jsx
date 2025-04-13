// App.jsx
import React from 'react';
import { BrowserRouter as Router, Routes, Route } from 'react-router-dom';
import ListaBuses from './ListaBuses';
import DetalleBus from './DetalleBus';

function App() {
  return (
    <Router>
      <Routes>
        <Route path="/" element={<ListaBuses />} />
        <Route path="/bus/:id" element={<DetalleBus />} />
      </Routes>
    </Router>
  );
}

export default App;
