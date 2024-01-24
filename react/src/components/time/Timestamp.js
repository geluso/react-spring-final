import ZeroPad from "./ZeroPad"

const Timestamp = ({hour, minute}) => {
    return <>
        {hour % 12}:<ZeroPad value={minute} />
    </>
}

export default Timestamp;