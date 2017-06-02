import React, {Component} from "react";
import {Col, Container, Row} from "react-bootstrap";
import styles from "./App.css";
import FactorizeForm from "../form/FactorizeForm";
import ResultPanel from "../result-panel/ResultPanel";

export default class App extends Component {

    render() {
        return (
            <div className={`container ${styles.Container}`}>
                <Row>
                    <Col xs={3} xsOffset={1}>
                        <div className={styles.Header}>factorising</div>
                        <div className={styles.Underline}/>
                    </Col>
                </Row>
                <Row>
                    <Col xs={3} xsOffset={1}>
                        <FactorizeForm/>
                    </Col>
                    <Col xs={4} xsOffset={2}>
                        <ResultPanel/>
                    </Col>
                </Row>
            </div>
        );
    }
}

