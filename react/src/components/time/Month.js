const Month = ({month}) => {
    const months = ["January", "February", "March", "April", "May", "June", "July", "August", "September", "October", "November", "December"];
    if (month < 0 || month >= month.length) {
        console.log('incorrect month number:', month);
        return "BADMONTH";
    }
    return months[month];
}

export default Month;