const ZeroPad = ({value}) => {
    if (value < 10) {
        return '0' + value;
    }
    return value;
}

export default ZeroPad;