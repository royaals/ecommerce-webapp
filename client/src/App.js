

import './App.css';

import { Route, Routes } from 'react-router-dom';
import CustomerRouters from './routers/CustomerRouters.jsx';
import AdminRouters from './routers/AdminRouters.jsx';

function App() {
  return (
    <div className="">
      <Routes>
        <Route path='/*' element={<CustomerRouters />} />
        <Route path='/admin/*' element={<AdminRouters />}></Route>
      </Routes>
    </div>
  );
}

export default App;
