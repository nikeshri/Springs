import React from 'react';
import { MDBContainer, MDBRow, MDBCol, MDBCard, MDBCardBody, MDBBtn, MDBIcon } from 'mdb-react-ui-kit';

const HomePage = () => {
  return (
    <MDBContainer fluid>
      <MDBRow className="mt-5">
        <MDBCol md="6" className="text-center text-md-start ">
          <h1 className="display-4 fw-bold ls-tight">
            Welcome to Expense Tracker
          </h1>
          <p className="lead ">
            Easily manage your expenses, set budgets, and analyze your spending habits with our intuitive expense tracker.
            Take control of your finances with our intuitive expense tracker. Easily manage your expenses, set personalized budgets, and gain valuable insights into your spending habits.
          </p>
          <MDBBtn href="#" color="primary">
            Get Started
          </MDBBtn>
        </MDBCol>
        <MDBCol md="6" className="text-center">
          <img src="\src\assets\homepage.jpg" alt="Expense Tracker" style={{ maxWidth: '100%', height: 'auto' }} />
        </MDBCol>
      </MDBRow>

      <MDBRow className="mt-5">
        <MDBCol className="text-center">
          <h2>Features</h2>
        </MDBCol>
      </MDBRow>

      <MDBRow className="mt-3">
        <MDBCol>
        <MDBCard>
      <img src="\src\assets\3f.jpg" alt="Track Expenses" className="card-img-top" />
      <MDBCardBody>
        <h5 className="card-title">Track Expenses</h5>
        <p className="card-text">Easily track all your expenses and categorize them for better management.</p>
      </MDBCardBody>
    </MDBCard>
  </MDBCol>
  <MDBCol>
    <MDBCard>
      <img src="\src\assets\3f.jpg" alt="Budget Management" className="card-img-top" />
      <MDBCardBody>
        <h5 className="card-title">Budget Management</h5>
        <p className="card-text">Set monthly budgets and receive notifications when you exceed your budget limits.</p>
      </MDBCardBody>
    </MDBCard>
  </MDBCol>
  <MDBCol>
    <MDBCard>
      <img src="\src\assets\3f.jpg" alt="Data Analysis" className="card-img-top" />
      <MDBCardBody>
        <h5 className="card-title">Data Analysis</h5>
        <p className="card-text">Analyze your spending habits with detailed reports and visualizations.</p>
      </MDBCardBody>
    </MDBCard>
        </MDBCol>
      </MDBRow>

      <MDBRow className="mt-5">
        <MDBCol className="text-center">
          <h2>About Developer</h2>
          <p>Nikesh Mishra, Full Stack Developer.</p>
          <MDBBtn href="#" color="primary">
            <MDBIcon fas icon="user" className="me-2" />View Profile
          </MDBBtn>
        </MDBCol>
      </MDBRow>
    </MDBContainer>
  );
};

export default HomePage;
