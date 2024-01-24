const Weekday = ({day}) => {
    let days = ["Monday", "Tuesday", "Wednesday", "Thursday", "Friday", "Saturday", "Sunday"];
    // subtract one from the day to account for 1 representing Monday from Java
    // whereas our array has "Monday" at position 0
    let weekday = days[day - 1];
    console.log('day value:', day, 'weekday:', weekday);
    return weekday
}

export default Weekday;