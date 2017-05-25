import React, {Component} from 'react';
import {Container, Button, Col, ControlLabel, Form, FormControl, FormGroup, Row} from "react-bootstrap";
import {connect} from "react-redux";
import {factorize} from "../actions/factorize";
import styles from "./App.css";

class App extends Component {

    constructor(props) {
        super(props);
        this.handleSubmit = this.handleSubmit.bind(this);
    }

    handleSubmit(event) {
        event.preventDefault();
        this.props.dispatch(factorize(this.numberInput.value));
    }

    render() {
        let {
            number1,
            number2,
        } = this.props;
        return (
            <div className="container">
                <Row>
                    <Col xs={6} xsOffset={3} className={styles.Container}>
                        <Form onSubmit={this.handleSubmit}>
                            <FormGroup controlId="numericalSystem">
                                <ControlLabel>Calculation type:</ControlLabel>
                                <FormControl componentClass="select">
                                    <option value="select">Classic</option>
                                    <option value="select">Parallel classic</option>
                                </FormControl>
                            </FormGroup>
                            <FormGroup controlId="numericalSystem">
                                <ControlLabel>Numeral system:</ControlLabel>
                                <FormControl componentClass="select">
                                    <option value="select">2</option>
                                    <option value="select">8</option>
                                    <option value="select">10</option>
                                    <option value="other">16</option>
                                </FormControl>
                            </FormGroup>
                            <FormGroup controlId="formControlsTextarea">
                                <ControlLabel>Number for factorize</ControlLabel>
                                <textarea className="form-control" placeholder="textarea" ref={(input) => {
                                    this.numberInput = input
                                }}/>
                            </FormGroup>
                            <Button type="submit" disabled={this.props.loading}>
                                Factorize
                            </Button>
                        </Form>
                    </Col>
                </Row>
                <Row>
                    <Col xs={6} xsOffset={3}>
                        {
                            number1 && number2 ?
                                <div>
                                    <div>First factor: {number1}</div>
                                    <div>Second factor: {number2}</div>
                                    <div>Period: 176</div>
                                    <div>Time: 2m. 15s.</div>
                                </div>
                                : <h1>Result will be here</h1>
                        }
                    </Col>
                </Row>
            </div>
        );
    }
}

function mapStateToProps(state) {
    return {
        loading: state.factorize.loading,
        number1: state.factorize.number1,
        number2: state.factorize.number2,
        errorMessage: state.factorize.errorMessage
    }
}

export default connect(mapStateToProps)(App);
