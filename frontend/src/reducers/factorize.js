import {FACTORIZED, FACTORIZED_ERROR, REQUEST} from "../actions/factorize";

const factorize = (state = {loading: false}, action) => {
    console.log(action);
    switch (action.type) {
        case REQUEST:
            return {
                loading: true
            };
        case FACTORIZED:
            return {
                loading: false,
                number1: action.number1,
                number2: action.number2,
            };
        case FACTORIZED_ERROR:
            return {
                loading: false,
                errorMessage: action.errorMessage
            };
        default:
            return state;
    }
};

export default factorize;