const Suffix = ({value}) => {
    let lastDigit = value % 10;
    if (lastDigit === 1) {
        return value + "st"
    } else if (lastDigit === 2) {
        return value + "nd"
    } else if (lastDigit === 3) {
        return value + "rd"
    } else {
        return value + "th"
    }
}

export default Suffix;