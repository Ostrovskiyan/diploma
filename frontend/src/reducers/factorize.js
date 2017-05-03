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
                factorizedNumber: action.number
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