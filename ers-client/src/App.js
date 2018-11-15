import React, { Component } from 'react';
import './App.css';
import './Include/bootstrap';
import { AppNav } from './Components/Nav.component';
import { BrowserRouter, Route, Switch } from 'react-router-dom';
import { SignInComponent } from './Signin.component';
import { Home } from './Components/Home.component';
import { Success } from './Components/Login.success.component';

class App extends Component {
  render() {
    return (
      <BrowserRouter>
        <>
          <AppNav />
          <div id="main-content-container">
            <Switch>
              <Route path="/home" component={ Home } />
              <Route path="/sign-in" component={ SignInComponent } />
              <Route path="/success" component={ Success } />
            </Switch>
          </div>
        </>
      </BrowserRouter>
    );
  }
}

export default App;
