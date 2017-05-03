import React, {Component} from 'react';
import {Container, Button, Col, ControlLabel, Form, FormControl, FormGroup, Row} from "react-bootstrap";
import {connect} from "react-redux";
import {factorize} from "./actions/factorize";

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
        return (
            <div className="container">
                <Row>
                    <Col xs={6} xsOffset={3}>
                        <Form onSubmit={this.handleSubmit}>
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
                        <h1>{this.props.factorizedNumber? this.props.factorizedNumber : "Result will be here"}</h1>
                    </Col>
                </Row>
            </div>
        );
    }
}

function mapStateToProps(state) {
    return {
        loading: state.factorize.loading,
        factorizedNumber: state.factorize.factorizedNumber,
        errorMessage: state.factorize.errorMessage
    }
}

export default connect(mapStateToProps)(App);
