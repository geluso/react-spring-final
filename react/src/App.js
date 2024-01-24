import './App.css';
import 'bootstrap/dist/css/bootstrap.min.css';

import Container from 'react-bootstrap/Container';

import {
  RouterProvider,
} from "react-router-dom";
import { router } from './pages/routes';

function App() {
  return (<>
      {/*
      Previously we used className to use Bootstrap
      Now we can use Bootstrap components
      like <Container>
      <div className="container">
        <div className="row">
          <div className="col-6">one third</div>
          <div className="col-6">two thirds</div>
        </div>
      </div> */}
      <Container id="app-container">
        <RouterProvider router={router} />
      </Container>
    </>
  );
}

export default App;
