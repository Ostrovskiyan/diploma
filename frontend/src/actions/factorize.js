import axios from 'axios';

export const REQUEST = 'REQUEST';
export const FACTORIZED = 'FACTORIZED';
export const FACTORIZED_ERROR = 'FACTORIZED_ERROR';

const request = () => {
    return {
        type: REQUEST
    }
};

const factorized = (resultNumber) => {
    return {
        type: FACTORIZED,
        number: resultNumber
    }
};

const factorizedError = (errorMessage) => {
    return {
        type: FACTORIZED_ERROR
    }
};


export function factorize(number) {
    return dispatch => {
        console.log("before request");
        dispatch(request());
        console.log("start request");
        axios.post('http://localhost:9000/factorize', {
            number
        })
        .then(function (response) {
            console.log("success");
            console.log(response);
            dispatch(factorized(response.data.number));
        })
        .catch(function (error) {
            console.log("error");
            dispatch(factorizedError(error));
        });
    }
}