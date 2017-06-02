import React, {Component} from "react";
import {Button, Container, ControlLabel, Form, FormControl, FormGroup} from "react-bootstrap";
import {connect} from "react-redux";
import {factorize} from "../actions/factorize";
import styles from "./FactorizeForm.css";

class FactorizeForm extends Component {

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
            <Form onSubmit={this.handleSubmit}>
                <FormGroup controlId="numericalSystem">
                    <ControlLabel className={styles.Label}>calculation type</ControlLabel>
                    <FormControl componentClass="select" className={styles.Select}>
                        <option value="select">Classic</option>
                        <option value="select">Parallel classic</option>
                    </FormControl>
                </FormGroup>
                <FormGroup controlId="numericalSystem">
                    <ControlLabel className={styles.Label}>numeral system</ControlLabel>
                    <FormControl componentClass="select" className={styles.Select}>
                        <option value="select">2</option>
                        <option value="select">8</option>
                        <option value="select" selected>10</option>
                        <option value="other">16</option>
                    </FormControl>
                </FormGroup>
                <FormGroup controlId="formControlsTextarea">
                    <ControlLabel className={styles.Label}>number for factorize</ControlLabel>
                    <textarea className={`form-control ${styles.Textarea}`}
                              placeholder="Number" ref={(input) => {
                        this.numberInput = input
                    }} defaultValue="9173503"/>
                </FormGroup>
                <Button type="submit" disabled={this.props.loading} className={styles.Submit}>
                    factorize
                </Button>
            </Form>

        );
    }
}

function mapStateToProps(state) {
    return {
        loading: state.factorize.loading,
        errorMessage: state.factorize.errorMessage
    }
}

export default connect(mapStateToProps)(FactorizeForm);
