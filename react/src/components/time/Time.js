import Weekday from './Weekday';
import Month from './Month';
import Suffix from './Suffix';
import Timestamp from './Timestamp';
import ZeroPad from './ZeroPad';

const { useState, useEffect } = require("react")

const Time = () => {
    const [time, setTime] = useState({hour: 0, minute: 0, dayOfWeek: 0, month: 0, dayOfMonth: 0});

    useEffect(() => {
        console.log('fetching /time');
        fetch("http://localhost:8080/time")
        .then(res => res.json())
        .then(json => {
            console.log('received /time:', json);

            // make a copy of the original time object
            let newTime = {...time};

            newTime.hour = json.hour;
            newTime.minute = json.minute;
            newTime.dayOfWeek = json.dayOfWeek;
            newTime.month = json.month;

            // now give React the new Object and it will see it is different
            // and it will refresh part of the page.
            setTime(newTime);

            console.log('set values')
        })
        .catch(err => {
            console.log('Error fetching time:', err);
        })
    }, [])

   return <span>
        The time is currently
        {' '}
        <Timestamp hour={time.hour} minute={time.minute} />
        {' '}
        on
        {' '}
        <Weekday day={time.dayOfWeek} />
        {' '}
        <Month month={time.month} />
        {' '}
        the <Suffix value={time.dayOfMonth} />.
    </span>
}

export default Time;