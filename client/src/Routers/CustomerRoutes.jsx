import React from "react";
import { Route, Routes } from "react-router-dom";
import HomePage from "../Customer/components/pages/HomePage/HomePage";


const CustomerRoutes = () => {
  return (
    <div>
      <Routes>
        <Route path="/login" element={<HomePage />} />
        <Route path="/register" element={<HomePage />} />
        <Route path="/" element={<HomePage />} />
     
      </Routes>
    
    </div>
  );
};

export default CustomerRoutes;
