import React, {Component} from "react";
import {Container} from "react-bootstrap";
import {connect} from "react-redux";
import styles from "./ResultPanel.css";

class ResultPanel extends Component {

    render() {
        let {
            number1,
            number2,
        } = this.props;

        // (number1 && number2 ?
        //         <div>
        //             <div>First factor: {number1}</div>
        //             <div>Second factor: {number2}</div>
        //             <div>Period: 176</div>
        //             <div>Time: 2m. 15s.</div>
        //         </div>
        //         : <h1>Result will be here</h1>
        // )

        return (
            <div>
                <div className={styles.ResultHeader}>
                    result
                </div>
                <div className={styles.ResultPanel}>
                    <table>
                        <tr>
                            <td>Factor1: </td>
                            <td>2579</td>
                        </tr>
                        <tr>
                            <td>Factor2: </td>
                            <td>3557</td>
                        </tr>
                        <tr>
                            <td>Period: </td>
                            <td>4583684</td>
                        </tr>
                        <tr>
                            <td>Basis (a): </td>
                            <td>2</td>
                        </tr>
                        <tr>
                            <td>Time: </td>
                            <td>4069 ms</td>
                        </tr>
                    </table>
                </div>
            </div>
        );
    }
}

function mapStateToProps(state) {
    return {
        number1: state.factorize.number1,
        number2: state.factorize.number2,
    }
}

export default connect(mapStateToProps)(ResultPanel);
